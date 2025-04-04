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
@Table(name = "ca_si")
public class CaSi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_ca_si")
    private String tenCaSi;

    @Column(name = "que_quan")
    private String queQuan;

    @Column(name = "tuoi")
    private Integer tuoi;

    @Column(name = "cong_ty")
    private String congTy;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;
}
