package com.example.lab6.controller;

import com.example.lab6.entity.Tecnico;
import com.example.lab6.repository.TecnicoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tecnico")
public class TecnicoController {
    final TecnicoRepository tecnicoRepository;

    public TecnicoController(TecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }

    @GetMapping("/lista")
    public String listarTecnicos(Model model) {

        List<Tecnico> lista = tecnicoRepository.findAll();
        model.addAttribute("tecnicoLista", lista);

        return "tecnicos/list";
    }

    @GetMapping("/new")
    public String nuevoTecnico(@ModelAttribute("tecnico") Tecnico tecnico) {
        return "tecnicos/frm";
    }

    @PostMapping("/save")
    public String guardarNuevoTecnico(@ModelAttribute("tecnico") Tecnico tecnico) {
        tecnicoRepository.save(tecnico);
        return "redirect:/tecnicos/list";
    }

    @GetMapping("/edit")
    public String editarTecnico(@ModelAttribute("tecnico") Tecnico tecnico,
                                      Model model, @RequestParam("id") int id) {

        Optional<Tecnico> optShipper = tecnicoRepository.findById(id);

        if (optShipper.isPresent()) {
            tecnico = optShipper.get();
            model.addAttribute("tecnico", tecnico);
            return "tecnicos/frm";
        } else {
            return "redirect:/shipper/list";
        }
    }

    @GetMapping("/delete")
    public String borrarTecnico(Model model,
                                      @RequestParam("id") int id,
                                      RedirectAttributes attr) {

        Optional<Tecnico> optShipper = tecnicoRepository.findById(id);

        if (optShipper.isPresent()) {
            tecnicoRepository.deleteById(id);
            attr.addFlashAttribute("msg", "Transportista borrado exitosamente");
        }
        return "redirect:/shipper/list";

    }


}
