package com.codegym.controller;

import com.codegym.model.MyCounter;
import com.codegym.model.Product;
import com.codegym.model.ProductForm;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
@PropertySource("classpath:global_config_app.properties")
public class ProductController {

    @Autowired
    Environment env;

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ModelAndView findAll(HttpSession httpSession, HttpServletRequest request) {

        List<Product> productList = productService.findAllHaveBusiness();

        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products", productList);

        //MyCounter myCounter = (MyCounter) httpSession.getAttribute("mycounter");
        //int counter = myCounter.getCount();


        //get all cookies
        Cookie[] cookies = request.getCookies();
        //iterate each cookie
        for (Cookie ck : cookies) {
            //display only the cookie with the name 'setUser'
            if (ck.getName().equals("setUser")) {
                modelAndView.addObject("cookieValue", ck);
                break;
            }
        }


        //Iterable<Product> productListByName = productService.findByName("OPPO");

        //Product product = productService.findById(Long.valueOf("3"));

        return modelAndView;
    }

    @GetMapping("/create-product")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("productform", new ProductForm());
        return modelAndView;
    }

    @GetMapping("/e-product")
    public ModelAndView Form() {
        ModelAndView modelAndView = new ModelAndView("/product/edit");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/save-product")
    public ModelAndView saveProduct(@Validated @ModelAttribute("productform") ProductForm productform, BindingResult result) {

        // thong bao neu xay ra loi
        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/product/create");
            modelAndView.addObject("product", new ProductForm());
            return modelAndView;
        }

        // lay ten file
        MultipartFile multipartFile = productform.getImage();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload").toString();

        // luu file len server
        try {
            //multipartFile.transferTo(imageFile);
            FileCopyUtils.copy(productform.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // tham khảo: https://github.com/codegym-vn/spring-static-resources

        // tao doi tuong de luu vao db
        Product productObject = new Product(productform.getName(), productform.getPrice(), fileName);

        // luu vao db
        //productService.save(productObject);
        productService.addHaveBusiness(productObject);

        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new ProductForm());
        modelAndView.addObject("message","successes!");
        return modelAndView;

    }

    /*@ModelAttribute("product")
    public Product product(){
        return new Product();
    }*/
}
