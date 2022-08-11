package com.spring.study.kafka.producer;

import org.apache.kafka.clients.producer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * @description kafka producer 消息生产者
 * @author Qi
 * @date 2022/7/16 17:27
 */
public class Producer {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Producer.class);
        Properties properties = new Properties();
        //kafka集群
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"node1:9092,node2:9092,node3:9092");
        properties.setProperty(ProducerConfig.BATCH_SIZE_CONFIG,"16384");
        properties.put(ProducerConfig.LINGER_MS_CONFIG,1);
        //生产者的key序列化和value序列化必须设置
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        //使用自定义的分区策略
        properties.setProperty(ProducerConfig.PARTITIONER_CLASS_CONFIG,"com.spring.study.kafka.partition.MyPartition");

        KafkaProducer<String,String> producer = new KafkaProducer<>(properties);
        for (int i = 0; i < 10; i++) {
            ProducerRecord<String,String> producerRecord = new ProducerRecord<>("fourth", "hhh" + i, "hello-" + i);
            //普通发送方式
//            producer.send(producerRecord);
            //带回调的发送方式
            producer.send(producerRecord, (metadata, exception) -> {
                if (exception == null) {

                    System.out.println("partation:" + metadata.partition());
                    System.out.println("offset:" + metadata.offset());
//                        logger.info("partation",metadata.partition());
                } else {
                    logger.error("prodecer exception", exception);
                }
            });
        }
        producer.close();
    }
}
