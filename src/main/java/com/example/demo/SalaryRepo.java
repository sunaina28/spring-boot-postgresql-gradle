package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface SalaryRepo extends JpaRepository<SalaryModel,String> {
SalaryModel findByJobName(String jobName);
List<SalaryModel> findAll();
}

