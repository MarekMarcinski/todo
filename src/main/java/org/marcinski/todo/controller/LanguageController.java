package org.marcinski.todo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/language")
public class LanguageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        boolean isExist = false;
        Cookie cookie;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("language")) {
                    isExist = true;
                }
            }
        }

        if (isExist) {
            String langParam = req.getParameter("lang");
            if (langParam !=null && !langParam.isEmpty()) {
                cookie = new Cookie("language", req.getParameter("lang"));
                resp.addCookie(cookie);
                resp.sendRedirect("task");
            }
        } else {
            String locale = req.getLocale().toLanguageTag();
            cookie = new Cookie("language", locale);
            resp.addCookie(cookie);
            resp.sendRedirect("task");
        }
    }
}
