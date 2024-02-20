package com.example.StudentManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "sinh_vien")
public class SinhVien {
    @Id
    @Column(name = "MaSV", nullable = false, length = 50)
    private String maSV;

    @Column(name = "TenSV", nullable = false)
    private String tenSV;

    @Column(name = "gioi_tinh", nullable = false, length = 5)
    private String gioiTinh;

    @Column(name = "ngay_sinh", nullable = false)
    private LocalDate ngaySinh;

    @Column(name = "que_quan", nullable = false)
    private String queQuan;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Malop", nullable = false)
    private Lop maLop;

    @Column(name = "phone_number", nullable = false, length = 10)
    private String phoneNumber;

    @OneToMany(mappedBy = "maSV")
    private Set<Diem> diems = new LinkedHashSet<>();

}