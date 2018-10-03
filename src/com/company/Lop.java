package com.company;

import java.util.ArrayList;

public class Lop {
    int MaLop;
    String tenLop;
    ArrayList dsLop = new ArrayList();

    public Lop(int maLop, String tenLop) {
        MaLop = maLop;
        this.tenLop = tenLop;
    }

    public int getMaLop() {
        return MaLop;
    }

    public void setMaLop(int maLop) {
        MaLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public void addSinhvien(SinhVien sinhVien){
        dsLop.add(sinhVien);
    }

    public ArrayList getDSLop(){
        return dsLop;
    }
}
