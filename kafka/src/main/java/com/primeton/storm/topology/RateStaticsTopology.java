package com.primeton.storm.topology;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.generated.StormTopology;
import org.apache.storm.kafka.ZkHosts;
import org.apache.storm.kafka.trident.OpaqueTridentKafkaSpout;
import org.apache.storm.kafka.trident.TridentKafkaConfig;
import org.apache.storm.trident.Stream;
import org.apache.storm.trident.TridentTopology;
import org.apache.storm.tuple.Fields;

import com.primeton.storm.common.Time;
import com.primeton.storm.functions.JsonParseFunction;
import com.primeton.storm.functions.ServiceRateFunction;
import com.primeton.storm.functions.SystemRateFunction;
import com.primeton.storm.functions.TestFunction;

/**
 * 统计成功率.
 * @author sks
 *
 */
public class RateStaticsTopology {

	public static StormTopology buildTopology() {
		TridentTopology topology = new TridentTopology();
		TridentKafkaConfig spoutConf = new TridentKafkaConfig(new ZkHosts("RHEL01:2181,RHEL02:2181,RHEL03:2181"),"test");
		OpaqueTridentKafkaSpout spout = new OpaqueTridentKafkaSpout(spoutConf);
		Stream spoutStream = topology.newStream("kafka-rate-statics-stream", spout);
		spoutStream.each(new Fields("bytes"), new JsonParseFunction(), new Fields("event"))
				.each(new Fields("event"), new ServiceRateFunction(Time.MINUTES.getTime()), new Fields("rate"))
				.each(new Fields("event","rate"), new SystemRateFunction(), new Fields("sysRate"))
				.each(new Fields("event","rate","sysRate"), new TestFunction(), new Fields());
			

		return topology.build();
	}

	public static void main(String[] args)
			throws AlreadyAliveException, InvalidTopologyException, AuthorizationException {
		Config conf = new Config();

		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology("kafka-rate-statics-topology", conf, buildTopology());
	}
}
