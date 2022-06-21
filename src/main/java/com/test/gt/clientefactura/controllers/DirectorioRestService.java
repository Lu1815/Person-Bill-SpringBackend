package com.test.gt.clientefactura.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.test.gt.clientefactura.models.Persona;
import com.test.gt.clientefactura.services.Directorio;
import org.springframework.web.bind.annotation.GetMapping;

@RestController 
@RequestMapping("/persona")
@CrossOrigin(origins = "http://localhost:3000/")
public class DirectorioRestService { 

    @Autowired
    Directorio personaService;

    @GetMapping()
    public ArrayList<Persona> findPersonas() {
        return personaService.findPersonas();
    }

    @PostMapping()
    public Persona storePersona(@RequestBody Persona persona) {
        return personaService.storePersona(persona);
    }

    @GetMapping(path = "/{identificacion}")
    public Optional<Persona> findPersonaByIdentificacion(@PathVariable("identificacion") String identificacion) {
        return personaService.findPersonaByIdentificacion(identificacion);
    }
    
    @DeleteMapping(path = "/{identificacion}")
    public String deletePersonaByIdentificacion(@PathVariable("identificacion") String identificacion) {
        Long ok = personaService.deletePersonaByIdentificacion(identificacion);
        if(ok > 0) {
            return "Se ha eliminado con éxito a la persona con identificación: " + identificacion;
        } else {
            return "No se pudo eliminar a la persona con identificación: " + identificacion;
        }
    }
}
