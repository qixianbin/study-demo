package com.spring.study.kafka.partition;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

import java.util.List;
import java.util.Map;

/**
 * @description 自定义分区策略
 * @author Qi
 * @date 2022/7/17 10:37
 */
public class MyPartition implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        List<PartitionInfo> partitionInfos = cluster.availablePartitionsForTopic(topic);
        System.out.println("分区数：" + partitionInfos.size());
        if (null != key){
            return key.hashCode() % partitionInfos.size();
        }else {
            return 0;
        }
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
