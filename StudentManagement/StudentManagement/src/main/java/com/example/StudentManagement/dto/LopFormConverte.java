package com.example.StudentManagement.dto;

import com.example.StudentManagement.entity.Lop;

public class LopFormConverte {
    public static LopForm convertToLopForm(Lop lop) {
        LopForm lopForm = new LopForm();
        lopForm.setMaLop(lop.getMalop());
        lopForm.setTenLop(lop.getTenLop());
        // Set other fields accordingly
        if (lop.getMaKhoaHoc() != null) {
            lopForm.setMakhoa(lop.getMakhoa().getMakhoa());
        }
        if (lop.getMaHeDt() != null) {
            lopForm.setMaHeDt(lop.getMaHeDt().getMaHeDt());
        }
        if (lop.getMaKhoaHoc() != null) {
            lopForm.setMaKhoaHoc(lop.getMaKhoaHoc().getMaKhoaHoc());
        }
        return lopForm;
    }
}
