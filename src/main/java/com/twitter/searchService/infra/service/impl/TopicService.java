package com.twitter.searchService.infra.service.impl;

import com.twitter.searchService.infra.model.Topic;
import com.twitter.searchService.infra.repository.TopicRepository;
import com.twitter.searchService.infra.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService implements ITopicService {
    @Autowired
    private TopicRepository topicRepository;

    @Override
    public Topic update(Topic topic) {
        return topicRepository.save(topic);
    }
}
