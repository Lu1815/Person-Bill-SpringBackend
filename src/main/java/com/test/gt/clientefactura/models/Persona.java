package com.test.gt.clientefactura.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "persona_id")
    private Long id;
    
    @Column(nullable = false)
    private String nombre;    

    @Column(nullable = false)
    private String apellidoPaterno;    
    
    private String apellidoMaterno;    

    @Column(unique = true, nullable = false)
    private String identificacion;

    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy = "fkPersonaId",
        cascade = CascadeType.ALL,
        orphanRemoval = true
        )
    private Set<Factura> facturas = new HashSet<>();

    // GETTERS Y SETTERS
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
    
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellidoPaterno(){
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno){
        this.apellidoPaterno = apellidoPaterno;
    }


    public String getApellidoMaterno(){
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno){
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getIdentificacion(){
        return identificacion;
    }

    public void setIdentificacion(String identificacion){
        this.identificacion = identificacion;
    }

    public Set<Factura> geFactura() {
        return facturas;
    }
}
