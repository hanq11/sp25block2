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
import tutor_pro1041_sp24b2.response.ChiTietSPResponse;
import tutor_pro1041_sp24b2.util.DbConnection;

/**
 *
 * @author Syn
 */
public class ChiTietSPRepository {
    private Connection conn = null;
    
    public ChiTietSPRepository() {
        conn = DbConnection.getConnection();
    }
    
    public ArrayList<ChiTietSPResponse> getAll() {
        ArrayList<ChiTietSPResponse> danhSach = new ArrayList<>();
        String sql = """
                        SELECT 
                        	ctsp.id, sp.Ten, nsx.Ten, ms.Ten, dsp.Ten,
                        	ctsp.NamBH, ctsp.MoTa, ctsp.SoLuongTon, ctsp.GiaNhap, ctsp.GiaBan
                        FROM ChiTietSP ctsp
                        JOIN SanPham sp ON ctsp.IdSP = sp.Id
                        JOIN NSX nsx ON ctsp.IdNsx = nsx.Id
                        JOIN MauSac ms ON ctsp.IdMauSac = ms.Id
                        JOIN DongSP dsp ON ctsp.IdDongSP = dsp.Id
                     """;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                danhSach.add(new ChiTietSPResponse(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10)
                ));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return danhSach;
    }
}
