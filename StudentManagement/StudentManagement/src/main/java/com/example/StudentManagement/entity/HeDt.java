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
@Table(name = "he_dt")
public class HeDt {
    @Id
    @Column(name = "ma_he_dt", nullable = false)
    private String maHeDt;


    @Column(name = "TenHeDt")
    private String tenHeDt;

    @OneToMany(mappedBy = "maHeDt")
    private Set<Lop> lops = new LinkedHashSet<>();

}