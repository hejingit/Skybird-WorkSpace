package com.primeton.storm.topology;

import java.util.Map;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.generated.StormTopology;
import org.apache.storm.kafka.ZkHosts;
import org.apache.storm.kafka.trident.OpaqueTridentKafkaSpout;
import org.apache.storm.kafka.trident.TridentKafkaConfig;
import org.apache.storm.task.IMetricsContext;
import org.apache.storm.trident.Stream;
import org.apache.storm.trident.TridentTopology;
import org.apache.storm.trident.operation.builtin.Count;
import org.apache.storm.trident.state.State;
import org.apache.storm.trident.state.StateFactory;
import org.apache.storm.trident.state.map.NonTransactionalMap;
import org.apache.storm.trident.testing.MemoryBackingMap;
import org.apache.storm.tuple.Fields;

import com.primeton.storm.common.Time;
import com.primeton.storm.functions.JsonParseFunction;
import com.primeton.storm.functions.KeyAssignFunction;
import com.primeton.storm.functions.TestFunction;

/**
 * 统计每秒调用次数.
 * @author sks
 *
 */
public class TimesCountTopology {

	@SuppressWarnings("serial")
	public static StormTopology buildTopology(){

		TridentTopology topology = new TridentTopology();
		TridentKafkaConfig spoutConf = new TridentKafkaConfig(new ZkHosts("RHEL01:2181,RHEL02:2181,RHEL03:2181"),"test");
		OpaqueTridentKafkaSpout spout = new OpaqueTridentKafkaSpout(spoutConf);
		Stream spoutStream = topology.newStream("kafka-times-count-stream", spout);
		spoutStream.each(new Fields("bytes"), new JsonParseFunction(), new Fields("event"))
				.each(new Fields("event"), new KeyAssignFunction(Time.SECONDS.getTime()), new Fields("key"))
				.groupBy(new Fields("key"))
				.persistentAggregate(new StateFactory(){
					@SuppressWarnings("rawtypes")
					public State makeState(Map conf, IMetricsContext metrics, int partitionIndex, int numPartitions) {
						return NonTransactionalMap.build(new MemoryBackingMap());
					}
				}, new Count(), new Fields("count"))
				.newValuesStream()
				.each(new Fields("key","count"), new TestFunction(), new Fields());

		return topology.build();
	}
	
	public static void main(String[] args)
			throws AlreadyAliveException, InvalidTopologyException, AuthorizationException {
		Config conf = new Config();
		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology("kafka-times-count-topology", conf, buildTopology());

	}
}
