package com.pertemuan7.pertemuan7.repository;


import com.pertemuan7.pertemuan7.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, String> {
}
