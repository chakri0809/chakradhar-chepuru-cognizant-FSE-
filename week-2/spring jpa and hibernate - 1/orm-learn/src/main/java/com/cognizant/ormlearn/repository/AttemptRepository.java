package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Attempt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttemptRepository extends CrudRepository<Attempt, Integer> {

    @Query("SELECT a FROM Attempt a " +
            "JOIN FETCH a.user u " +
            "JOIN FETCH a.questions q " +
            "JOIN FETCH q.options o " +
            "WHERE u.id = :userId AND a.id = :attemptId")
    Attempt getAttempt(int userId, int attemptId);
}
