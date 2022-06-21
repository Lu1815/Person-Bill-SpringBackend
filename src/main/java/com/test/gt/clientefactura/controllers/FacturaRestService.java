package com.test.gt.clientefactura.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.gt.clientefactura.models.Factura;
import com.test.gt.clientefactura.services.Ventas;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping("/factura")
@CrossOrigin(origins = "http://localhost:3000/")
public class FacturaRestService {
    @Autowired
    private Ventas facturaService;

    @GetMapping
    public ArrayList<Factura> findFacturas() {
        return facturaService.listFacturas();
    }

    @PostMapping
    public Factura addFactura(@RequestBody Factura factura) {
        return facturaService.storeFactura(factura);
    }

    @GetMapping(path = "/{personaId}")
    public ArrayList<Factura> findFacturasByPersona(@RequestParam("personaId") Long fkPersonaId) {
        return facturaService.findFacturasByPersona(fkPersonaId);
    }
    
}
