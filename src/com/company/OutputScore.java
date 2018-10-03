package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class OutputScore {
    private JLabel msv;
    private JLabel mlop;
    private JLabel name;
    private JTable table;
    private JTextField inputMsv;
    private JButton search;
    private JPanel panel ;//= new JPanel();

    public OutputScore(){
        JFrame frame = new JFrame("OutputScore");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        table = createTable();
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    MySQLAccess mySQLAccess = new MySQLAccess();
                    SinhVien sinhVien = mySQLAccess.getSinhVienDiem(Integer.parseInt(inputMsv.getText()));
                    name.setText("Họ và tên: " + sinhVien.getName());
                    mlop.setText("Lớp: " + mySQLAccess.getLopByID(sinhVien.getMalop()).tenLop);
                    msv.setText("MSSV" + String.valueOf(sinhVien.getMaSV()));

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static JTable createTable()
    {
        String[] columnNames = {"First Name", "Last Name"};
        Object[][] data = {{"Kathy", "Smith"},{"John", "Doe"}};
        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);

        return table;
    }
}

