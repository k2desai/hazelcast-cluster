package me.desaikun.hazelcastdemo.controller;

import com.hazelcast.map.IMap;
import com.hazelcast.map.LocalMapStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/map")
public class MapService {
    private final IMap<String, String> cache;

    @Autowired
    public MapService(IMap<String, String> cache) {
        this.cache = cache;
    }

    @GetMapping("/put")
    public ResponseEntity<String> putInMap(@RequestParam("key") String key,
                                           @RequestParam("value") String value) {
        cache.put(key, value);
        return ResponseEntity.accepted().body("Ok");
    }

    @GetMapping("/get")
    public ResponseEntity<String> getFromMap(@RequestParam("key") String key) {
        String value = cache.get(key);
        return ResponseEntity.ok(value);
    }

    @GetMapping("/stats")
    public LocalMapStats getStats() {
        return cache.getLocalMapStats();
    }



}
