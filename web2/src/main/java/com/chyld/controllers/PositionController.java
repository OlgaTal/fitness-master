package com.chyld.controllers;

import com.chyld.entities.Position;
import com.chyld.entities.Run;
import com.chyld.services.PositionService;
import com.chyld.services.RunService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class PositionController {

    private final PositionService service;
    private RabbitTemplate rabbitTemplate;
    private TopicExchange topicExchange;

    @Autowired
    public PositionController(final PositionService service) {
        this.service = service;
    }

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate){this.rabbitTemplate = rabbitTemplate;}

    @Autowired
    public void setTopicExchange(TopicExchange topicExchange){this.topicExchange = topicExchange;}

//    @RequestMapping(value = "/positions/{devSn}", method = RequestMethod.POST)
//    public ResponseEntity<?> addPosition(@PathVariable String devSn, @RequestBody Position position) throws JsonProcessingException {
//        Position pos = service.savePosition(devSn, position);
//        if (pos == null) {
//            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
//        }
//        return ResponseEntity.status(HttpStatus.CREATED).body(null);
//    }

    @RequestMapping(value = "/positions/{serial}", method = RequestMethod.POST)
    public Position addPosition(@PathVariable String serial, @RequestBody Position position) throws JsonProcessingException {
        String topicName = topicExchange.getName();
        HashMap<String, Object> hm = new HashMap<>();
        hm.put("serial", serial);
        hm.put("position", position);
        rabbitTemplate.convertAndSend(topicName, "fit.topic.pos", hm);

        return null;
    }

    @RequestMapping(value = "/positions/{devSn}", method = RequestMethod.GET)
    public List<Position> getPositions(@PathVariable String devSn) throws JsonProcessingException {
        return service.findPositionByDeviceSn(devSn);
    }
}
