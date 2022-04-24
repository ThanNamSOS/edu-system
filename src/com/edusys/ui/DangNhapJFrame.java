package com.edusys.ui;

import com.edusys.dao.NhanVienDAO;
import com.edusys.entity.NhanVien;
import com.edusys.utils.Auth;
import com.edusys.utils.MsgBox;
import com.edusys.utils.XImage;

public class DangNhapJFrame extends javax.swing.JFrame {

    public DangNhapJFrame() {
        initComponents();
        txtMaNV.setText("TEONV");
        txtPass.setText("123456");
        setLocationRelativeTo(null);
        setIconImage(XImage.getAppIcon());
    }

    NhanVienDAO dao = new NhanVienDAO();

    void dangNhap() {
        String manv = txtMaNV.getText();
        String matkhau = new String(txtPass.getPassword());

        if (manv.length() == 0) {
            lblTenDangNhap.setText("Không được để trống Tên Đăng Nhập!");
            txtMaNV.requestFocus();
            return;
        } else if (manv.length() == 0) {
            lblMatKhau.setText("Không được để trống Mật Khẩu!");
            txtPass.requestFocus();
            return;
        }

        NhanVien nv = dao.selectByID(manv);

        if (nv == null) {
            lblTenDangNhap.setText("Sai tên đăng nhập!");
            txtMaNV.requestFocus();
        } else if (!matkhau.equals(nv.getMatKhau())) {
            lblMatKhau.setText("Sai mật khẩu!");
            txtPass.requestFocus();
        } else {
            lblTenDangNhap.setText(null);
            lblMatKhau.setText(null);
            MsgBox.alert(this, "Đăng nhập thành công.");
            Auth.user = nv;
            this.dispose();
            new MainFrame().setVisible(true);
        }
    }

    void ketThuc() {
        if (MsgBox.confirm(this, "Bạn muốn kết thúc ứng dụng?")) {
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnDangNhap = new javax.swing.JButton();
        btnKetThuc = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        lblTenDangNhap = new javax.swing.JLabel();
        lblMatKhau = new javax.swing.JLabel();
        cbxShowPass = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 204));
        jLabel2.setText("Mật Khẩu");

        btnDangNhap.setBackground(new java.awt.Color(204, 102, 0));
        btnDangNhap.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Key.png"))); // NOI18N
        btnDangNhap.setText("Đăng Nhập");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        btnKetThuc.setBackground(new java.awt.Color(204, 102, 0));
        btnKetThuc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnKetThuc.setForeground(new java.awt.Color(255, 255, 255));
        btnKetThuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit.png"))); // NOI18N
        btnKetThuc.setText("Kết Thúc");
        btnKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetThucActionPerformed(evt);
            }
        });

        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Tên Đăng Nhập");

        lblTenDangNhap.setForeground(new java.awt.Color(204, 51, 0));
        lblTenDangNhap.setText(" ");

        lblMatKhau.setForeground(new java.awt.Color(204, 51, 0));
        lblMatKhau.setText(" ");

        cbxShowPass.setText("Hiện mật khẩu");
        cbxShowPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxShowPassMouseClicked(evt);
            }
        });
        cbxShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxShowPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxShowPass)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblTenDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(txtMaNV)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblTenDangNhap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblMatKhau))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxShowPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        dangNhap();
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void btnKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetThucActionPerformed
        ketThuc();
    }//GEN-LAST:event_btnKetThucActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        dangNhap();
    }//GEN-LAST:event_txtPassActionPerformed

    private void cbxShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxShowPassActionPerformed
      
    }//GEN-LAST:event_cbxShowPassActionPerformed

    private void cbxShowPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxShowPassMouseClicked
         if(cbxShowPass.isSelected()){
           txtPass.setEchoChar((char)0);
       }else{
           txtPass.setEchoChar('*');
       }
    }//GEN-LAST:event_cbxShowPassMouseClicked

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnKetThuc;
    private javax.swing.JCheckBox cbxShowPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblTenDangNhap;
    public javax.swing.JTextField txtMaNV;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}
