package com.example.projecto_integrador.service;

import com.example.projecto_integrador.exception.BadRequestException;
import com.example.projecto_integrador.exception.ResourceNotFoundException;
import com.example.projecto_integrador.model.Domicilio;
import com.example.projecto_integrador.model.Odontologo;
import com.example.projecto_integrador.model.Paciente;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class OdontologoServiceTest {
    @Autowired
    private OdontologoService odontologoService;

    @Test
    @Order(1)
    public void guardaroOdontologoTest(){
        Odontologo odontologoAGuardar= new Odontologo("213124123","Pablo", "Velez");
        Odontologo odontologoGuardado=odontologoService.guardarOdontologo(odontologoAGuardar);
        assertEquals(1L,odontologoGuardado.getId());
    }

    @Test
    @Order(2)
    public void buscarOdontologoTest() throws BadRequestException {
        Long idAbuscar = 1L;
        Optional<Odontologo> odontologoBuscado=odontologoService.buscarOdontologoXId(idAbuscar);
        assertNotNull(odontologoBuscado.get());
    }

    @Test
    @Order(3)
    public void listarOdontologo() throws BadRequestException {
        List<Odontologo> odontologos=odontologoService.listarOdontologos();
        Integer cantidadEsperada=1;
        assertEquals(cantidadEsperada,odontologos.size());
    }

    @Test
    @Order(4)
    public void actualizarOdontologoTest() {
        Odontologo odontologoAActualizar= new Odontologo(1L, "aa567", "Marta", "Bonino");
        odontologoService.actualizarOdontologo(odontologoAActualizar);
        Optional<Odontologo> odontologoActualizado= odontologoService.buscarOdontologoXId(odontologoAActualizar.getId());
        assertEquals("Marta",odontologoActualizado.get().getNombre());
    }

    @Test
    @Order(5)
    public void eliminarOdontologoTest() throws BadRequestException, ResourceNotFoundException {
        Long idAEliminar=1L;
        odontologoService.eliminarOdontologo(idAEliminar);
        Optional<Odontologo> odontologoElimnado = odontologoService.buscarOdontologoXId(idAEliminar);
        assertFalse(odontologoElimnado.isPresent());
    }









}
