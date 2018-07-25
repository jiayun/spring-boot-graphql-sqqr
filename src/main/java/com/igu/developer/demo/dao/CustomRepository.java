package com.igu.developer.demo.dao;

import com.igu.developer.demo.model.Custom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomRepository extends JpaRepository<Custom, Long> {
}