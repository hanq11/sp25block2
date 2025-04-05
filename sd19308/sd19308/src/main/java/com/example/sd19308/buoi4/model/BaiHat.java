package com.example.sd19308.buoi4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bai_hat")
public class BaiHat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_bai_hat")
    private String tenBaiHat;

    @Column(name = "ten_tac_gia")
    private String tenTacGia;

    @Column(name = "thoi_luong")
    private Integer thoiLuong;

    @Column(name = "ngay_san_xuat")
    private String ngaySanXuat;

    @Column(name = "gia")
    private Float gia;

    @Column(name = "phat_hanh_dia")
    private Boolean phatHanhDia;

    @Column(name = "ngay_ra_mat")
    private String ngay_ra_mat;

    @ManyToOne
    @JoinColumn(name = "ca_si_id", referencedColumnName = "id")
    private CaSi caSi;
}
