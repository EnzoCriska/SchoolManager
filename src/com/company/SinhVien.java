package com.company;

import java.util.ArrayList;

public class SinhVien {
    private int MaSV, Malop;
    private String name, address;
    private ArrayList listMonHoc = new ArrayList();

    public SinhVien(int maSV, String name, String address, int malop) {
        MaSV = maSV;
        Malop = malop;
        this.name = name;
        this.address = address;
    }

    public void addListMH(MonHoc monHoc){
        listMonHoc.add(monHoc);
    }

    public ArrayList<MonHoc> getListMonHoc(){
        return listMonHoc;
    }

    public int getMaSV() {
        return MaSV;
    }

    public void setMaSV(int maSV) {
        MaSV = maSV;
    }

    public int getMalop() {
        return Malop;
    }

    public void setMalop(int malop) {
        Malop = malop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}