package com.test.gt.clientefactura.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.gt.clientefactura.models.Factura;
import com.test.gt.clientefactura.repositories.FacturaRepository;

@Service
public class Ventas {

    @Autowired
    FacturaRepository facturaRepository;

    public ArrayList<Factura> listFacturas() {
        return (ArrayList<Factura>) facturaRepository.findAll();
    }

    @Transactional
    public Factura storeFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Transactional(readOnly = true)
    public ArrayList<Factura> findFacturasByPersona(Long personaId) {
        return (ArrayList<Factura>) facturaRepository.findAllByFkPersonaId(personaId);
    }
}
