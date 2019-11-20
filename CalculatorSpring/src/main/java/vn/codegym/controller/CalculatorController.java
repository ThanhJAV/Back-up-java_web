package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/home")
    String getIndex() {
        return "index";
    }

    @PostMapping("/calculate")
    public String result(Model model, @RequestParam int first, @RequestParam int second, @RequestParam String operator) {
        int result = 0;
        switch (operator) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                result = first / second;
                break;
        }
        model.addAttribute("first", first);
        model.addAttribute("second", second);
        model.addAttribute("result", result);
        return "index";
    }
}
