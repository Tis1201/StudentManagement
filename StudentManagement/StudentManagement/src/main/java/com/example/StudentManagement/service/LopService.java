package com.example.StudentManagement.service;

import com.example.StudentManagement.dto.LopDTO;
import com.example.StudentManagement.entity.Lop;

import java.util.List;

public interface LopService {
    int getTotalSinhVien(String id);

    String getClass(String id);


    void insertLop(
            String in_Malop,
            String in_TenLop,
            String in_Makhoa,
            String in_MaHeDt,
            String in_MaKhoahoc
    );
    List<LopDTO> getAll();
    void update(
            String malop,
            String tl,
            String mk,
            String mdt,
            String mkh
    );
    Lop getlop(String id);
}
