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
import tutor_pro1041_sp24b2.model.HoaDonChiTiet;
import tutor_pro1041_sp24b2.model.SanPham;
import tutor_pro1041_sp24b2.response.ChiTietSPResponse;
import tutor_pro1041_sp24b2.response.HoaDonChiTietResponse;
import tutor_pro1041_sp24b2.util.DbConnection;

/**
 *
 * @author Syn
 */
public class HoaDonChiTietRepository {
    private Connection conn = null;
    
    public HoaDonChiTietRepository() {
        conn = DbConnection.getConnection();
    }
    
    public ArrayList<HoaDonChiTietResponse> getAll(Integer idHoaDon) {
        ArrayList<HoaDonChiTietResponse> danhSach = new ArrayList<>();
        String sql = """
                       SELECT 
                       	hdct.Id,
                       	ctsp.Id,
                       	sp.Ten,
                       	ms.Ten,
                       	hdct.SoLuong,
                       	hdct.DonGia
                       FROM HoaDonChiTiet hdct 
                       INNER JOIN ChiTietSP ctsp ON hdct.IdChiTietSP = ctsp.Id
                       INNER JOIN SanPham sp ON ctsp.IdSP = sp.Id
                       INNER JOIN MauSac ms ON ctsp.IdMauSac = ms.Id
                       WHERE hdct.IdHoaDon = ?
                     """;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idHoaDon);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                danhSach.add(new HoaDonChiTietResponse(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6)
                ));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    
   public void themHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet) {
        String sql = """
                        INSERT INTO [dbo].[HoaDonChiTiet]
                                   ([IdHoaDon]
                                   ,[IdChiTietSP]
                                   ,[SoLuong]
                                   ,[DonGia])
                             VALUES
                                   (?, ?, ?, ?)
                     """;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, hoaDonChiTiet.getIdHoaDon());
            ps.setInt(2, hoaDonChiTiet.getIdChiTietSanPham());
            ps.setInt(3, hoaDonChiTiet.getSoLuong());
            ps.setInt(4, hoaDonChiTiet.getDonGia());
            ps.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
