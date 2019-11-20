package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class ConvertController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/convert")
    public String convertCurrency(@RequestParam String usd, Model model){
        double vnd = Double.parseDouble(usd) * 22000;
        model.addAttribute("vnd", vnd);

        return "index";
    }
}