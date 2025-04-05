package com.example.sd19308.buoi4.repository;

import com.example.sd19308.buoi4.dto.BaiHatResponse;
import com.example.sd19308.buoi4.model.BaiHat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaiHatRepository extends JpaRepository<BaiHat, Integer> {
    // JPQL
    @Query("""
            SELECT new com.example.sd19308.buoi4.dto.BaiHatResponse(
                bh.id,
                bh.tenBaiHat,
                bh.tenTacGia,
                bh.thoiLuong,
                bh.ngaySanXuat,
                bh.gia,
                bh.phatHanhDia,
                bh.ngay_ra_mat,
                bh.caSi.id,
                bh.caSi.tenCaSi
            ) FROM BaiHat bh
            """)
    public List<BaiHatResponse> getAllResponse();
}
