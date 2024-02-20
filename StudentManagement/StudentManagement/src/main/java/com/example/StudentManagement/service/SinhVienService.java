package com.example.StudentManagement.service;

import com.example.StudentManagement.dto.DiemDTO;
import com.example.StudentManagement.dto.SinhVienDTO;
import com.example.StudentManagement.entity.SinhVien;

import java.util.List;

public interface SinhVienService {
    List<SinhVienDTO> getAllSinhVien();
    void insertSinhVien(
            String in_MaSV,
            String in_TenSV,
            String in_GioiTinh,
            String in_NgaySinh,
            String in_QueQuan,
            String in_Malop,
            String in_PhoneNumber
    );
    void updateSinhVien(
            String maSV,
            String tenSV,
            String gioiTinh,
            String ngaySinh,
            String queQuan,
            String malop,
            String phoneNumber
    );
    SinhVien findSinhVienByMaSV(String id);
    int sumSinhvien();
    void deleteSinhVienById( String masv);
    Double AvgScore(String id, int hk);
    int totalCre(String id);
    List<DiemDTO> viewPoint( String id,  int hk);
}
