package pe.edu.cibertec.DAWI_CL1_Grupo08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_Grupo08.model.LlamadaModel;

@Controller

public class LlamadaController {

    @GetMapping("/Pregunta1")
    public String iniciollamada(Model model){
        model.addAttribute("llamadaModelo", new LlamadaModel());
        model.addAttribute("mostrarMensaje", false);
        return "Pregunta1";
    }


    @PostMapping("/Pregunta1")
    public String calcularCostoLlamada(@ModelAttribute("llamadaModelo") LlamadaModel llamadaModel, Model model) {
        int minutos = llamadaModel.getMinuto();
        int coste;

        if (minutos <= 5) {
            coste = 10;
        } else {
            coste = 10 + (minutos - 5) * 2;
        }
        model.addAttribute("mostrarMensaje", true);
        model.addAttribute("resultado", "Total a pagar: $" + coste);
        return "Pregunta1";
    }

    }

