package com.example.sof301202.buoi15;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "CuaHangFilter", value = {
        "/buoi15/nhan-vien/*",
        "/buoi15/quan-ly/*"
})
public class CuaHangFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        Filter.super.init(config);
    }

    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String chucVu = (String) session.getAttribute("chucVu");

        if(chucVu != null) {
            if(chucVu.equals("quanLy")) {
                chain.doFilter(req, resp);
            } else if(chucVu.equals("nhanVien")) {
                String uri = req.getRequestURI();
                if(uri.contains("quan-ly")) {
                    req.getRequestDispatcher("/views/buoi15/403.jsp").forward(req, resp);
                    return;
                }
                chain.doFilter(req, resp);
            }
        } else {
            req.setAttribute("errorMessage", "Vui long dang nhap");
            req.getRequestDispatcher("/views/buoi15/login.jsp").forward(req, resp);
        }
    }
}
