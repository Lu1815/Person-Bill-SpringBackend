package com.test.gt.clientefactura.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.gt.clientefactura.models.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long>{
    public Optional<Persona> findByIdentificacion(String identificacion);
    public long deleteByIdentificacion(String identificacion);
}
