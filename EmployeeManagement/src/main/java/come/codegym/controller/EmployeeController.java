package come.codegym.controller;


import come.codegym.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {

    @RequestMapping("/create-employee")
    public String getCreateEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "create-employee";
    }

}
