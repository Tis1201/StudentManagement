package com.example.StudentManagement.service;

import com.example.StudentManagement.dto.LopDTO;
import com.example.StudentManagement.entity.Lop;
import com.example.StudentManagement.repository.LopRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LopServiceImpl implements LopService{
    private final LopRepository lopRepository;
    @Autowired
    public LopServiceImpl(LopRepository lopRepository) {
        this.lopRepository = lopRepository;
    }

    @Override
    public int getTotalSinhVien(String id) {
        return lopRepository.getTotalSinhVien(id);
    }

    @Override
    public String getClass(String id) {
        return lopRepository.getClass(id);
    }
    @Transactional
    @Override
    public void insertLop(String in_Malop, String in_TenLop, String in_Makhoa, String in_MaHeDt, String in_MaKhoahoc) {
        lopRepository.insertLop(in_Malop,in_TenLop,in_Makhoa,in_MaHeDt,in_MaKhoahoc);
    }
    @Transactional
    @Override
    public List<LopDTO> getAll() {
        return lopRepository.getAll();
    }

    @Transactional
    @Override
    public void update(String malop, String tl, String mk, String mdt, String mkh) {
        lopRepository.update(malop, tl, mk, mdt, mkh);
    }

    @Transactional
    @Override
    public Lop getlop(String id) {
        return lopRepository.getlop(id);
    }
}
