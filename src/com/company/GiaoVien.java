package com.company;

public class GiaoVien {
    int MaGV, MaLop;
    String name, address, rank;

    public GiaoVien(int maGV, int maLop, String name, String address, String rank) {
        MaGV = maGV;
        MaLop = maLop;
        this.name = name;
        this.address = address;
        this.rank = rank;
    }

    public int getMaGV() {
        return MaGV;
    }

    public void setMaGV(int maGV) {
        MaGV = maGV;
    }

    public int getMaLop() {
        return MaLop;
    }

    public void setMaLop(int maLop) {
        MaLop = maLop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
