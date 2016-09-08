package com.chyld.messaging;

import com.chyld.services.RunService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RuService {
    private RunService runService;


    @Autowired
    public void setPosService(RunService runService) {this.runService = runService;}

    @RabbitListener(queues = "fit.queue.run")
    @Transactional
    public void receive(Message msg, String serial){
        String key = msg.getMessageProperties().getReceivedRoutingKey();

        if (key.endsWith("start")) {
            runService.saveRun(serial);
        } else if (key.endsWith("stop")) {
            runService.stopRun(serial);
        }
    }
}
