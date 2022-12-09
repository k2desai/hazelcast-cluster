package me.desaikun.hazelcastdemo.config;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public Config getHazelcastConfig() {
        return new Config();
    }

    @Bean
    public HazelcastInstance getHazelcastInstance(Config config) {
        return Hazelcast.newHazelcastInstance(config);
    }

    @Bean
    public IMap<String, String> getHazelcastCache(HazelcastInstance instance) {
        return instance.getMap("distributed-cache");
    }
}
