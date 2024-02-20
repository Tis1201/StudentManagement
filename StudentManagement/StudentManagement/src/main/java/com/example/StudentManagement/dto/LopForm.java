package com.example.StudentManagement.dto;

public class LopForm {
    String MaLop;
    String TenLop;
    String Makhoa;
    String maHeDt;
    String maKhoaHoc;

    public LopForm() {
    }

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String maLop) {
        MaLop = maLop;
    }

    public String getTenLop() {
        return TenLop;
    }

    public void setTenLop(String tenLop) {
        TenLop = tenLop;
    }

    public String getMakhoa() {
        return Makhoa;
    }

    public void setMakhoa(String makhoa) {
        Makhoa = makhoa;
    }

    public String getMaHeDt() {
        return maHeDt;
    }

    public void setMaHeDt(String maHeDt) {
        this.maHeDt = maHeDt;
    }

    public String getMaKhoaHoc() {
        return maKhoaHoc;
    }

    public void setMaKhoaHoc(String maKhoaHoc) {
        this.maKhoaHoc = maKhoaHoc;
    }
}
