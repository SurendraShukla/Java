package com.surendra.hazelcast.cluster;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.flakeidgen.FlakeIdGenerator;

import java.util.Map;

public class ServerNode {

    public static void main(final String[] args) {
        final HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
        final Map<Long, String> map = hazelcastInstance.getMap("data");
        final FlakeIdGenerator idGenerator = hazelcastInstance.getFlakeIdGenerator("newid");
        for (int i = 0; i < 10; i++) {
            map.put(idGenerator.newId(), "message" + i);
        }
    }

}
