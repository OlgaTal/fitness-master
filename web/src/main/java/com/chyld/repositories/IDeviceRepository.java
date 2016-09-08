package com.chyld.repositories;

import com.chyld.entities.Device;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IDeviceRepository extends PagingAndSortingRepository<Device, Integer> {
    public Device findBySerialNumber(String serialNumber);

    List<Device> findByUserId(int userId);
}
