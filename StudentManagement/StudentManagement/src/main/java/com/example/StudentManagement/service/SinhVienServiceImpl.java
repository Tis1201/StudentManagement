package com.example.StudentManagement.service;

import com.example.StudentManagement.dto.DiemDTO;
import com.example.StudentManagement.dto.SinhVienDTO;
import com.example.StudentManagement.entity.SinhVien;
import com.example.StudentManagement.repository.SinhVienRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SinhVienServiceImpl implements SinhVienService{
    private  final SinhVienRepository sinhVienRepository;
    @Autowired
    public SinhVienServiceImpl(SinhVienRepository sinhVienRepository) {
        this.sinhVienRepository = sinhVienRepository;
    }

    @Transactional
    @Override
    public List<SinhVienDTO> getAllSinhVien() {
        return sinhVienRepository.getAllSinhVien();
    }
    @Transactional
    @Override
    public void insertSinhVien(String in_MaSV, String in_TenSV, String in_GioiTinh, String in_NgaySinh, String in_QueQuan, String in_Malop, String in_PhoneNumber) {
        sinhVienRepository.insertSinhVien(in_MaSV, in_TenSV, in_GioiTinh, in_NgaySinh, in_QueQuan, in_Malop, in_PhoneNumber);
    }
    @Transactional
    @Override
    public void updateSinhVien(String maSV, String tenSV, String gioiTinh, String ngaySinh, String queQuan, String malop, String phoneNumber) {
        sinhVienRepository.updateSinhVien(maSV, tenSV, gioiTinh, ngaySinh, queQuan, malop, phoneNumber);
    }

    @Transactional
    @Override
    public SinhVien findSinhVienByMaSV(String id) {
        return sinhVienRepository.findSinhVienByMaSV(id);
    }

    @Override
    public int sumSinhvien() {
        return sinhVienRepository.sumSinhvien();
    }

    @Transactional
    @Override
    public void deleteSinhVienById(String masv) {
        sinhVienRepository.deleteSinhVienById(masv);
    }

    @Override
    public Double AvgScore(String id, int hk) {
        return sinhVienRepository.AvgScore(id,hk);
    }

    @Override
    public int totalCre(String id) {
        return sinhVienRepository.totalCre(id);
    }

    @Transactional
    @Override
    public List<DiemDTO> viewPoint(String id, int hk) {
        return sinhVienRepository.viewPoint(id, hk);
    }
}
