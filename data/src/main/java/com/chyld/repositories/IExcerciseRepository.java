package com.chyld.repositories;

import com.chyld.entities.Exercise;
import com.chyld.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface IExcerciseRepository extends PagingAndSortingRepository<Exercise, Integer> {

    public List<Exercise> findByUser(User user);

}
