package com.surendra.hazelcast.cluster;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;

public class NativeClient {

    public static void main(final String[] args) {
        System.out.println("Surendra1");
        usingClientConfig();
        System.out.println("Surendra2");
    }


    private static void usingClientConfig() {
//        System.out.println("1 sum=["+sum+"] carry=["+carry+"]");

        final ClientConfig config = new ClientConfig();
        config.setClusterName("dev");
//        config.getNetworkConfig().addAddress("127.0.0.1:7000");
        config.setClusterName("local-central");
        config.getNetworkConfig().addAddress("127.0.0.1:6760", "localhost:6760", "0.0.0.0:6760");
        final HazelcastInstance hazelcastInstanceClient = HazelcastClient.newHazelcastClient(config);
        final Map<Long, String> map = hazelcastInstanceClient.getMap("data");
        final Map<Long, String> mapToWrite = hazelcastInstanceClient.getMap("data");
        mapToWrite.put(1L, "Test 1");
        mapToWrite.put(2L, "Test 2");

        for (Map.Entry<Long, String> entry : map.entrySet()) {
            System.out.printf("Key: %d, Value: %s%n", entry.getKey(), entry.getValue());
        }

        for (Map.Entry<Long, String> entry : mapToWrite.entrySet()) {
            System.out.printf("Key: %d, Value: %s%n", entry.getKey(), entry.getValue());
        }
    }


    private static void configure() {
        final Config config = new Config();
        config.setInstanceName("Programmatic_Hazelcast_Instance");

        final NetworkConfig network = config.getNetworkConfig();
        network.setPort(7000).setPortCount(20);
        network.setPortAutoIncrement(true);
        final JoinConfig join = network.getJoin();
        join.getMulticastConfig().setEnabled(false);
        join.getTcpIpConfig()
            .addMember("127.0.0.1")
            .addMember("localhost").setEnabled(true);

        // initialize hazelcast server/instance
        final HazelcastInstance hazelcast = Hazelcast.newHazelcastInstance(config);
        System.out.println(String.format("Name of the instance: %s", hazelcast.getName()));
    }

}
