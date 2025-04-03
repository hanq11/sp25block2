package com.example.sof301202.buoi11;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AjaxController", value = {
        "/ajax/hien-thi",
        "/ajax/api"
})
public class AjaxController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else {
            api(req, resp);
        }
    }

    private void api(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SinhVien sv = new SinhVien(1, "PH12345", "Nguyen Van A");
        // Chuyen object ve dang json
        Gson gson = new Gson();
        String data = gson.toJson(sv);
        // Set kieu du lieu tra ve
        resp.setContentType("application/json");
        // Tra ve du lieu
        PrintWriter pw = resp.getWriter();
        pw.print(data);
        pw.flush();
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/buoi11/hien-thi.jsp").forward(req, resp);
    }
}
