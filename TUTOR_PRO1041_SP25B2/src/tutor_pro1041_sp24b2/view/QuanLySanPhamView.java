/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tutor_pro1041_sp24b2.view;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import tutor_pro1041_sp24b2.model.DongSanPham;
import tutor_pro1041_sp24b2.model.MauSac;
import tutor_pro1041_sp24b2.model.NhaSanXuat;
import tutor_pro1041_sp24b2.model.SanPham;
import tutor_pro1041_sp24b2.repository.ChiTietSPRepository;
import tutor_pro1041_sp24b2.repository.DongSanPhamRepository;
import tutor_pro1041_sp24b2.repository.MauSacRepository;
import tutor_pro1041_sp24b2.repository.NhaSanXuatRepository;
import tutor_pro1041_sp24b2.repository.SanPhamRepository;
import tutor_pro1041_sp24b2.response.ChiTietSPResponse;

/**
 *
 * @author Syn
 */
public class QuanLySanPhamView extends javax.swing.JPanel {
    SanPhamRepository sanPhamRepository;
    ChiTietSPRepository chiTietSPRepository;
    DefaultTableModel dtmSanPham;
    DefaultTableModel dtmChiTietSanPham;
    //// Combobox - Chi tiet san pham
    DefaultComboBoxModel cbmSanPham;
    DefaultComboBoxModel cbmNhaSanXuat;
    DefaultComboBoxModel cbmMauSac;
    DefaultComboBoxModel cbmDongSanPham;
    NhaSanXuatRepository nhaSanXuatRepository;
    MauSacRepository mauSacRepository;
    DongSanPhamRepository dongSanPhamRepository;
    /**
     * Creates new form QuanLySanPhamView
     */
    public QuanLySanPhamView() {
        initComponents();
        // San pham
        sanPhamRepository = new SanPhamRepository();
        dtmSanPham = (DefaultTableModel) tblSanPham.getModel();
        // Chi tiet san pham
        chiTietSPRepository = new ChiTietSPRepository();
        dtmChiTietSanPham = (DefaultTableModel) tblSanPhamChiTiet.getModel();
        
        //// Combobox - Chi tiet san pham
        cbmSanPham = (DefaultComboBoxModel) cbbSanPham.getModel();
        cbmNhaSanXuat = (DefaultComboBoxModel) cbbNhaSanXuat.getModel();
        cbmMauSac = (DefaultComboBoxModel) cbbMauSac.getModel();
        cbmDongSanPham = (DefaultComboBoxModel) cbbDongSanPham.getModel();
        nhaSanXuatRepository = new NhaSanXuatRepository();
        mauSacRepository = new MauSacRepository();
        dongSanPhamRepository = new DongSanPhamRepository();
        
        fillTableSanPham(sanPhamRepository.getAll());
        fillTableChiTietSanPham(chiTietSPRepository.getAll());
        fillComboBox(
                sanPhamRepository.getAll(),
                nhaSanXuatRepository.getAll(),
                mauSacRepository.getAll(),
                dongSanPhamRepository.getAll()
        );
    }

    public void fillComboBox(
            ArrayList<SanPham> listSanPham,
            ArrayList<NhaSanXuat> listNhaSanXuat,
            ArrayList<MauSac> listMauSac,
            ArrayList<DongSanPham> listDongSanPham) {
        cbbSanPham.removeAllItems();
        cbbNhaSanXuat.removeAllItems();
        cbbMauSac.removeAllItems();
        cbbDongSanPham.removeAllItems();
        listSanPham.forEach(sp -> cbbSanPham.addItem(sp.getTen()));
        listNhaSanXuat.forEach(nsx -> cbbNhaSanXuat.addItem(nsx.getTen()));
        listMauSac.forEach(ms -> cbbMauSac.addItem(ms.getTen()));
        listDongSanPham.forEach(dsp -> cbbDongSanPham.addItem(dsp.getTen()));
    }
    public void fillTableSanPham(ArrayList<SanPham> danhSach) {
        dtmSanPham.setRowCount(0);
        for(SanPham sanPham: danhSach) {
            dtmSanPham.addRow(new Object[]{
                sanPham.getId(),
                sanPham.getMa(),
                sanPham.getTen(),
                sanPham.getTrangThai() == 1 ? "Hoat dong" : "Khong hoat dong"
            });
        }
    }
    
    public void fillTableChiTietSanPham(ArrayList<ChiTietSPResponse> danhSach) {
        dtmChiTietSanPham.setRowCount(0);
        for(ChiTietSPResponse chiTietSPResponse: danhSach) {
            dtmChiTietSanPham.addRow(new Object[]{
                chiTietSPResponse.getId(),
                chiTietSPResponse.getTenSanPham(),
                chiTietSPResponse.getTenNhaSanXuat(),
                chiTietSPResponse.getTenMauSac(),
                chiTietSPResponse.getTenDongSanPham(),
                chiTietSPResponse.getNamBaoHanh(),
                chiTietSPResponse.getMoTa(),
                chiTietSPResponse.getSoLuongTon(),
                chiTietSPResponse.getGiaNhap(),
                chiTietSPResponse.getGiaBan()
            });
        }
    }
    
    public SanPham getFormSanPham() {
        Integer id = txtIdSanPham.getText().isBlank() ? 0 : Integer.valueOf(txtIdSanPham.getText());
        String ma = txtMaSanPham.getText();
        String ten = txtTenSanPham.getText();
        Integer trangThai = rdoHoatDongSanPham.isSelected() ? 1 : 0;
        return new SanPham(id, ma, ten, trangThai);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnThemSanPham = new javax.swing.JButton();
        btnSuaSanPham = new javax.swing.JButton();
        txtMaSanPham = new javax.swing.JTextField();
        txtTenSanPham = new javax.swing.JTextField();
        rdoHoatDongSanPham = new javax.swing.JRadioButton();
        rdoKhongHoatDongSanPham = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        txtIdSanPham = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbbSanPham = new javax.swing.JComboBox<>();
        cbbNhaSanXuat = new javax.swing.JComboBox<>();
        cbbMauSac = new javax.swing.JComboBox<>();
        cbbDongSanPham = new javax.swing.JComboBox<>();
        txtNamBaoHanh = new javax.swing.JTextField();
        txtMoTa = new javax.swing.JTextField();
        txtSoLuongTon = new javax.swing.JTextField();
        txtGiaNhap = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPhamChiTiet = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtIdChiTietSanPham = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();

        setMinimumSize(new java.awt.Dimension(800, 800));
        setPreferredSize(new java.awt.Dimension(800, 800));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Quản lý sản phẩm");

        btnThemSanPham.setText("Them");
        btnThemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSanPhamActionPerformed(evt);
            }
        });

        btnSuaSanPham.setText("Sua");
        btnSuaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSanPhamActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoHoatDongSanPham);
        rdoHoatDongSanPham.setText("Hoat dong");

        buttonGroup1.add(rdoKhongHoatDongSanPham);
        rdoKhongHoatDongSanPham.setText("Khong hoat dong");

        jLabel6.setText("Trang thai");

        jLabel4.setText("Ten");

        jLabel5.setText("Ma");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ma", "Ten", "Trang thai"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        jLabel7.setText("Id");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(rdoHoatDongSanPham)
                                .addGap(29, 29, 29)
                                .addComponent(rdoKhongHoatDongSanPham)))
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(86, 86, 86)
                                .addComponent(btnThemSanPham))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSuaSanPham)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThemSanPham)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaSanPham)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rdoHoatDongSanPham)
                    .addComponent(rdoKhongHoatDongSanPham))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý sản phẩm", jPanel1);

        jLabel2.setText("San pham");

        jLabel8.setText("Nha san xuat");

        jLabel9.setText("Mau sac");

        jLabel10.setText("Dong san pham");

        jLabel11.setText("Mo ta");

        jLabel12.setText("Nam bao hanh");

        jLabel13.setText("So luong ton");

        jLabel14.setText("Gia nhap");

        jLabel15.setText("Gia ban");

        cbbSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbNhaSanXuat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbDongSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tblSanPhamChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdCTSP", "San pham", "Nha san xuat", "Mau sac", "Dong san pham", "Nam bao hanh", "Mo ta", "So luong ton", "Gia nhap", "Gia ban"
            }
        ));
        jScrollPane2.setViewportView(tblSanPhamChiTiet);

        btnThem.setText("Them");

        btnSua.setText("Sua");

        jLabel3.setText("Id CTSP");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbbNhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addGap(33, 33, 33)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cbbSanPham, 0, 182, Short.MAX_VALUE)
                                        .addComponent(txtIdChiTietSanPham))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbDongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNamBaoHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSua)
                                    .addComponent(btnThem))
                                .addGap(20, 20, 20))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtNamBaoHanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem)
                    .addComponent(jLabel3)
                    .addComponent(txtIdChiTietSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbbNhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cbbDongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý chi tiết sản phẩm", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 794, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 673, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Quản lý thuộc tính sản phẩm", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        int selectedIndex = tblSanPham.getSelectedRow();
        txtIdSanPham.setText(tblSanPham.getValueAt(selectedIndex, 0).toString());
        txtMaSanPham.setText(tblSanPham.getValueAt(selectedIndex, 1).toString());
        txtTenSanPham.setText(tblSanPham.getValueAt(selectedIndex, 2).toString());
        if(tblSanPham.getValueAt(selectedIndex, 3).toString().equals("Hoat dong")) {
            rdoHoatDongSanPham.setSelected(true);
        } else {
            rdoKhongHoatDongSanPham.setSelected(true);
        }
        
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnThemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSanPhamActionPerformed
        sanPhamRepository.themSanPham(this.getFormSanPham());
        fillTableSanPham(sanPhamRepository.getAll());
    }//GEN-LAST:event_btnThemSanPhamActionPerformed

    private void btnSuaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSanPhamActionPerformed
        sanPhamRepository.suaSanPham(this.getFormSanPham());
        fillTableSanPham(sanPhamRepository.getAll());
    }//GEN-LAST:event_btnSuaSanPhamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSuaSanPham;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemSanPham;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbDongSanPham;
    private javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JComboBox<String> cbbNhaSanXuat;
    private javax.swing.JComboBox<String> cbbSanPham;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdoHoatDongSanPham;
    private javax.swing.JRadioButton rdoKhongHoatDongSanPham;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblSanPhamChiTiet;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtIdChiTietSanPham;
    private javax.swing.JTextField txtIdSanPham;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtNamBaoHanh;
    private javax.swing.JTextField txtSoLuongTon;
    private javax.swing.JTextField txtTenSanPham;
    // End of variables declaration//GEN-END:variables
}
