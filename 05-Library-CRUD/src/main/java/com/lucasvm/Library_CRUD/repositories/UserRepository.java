package com.lucasvm.Library_CRUD.repositories;

import com.lucasvm.Library_CRUD.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
}
