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
@Table(name = "khoa")
public class Khoa {
    @Id
    @Column(name = "Makhoa", nullable = false)
    private String makhoa;


    @Column(name = "Tenkhoa", nullable = false)
    private String tenkhoa;

    @OneToMany(mappedBy = "makhoa")
    private Set<Lop> lops = new LinkedHashSet<>();

}