package com.example.imc;

import java.text.DecimalFormat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImcController {
    
    @GetMapping("/imc")
    String home(@RequestParam String peso, String altura){
        DecimalFormat df = new DecimalFormat("###.##");
        double p = Double.parseDouble(peso);
        double a = Double.parseDouble(altura);
        double imc = p/(a*a);
        String message;
        if (imc < 18.5) message = "IMC: "+ df.format(imc) +". Está abaixo do peso risco a saúde eleveado";
        else if (imc > 18.5 && imc < 24.99) message = "IMC: "+ df.format(imc) +". Peso ideal risco a saúde inexistete";
        else if (imc > 25.0 && imc < 29.99) message = "IMC: "+ df.format(imc) +". Excesso de peso risco a saúde elevado";
        else if (imc > 30.0 && imc < 34.99) message = "IMC: "+ df.format(imc) +". Obesidade grau 1 risco a saúde muito elevado";
        else if (imc > 35.0 && imc < 39.99) message = "IMC: "+ df.format(imc) +". Obesidade grau 2 risco a saúde muitíssimo elevado";
        else if (imc > 40.0 && imc < 44.99) message = "IMC: "+ df.format(imc) +". Obesidade grau 3 risco a saúde obesidade mórbida";
        else message = "IMC: "+ df.format(imc) +". Obesidade grau 3 risco a saúde obesidade mórbida";
        return message;
    }
}
