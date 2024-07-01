
package com.practica01.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="arbol")
public class Arbol implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arbol")
    
    private Long idArbol;
    private String rutaImagen;
    private String nombreComun;
    private String tipoFlor;
    private String durezaMadera;
    private int alturaArbol;
    private int cantidadEjemplares;
    private boolean activo;

    public Arbol() {
    }

    public Arbol(String rutaImagen, String nombreComun, String tipoFlor, String durezaMadera, int alturaArbol, int cantidadEjemplares,  boolean activo) {
        this.rutaImagen = rutaImagen;
        this.nombreComun = nombreComun;
        this.tipoFlor = tipoFlor;
        this.durezaMadera = durezaMadera;
        this.alturaArbol = alturaArbol;
        this.cantidadEjemplares = cantidadEjemplares;
        this.activo = activo;
    }
}

    