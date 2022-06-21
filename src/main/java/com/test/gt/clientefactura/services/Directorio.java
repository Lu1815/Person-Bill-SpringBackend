package com.test.gt.clientefactura.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.gt.clientefactura.models.Persona;
import com.test.gt.clientefactura.repositories.PersonaRepository;

@Service
public class Directorio {
    
    @Autowired
    PersonaRepository personaRepository;

    @Transactional(readOnly = true)
    public ArrayList<Persona> findPersonas() {
        return (ArrayList<Persona>) personaRepository.findAll();
    }

    @Transactional
    public Persona storePersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Transactional(readOnly = true)
    public Optional<Persona> findPersonaByIdentificacion(String identificacion) {
        return personaRepository.findByIdentificacion(identificacion);
    }

    @Transactional
    public Long deletePersonaByIdentificacion(String identificacion) {
        return personaRepository.deleteByIdentificacion(identificacion);
        // try{
        //     personaRepository.deleteByIdentificacion(identificacion);
        //     return true;
        // } catch(Exception e) {
        //     return false;
        // }
    }
}