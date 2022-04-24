package com.edusys.ui;

import com.edusys.dao.ChuyenDeDAO;
import com.edusys.dao.HocVienDAO;
import com.edusys.dao.KhoaHocDAO;
import com.edusys.dao.NguoiHocDAO;
import com.edusys.entity.ChuyenDe;
import com.edusys.entity.HocVien;
import com.edusys.entity.KhoaHoc;
import com.edusys.entity.NguoiHoc;
import com.edusys.utils.Auth;
import com.edusys.utils.MsgBox;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class HocVienFrame extends javax.swing.JInternalFrame {

    public HocVienFrame() {
        initComponents();
        init();
    }

    ChuyenDeDAO cddao = new ChuyenDeDAO();
    KhoaHocDAO khdao = new KhoaHocDAO();
    NguoiHocDAO nhdao = new NguoiHocDAO();
    HocVienDAO hvdao = new HocVienDAO();

    void init() {
        fillComboBoxChuyenDe();
    }

    void fillComboBoxChuyenDe() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboChuyenDe.getModel();
        model.removeAllElements();
        List<ChuyenDe> list = cddao.selectAll();
        for (ChuyenDe cd : list) {
            model.addElement(cd);
        }
        fillComboBoxKhoaHoc();
    }

    void fillComboBoxKhoaHoc() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboKhoaHoc.getModel();
        model.removeAllElements();
        ChuyenDe chuyende = (ChuyenDe) cboChuyenDe.getSelectedItem();
        if (chuyende != null) {
            List<KhoaHoc> list = khdao.selectByChuyenDe(chuyende.getMaCD());
            for (KhoaHoc kh : list) {
                model.addElement(kh);
            }
            fillTableHocVien();
        }
    }

    void fillTableHocVien() {
        DefaultTableModel model = (DefaultTableModel) tblHocVien.getModel();
        model.setRowCount(0);
        KhoaHoc khoahoc = (KhoaHoc) cboKhoaHoc.getSelectedItem();
        if (khoahoc != null) {
            List<HocVien> list = hvdao.selectByKhoaHoc(khoahoc.getMaKH());
            for (int i = 0; i < list.size(); i++) {
                HocVien hv = list.get(i);
                String hoten = nhdao.selectByID(hv.getMaNH()).getHoTen();
                model.addRow(new Object[]{i + 1, hv.getMaHV(), hv.getMaNH(), hoten, hv.getDiem()});
            }
            fillTableNguoiHoc();
        }
    }

    void fillTableNguoiHoc() {
        DefaultTableModel model = (DefaultTableModel) tblNguoiHoc.getModel();
        model.setRowCount(0);
        KhoaHoc khoahoc = (KhoaHoc) cboKhoaHoc.getSelectedItem();
        String keyword = txtTimKiem.getText();
        List<NguoiHoc> list = nhdao.selectNotInCourse(khoahoc.getMaKH(), keyword);
        for (NguoiHoc nh : list) {
            model.addRow(new Object[]{
                nh.getMaNH(),
                nh.getHoTen(),
                nh.isGioiTinh() ? "Nam" : "Nữ",
                nh.getNgaySinh(),
                nh.getDienThoai(),
                nh.getEmail()
            });
        }
    }

    void addHocVien() {
        try {
            KhoaHoc khoahoc = (KhoaHoc) cboKhoaHoc.getSelectedItem();
            for (int row : tblNguoiHoc.getSelectedRows()) {
                HocVien hv = new HocVien();
                hv.setMaKH(khoahoc.getMaKH());
                hv.setMaNH((String) tblNguoiHoc.getValueAt(row, 0));
                hv.setDiem(null);
                hvdao.insert(hv);
            }
            fillTableHocVien();
            MsgBox.alert(this, "Thêm học viên thành công!");
            tabs.setSelectedIndex(0);
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm học viên thất bại!");
        }

    }

    void removeHocVien() {
        try {
            if (!Auth.isManager()) {
                MsgBox.alert(this, "Bạn không có quyền xóa học viên!");
            } else {
                if (MsgBox.confirm(this, "Bạn có muốn xóa các học viên được chọn?")) {
                    for (int row : tblHocVien.getSelectedRows()) {
                        int mahv = (Integer) tblHocVien.getValueAt(row, 1);
                        hvdao.delete(mahv);
                    }
                    fillTableHocVien();
                    MsgBox.alert(this, "Xóa học viên thành công!");
                }
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Xóa học viên thất bại!");
        }

    }

    void updateDiem() {
        try {
            System.out.println("Uodate");
            KhoaHoc khoahoc = (KhoaHoc) cboKhoaHoc.getSelectedItem();
            for (int i = 0; i < tblHocVien.getRowCount(); i++) {
                int mahv = (Integer) tblHocVien.getValueAt(i, 1);
                String manh = (String) tblHocVien.getValueAt(i, 2);
                Double diem = Double.parseDouble(String.valueOf(tblHocVien.getValueAt(i, 4)));
                HocVien hv = hvdao.selectByID(mahv);
                hv.setMaHV(mahv);
                hv.setMaKH(khoahoc.getMaKH());
                hv.setMaNH(manh);
                hv.setDiem(diem);
                hvdao.update(hv);
            }
            fillTableHocVien();
            MsgBox.alert(this, "Cập nhật điểm thành công!");
        } catch (Exception e) {
//            e.printStackTrace();
//            MsgBox.alert(this, "Cập nhật điểm thất bại!");
        }

    }

    private boolean CheckDiem() {
        Double diem = null;
        for (int i = 0; i < this.tblHocVien.getRowCount(); i++) {
            if (tblHocVien.getValueAt(i, 4).equals("")) {
                System.out.println("1");
                MsgBox.alert(this, "Không để trống");
                return false;
            }
            try {
                diem = Double.parseDouble(tblHocVien.getValueAt(i, 4).toString());
                if (diem < 0) {
                    MsgBox.alert(this, "Điểm phải lớn hơn hoặc bằng 0");
                    return false;
                } else if (diem > 10) {
                    MsgBox.alert(this, "Điểm phải nhỏ hơn hoặc bằng 10");
                    return false;
                }
            } catch (Exception e) {
                System.out.println("2");
                MsgBox.alert(this, "Điểm phải là số");
                return false;
            }
        }
        MsgBox.alert(this, "Cập nhật điểm thành công");
        return true;
    }

    private void updateDiemFrom() {
        Double diem = null;
        int index = tblHocVien.getSelectedRow();
        System.out.println(index);
            try {
                diem = Double.parseDouble(tblHocVien.getValueAt(index, 4)+"");
                System.out.println(diem);
                 if (tblHocVien.getValueAt(index, 4).equals("")) {
                    MsgBox.alert(this, "Không để trống");
                    return;
                }
                    if (diem < 0) {
                        MsgBox.alert(this, "Điểm phải lớn hơn hoặc bằng 0");
                        return;
                    } else if (diem > 10) {
                        MsgBox.alert(this, "Điểm phải nhỏ hơn hoặc bằng 10");
                        return;
                    }
                } catch (Exception e) {
                    MsgBox.alert(this, "Bạn cần nhập điểm và phải là số");
                    return;
                }
            updateDiem();
            this.fillTableHocVien();
            MsgBox.alert(this, "Cập nhật điểm thành công");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHocVien = new javax.swing.JTable();
        btnSuaDiem = new javax.swing.JButton();
        btnXoaHV = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNguoiHoc = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnThemHV = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        cboKhoaHoc = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        cboChuyenDe = new javax.swing.JComboBox<>();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(1080, 546));

        tblHocVien.setForeground(new java.awt.Color(0, 0, 255));
        tblHocVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TT", "Mã Học Viên", "Mã Người Học", "Họ Tên", "Điểm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblHocVien);

        btnSuaDiem.setBackground(new java.awt.Color(204, 51, 0));
        btnSuaDiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSuaDiem.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaDiem.setText("Cập Nhật Điểm");
        btnSuaDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDiemActionPerformed(evt);
            }
        });

        btnXoaHV.setBackground(new java.awt.Color(204, 51, 0));
        btnXoaHV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoaHV.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaHV.setText("Xóa Khỏi Khóa Học");
        btnXoaHV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXoaHV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuaDiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnXoaHV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69))
        );

        tabs.addTab("HỌC VIÊN", jPanel1);

        tblNguoiHoc.setForeground(new java.awt.Color(51, 0, 204));
        tblNguoiHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NH", "Họ Tên", "Giới Tính", "Ngày Sinh", "Điện Thoại", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblNguoiHoc);

        jPanel6.setBackground(new java.awt.Color(51, 255, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnThemHV.setBackground(new java.awt.Color(204, 102, 0));
        btnThemHV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemHV.setForeground(new java.awt.Color(255, 255, 255));
        btnThemHV.setText("Thêm Vào Khóa Học");
        btnThemHV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThemHV)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemHV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(366, 366, 366))
        );

        tabs.addTab("NGƯỜI HỌC", jPanel3);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 153));
        jLabel1.setText("QUẢN LÝ HỌC VIÊN");

        jPanel10.setBackground(new java.awt.Color(51, 255, 51));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "KHÓA HỌC", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel10.setPreferredSize(new java.awt.Dimension(500, 81));

        cboKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboKhoaHocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboKhoaHoc, 0, 321, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(51, 255, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "CHUYÊN ĐỀ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        cboChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboChuyenDeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboChuyenDe, 0, 297, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboChuyenDe, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDiemActionPerformed
        updateDiemFrom();
    }//GEN-LAST:event_btnSuaDiemActionPerformed

    private void btnXoaHVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHVActionPerformed
        // TODO add your handling code here:
        removeHocVien();
    }//GEN-LAST:event_btnXoaHVActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
        fillTableNguoiHoc();
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnThemHVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHVActionPerformed
        // TODO add your handling code here:
        addHocVien();
    }//GEN-LAST:event_btnThemHVActionPerformed

    private void cboKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboKhoaHocActionPerformed
        // TODO add your handling code here:
        fillTableHocVien();
    }//GEN-LAST:event_cboKhoaHocActionPerformed

    private void cboChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboChuyenDeActionPerformed
        // TODO add your handling code here:
        fillComboBoxKhoaHoc();
    }//GEN-LAST:event_cboChuyenDeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaDiem;
    private javax.swing.JButton btnThemHV;
    private javax.swing.JButton btnXoaHV;
    private javax.swing.JComboBox<String> cboChuyenDe;
    private javax.swing.JComboBox<String> cboKhoaHoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblHocVien;
    private javax.swing.JTable tblNguoiHoc;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
