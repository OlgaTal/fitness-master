package com.chyld.services;

import com.chyld.entities.Device;
import com.chyld.repositories.IDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
    private IDeviceRepository repository;

    @Autowired
    public void setRepository(IDeviceRepository repository) {
        this.repository = repository;
    }

    public Device saveDevice(Device device) {
        return repository.save(device);
    }

    public Device findDeviceById(Integer id) {
        return repository.findOne(id);
    }

    public Device findDeviceBySerialNumber(String serialNumber) {
        return repository.findBySerialNumber(serialNumber);
    }

    public List<Device> findDeviceByUserId(int userId) {
        return repository.findByUserId(userId);
    }

    public Page<Device> findAll(int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.repository.findAll(pr);
    }
}
