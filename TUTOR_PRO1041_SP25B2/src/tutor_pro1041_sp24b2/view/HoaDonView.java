/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tutor_pro1041_sp24b2.view;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import tutor_pro1041_sp24b2.model.HoaDon;
import tutor_pro1041_sp24b2.repository.ChiTietSPRepository;
import tutor_pro1041_sp24b2.repository.HoaDonChiTietRepository;
import tutor_pro1041_sp24b2.repository.HoaDonRepository;
import tutor_pro1041_sp24b2.response.HoaDonChiTietResponse;

/**
 *
 * @author Syn
 */
public class HoaDonView extends javax.swing.JPanel {
    // Hoa don
    HoaDonRepository hoaDonRepository;
    DefaultTableModel dtmHoaDon;
    // Gio hang
    HoaDonChiTietRepository hoaDonChiTietRepository;
    DefaultTableModel dtmHoaDonChiTiet;
    /**
     * Creates new form HoaDonView
     */
    int idHoaDon = -1;
    public HoaDonView() {
        initComponents();
        hoaDonRepository = new HoaDonRepository();
        dtmHoaDon = (DefaultTableModel) tblHoaDon.getModel();
        
        
        hoaDonChiTietRepository = new HoaDonChiTietRepository();
        dtmHoaDonChiTiet = (DefaultTableModel) tblGioHang.getModel();
        
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                fillTableHoaDon(hoaDonRepository.getAll());
            }
        });
    }
    private void fillTableGiohang(ArrayList<HoaDonChiTietResponse> danhSach) {
          dtmHoaDonChiTiet.setRowCount(0);
          for(HoaDonChiTietResponse hdct: danhSach) {
              dtmHoaDonChiTiet.addRow(new Object[]{
                 hdct.getId(),
                 hdct.getIdChiTietSanPham(),
                 hdct.getTenSanPham(),
                 hdct.getTenMauSac(),
                 hdct.getSoLuong(),
                 hdct.getDonGia()
              });
          }
      }
    private void fillTableHoaDon(ArrayList<HoaDon> danhSach) {
        dtmHoaDon.setRowCount(0);
        for(HoaDon hoaDon: danhSach) {
            dtmHoaDon.addRow(new Object[]{
                hoaDon.getId(),
                hoaDon.getTenNguoiNhan(),
                hoaDon.getTinhTrang() == 0 ? "Chưa thanh toán" : "Đã thanh toán", 
                hoaDon.getNgayTao()
            });
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(800, 800));
        setPreferredSize(new java.awt.Dimension(800, 800));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Hoa don");

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "IdChiTietSP", "Ten san pham", "Mau sac", "So luong", "Don gia"
            }
        ));
        jScrollPane1.setViewportView(tblGioHang);

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Khach hang", "Tinh trang", "Ngay tao"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Hoa don chi tiet");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Thong tin hoa don");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(338, 338, 338))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addContainerGap(39, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(jLabel3)
                    .addContainerGap(566, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(jLabel3)
                    .addContainerGap(713, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int selectedIndex = tblHoaDon.getSelectedRow();
        idHoaDon = Integer.valueOf(tblHoaDon.getValueAt(selectedIndex, 0).toString());
        fillTableGiohang(hoaDonChiTietRepository.getAll(idHoaDon));
    }//GEN-LAST:event_tblHoaDonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    // End of variables declaration//GEN-END:variables
}
