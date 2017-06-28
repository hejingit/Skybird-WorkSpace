package com.primeton.storm.kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 * 消息接收器.
 * @author sks
 *
 */
public class MessageConsumer {
	private Properties props = new Properties();
	private KafkaConsumer<String, String> consumer;
/*	private List<TopicPartition> partitions = new ArrayList<TopicPartition>();
	private List<PartitionInfo> partitionInfoList;
	private String topic;*/
	
	public MessageConsumer(String topic){
		//this.topic = topic;
		props.put("bootstrap.servers", "RHEL01:9092,RHEL02:9092,RHEL03:9092");
		props.put("group.id", "0");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

		consumer = new KafkaConsumer<String, String>(props);
		/*partitionInfoList = consumer.partitionsFor(topic);
		for(PartitionInfo partitionInfo : partitionInfoList){
			TopicPartition tp = new TopicPartition(topic, partitionInfo.partition());
			partitions.add(tp);
		}
		*/
		//consumer.assign(partitions);
		consumer.subscribe(Arrays.asList(topic));

	}


	/**
	 * 返回最近count秒内发到topic的消息.
	 * @param topic
	 * @param count
	 * @return
	 */
	public ConsumerRecords<String,String> getRecentRecords() {
		ConsumerRecords<String,String> consumerRecords = consumer.poll(200);
		return consumerRecords;
		
		/*long timestamp = System.currentTimeMillis();
		Map<TopicPartition, Long> map = new HashMap<TopicPartition, Long>();
		for(TopicPartition tp : partitions){
			map.put(tp,  timestamp - count * 1000);
		}

		Map<TopicPartition, OffsetAndTimestamp> offsetMap = consumer.offsetsForTimes(map);
		
		List<ConsumerRecord<String,String>> latestRecords = new ArrayList<ConsumerRecord<String,String>>();
		for(Map.Entry<TopicPartition, OffsetAndTimestamp> entry : offsetMap.entrySet()){
			TopicPartition tp = entry.getKey();
			OffsetAndTimestamp offSetTimestamp = entry.getValue();

			if (offSetTimestamp != null) {
				long offset = offSetTimestamp.offset();
				consumer.seek(tp, offset);
				ConsumerRecords<String,String> consumerRecords = consumer.poll(200);
				latestRecords.addAll(consumerRecords.records(tp));
				
			}
		}*/
		
		

	}
	
	/**
	 * 打印测试.
	 * @param records
	 */
	private static void print(ConsumerRecords<String,String> records){
		if(records != null){
			for (ConsumerRecord<String, String> record : records) {
				System.out.println(record.key() + ":" + record.value());
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("开始消费消息");
		MessageConsumer consumer =  new MessageConsumer("test");
		
		while(true){
			print(consumer.getRecentRecords());
		}
	
	}
}
