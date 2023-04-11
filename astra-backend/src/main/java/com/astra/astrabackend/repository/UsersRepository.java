package com.astra.astrabackend.repository;

import com.astra.astrabackend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users , String> {

}
