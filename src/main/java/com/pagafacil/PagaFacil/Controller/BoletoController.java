package com.pagafacil.PagaFacil.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("boleto")
public class BoletoController {

    public String seuBoleto(){
        String boleto = "566,00 R$";
        return boleto;
    }

}
