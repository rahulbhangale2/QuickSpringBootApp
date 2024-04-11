package com.home.practice.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    public List<Topic> getAllTopics(){
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Optional<Topic> getTopic(String id){
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id);

    }

    public void addTopic(Topic topic){
        //topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic){
        /*topics.stream().filter(t->t.id.equals(id)).map(t -> {
            t.setName(topic.getName());
            t.setDescription(topic.getDescription());
            return t;
        }).collect(Collectors.toList());*/
        topicRepository.save(topic);
    }

    public void deleteTopic(String id){
        //topics.removeIf(e-> e.getId().equals(id));
        topicRepository.deleteById(id);
    }

}
