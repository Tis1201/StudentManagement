package com.example.StudentManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class DiemId implements Serializable {
    private static final long serialVersionUID = 1401992281127730268L;
    @Column(name = "MaMH", nullable = false)
    private String maMH;

    @Column(name = "MaSV", nullable = false, length = 50)
    private String maSV;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DiemId entity = (DiemId) o;
        return Objects.equals(this.maSV, entity.maSV) &&
                Objects.equals(this.maMH, entity.maMH);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maSV, maMH);
    }

}