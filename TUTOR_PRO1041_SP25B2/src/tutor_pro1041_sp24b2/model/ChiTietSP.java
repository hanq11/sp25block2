/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutor_pro1041_sp24b2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Syn
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChiTietSP {
    private Integer id;
    private Integer idSanPham;
    private Integer idNhaSanXuat;
    private Integer idMauSac;
    private Integer idDongSanPham;
    private Integer namBaoHanh;
    private String moTa;
    private Integer soLuongTon;
    private Integer giaNhap;
    private Integer giaBan;
}
