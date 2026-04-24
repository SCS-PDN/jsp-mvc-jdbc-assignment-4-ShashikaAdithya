package pdn.ac.lk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class CourseController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

   
    @GetMapping("/courses")
    public String listCourses(Model model, HttpSession session) {
       
        if (session.getAttribute("userEmail") == null) {
            return "redirect:/login";
        }

        String sql = "SELECT * FROM courses";
        List<Map<String, Object>> courses = jdbcTemplate.queryForList(sql);
        
       
        model.addAttribute("courseList", courses);
        return "courses";
    }

    
    @PostMapping("/register/{courseId}")
    public String registerCourse(@PathVariable("courseId") int courseId, HttpSession session) {
        String email = (String) session.getAttribute("userEmail");
        
        if (email != null) {
            
            String studentSql = "SELECT student_id FROM students WHERE email = ?";
            Integer studentId = jdbcTemplate.queryForObject(studentSql, new Object[]{email}, Integer.class);
            
            
            String regSql = "INSERT INTO registrations (student_id, course_id) VALUES (?, ?)";
            jdbcTemplate.update(regSql, studentId, courseId);
            
            return "success"; 
        }
        return "redirect:/login";
    }
}