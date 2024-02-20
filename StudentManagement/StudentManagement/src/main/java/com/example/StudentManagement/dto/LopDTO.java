package com.example.StudentManagement.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "Malop",
        "ten_lop",
        "Makhoa",
        "ma_he_dt",
        "ma_khoa_hoc"
})
public interface LopDTO {
    String getmalop();
    String gettenLop();
    String getmakhoa();
    String getmaHeDt();
    String getmaKhoaHoc();
}
