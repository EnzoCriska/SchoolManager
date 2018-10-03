package com.company;

public class MonHoc {
    private int MaMH;
    private String tenMH;
    private float diem;

    public MonHoc(int maMH, String tenMH) {
        MaMH = maMH;
        this.tenMH = tenMH;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public int getMaMH() {
        return MaMH;
    }

    public void setMaMH(int maMH) {
        MaMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }
}
