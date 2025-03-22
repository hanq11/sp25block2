/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutor_pro1041_sp24b2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import tutor_pro1041_sp24b2.model.SanPham;
import tutor_pro1041_sp24b2.util.DbConnection;

/**
 *
 * @author Syn
 */
public class SanPhamRepository {
    private Connection conn = null;
    
    public SanPhamRepository() {
        conn = DbConnection.getConnection();
    }
    
    public ArrayList<SanPham> getAll() {
        ArrayList<SanPham> danhSach = new ArrayList<>();
        String sql = """
                        SELECT Id, Ma, Ten, TrangThai FROM SanPham;
                     """;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                danhSach.add(new SanPham(
                        rs.getInt("Id"),
                        rs.getString("Ma"),
                        rs.getString("Ten"),
                        rs.getInt("TrangThai")
                ));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    
    public void themSanPham(SanPham sanPham) {
        String sql = """
                        INSERT INTO SanPham (Ma, Ten, TrangThai)
                        VALUES
                            (?, ?, ?);
                     """;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sanPham.getMa());
            ps.setString(2, sanPham.getTen());
            ps.setInt(3, sanPham.getTrangThai());
            ps.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void suaSanPham(SanPham sanPham) {
        String sql = """
                        UPDATE SanPham
                        SET
                            Ma = ?,
                            Ten = ?,
                            TrangThai = ?
                        WHERE Id = ?
                     """;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sanPham.getMa());
            ps.setString(2, sanPham.getTen());
            ps.setInt(3, sanPham.getTrangThai());
            ps.setInt(4, sanPham.getId());
            ps.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
