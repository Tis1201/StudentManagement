package com.example.StudentManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "lop")
public class Lop {
    @Id
    @Column(name = "Malop", nullable = false, length = 50)
    private String malop;



    @Column(name = "ten_lop")
    private String tenLop;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Makhoa")
    private Khoa makhoa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ma_he_dt")
    private HeDt maHeDt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ma_khoa_hoc")
    private KhoaHoc maKhoaHoc;

    @OneToMany(mappedBy = "maLop")
    private Set<SinhVien> sinhViens = new LinkedHashSet<>();


}