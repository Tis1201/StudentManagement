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
@Table(name = "khoa_hoc")
public class KhoaHoc {
    @Id
    @Column(name = "ma_khoa_hoc", nullable = false)
    private String maKhoaHoc;



    @Column(name = "TenKhoaHoc")
    private String tenKhoaHoc;

    @OneToMany(mappedBy = "maKhoaHoc")
    private Set<Lop> lops = new LinkedHashSet<>();

}