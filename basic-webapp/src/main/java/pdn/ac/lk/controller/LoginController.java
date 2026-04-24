package pdn.ac.lk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller 
public class LoginController {

    @Autowired 
    private JdbcTemplate jdbcTemplate;

   
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    
    @PostMapping("/login")
    public String handleLogin(@RequestParam("email") String email, 
                              @RequestParam("password") String password, 
                              HttpSession session, 
                              Model model) {
        
        
        String sql = "SELECT count(*) FROM students WHERE email = ? AND password = ?";
        
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{email, password}, Integer.class);

        if (count != null && count > 0) {
           
            session.setAttribute("userEmail", email);
            return "redirect:/courses";
        } else {
            
            model.addAttribute("error", "Invalid Email or Password!");
            return "login";
        }
    }
}