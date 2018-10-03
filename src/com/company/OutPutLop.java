package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class OutPutLop {
    private JTextField inputClass;
    private JButton search;
    private JTable table = new JTable();
    public JPanel panel;

    public OutPutLop(){



//        // create a table model and set a Column Identifiers to this model
//        Object[] columns = {"Id","First Name","Last Name","Age"};
//        DefaultTableModel model = new DefaultTableModel();
//        model.setColumnIdentifiers(columns);
//
//        // set the model to the table
//        table.setModel(model);
//
//        // Change A JTable Background Color, Font Size, Font Color, Row Height
//        table.setBackground(Color.LIGHT_GRAY);
//        table.setForeground(Color.black);
//        Font font = new Font("",1,22);
//        table.setFont(font);
//        table.setRowHeight(30);


        String[] colum = {"STT", "Full name", "MSSV", "Address"};
            DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(colum);
        table.setModel(model);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    MySQLAccess mySQLAccess = new MySQLAccess();
                    Lop lop = mySQLAccess.getSinhVienLop(inputClass.getText());
                    ArrayList<SinhVien> list = lop.getDSLop();

                    String[][] value = new String[list.size()][4];


                    for (int i = 0; i < list.size(); i++){
                        value[i][0] = String.valueOf(i+1);
                        value[i][1] = list.get(i).getName();
                        value[i][2] = String.valueOf(list.get(i).getMaSV());
                        value[i][3] = list.get(i).getAddress();
                    }

                    for (int i = 0; i < list.size(); i++) {
                        for (int j = 0; j <4 ; j++) {
                            System.out.print(value[i][j] +"\t");
                        }
                        System.out.println();
                    }

                    table = new JTable(value,colum);

                    table.setPreferredScrollableViewportSize(new Dimension(450,63));
                    table.setFillsViewportHeight(true);
                    JScrollPane jps = new JScrollPane(table);
//                    Container a = frame2.getContentPane();
                    panel.add(jps);


                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
