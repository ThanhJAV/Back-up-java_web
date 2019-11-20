package vn.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("/Sandwich")
    public String getIndex(){
        return "index";
    }
    @GetMapping("/save")
    public String saveSandWich(ModelMap modeMap, @RequestParam(value ="condiment")String[] condiment){
        modeMap.addAttribute("condimentChoose",condiment);
        return "display";
    }
}
