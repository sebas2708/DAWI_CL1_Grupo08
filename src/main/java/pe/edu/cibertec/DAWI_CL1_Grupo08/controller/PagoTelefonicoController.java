package pe.edu.cibertec.DAWI_CL1_Grupo08.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_Grupo08.model.PagoTelefonicoModel;


@Controller
public class PagoTelefonicoController {

    @GetMapping("/pago")
    public String inicioPago(Model model){
        model.addAttribute("PagoTelefonicoModel", new PagoTelefonicoModel());
        model.addAttribute("mostraMensaje", false);
                return "pago";
    }

    @PostMapping("/pago")
    public String calcularminutos(@ModelAttribute("pagoTelefonicoModel") PagoTelefonicoModel pagoTelefonicoModel, Model model){

        double minutos = pagoTelefonicoModel.getMinutos();
        String calculo;
        if (minutos <= 5){
            calculo = "usted debe pagar:"+"$10";
        }else{
            calculo = "usted debe pagar:"+minutos*2;
        }
        model.addAttribute("mostrarMensaje", true);
        model.addAttribute("resultado","Mensaje:"+ calculo);
        return "pago";
    }


}
