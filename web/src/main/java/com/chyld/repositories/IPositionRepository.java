package com.chyld.repositories;

import com.chyld.entities.Position;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IPositionRepository extends PagingAndSortingRepository<Position, Integer> {

    List<Position> findByRunId(int id);

}
