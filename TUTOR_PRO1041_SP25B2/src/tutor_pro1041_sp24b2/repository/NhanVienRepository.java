/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutor_pro1041_sp24b2.repository;

import tutor_pro1041_sp24b2.util.DbConnection;
import java.sql.*;
/**
 *
 * @author Syn
 */
public class NhanVienRepository {
    
    private Connection conn = null;
    
    public NhanVienRepository() {
        conn = DbConnection.getConnection();
    }
    
    public Boolean login(String ma, String matKhau) {
        Boolean result = null;
        String sql = """
                        SELECT * FROM NhanVien
                        WHERE Ma = ? AND MatKhau = ?;
                     """;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            result = rs.next() ? true : false;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
