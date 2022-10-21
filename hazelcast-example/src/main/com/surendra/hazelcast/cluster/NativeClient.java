package com.surendra.hazelcast.cluster;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;

public class NativeClient {

    public static void main(final String[] args) {
        final ClientConfig config = new ClientConfig();
        config.setClusterName("dev");
        final HazelcastInstance hazelcastInstanceClient = HazelcastClient.newHazelcastClient(config);
        final Map<Long, String> map = hazelcastInstanceClient.getMap("data");
        for (Map.Entry<Long, String> entry : map.entrySet()) {
            System.out.printf("Key: %d, Value: %s%n", entry.getKey(), entry.getValue());
        }
    }

}
