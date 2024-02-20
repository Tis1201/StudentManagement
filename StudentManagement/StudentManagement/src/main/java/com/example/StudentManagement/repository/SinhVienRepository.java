package com.example.StudentManagement.repository;

import com.example.StudentManagement.dto.DiemDTO;
import com.example.StudentManagement.dto.SinhVienDTO;
import com.example.StudentManagement.entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien,String> {
    @Procedure(value = "ShowStudentDetails")
    List<SinhVienDTO> getAllSinhVien();
    @Procedure(value = "InsertSinhVien")
    void insertSinhVien(
            @Param("MaSV") String in_MaSV,
            @Param("TenSV") String in_TenSV,
            @Param("gioi_tinh") String in_GioiTinh,
            @Param("ngay_sinh") String in_NgaySinh,
            @Param("que_quan") String in_QueQuan,
            @Param("Malop") String in_Malop,
            @Param("phone_number") String in_PhoneNumber
    );
    @Procedure(name = "updateSinhVien")
    void updateSinhVien(
            @Param("MaSV") String maSV,
            @Param("TenSV") String tenSV,
            @Param("gioi_tinh") String gioiTinh,
            @Param("ngay_sinh") String ngaySinh,
            @Param("que_quan") String queQuan,
            @Param("Malop") String malop,
            @Param("phone_number") String phoneNumber
    );

    @Procedure(value = "GetSinhVienDetailsByMaSV")
    SinhVien findSinhVienByMaSV(@Param("MaSV") String id);

    @Query(value = "select CountSinhVien()",nativeQuery = true)
    int sumSinhvien();

    @Procedure(value = "DeleteSinhVien")
    void deleteSinhVienById(@Param("MaSV") String masv);

    @Query(value = "select CalculateAverageScore(?1, ?2)",nativeQuery = true)
    Double AvgScore(String id, int hk);

    @Query(value = "select GetTotalCreditsByStudentID(?1)",nativeQuery = true)
    int totalCre(String id);

    @Procedure(value = "GetStudentCourseInfo")
    List<DiemDTO> viewPoint(@Param("MaSV") String id, @Param("hoc_ky") int hk);
}
