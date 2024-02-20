package com.example.StudentManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "diem")
public class Diem {
    @EmbeddedId
    private DiemId id;

    @MapsId("maMH")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaMH", nullable = false)
    private MonHoc maMH;

    @MapsId("maSV")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaSV", nullable = false)
    private SinhVien maSV;

    @Column(name = "diem", nullable = false, precision = 10, scale = 2)
    private BigDecimal diem;

    @Column(name = "hoc_ky")
    private Integer hocKy;

}