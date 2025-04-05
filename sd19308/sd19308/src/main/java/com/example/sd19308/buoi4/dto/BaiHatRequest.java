package com.example.sd19308.buoi4.dto;

import com.example.sd19308.buoi4.model.CaSi;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaiHatRequest {
    private Integer id;
    @NotBlank
    private String tenBaiHat;
    @NotBlank
    private String tenTacGia;
    @NotNull
    private Integer thoiLuong;
    @NotBlank
    private String ngaySanXuat;
    @NotNull
    private Float gia;
    @NotNull
    private Boolean phatHanhDia;
    @NotBlank
    private String ngay_ra_mat;
    @NotNull
    private CaSi caSi;
}
