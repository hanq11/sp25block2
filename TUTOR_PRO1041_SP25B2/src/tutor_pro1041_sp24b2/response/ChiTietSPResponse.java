/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutor_pro1041_sp24b2.response;

import lombok.AllArgsConstructor;
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
public class ChiTietSPResponse {
    private Integer id;
    private String tenSanPham;
    private String tenNhaSanXuat;
    private String tenMauSac;
    private String tenDongSanPham;
    private Integer namBaoHanh;
    private String moTa;
    private Integer soLuongTon;
    private Integer giaNhap;
    private Integer giaBan;
}
