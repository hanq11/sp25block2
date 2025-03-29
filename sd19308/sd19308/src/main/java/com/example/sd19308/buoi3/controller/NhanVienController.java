package com.example.sd19308.buoi3.controller;

import com.example.sd19308.buoi3.model.NhanVien;
import com.example.sd19308.buoi3.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/nhan-vien")
public class NhanVienController {
    @Autowired
    NhanVienRepository nhanVienRepository;

    @GetMapping("/hien-thi")
    public List<NhanVien> hienThi() {
        return nhanVienRepository.findAll();
    }

    @GetMapping("/chi-tiet/{id}")
    public NhanVien chiTiet(@PathVariable("id") Integer id) {
        return nhanVienRepository.findById(id).get();
    }

    @PostMapping("/them")
    public String them(@RequestBody NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
        return "Them thanh cong";
    }

    @PostMapping("/sua")
    public String sua(@RequestBody NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
        return "Sua thanh cong";
    }

    @GetMapping("/xoa")
    public String xoa(@RequestParam("id") Integer id) {
        nhanVienRepository.deleteById(id);
        return "Xoa thanh cong";
    }
}
