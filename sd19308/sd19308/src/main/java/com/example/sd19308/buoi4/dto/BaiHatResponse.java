package com.example.sd19308.buoi4.dto;

import com.example.sd19308.buoi4.model.CaSi;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaiHatResponse {
    private Integer id;

    private String tenBaiHat;

    private String tenTacGia;

    private Integer thoiLuong;

    private String ngaySanXuat;

    private Float gia;

    private Boolean phatHanhDia;

    private String ngay_ra_mat;

    private Integer id_ca_si;

    private String ten_ca_si;
}
