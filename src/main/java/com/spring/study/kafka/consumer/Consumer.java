package com.spring.study.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * @description kafka consumer
 * @author Qi
 * @date 2022/7/17 11:00
 */
public class Consumer {
    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"node2:9092,node1:9092,node3:9092");
        //消费者的key序列化、value序列化、消费者组必须设置
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,"bigdata3");
        //从最小值开始消费，此值只有重新设置消费者组时才生效。
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        //自动提交，如果为true，则会自动提交，
        //如果为false，消费者不进行手动提交的话，消费者只会在本地存储消费到的offset，不会将消费到的offset推到服务器，当消费者重新启动会重新从服务器读取offset
        properties.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,"false");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Collections.singletonList("fourth"));
        while (true){
            ConsumerRecords<String,String> records = consumer.poll(Duration.ofMinutes(100));
            records.forEach(record-> System.out.printf("topic:%s,key:%s,value:%s,partition:%s,offset:%d,%n",record.topic(),record.key(),record.value(),record.partition(),record.offset()));
            //手动提交
            consumer.commitAsync((offsets, exception) -> {
                if (exception != null){
                    System.out.println("自动提交出现异常");
                }
            });
        }

    }
}
