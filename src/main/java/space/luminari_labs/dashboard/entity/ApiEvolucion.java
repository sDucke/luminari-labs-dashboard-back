/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package space.luminari_labs.dashboard.entity;

import jakarta.persistence.*;

/**
 *
 * @author carloszuniga
 */
@Entity
@Table(name = "api_evolucion")
public class ApiEvolucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 100)
    private String codigoInstancia;

    @Column(nullable = false, length = 50)
    private String estado;

    @Column(columnDefinition = "TEXT")
    private String qrGenerado;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instancia_id", nullable = false, unique = true)
    private Instancia instancia;

    public ApiEvolucion() {
    }

    public ApiEvolucion(String codigoInstancia, String estado, Instancia instancia) {
        this.codigoInstancia = codigoInstancia;
        this.estado = estado;
        this.instancia = instancia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoInstancia() {
        return codigoInstancia;
    }

    public void setCodigoInstancia(String codigoInstancia) {
        this.codigoInstancia = codigoInstancia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getQrGenerado() {
        return qrGenerado;
    }

    public void setQrGenerado(String qrGenerado) {
        this.qrGenerado = qrGenerado;
    }

    public Instancia getInstancia() {
        return instancia;
    }

    public void setInstancia(Instancia instancia) {
        this.instancia = instancia;
    }

}
