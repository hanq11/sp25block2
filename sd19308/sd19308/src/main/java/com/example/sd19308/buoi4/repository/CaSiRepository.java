package com.example.sd19308.buoi4.repository;

import com.example.sd19308.buoi4.model.CaSi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaSiRepository extends JpaRepository<CaSi, Integer> {
}
