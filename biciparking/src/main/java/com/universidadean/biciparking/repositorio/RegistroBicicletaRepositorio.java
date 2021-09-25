package com.universidadean.biciparking.repositorio;

import com.universidadean.biciparking.modelo.RegistroBicicleta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroBicicletaRepositorio extends CrudRepository<RegistroBicicleta, Long> {

    @Query("SELECT rb FROM RegistroBicicleta rb WHERE rb.identificacion = ?1 and rb.serialBici = ?2")
    RegistroBicicleta findRegistrobyIdSerial(Long identificacion, String serialBici);
}