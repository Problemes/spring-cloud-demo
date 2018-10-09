package com.hr.cloud.microserviceprovideruser.repository;

import com.hr.cloud.microserviceprovideruser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
