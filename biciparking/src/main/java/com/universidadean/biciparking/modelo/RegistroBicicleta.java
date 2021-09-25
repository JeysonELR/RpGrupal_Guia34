package com.universidadean.biciparking.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "tbl_registro_bicicletas")
public class RegistroBicicleta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_registro_bicicleta", unique = true)
    private Long idRegistroBicicleta;

    @Column(name = "nombre")
    @NotNull(message = "Nombre es requerido")
    private String nombre;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_salida")
    private Date fechaSalida;

    @NotNull(message = "Serial Bicicleta es requerido")
    @Column(name = "serial_bici", unique = true)
    private String serialBici;

    @NotNull(message = "Identificación es requerido")
    @Column(name = "identificacion", unique = true)
    private Long identificacion;

    public Long getIdRegistroBicicleta() {
        return idRegistroBicicleta;
    }

    public void setIdRegistroBicicleta(Long idRegistroBicicleta) {
        this.idRegistroBicicleta = idRegistroBicicleta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getSerialBici() {
        return serialBici;
    }

    public void setSerialBici(String serialBici) {
        this.serialBici = serialBici;
    }

    public Long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
    }
}
