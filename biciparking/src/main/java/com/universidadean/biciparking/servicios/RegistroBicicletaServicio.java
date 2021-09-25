package com.universidadean.biciparking.servicios;

import com.universidadean.biciparking.modelo.RegistroBicicleta;
import com.universidadean.biciparking.repositorio.RegistroBicicletaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class RegistroBicicletaServicio {
    @Autowired
    private RegistroBicicletaRepositorio repositorio;

    public Long crearRegistroBicicleta(RegistroBicicleta registroBicicleta){
        registroBicicleta.setFechaIngreso(new Date());
        RegistroBicicleta nuevoRegistroBicicleta = repositorio.save(registroBicicleta);
        return nuevoRegistroBicicleta.getIdRegistroBicicleta();
    }

    public RegistroBicicleta obtenerRegistroBicicleta(Long identificacion, String serialBici){
        return repositorio.findRegistrobyIdSerial(identificacion,serialBici);
    }

    public Optional<RegistroBicicleta> obtenerRegistroBicicleta(Long id){
        return repositorio.findById(id);
    }

    public Iterable<RegistroBicicleta> obtenerRegistrosBicicletas(){
        return repositorio.findAll();
    }
    
    public Long registrarFechaSalidaBicicleta(Long id){
        Optional<RegistroBicicleta> rBicicleta = repositorio.findById(id);
        RegistroBicicleta registroBicicleta = rBicicleta.get();
        registroBicicleta.setFechaSalida(new Date());
        RegistroBicicleta nuevoRegistroBicicleta = repositorio.save(registroBicicleta);
        return nuevoRegistroBicicleta.getIdRegistroBicicleta();
    }

    public void eliminarRegistro(Long id){
        Optional<RegistroBicicleta> registroBicicleta = repositorio.findById(id);
        repositorio.delete(registroBicicleta.get());
    }
}
