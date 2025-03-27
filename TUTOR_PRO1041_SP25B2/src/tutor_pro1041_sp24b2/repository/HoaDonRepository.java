/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutor_pro1041_sp24b2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import tutor_pro1041_sp24b2.model.ChiTietSP;
import tutor_pro1041_sp24b2.model.DongSanPham;
import tutor_pro1041_sp24b2.model.HoaDon;
import tutor_pro1041_sp24b2.util.DbConnection;

/**
 *
 * @author Syn
 */
public class HoaDonRepository {
    private Connection conn = null;
    
    public HoaDonRepository() {
        conn = DbConnection.getConnection();
    }
    
    public ArrayList<HoaDon> getAll() {
        ArrayList<HoaDon> danhSach = new ArrayList<>();
        String sql = """
                        SELECT Id, TenNguoiNhan, Sdt, NgayTao, TinhTrang FROM HoaDon;
                     """;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                danhSach.add(new HoaDon(
                        rs.getInt("Id"),
                        rs.getString("TenNguoiNhan"),
                        rs.getString("Sdt"),
                        rs.getString("NgayTao"),
                        rs.getInt("TinhTrang")
                ));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    
    public ArrayList<HoaDon> getAllChuaThanhToan() {
        ArrayList<HoaDon> danhSach = new ArrayList<>();
        String sql = """
                        SELECT 
                            Id, TenNguoiNhan, Sdt, NgayTao, TinhTrang 
                        FROM HoaDon
                        WHERE TinhTrang = 0;
                     """;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                danhSach.add(new HoaDon(
                        rs.getInt("Id"),
                        rs.getString("TenNguoiNhan"),
                        rs.getString("Sdt"),
                        rs.getString("NgayTao"),
                        rs.getInt("TinhTrang")
                ));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    
    public void themHoaDon(HoaDon hoaDon) {
        String sql = """
                        INSERT INTO HoaDon (TenNguoiNhan, NgayTao, Sdt, TinhTrang)
                             VALUES
                                   (?, ?, ?, 0)
                     """;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hoaDon.getTenNguoiNhan());
            ps.setString(2, hoaDon.getNgayTao());
            ps.setString(3, hoaDon.getSoDienThoai());
            ps.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void thanhToanHoaDon(HoaDon hoaDon) {
        String sql = """
                        UPDATE HoaDon
                        SET TinhTrang = 1
                        WHERE id = ?;
                     """;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, hoaDon.getId());
            ps.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
