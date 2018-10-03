package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class InputStudent {
    private JTextField name;
    private JButton InputButton;
    private JTextField address;
    private JTextField mssv;
    private JTextField tenlop;
    public JPanel panel;

    public InputStudent() {
        InputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try {
                    MySQLAccess mySQLAccess = new MySQLAccess();
                    int malop = mySQLAccess.getLopByName(tenlop.getText()).getMaLop();
                    SinhVien sinhVien = new SinhVien(Integer.parseInt(mssv.getText()), name.getText(),address.getText(), malop);

                    mySQLAccess.insertStudent(sinhVien);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Added " + name.getText());
                mssv.setText("");
                name.setText("");
                address.setText("");
                tenlop.setText("");
            }
        });
    }
}
