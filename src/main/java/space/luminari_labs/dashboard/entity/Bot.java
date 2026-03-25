/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package space.luminari_labs.dashboard.entity;

import jakarta.persistence.*;
import java.util.List;

/**
 *
 * @author carloszuniga
 */
@Entity
@Table(name = "bots")
public class Bot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 255)
    private String descripcion;

    @Column(columnDefinition = "TEXT")
    private String configuracionBase;

    @OneToMany(mappedBy = "bot", cascade = CascadeType.ALL)
    private List<Instancia> instancias;

    public Bot() {
    }

    public Bot(String nombre, String descripcion, String configuracionBase) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.configuracionBase = configuracionBase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getConfiguracionBase() {
        return configuracionBase;
    }

    public void setConfiguracionBase(String configuracionBase) {
        this.configuracionBase = configuracionBase;
    }

    public List<Instancia> getInstancias() {
        return instancias;
    }

    public void setInstancias(List<Instancia> instancias) {
        this.instancias = instancias;
    }

}
