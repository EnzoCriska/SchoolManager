package com.company;

import java.sql.*;
import java.util.ArrayList;

public class MySQLAccess {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public MySQLAccess() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/score_Student","dung","123");
            statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public SinhVien getSinhVien(int MSV) throws SQLException {
        SinhVien sinhVien = null;
        resultSet = statement.executeQuery("SELECT * FROM SinhVien WHERE SinhVien.MaSv = " + MSV);
        while (resultSet.next()){
            sinhVien = new SinhVien(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4)); 
        }

        return sinhVien;
    }

    public ArrayList<SinhVien> getListSinhvien() throws SQLException {
        ArrayList<SinhVien> listSV = new ArrayList<>();
        resultSet = statement.executeQuery("SELECT * FROM SinhVien");
        while (resultSet.next()){
            listSV.add(new SinhVien(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4)));
        }
        return listSV;
    }

    public Lop getSinhVienLop(String lop) throws SQLException {
        ArrayList<SinhVien> listSV = new ArrayList<>();
        Lop lopsv = null;

        String query = "SELECT * FROM SinhVien INNER JOIN Lop ON SinhVien.MaLop = Lop.MaLop WHERE Lop.className = \"" + lop + "\"";
        resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            if(lopsv == null){
                lopsv  = new Lop(resultSet.getInt(5),resultSet.getString(6));
            }
            lopsv.addSinhvien(new SinhVien(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4)));
        }
        return lopsv;
    }

    public SinhVien getSinhVienDiem(int MSV) throws SQLException {
        ArrayList list = new ArrayList();
        SinhVien sinhVien = null;
        String query = "SELECT * FROM SinhVien INNER JOIN SV_MH ON SinhVien.MaSv = SV_MH.MaSv INNER JOIN MonHoc ON SV_MH.MaMH = MonHoc.MaMH WHERE SinhVien.MaSv = " + MSV;
        resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            if (sinhVien == null){
                sinhVien = new SinhVien(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
            }
            MonHoc monHoc = new MonHoc(resultSet.getInt(8), resultSet.getString(9));
            monHoc.setDiem(resultSet.getFloat(7));
            sinhVien.addListMH(monHoc);
        }

        return sinhVien;
    }

    public Lop getLopByName(String name) throws SQLException {
        String sql = "SELECT * FROM Lop WHERE Lop.className = \"" + name + "\"";
        resultSet = statement.executeQuery(sql);
        Lop lop = null;
        while (resultSet.next()){
            lop = new Lop(resultSet.getInt(1), resultSet.getString(2));
        }
        return lop;
    }

    public Lop getLopByID(int mlop) throws SQLException {
        String sql = "SELECT * FROM Lop WHERE Lop.MaLop = " + mlop;
        resultSet = statement.executeQuery(sql);
        Lop lop = null;
        while (resultSet.next()){
            lop = new Lop(resultSet.getInt(1), resultSet.getString(2));
        }
        return lop;
    }

    public void insertStudent(SinhVien sinhVien) throws SQLException {
        String sql = "INSERT INTO SinhVien VALUES("+ sinhVien.getMaSV() +",\'"+sinhVien.getName()+"\', \'"+sinhVien.getAddress()+"\', \'"+ sinhVien.getMalop()+"\');";
        int count = statement.executeUpdate(sql);
    }

    public void  insertScore(int msv, int mmh, float diem) throws SQLException {
        String sql = "INSERT INTO SV_MH VALUES("+msv+","+mmh+","+diem+");";
        int count = statement.executeUpdate(sql);
    }


}
