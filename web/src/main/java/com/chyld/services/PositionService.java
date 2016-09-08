package com.chyld.services;

import com.chyld.entities.Device;
import com.chyld.entities.Position;
import com.chyld.entities.Run;
import com.chyld.repositories.IDeviceRepository;
import com.chyld.repositories.IPositionRepository;
import com.chyld.repositories.IRunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PositionService {
    private IPositionRepository repository;
    private IDeviceRepository deviceRepository;
    private IRunRepository runRepository;

    @Autowired
    public void setRepository(IPositionRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setDeviceRepository(IDeviceRepository repository) {
        this.deviceRepository = repository;
    }

    @Autowired
    public void setRunRepository(IRunRepository repository) {
        this.runRepository = repository;
    }


    public Position savePosition(String devSn, Position pos) {
        // find device by serialNumber

        Device device = deviceRepository.findBySerialNumber(devSn);

        Run r = runRepository.findByDeviceIdAndActive(device.getId(), true);

        if (r == null) {
            return null;
        }

        pos.setRun(r);
        return repository.save(pos);

    }

    public Position findPositionById(Integer id) {
        return repository.findOne(id);
    }

    public List<Position> findPositionByDeviceSn(String devSn) {
        Device device = deviceRepository.findBySerialNumber(devSn);

        Run r = runRepository.findByDeviceIdAndActive(device.getId(), true);

        if (r == null) {
            return null;
        }

        return repository.findByRunId(r.getId());
    }

}
