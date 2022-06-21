package com.test.gt.clientefactura.models;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "factura")
public class Factura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    private float monto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fkPersonaId", referencedColumnName = "persona_id")
    private Persona fkPersonaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Persona getPersona() {
        return fkPersonaId;
    }

    public void setPersona(Persona fkPersonaId) {
        this.fkPersonaId = fkPersonaId;
    }
}
