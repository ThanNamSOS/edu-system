package com.edusys.utils;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MsgBox {
    public static void alert(Component parent, String message){
        JOptionPane.showMessageDialog(parent, message,
                "Hệ thống quản lý đào tạo", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static boolean confirm(Component parent, String message){
        int result = JOptionPane.showConfirmDialog(parent, message,
                "Hệ thống quản lý đào tạo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }
    
    public static boolean checkSoThoiLuongHocPhi(String data, JLabel lbl){
        try {
            float thoiLuong = Float.parseFloat(data);
        } catch (Exception e) {
            lbl.setText("Gía trị phải là số");
            return true;
        }
        return false;
    }
    
   
}
