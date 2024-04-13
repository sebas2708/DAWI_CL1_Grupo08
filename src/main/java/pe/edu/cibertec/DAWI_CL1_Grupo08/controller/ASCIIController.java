package pe.edu.cibertec.DAWI_CL1_Grupo08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class ASCIIController {

    @GetMapping("/Pregunta4")
    public String inicioCaractereASCII(Model model) {
        StringBuilder caracteres = new StringBuilder();

        for (int i = 32; i <= 164; i++) {
            if (i < 97 || i > 122) {
           caracteres.append((char) i).append("<br>");
            }
        }

        model.addAttribute("caracteres", caracteres.toString());
        return "Pregunta4";
    }

}
