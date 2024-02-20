package com.example.StudentManagement.controller;

import com.example.StudentManagement.dto.LopDTO;
import com.example.StudentManagement.dto.LopForm;
import com.example.StudentManagement.dto.LopFormConverte;
import com.example.StudentManagement.entity.Lop;
import com.example.StudentManagement.service.LopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/test")
public class LopController {
    private final LopService lopService;
    @Autowired
    public LopController(LopService lopService) {
        this.lopService = lopService;
    }

    @GetMapping("/getAll")
    public String getAll(Model model){
        List<LopDTO> lopDTOS = lopService.getAll();
        model.addAttribute("lopDTOs",lopDTOS);
        return "lop/lops";
    }

    @GetMapping("/total/{id}")
    public String numberStudent(@PathVariable String id, Model model){
        int total = lopService.getTotalSinhVien(id);
        model.addAttribute("totalStu",total);
        return "lop/totalStudent";
    }

    @GetMapping("/create")
    public String create(Model model) {
        LopForm lopForm = new LopForm();
        model.addAttribute("sinhVienForm", lopForm);
        return "lop/insert_form";
    }

    @PostMapping("/insert")
    public String insertSinhVien(@ModelAttribute("sinhVienForm") LopForm lopForm) {
        try {
            lopService.insertLop(
                    lopForm.getMaLop(),
                    lopForm.getTenLop(),
                    lopForm.getMakhoa(),
                    lopForm.getMaHeDt(),
                    lopForm.getMaKhoaHoc()
            );
            return "redirect:/test/getAll";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }
    @GetMapping("/pre")
    public String find(@RequestParam("id")  String id, Model model){
        Lop lop = lopService.getlop(id);
        LopForm lopForm = LopFormConverte.convertToLopForm(lop);
        model.addAttribute("sinhVienForm", lopForm);
        return "lop/update";
    }

    @PostMapping("/ok")
    public String update(@ModelAttribute("sinhVienForm") LopForm lopForm) {
        try {
            lopService.update(
                    lopForm.getMaLop(),
                    lopForm.getTenLop(),
                    lopForm.getMakhoa(),
                    lopForm.getMaHeDt(),
                    lopForm.getMaKhoaHoc()
            );
            return "redirect:/test/getAll";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }
}
