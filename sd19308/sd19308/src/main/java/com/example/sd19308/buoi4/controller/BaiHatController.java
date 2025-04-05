package com.example.sd19308.buoi4.controller;

import com.example.sd19308.buoi4.dto.BaiHatRequest;
import com.example.sd19308.buoi4.dto.BaiHatResponse;
import com.example.sd19308.buoi4.model.BaiHat;
import com.example.sd19308.buoi4.repository.BaiHatRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
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

    @GetMapping("/phan-trang")
    public List<BaiHat> phanTrang(@RequestParam(name = "page", defaultValue = "0",required = false) Integer page) {
        int pageSize = 3;
        Pageable pageable = PageRequest.of(page, pageSize);
        return baiHatRepository.findAll(pageable).getContent();
    }

    @GetMapping("/hien-thi-response")
    public List<BaiHatResponse> hienThiResponse() {
        return baiHatRepository.getAllResponse();
    }

    @PostMapping("/add")
    public String add(@RequestBody @Valid BaiHatRequest baiHatRequest, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "Them loi";
        }
        BaiHat bh = new BaiHat();
        BeanUtils.copyProperties(baiHatRequest, bh);
        baiHatRepository.save(bh);
        return "Them thanh cong";
    }

    @PostMapping("/update")
    public String update(@RequestBody @Valid BaiHatRequest baiHatRequest, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "Sua loi";
        }
        BaiHat bh = new BaiHat();
        BeanUtils.copyProperties(baiHatRequest, bh);
        baiHatRepository.save(bh);
        return "Sua thanh cong";
    }
}
