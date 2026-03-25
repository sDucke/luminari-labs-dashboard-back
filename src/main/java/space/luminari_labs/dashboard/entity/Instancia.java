/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package space.luminari_labs.dashboard.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author carloszuniga
 */
@Entity
@Table(name = "instancias")
public class Instancia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombreInstancia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bot_id", nullable = false)
    private Bot bot;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @OneToOne(mappedBy = "instancia", cascade = CascadeType.ALL, orphanRemoval = true)
    private ApiEvolucion api;

    @OneToMany(mappedBy = "instancia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DatosContexto> datosContexto;

    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = LocalDateTime.now();
    }

    public Instancia() {
    }

    public Instancia(String nombreInstancia, Usuario usuario, Bot bot) {
        this.nombreInstancia = nombreInstancia;
        this.usuario = usuario;
        this.bot = bot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreInstancia() {
        return nombreInstancia;
    }

    public void setNombreInstancia(String nombreInstancia) {
        this.nombreInstancia = nombreInstancia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Bot getBot() {
        return bot;
    }

    public void setBot(Bot bot) {
        this.bot = bot;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public ApiEvolucion getApi() {
        return api;
    }

    public void setApi(ApiEvolucion api) {
        this.api = api;
    }

    public List<DatosContexto> getDatosContexto() {
        return datosContexto;
    }

    public void setDatosContexto(List<DatosContexto> datosContexto) {
        this.datosContexto = datosContexto;
    }

}
