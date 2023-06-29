package com.example.demo.controler;

import org.springframework.ui.Model;
import com.example.demo.modelo.Estado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.interfaceService.IestadoService;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated; // Importación agregada
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping
@Validated // Anotación agregada
public class Controlador {
    
   @Autowired 
   private IestadoService service; 
   
   @GetMapping("/listar")
   public String listar(Model model){
       List<Estado> personas = service.listar();
       model.addAttribute("personas", personas);
       return "index"; 
   }
   
   @GetMapping("/new")
   public String agregar(Model model){
       model.addAttribute("estado", new Estado()); // Cambiado "persona" a "estado"
       return "form";
   }
   
   @PostMapping("/save")
   public String save(@Valid Estado estado, Model model) { // Cambiado "p" a "estado"
       service.save(estado);
       return "redirect:/listar";
   }
   
   @GetMapping("/editar/{id}")
   public String editar(@PathVariable int id, Model model){
       Optional<Estado>estado=service.listarId(id);
       model.addAttribute("estado", estado);
       return "form";
   }
   
   @GetMapping("/eliminar/{id}")
   public String delete(Model model, @PathVariable int id){
       service.delete(id);
       return "redirect:/listar";
   }
}

