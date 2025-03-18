package com.example.sof301202.buoi1.controller;

import com.example.sof301202.buoi1.model.ButXoa;
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

    /**
     * Get: Hien thi/Lay du lieu ra...
     * Post: Xu ly form
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // B1: Lay ra uri cua duong dan 
        String uri = req.getRequestURI();
        System.out.println(uri);
        if (uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if (uri.contains("detail")) {
            detail(req, resp);
        } else if (uri.contains("view-update")) {
            viewUpdate(req, resp);
        } else if (uri.contains("delete")) {
            delete(req, resp);
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        butXoaRepository.delete(id);
        resp.sendRedirect("/but-xoa/hien-thi");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        ButXoa butXoa = butXoaRepository.getOne(id);
        req.setAttribute("butXoa", butXoa);
        req.getRequestDispatcher("/views/view-update.jsp").forward(req, resp);
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        ButXoa butXoa = butXoaRepository.getOne(id);
        req.setAttribute("butXoa", butXoa);
        req.getRequestDispatcher("/views/detail.jsp").forward(req, resp);
    }


    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", butXoaRepository.getAll());
        req.getRequestDispatcher("/views/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")) {
            add(req, resp);
        } else if(uri.contains("update")) {
            update(req, resp);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String ten = req.getParameter("ten");
        Float gia = Float.valueOf(req.getParameter("gia"));
        String congDung = req.getParameter("congDung");
        ButXoa butXoa = new ButXoa(id, ten, gia, congDung);
        butXoaRepository.update(butXoa);
        resp.sendRedirect("/but-xoa/hien-thi");
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ten = req.getParameter("ten");
        Float gia = Float.valueOf(req.getParameter("gia"));
        String congDung = req.getParameter("congDung");
        ButXoa butXoa = new ButXoa(null, ten, gia, congDung);
        butXoaRepository.add(butXoa);
        resp.sendRedirect("/but-xoa/hien-thi");
    }
}
