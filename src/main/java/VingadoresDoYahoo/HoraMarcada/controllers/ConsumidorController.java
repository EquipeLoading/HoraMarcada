package VingadoresDoYahoo.HoraMarcada.controllers;

import VingadoresDoYahoo.HoraMarcada.models.*;
import VingadoresDoYahoo.HoraMarcada.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
@RequestMapping("consumidores")
public class ConsumidorController {

    @Autowired
    ConsumidorRepository ConsumidorRepository;


    @GetMapping()
    public String listaConsumidores(Model model) {
        model.addAttribute("consumidores", ConsumidorRepository.findAll());
        return "lista";
    }


    @GetMapping("novo")
    public String novoConsumidor(Model model){
        return "consumidores/cadastro";
    }

    /*
    public Model consumidorForm(FormConsumidor formConsumidor){
        Usuario usuario = new Usuario(
        )
        return "consumidorForm";
    }
    */

    @PostMapping()
    public String processForm(@Validated CadastroConsumidor cadastroConsumidor, BindingResult result) {
        if(result.hasErrors()){
            return "consumidorForm";
        }

        Usuario usuario = new Usuario(cadastroConsumidor.getNome(), cadastroConsumidor.getEmail(), cadastroConsumidor.getSenha(), cadastroConsumidor.getTelefone(), RoleType.CONSUMIDOR);
        Consumidor consumidor = new Consumidor(cadastroConsumidor.getEndereco(), usuario);

        System.out.println(consumidor);

        ConsumidorRepository.save(consumidor);
        return "redirect:/";
    }

    @RequestMapping("/login")
    public String loginConsumidores() {
        return "login";
    }
}
