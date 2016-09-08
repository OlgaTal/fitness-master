package com.chyld.controllers;

import com.chyld.entities.Device;
import com.chyld.entities.Position;
import com.chyld.entities.Run;
import com.chyld.entities.User;
import com.chyld.security.JwtToken;
import com.chyld.services.DeviceService;
import com.chyld.services.RunService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
public class RunController {

    private final RunService runService;

    @Autowired
    public RunController(final RunService runService) {
        this.runService = runService;
    }

    @RequestMapping(value = "/runs/{devSn}/start", method = RequestMethod.POST)
    public ResponseEntity<?> createRun(@PathVariable String devSn) throws JsonProcessingException {
        Run run = runService.saveRun(devSn);
        if (run == null) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @RequestMapping(value = "/runs/{devSn}/stop", method = RequestMethod.PUT)
    public ResponseEntity<?> stopRun(@PathVariable String devSn) throws JsonProcessingException {
        Run run = runService.stopRun(devSn);
        if (run == null) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @RequestMapping(value = "/runs/{devSn}", method = RequestMethod.GET)
    public List<Run> getPositions(@PathVariable String devSn) throws JsonProcessingException {
        return runService.findRunByDeviceSn(devSn);
    }

}
