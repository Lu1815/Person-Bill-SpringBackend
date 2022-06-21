package com.test.gt.clientefactura.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.gt.clientefactura.models.Factura;

@Repository
public interface FacturaRepository extends CrudRepository<Factura, Long>{
    public abstract ArrayList<Factura> findAllByFkPersonaId(Long personaId);
}
