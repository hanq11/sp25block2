package com.example.sd19303.model;

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

    @Column(name = "luot_nghe")
    private Integer luotNghe;

    @Column(name = "ngay_phat_hanh")
    private String ngayPhatHanh;

    @ManyToOne
    @JoinColumn(name = "id_ca_si", referencedColumnName = "id")
    private CaSi caSi;
}
