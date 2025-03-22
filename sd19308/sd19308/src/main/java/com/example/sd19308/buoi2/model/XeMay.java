package com.example.sd19308.buoi2.model;


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
@Table(name = "xe_may")
public class XeMay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "thuong_hieu")
    private String thuongHieu;

    @Column(name = "mau_xe")
    private String mauXe;

    @Column(name = "ngay_san_xuat")
    private String ngaySanXuat;

    @Column(name = "dung_tich_dong_co")
    private String dungTichDongCo;

    @Column(name = "gia")
    private Integer gia;
}
