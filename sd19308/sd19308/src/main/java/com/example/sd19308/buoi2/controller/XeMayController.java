package com.example.sd19308.buoi2.controller;

import com.example.sd19308.buoi2.model.XeMay;
import com.example.sd19308.buoi2.repository.XeMayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/xe-may")
@RestController
public class XeMayController {
    @Autowired
    XeMayRepository xeMayRepository;

    @GetMapping("/hien-thi")
    public List<XeMay> hienThi() {
        return xeMayRepository.findAll();
    }

    @PostMapping("/them")
    public String them(@RequestBody XeMay xeMay) {
        xeMayRepository.save(xeMay);
        return "Them thanh cong";
    }

    @PostMapping("/sua")
    public String sua(@RequestBody XeMay xeMay) {
        xeMayRepository.save(xeMay);
        return "Sua thanh cong";
    }

    @GetMapping("/xoa")
    public String xoa(@RequestParam("id") Integer id) {
        xeMayRepository.deleteById(id);
        return "Xoa thanh cong";
    }

    @GetMapping("/chi-tiet/{id}")
    public XeMay chiTiet(@PathVariable("id") Integer id) {
        return xeMayRepository.findById(id).get();
    }

}























