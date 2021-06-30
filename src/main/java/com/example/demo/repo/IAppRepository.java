package com.example.demo.repo;

import com.example.demo.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppRepository extends JpaRepository<AppRole,Long> {

}
