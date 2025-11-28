package com.ms.user.dao;

import com.ms.user.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;

public interface UserRepository extends JpaRepository<UserModel, UID> {
}
