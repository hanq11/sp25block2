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
    
    public void themChiTietSanPham(ChiTietSP chiTietSP) {
        String sql = """
                        INSERT INTO [dbo].[ChiTietSP]
                                   ([IdSP]
                                   ,[IdNsx]
                                   ,[IdMauSac]
                                   ,[IdDongSP]
                                   ,[NamBH]
                                   ,[MoTa]
                                   ,[SoLuongTon]
                                   ,[GiaNhap]
                                   ,[GiaBan])
                             VALUES
                                   (?, ?, ?, ?, ?, ?, ?, ?, ?)
                     """;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, chiTietSP.getIdSanPham());
            ps.setInt(2, chiTietSP.getIdNhaSanXuat());
            ps.setInt(3, chiTietSP.getIdMauSac());
            ps.setInt(4, chiTietSP.getIdDongSanPham());
            ps.setInt(5, chiTietSP.getNamBaoHanh());
            ps.setString(6, chiTietSP.getMoTa());
            ps.setInt(7, chiTietSP.getSoLuongTon());
            ps.setInt(8, chiTietSP.getGiaNhap());
            ps.setInt(9, chiTietSP.getGiaBan());
            ps.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void suaChiTietSanPham(ChiTietSP chiTietSP) {
        String sql = """
                        UPDATE [dbo].[ChiTietSP]
                        SET [IdSP] = ?
                           ,[IdNsx] = ?
                           ,[IdMauSac] = ?
                           ,[IdDongSP] = ?
                           ,[NamBH] = ?
                           ,[MoTa] = ?
                           ,[SoLuongTon] = ?
                           ,[GiaNhap] = ?
                           ,[GiaBan] = ?
                        WHERE Id = ?
                     """;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, chiTietSP.getIdSanPham());
            ps.setInt(2, chiTietSP.getIdNhaSanXuat());
            ps.setInt(3, chiTietSP.getIdMauSac());
            ps.setInt(4, chiTietSP.getIdDongSanPham());
            ps.setInt(5, chiTietSP.getNamBaoHanh());
            ps.setString(6, chiTietSP.getMoTa());
            ps.setInt(7, chiTietSP.getSoLuongTon());
            ps.setInt(8, chiTietSP.getGiaNhap());
            ps.setInt(9, chiTietSP.getGiaBan());
            ps.setInt(10, chiTietSP.getId());
            ps.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void suaSoLuong(ChiTietSP chiTietSP) {
        String sql = """
                        UPDATE [dbo].[ChiTietSP]
                        SET [SoLuongTon] = ?
                        WHERE Id = ?
                     """;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, chiTietSP.getSoLuongTon());
            ps.setInt(2, chiTietSP.getId());
            ps.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
