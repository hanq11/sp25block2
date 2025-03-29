package com.example.sd19308.buoi3.repository;

import com.example.sd19308.buoi3.model.CongTy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongTyRepository extends JpaRepository<CongTy, Integer> {
}
