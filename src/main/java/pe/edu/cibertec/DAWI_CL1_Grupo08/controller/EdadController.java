package pe.edu.cibertec.DAWI_CL1_Grupo08.controller;

import pe.edu.cibertec.DAWI_CL1_Grupo08.model.EdadModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EdadController {
    @GetMapping("/frm2")
    public String principal(Model model){
        model.addAttribute("edadModel", new EdadModel());
        model.addAttribute("mostrarMensaje", false);
        return "frm2";
    }

    @PostMapping("/frm2")
    public String calcularEdad(@ModelAttribute("edadModel") EdadModel edadModel, Model model) {
        int edad1 = edadModel.getEdad1();
        int edad2 = edadModel.getEdad2();
        String diagnostico = "";
        if (edad1 < edad2) {
            model.addAttribute("resultado", "La edad del hermano mayor es: " +
                    edad2 + " y se llevan " + (edad2 - edad1) + " años respecto a su hermano menor.");
        }else{
            model.addAttribute("resultado", "La edad del hermano mayor es: " +
                    edad1 + " y se llevan " + (edad1 - edad2) + " años respecto a su hermano menor.");
        }
        model.addAttribute("mostrarMensaje", true);
        return "frm2";
    }
}
