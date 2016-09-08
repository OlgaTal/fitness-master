package com.chyld.services;

import com.chyld.entities.Exercise;
import com.chyld.entities.User;
import com.chyld.repositories.IExcerciseRepository;
import com.chyld.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    private IExcerciseRepository repository;

    @Autowired
    public void setRepository(IExcerciseRepository repository) {this.repository = repository;}

    public List<Exercise> findExcercisesByUser(int userId) {
        User user = new User();
        user.setId(userId);
        return  repository.findByUser(user);
    }

    public void saveExcercise(int userId, Exercise exercise) {

        User user = new User();
        user.setId(userId);

        exercise.setUser(user);
        repository.save(exercise);

    }

    public boolean updateExcercise(int userId, Exercise exercise) {

        Exercise oldExercise = repository.findOne(exercise.getId());
        if (oldExercise != null && oldExercise.getUser() != null &&
            oldExercise.getUser().getId() == userId) {
            oldExercise.setCalories(exercise.getCalories());
            oldExercise.setDuration(exercise.getDuration());
            oldExercise.setQuantity(exercise.getQuantity());
            oldExercise.setType(exercise.getType());

            repository.save(oldExercise);
            return true;
        }
        return false;
    }

    public boolean deleteExcercise(int userId, int exerciseId) {
        Exercise exercise = repository.findOne(exerciseId);

        if (exercise != null && exercise.getUser() != null &&
            exercise.getUser().getId() == userId) {
            repository.delete(exerciseId);
            return true;
        }
        return false;
    }

    public Exercise findExcercise(int userId, int exerciseId) {
        Exercise exercise = repository.findOne(exerciseId);

        if (exercise != null && exercise.getUser() != null &&
                exercise.getUser().getId() == userId) {
            return exercise;
        }
        return null;
    }

}
