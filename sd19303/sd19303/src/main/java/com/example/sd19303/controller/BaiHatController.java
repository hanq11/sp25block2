package com.example.sd19303.controller;

import com.example.sd19303.model.BaiHat;
import com.example.sd19303.repository.BaiHatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/bai-hat")
public class BaiHatController {
    @Autowired
    BaiHatRepository baiHatRepository;

    @GetMapping("/hien-thi")
    public List<BaiHat> hienThi() {
        return baiHatRepository.findAll();
    }

    @GetMapping("/chi-tiet/{id}")
    public BaiHat chiTiet(@PathVariable("id") Integer id) {
        return baiHatRepository.findById(id).get();
    }

    @PostMapping("/them")
    public String them(@RequestBody BaiHat baiHat) {
        baiHatRepository.save(baiHat);
        return "Them thanh cong";
    }

    @PostMapping("/sua")
    public String sua(@RequestBody BaiHat baiHat) {
        baiHatRepository.save(baiHat);
        return "Sua thanh cong";
    }

    @DeleteMapping("/xoa")
    public String xoa(@RequestParam("id") Integer id) {
        baiHatRepository.deleteById(id);
        return "Xoa thanh cong";
    }

    @GetMapping("/phan-trang")
    public List<BaiHat> phanTrang(@RequestParam(name = "page", defaultValue = "0") Integer page) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page, pageSize);
        return baiHatRepository.findAll(pageable).getContent();
    }
}























