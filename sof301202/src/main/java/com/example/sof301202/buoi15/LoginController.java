package com.example.sof301202.buoi15;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.hql.internal.ast.tree.SessionFactoryAwareNode;

import java.io.IOException;

@WebServlet(name = "LoginController", value = {
        "/buoi15/login",
        "/buoi15/logout"
})
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("login")) {
            req.getRequestDispatcher("/views/buoi15/login.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            session.invalidate();
            req.getRequestDispatcher("/views/buoi15/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        if(user.equals("abc") && password.equals("abc")) {
            // nhan vien
            session.setAttribute("chucVu", "nhanVien");
            resp.sendRedirect("/buoi15/nhan-vien/hien-thi");
        } else if(user.equals("bde") && password.equals("bde")) {
            // quan ly
            session.setAttribute("chucVu", "quanLy");
            resp.sendRedirect("/buoi15/quan-ly/hien-thi");
        } else {
            req.setAttribute("errorMessage", "Thong tin dang nhap sai");
            req.getRequestDispatcher("/views/buoi15/login.jsp").forward(req, resp);
        }
    }
}
