package com.bitfest.BitFest.database.topic.service;

import com.bitfest.BitFest.database.topic.model.Topic;
import com.bitfest.BitFest.database.topic.repository.TopicRepository;
import com.bitfest.BitFest.request_model.TopicBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
@RequiredArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;

    public List<Topic> readAllTopics(){
        return topicRepository.findAll();
    }

    public ResponseEntity<Map<String,Object>> save(TopicBody topicBody){
        final Map<String,Object> responseMap = new TreeMap<>();
        try{
            Topic topic = topicRepository.findById(topicBody.getId()).orElse(null);
            if(topic == null){
                final long timestamp = System.currentTimeMillis();
                topic = new Topic(topicBody.getId(), topicBody.getName(), topicBody.getDescription(),timestamp,timestamp);
            }
            else{
                topic.update(topicBody);
            }

            topicRepository.save(topic);
            responseMap.put("message","Data saved successfully");
            responseMap.put("data",topicBody);
            return ResponseEntity.ok(responseMap);
        }catch (Exception e){
            responseMap.put("message",e.getMessage());
            responseMap.put("data",null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMap);
        }
    }
}
