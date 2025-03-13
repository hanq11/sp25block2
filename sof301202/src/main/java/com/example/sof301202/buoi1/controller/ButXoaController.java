package com.example.sof301202.buoi1.controller;

import com.example.sof301202.buoi1.repository.ButXoaRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ButXoaController", value = {
        "/but-xoa/hien-thi", //GET
        "/but-xoa/detail", //GET
        "/but-xoa/view-update", //GET
        "/but-xoa/delete", //GET
        "/but-xoa/update", //POST
        "/but-xoa/add" //POST
})
public class ButXoaController extends HttpServlet {
    ButXoaRepository butXoaRepository = new ButXoaRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        }
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", butXoaRepository.getAll());
        req.getRequestDispatcher("/views/hien-thi.jsp").forward(req, resp);
    }
}
