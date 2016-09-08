package com.chyld.controllers;

import com.chyld.entities.Device;
import com.chyld.entities.User;
import com.chyld.security.JwtToken;
import com.chyld.services.DeviceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
public class DeviceController {

    private final DeviceService deviceService;

    @Autowired
    public DeviceController(final DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @RequestMapping(value = "/devices", method = RequestMethod.POST)
    public ResponseEntity<?> createDevice(@Valid @RequestBody Device device, Principal principal) throws JsonProcessingException {

        int uid = ((JwtToken)principal).getUserId();
        User user = new User();
        user.setId(uid);

        device.setUser(user);
        deviceService.saveDevice(device);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @RequestMapping(path = {"/devices/", "/devices"}, method = RequestMethod.GET)
    public List<Device> index(Principal principal) {
        int uid = ((JwtToken)principal).getUserId();
        return this.deviceService.findDeviceByUserId(uid);
    }

}
