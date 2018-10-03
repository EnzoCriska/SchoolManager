package com.company;

import javax.swing.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
	// write your code here
        MySQLAccess mySQLAccess = new MySQLAccess();
        System.out.println(mySQLAccess.getSinhVienDiem(15022052).getName());

//        JFrame frame = new JFrame("InputStudent");
//        frame.setContentPane(new InputStudent().panel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);


        JFrame frame2 = new JFrame("OutPutLop");
        frame2.setContentPane(new OutPutLop().panel);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);

        OutputScore outputScore = new OutputScore();

    }
}
