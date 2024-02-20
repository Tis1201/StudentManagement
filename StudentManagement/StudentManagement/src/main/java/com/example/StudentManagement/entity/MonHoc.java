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
@Table(name = "mon_hoc")
public class MonHoc {
    @Id
    @Column(name = "MaMH", nullable = false)
    private String maMH;

    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "TenMH", nullable = false)
    private String tenMH;

    @Column(name = "so_tin_chi")
    private Integer soTinChi;

    @OneToMany(mappedBy = "maMH")
    private Set<Diem> diems = new LinkedHashSet<>();

}