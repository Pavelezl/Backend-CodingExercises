package com.example.projecto_integrador.service;

import com.example.projecto_integrador.model.Domicilio;
import com.example.projecto_integrador.model.Paciente;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class PacienteServiceTest {
    @Autowired
    private PacienteService pacienteService;

    @Test
    @Order(1)
    public void guardarPacienteTest(){
        Paciente pacienteAGuardar= new Paciente("Rodolfo","Baspineiro"
        ,"5161", LocalDate.of(2022,11,28),
                new Domicilio("Carrera",14,"Chapinero","Cundinamarca"),"lopera@gmail.com");
        Paciente pacienteGuardado=pacienteService.guardarPaciente(pacienteAGuardar);
        assertEquals(1L,pacienteGuardado.getId());
    }
    @Test
    @Order(2)
    public void buscarPacientePorIdTest(){
        Long idABuscar=1L;
        Optional<Paciente> pacienteBuscado=pacienteService.buscarPaciente(idABuscar);
        assertNotNull(pacienteBuscado.get());
    }
    @Test
    @Order(3)
    public void buscarPacientesTest(){
        List<Paciente> pacientes= pacienteService.buscarTodosPaciente();
        //por la cantidad de los pacientes
        Integer cantidadEsperada=1;
        assertEquals(cantidadEsperada,pacientes.size());
    }
    @Test
    @Order(4)
    public void actualizarPacienteTest(){
        Paciente pacienteAActualizar= new Paciente(1L,"Antonio","Lopera"
                ,"5161", LocalDate.of(2022,11,28),
                new Domicilio(1L,"Calle",548,"carrera 14","patio bonito"),"Anotnio@gmail.com");
        pacienteService.actualizarPaciente(pacienteAActualizar);
        Optional<Paciente> pacienteActualizado= pacienteService.buscarPaciente(pacienteAActualizar.getId());
        assertEquals("Ezequiel",pacienteActualizado.get().getNombre());
    }
    @Test
    @Order(5)
    public void eliminarPacienteTest(){
        Long idAEliminar=1L;
        pacienteService.eliminarPaciente(idAEliminar);
        Optional<Paciente> pacienteEliminado=pacienteService.buscarPaciente(idAEliminar);
        assertFalse(pacienteEliminado.isPresent());
    }
}