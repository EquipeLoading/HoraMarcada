package VingadoresDoYahoo.HoraMarcada.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String homeApp(Model model) {
        //model.addAttribute("mensagem", "teste de mensagem");
        return "index";
    }

    @RequestMapping("/secure")
    public String secure(){
        return "secure";
    }
    
}