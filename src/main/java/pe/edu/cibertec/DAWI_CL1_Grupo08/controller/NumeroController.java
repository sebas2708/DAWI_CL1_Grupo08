package pe.edu.cibertec.DAWI_CL1_Grupo08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NumeroController {

    @GetMapping("/")
    public String mostrarFormulario() {
        return "formulario";
    }

    @PostMapping("/verificarCapicua")
    public String verificarCapicua(@RequestParam("numero") int numero, Model model) {
        boolean esCapicua = esCapicua(numero);
        model.addAttribute("numero", numero);
        model.addAttribute("esCapicua", esCapicua);
        return "resultado";
    }

    private boolean esCapicua(int numero) {
        String numeroStr = String.valueOf(numero);
        int longitud = numeroStr.length();
        for (int i = 0; i < longitud / 2; i++) {
            if (numeroStr.charAt(i) != numeroStr.charAt(longitud - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
