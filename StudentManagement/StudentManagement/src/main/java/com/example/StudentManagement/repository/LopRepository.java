package com.example.StudentManagement.repository;

import com.example.StudentManagement.dto.LopDTO;
import com.example.StudentManagement.entity.Lop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LopRepository extends JpaRepository<Lop,String> {
    @Query(value = "select GetNumberOfStudentsInClass(?1)",nativeQuery = true)
    int getTotalSinhVien(String id);


    @Query(value = "select GetClassByStudentID(?1)",nativeQuery = true)
    String getClass(String id);

    @Procedure(name = "InsertLop")
    void insertLop(
            @Param("Malop") String in_Malop,
            @Param("ten_lop") String in_TenLop,
            @Param("Makhoa") String in_Makhoa,
            @Param("ma_he_dt") String in_MaHeDt,
            @Param("ma_khoa_hoc") String in_MaKhoahoc
    );
    @Procedure(value = "GetLopDetails")
    List<LopDTO> getAll();

    @Procedure(value = "UpdateLopInfo")
    void update(
            @Param("Malop") String malop,
            @Param("ten_lop") String tl,
            @Param("Makhoa") String mk,
            @Param("ma_he_dt") String mdt,
            @Param("ma_khoa_hoc") String mkh
    );

    @Procedure(value = "GetLopInfo")
    Lop getlop(@Param("MaLop") String id);
}
