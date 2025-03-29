package com.example.sd19308.buoi3.model;

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
@Table(name = "nhan_vien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "chuc_vu")
    private String chucVu;

    @Column(name = "luong")
    private Integer luong;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @Column(name = "ngay_vao")
    private String ngayVao;

    @ManyToOne
    @JoinColumn(name = "id_cong_ty", referencedColumnName = "id")
    private CongTy congTy;
}
