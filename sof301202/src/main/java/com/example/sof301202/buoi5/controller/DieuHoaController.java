package com.example.sof301202.buoi5.controller;

import com.example.sof301202.buoi5.model.DieuHoa;
import com.example.sof301202.buoi5.model.Hang;
import com.example.sof301202.buoi5.repository.DieuHoaRepository;
import com.example.sof301202.buoi5.repository.HangRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DieuHoaController", value = {
        "/dieu-hoa/hien-thi",
        "/dieu-hoa/detail",
        "/dieu-hoa/view-update",
        "/dieu-hoa/delete",
        "/dieu-hoa/update",
        "/dieu-hoa/add",
        "/dieu-hoa/phan-trang"
})
public class DieuHoaController extends HttpServlet {
    DieuHoaRepository dieuHoaRepository = new DieuHoaRepository();
    HangRepository hangRepository = new HangRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if(uri.contains("detail")) {
            showDetail(req, resp);
        } else if(uri.contains("view-update")) {
            viewUpdate(req, resp);
        } else if(uri.contains("delete")) {
            deleteDieuHoa(req, resp);
        } else if(uri.contains("phan-trang")) {
            phanTrang(req,resp);
        }
    }

    private void phanTrang(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 0;
        if(req.getParameter("page") != null) {
            page = Integer.valueOf(req.getParameter("page"));
        }
        req.setAttribute("danhSach", dieuHoaRepository.phanTrang(page));
        req.setAttribute("listHang", hangRepository.getAll());
        req.setAttribute("pageNumber", page);
        req.getRequestDispatcher("/views/buoi5/hien-thi.jsp").forward(req, resp);
    }

    private void deleteDieuHoa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        dieuHoaRepository.xoaDieuHoa(id);
        resp.sendRedirect("/dieu-hoa/hien-thi");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("dieuHoa", dieuHoaRepository.getDetail(id));
        req.setAttribute("listHang", hangRepository.getAll());
        req.getRequestDispatcher("/views/buoi5/view-update.jsp").forward(req, resp);
    }

    private void showDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("dieuHoa", dieuHoaRepository.getDetail(id));
        req.getRequestDispatcher("/views/buoi5/detail.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listHang", hangRepository.getAll());
        req.setAttribute("danhSach", dieuHoaRepository.getAll());
        req.getRequestDispatcher("/views/buoi5/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")) {
            addDieuHoa(req, resp);
        } else if(uri.contains("update")) {
            updateDieuHoa(req, resp);
        }
    }

    private void updateDieuHoa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String ten = req.getParameter("ten");
        Float gia = Float.valueOf(req.getParameter("gia"));
        String chucNang = req.getParameter("chucNang");
        Boolean inverter = Boolean.valueOf(req.getParameter("inverter"));

        // Get hang
        Integer idHang = Integer.valueOf(req.getParameter("hang"));
        Hang hang = hangRepository.getDetail(idHang);
        DieuHoa dieuHoa = new DieuHoa(id, ten, gia, chucNang, inverter, hang);

        dieuHoaRepository.suaDieuHoa(dieuHoa);
        resp.sendRedirect("/dieu-hoa/hien-thi");
    }

    private void addDieuHoa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ten = req.getParameter("ten");
        Float gia = Float.valueOf(req.getParameter("gia"));
        String chucNang = req.getParameter("chucNang");
        Boolean inverter = Boolean.valueOf(req.getParameter("inverter"));
        // Get hang
        Integer idHang = Integer.valueOf(req.getParameter("hang"));
        Hang hang = hangRepository.getDetail(idHang);
        DieuHoa dieuHoa = new DieuHoa(null, ten, gia, chucNang, inverter, hang);

        dieuHoaRepository.themDieuHoa(dieuHoa);
        resp.sendRedirect("/dieu-hoa/hien-thi");
    }


}
