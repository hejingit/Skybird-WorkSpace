package com.primeton.storm.kafka;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.Executors;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.utils.Utils;

import com.alibaba.fastjson.JSON;
import com.primeton.storm.events.DubboInvoke;

public class MessageProducer {

    private Producer<String,String> producer;
    
	private String[] consumerApps = new String[]{"CRM","QLC","ITMIS","RISK"};
	private String[] providerApps = new String[]{"UAAP","BPM","ESB","USE"};
	private String[] consumerIPs = new String[]{"10.10.10.1","10.10.10.2","10.10.10.3","10.10.10.4"};
	private String[] providerIPs = new String[]{"10.20.20.1","10.20.20.2","10.20.20.3","10.20.20.4"};
	private String[] services = new String[]{"com.cdb.service.S1","com.cdb.service.S2","com.cdb.service.S3","com.cdb.service.S4"};
	
    public static void main(String[] args) {
        new MessageProducer().start();
    }

    public void init(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "RHEL01:9092,RHEL02:9092,RHEL03:9092");
        props.put("acks", "1");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<String,String>(props);

    }

    public void produceMsg(){
    	
    	int slow = 1000000;
    	int fast = 15;
    	
    	for(int i=0; i<slow; i++){
    		DubboInvoke dubboInvoke = new DubboInvoke();
    		dubboInvoke.setConsumerAppName(consumerApps[i % 4]);
    		dubboInvoke.setConsumerIP(consumerIPs[i % 4]);
    		dubboInvoke.setProviderAppName(providerApps[i % 4]);
    		dubboInvoke.setProviderIP(providerIPs[i % 4]);
    		dubboInvoke.setService(services[i % 4]);
    		dubboInvoke.setInvokeTime(System.currentTimeMillis());
    		dubboInvoke.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(dubboInvoke.getInvokeTime())));
    		dubboInvoke.setTimeCost(i*133 % 87);
    		dubboInvoke.setSuc(i % 3 > 0 ? true : false);
            producer.send(new ProducerRecord<String, String>("test", Integer.toString(i), JSON.toJSONString(dubboInvoke)));
            Utils.sleep(5000);
    	}
  
        for(int i = 0; i < fast; i++){
        	DubboInvoke dubboInvoke = new DubboInvoke();
    		dubboInvoke.setConsumerAppName(consumerApps[i % 4]);
    		dubboInvoke.setConsumerIP(consumerIPs[i % 4]);
    		dubboInvoke.setProviderAppName(providerApps[i % 4]);
    		dubboInvoke.setProviderIP(providerIPs[i % 4]);
    		dubboInvoke.setService(services[i % 4]);
    		dubboInvoke.setInvokeTime(System.currentTimeMillis());
            producer.send(new ProducerRecord<String, String>("test", Integer.toString(i), JSON.toJSONString(dubboInvoke)));
            Utils.sleep(2000);
        }
    }

    public void start() {
        System.out.println("开始发送消息 ...");
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            public void run() {
                init();
                while (true) {
                    try {
                        produceMsg();
                    } catch (Throwable e) {
                    	e.printStackTrace();
                        if (producer != null) {
                            try {
                                producer.close();
                            } catch (Throwable e1) {
                                System.out.println("Turn off Kafka producer error! " + e);
                            }
                        }
                    }

                }

            }
        });
    }
}