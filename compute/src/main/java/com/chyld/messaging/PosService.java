package com.chyld.messaging;

import com.chyld.entities.Position;
import com.chyld.services.PositionService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;


@Service
public class PosService {
    private PositionService positionService;

    @Autowired
    public void setPosService(PositionService positionService) {this.positionService = positionService;}

    @RabbitListener(queues = "fit.queue.pos")
    @Transactional
    public void receive(Message msg, HashMap<String, Object> data){
        String key = msg.getMessageProperties().getReceivedRoutingKey();
        String serial = (String)data.get("serial");
        Position position = (Position)data.get("position");
        positionService.savePosition(serial, position);
    }

}
