package com.bitfest.BitFest.controller;

import com.bitfest.BitFest.database.topic.service.TopicService;
import com.bitfest.BitFest.request_model.TopicBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ApiController {

    private final TopicService topicService;

    @PostMapping("/save_topic")
    public ResponseEntity<Map<String,Object>> saveTopic(@RequestBody TopicBody topicBody){
        return topicService.save(topicBody);
    }

    @GetMapping("/read_topics")
    public ResponseEntity<Map<String,Object>> readTopics(){
        final Map<String,Object> map = new TreeMap<>();
        map.put("message","Data read successful");
        map.put("data", topicService.readAllTopics());

        return ResponseEntity.ok(map);
    }

}
