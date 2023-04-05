package com.example.ejonespringboot.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    private String nombre;
    private String precio;
    private String codigo;
    private String empresa;
    private String lote;
    private String nombredueno;

    public Producto(Long id, String nombre, String precio, String codigo,
                   String empresa, String lote, String nombredueno) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
        this.empresa = empresa;
        this.lote = lote;
        this.nombredueno = nombredueno;
    }

    public Producto(){}


}
