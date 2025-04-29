package com.api.learn.restApiLearning.repos;

import com.api.learn.restApiLearning.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Long> {



}
