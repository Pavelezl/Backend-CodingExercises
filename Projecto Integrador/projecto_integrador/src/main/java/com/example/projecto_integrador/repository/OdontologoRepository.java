package com.example.projecto_integrador.repository;


import com.example.projecto_integrador.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {

    Optional<Odontologo> findByNombreAndApellido(String nombre, String apellido);

}
