/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutor_pro1041_sp24b2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import tutor_pro1041_sp24b2.model.DongSanPham;
import tutor_pro1041_sp24b2.model.MauSac;
import tutor_pro1041_sp24b2.model.NhaSanXuat;
import tutor_pro1041_sp24b2.model.SanPham;
import tutor_pro1041_sp24b2.util.DbConnection;

/**
 *
 * @author Syn
 */
public class DongSanPhamRepository {
    private Connection conn = null;
    
    public DongSanPhamRepository() {
        conn = DbConnection.getConnection();
    }
    
    public ArrayList<DongSanPham> getAll() {
        ArrayList<DongSanPham> danhSach = new ArrayList<>();
        String sql = """
                        SELECT Id, Ma, Ten FROM DongSP;
                     """;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                danhSach.add(new DongSanPham(
                        rs.getInt("Id"),
                        rs.getString("Ma"),
                        rs.getString("Ten")
                ));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    
}
