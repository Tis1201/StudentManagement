package com.example.StudentManagement.dto;

import com.example.StudentManagement.entity.SinhVien;

public class SinhVienFormConverter {
    public static SinhVienForm convertToSinhVienForm(SinhVien sinhVien) {
        SinhVienForm sinhVienForm = new SinhVienForm();
        sinhVienForm.setMaSV(sinhVien.getMaSV());
        sinhVienForm.setTenSV(sinhVien.getTenSV());
        sinhVienForm.setGioiTinh(sinhVien.getGioiTinh());
        sinhVienForm.setNgaySinh(sinhVien.getNgaySinh().toString()); // Convert LocalDate to String
        sinhVienForm.setQueQuan(sinhVien.getQueQuan());
        // Set other fields accordingly
        sinhVienForm.setMalop(sinhVien.getMaLop().getMalop()); // Assuming you have a getMaLop() method in the Lop class
        sinhVienForm.setPhoneNumber(sinhVien.getPhoneNumber());
        return sinhVienForm;
    }
}
