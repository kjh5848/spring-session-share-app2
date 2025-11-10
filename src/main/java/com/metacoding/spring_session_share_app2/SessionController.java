package com.metacoding.spring_session_share_app2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {

    @GetMapping("/app2/")
    public String home(HttpSession session, Model model) {
        Integer count = (Integer) session.getAttribute("count");
        if (count == null)
            count = 0;
        count++;
        session.setAttribute("count", count);

        model.addAttribute("server", "App2 Server");
        model.addAttribute("count", count);

        return "index";
    }
}