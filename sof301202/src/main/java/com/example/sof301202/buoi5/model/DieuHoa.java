package com.example.sof301202.buoi5.model;

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
@Table(name = "DieuHoa")
public class DieuHoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "gia")
    private Float gia;

    @Column(name = "chuc_nang")
    private String chucNang;

    @Column(name = "inverter")
    private Boolean inverter;
}
