package com.example.sd19308.buoi2.repository;

import com.example.sd19308.buoi2.model.XeMay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XeMayRepository extends JpaRepository<XeMay, Integer> {
}
