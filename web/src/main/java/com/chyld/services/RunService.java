package com.chyld.services;

import com.chyld.entities.Device;
import com.chyld.entities.Run;
import com.chyld.repositories.IDeviceRepository;
import com.chyld.repositories.IRunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RunService {
    private IRunRepository repository;
    private IDeviceRepository deviceRepository;

    @Autowired
    public void setRepository(IRunRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setDeviceRepository(IDeviceRepository repository) {
        this.deviceRepository = repository;
    }

    public Run saveRun(String devSn) {
        // find device by serialNumber

        Device device = deviceRepository.findBySerialNumber(devSn);

        Run r = repository.findByDeviceIdAndActive(device.getId(), true);

        if (r == null) {
            Run run = new Run(device);
            run.setActive(true);
            return repository.save(run);
        }

        return null;
    }

    public Run findRunById(Integer id) {
        return repository.findOne(id);
    }

    public List<Run> findRunByDeviceId(int deviceId) {
        return repository.findByDeviceId(deviceId);
    }

    public Run stopRun(String devSn) {
        Device device = deviceRepository.findBySerialNumber(devSn);
        Run r = repository.findByDeviceIdAndActive(device.getId(), true);
        if (r == null) {
            return null;
        }
        r.setEndTime(new Date());
        r.setActive(false);

        return repository.save(r);
    }

    public List<Run> findRunByDeviceSn(String devSerialNumber) {
        Device device = deviceRepository.findBySerialNumber(devSerialNumber);
        return repository.findByDeviceId(device.getId());
    }
}
