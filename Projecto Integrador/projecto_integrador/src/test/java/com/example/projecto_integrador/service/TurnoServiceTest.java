package com.example.projecto_integrador.service;

import com.example.projecto_integrador.model.Domicilio;
import com.example.projecto_integrador.model.Odontologo;
import com.example.projecto_integrador.model.Paciente;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class TurnoServiceTest {
    @Autowired
    private TurnoService turnoService;

    @Test
    @Order(1)
    public void guardarTurnoTest() {
        Paciente paciente = new Paciente("Pablo", "Velez", "123456", LocalDate.of(2022, 11, 28), new Domicilio("calle a", 456, "Caba", "Buenos Aires"), "prueba@gmail.com");
        Odontologo odontologoAGuardar = new Odontologo(1L, "1234", "Pablo", "Velez");
    }
}
