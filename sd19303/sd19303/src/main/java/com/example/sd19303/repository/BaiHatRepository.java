package com.example.sd19303.repository;

import com.example.sd19303.model.BaiHat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaiHatRepository extends JpaRepository<BaiHat, Integer> {
}
