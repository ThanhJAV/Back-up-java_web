package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;


@Controller
public class DictionaryController {

    private Map<String, String> dictionary = new HashMap<>();

    {
        dictionary.put("hello","Xin chao");
        dictionary.put("why", "tai sao");
    }

    @RequestMapping("/search")
    public String search(){
        return "index";
    }

    @RequestMapping("/searchword")
    public String searchword(@RequestParam String txtSearch, Model model){

        String en = txtSearch;
        String vi = dictionary.get(en);

        model.addAttribute("vi", vi);
        return "index";
    }

}