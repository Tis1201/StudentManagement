package com.example.StudentManagement.controller;

import com.example.StudentManagement.dto.DiemDTO;
import com.example.StudentManagement.dto.SinhVienDTO;
import com.example.StudentManagement.dto.SinhVienForm;
import com.example.StudentManagement.dto.SinhVienFormConverter;
import com.example.StudentManagement.entity.SinhVien;
import com.example.StudentManagement.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class SinhVienController {

    private final SinhVienService sinhVienService;

    @Autowired
    public SinhVienController(SinhVienService sinhVienService) {
        this.sinhVienService = sinhVienService;
    }

    @GetMapping("/getAll")
    public String getAll(Model model) {
        List<SinhVienDTO> sinhVienDTOS = sinhVienService.getAllSinhVien();
        model.addAttribute("SinhVienDTO", sinhVienDTOS);
        return "student/students";
    }
    @GetMapping("/find/{id}")
    public SinhVien findById(@PathVariable String id){
        return sinhVienService.findSinhVienByMaSV(id);
    }
    @GetMapping("/totalCre/{id}")
    public int gettotalCre(@PathVariable String id){
        return sinhVienService.totalCre(id);
    }

    @GetMapping("/delete/{id}")
    public String  deleteSinhVien(
            @PathVariable String id) {

        try {
            sinhVienService.deleteSinhVienById(id);
            return "redirect:/student/getAll";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }
    @PostMapping("/ok")
    public String updateSinhVien(@ModelAttribute("sinhVienUp") SinhVienForm sinhVien) {
        try {

            sinhVienService.updateSinhVien(
                    sinhVien.getMaSV(),
                    sinhVien.getTenSV(),
                    sinhVien.getGioiTinh(),
                    sinhVien.getNgaySinh(),
                    sinhVien.getQueQuan(),
                    sinhVien.getMalop(),
                    sinhVien.getPhoneNumber()
            );
            return "redirect:/student/getAll";
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            return "redirect:/error";
        }
    }


    // In your controller
    @GetMapping("/create")
    public String create(Model model) {
        SinhVienForm sinhVienForm = new SinhVienForm();
        model.addAttribute("sinhVienForm", sinhVienForm);
        return "student/insert_form";
    }


    @GetMapping("/pre")
    public String uplink(@RequestParam("id")  String id, Model model) {
        SinhVien SinhVien =  sinhVienService.findSinhVienByMaSV(id);
        SinhVienForm sinhVienForm = SinhVienFormConverter.convertToSinhVienForm(SinhVien);
        model.addAttribute("sinhVienUp", sinhVienForm);
        return "/student/update";
    }

    @PostMapping("/insert")
    public String insertSinhVien(@ModelAttribute("sinhVienForm") SinhVienForm sinhVien) {
        try {
            sinhVienService.insertSinhVien(
                    sinhVien.getMaSV(),
                    sinhVien.getTenSV(),
                    sinhVien.getGioiTinh(),
                    sinhVien.getNgaySinh(),
                    sinhVien.getQueQuan(),
                    sinhVien.getMalop(),
                    sinhVien.getPhoneNumber()
            );
            return "redirect:/student/getAll";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @GetMapping("/show")
    public String getAll(@ModelAttribute("diemDTOs") SinhVienForm sinhVienForm , Model model){
        List<DiemDTO> diemDTOS = sinhVienService.viewPoint(sinhVienForm.getMaSV(), sinhVienForm.getHocky());
        int hk= sinhVienForm.getHocky();
        String msv= sinhVienForm.getMaSV();
        model.addAttribute("diemDTOs" , diemDTOS);
        model.addAttribute("hk" , hk);
        model.addAttribute("msv" , msv);
        return "student/point";
    }


    @GetMapping("/input")
    public String dataBinder(Model model){
        SinhVienForm sinhVienForm = new SinhVienForm();
        model.addAttribute("diemDTOS",sinhVienForm);
        return "student/find";
    }

    @GetMapping("/avg/{id}/{hk}")
    public String getAvgPage(@PathVariable String id,@PathVariable int hk, Model model) {
        Double averageScore = sinhVienService.AvgScore(id, hk);
        int totalcre = sinhVienService.totalCre(id);

        if (averageScore != null) {
            model.addAttribute("averageScore", averageScore);
            model.addAttribute("totalcre", totalcre);
            return "student/averageScorePage"; // return the name of the HTML template
        } else {
            return "error/403"; // or return an error page
        }
    }

    @GetMapping("/totalSV")
    public String total( Model model) {
        int totals = sinhVienService.sumSinhvien();
        model.addAttribute("totals", totals);
        return "student/total";


    }


}
