package com.example.projecto_integrador.service;

import com.example.projecto_integrador.DTO.TurnoDTO;
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
class TurnoServiceTest {
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;

    @Test
    @Order(1)
    public void guardarTurnoTest() {
        Paciente paciente = pacienteService.guardarPaciente(new Paciente("Pablo", "Velez", "123456",
                LocalDate.of(2022, 11, 28),
                new Domicilio("calle a", 456, "Caba", "Buenos Aires"),
                "prueba@gmail.com"));
        Odontologo odontologo= odontologoService.guardarOdontologo(new Odontologo(1L, "1234", "Pablo", "Velez"));

        TurnoDTO turnoDTOGuardar = new TurnoDTO();
        turnoDTOGuardar.setPacienteId(paciente.getId());
        turnoDTOGuardar.setOdontologoId(odontologo.getId());
        turnoDTOGuardar.setFecha(LocalDate.of(2022,8,6));
        TurnoDTO turnoDTOGuardado = turnoService.guardarTurno(turnoDTOGuardar);

        assertEquals(1L,turnoDTOGuardado.getId());
        assertEquals(LocalDate.of(2022,8,6),turnoDTOGuardado.getFecha());

    }

    @Test
    @Order(2)
    public void buscarPorIdTest() throws BadRequestException, ResourceNotFoundException {
        Long idABuscar = 1L;
        Optional<TurnoDTO> turnobuscado = turnoService.buscarTurno(idABuscar);

        assertNotNull(turnobuscado);
    }

    @Test
    @Order(3)
    public void mostrarTurnosTest() {
        List<TurnoDTO> turnos = turnoService.buscarTodosTurno();
        Integer cantidadEsperada = 1;
        assertEquals(cantidadEsperada,turnos.size());
    }
    @Test
    @Order(4)
    public void actualizarTurnoTest() throws BadRequestException, ResourceNotFoundException {
        Paciente pacienteAct = pacienteService.guardarPaciente(new Paciente("Antonio", "Lopera", "54321",
                LocalDate.of(2022, 11, 28),
                new Domicilio("carrera a", 789, "Chapinero", "Bolivar"),
                "prueba@gmail.com"));
        Odontologo odontologoAct = odontologoService.guardarOdontologo(new Odontologo(1L, "6575", "Leo", "Messi"));
        LocalDate nuevaFecha = LocalDate.of(1993,8,6);

        TurnoDTO turnoDTOActualizar = new TurnoDTO();
        turnoDTOActualizar.setId(1L);
        turnoDTOActualizar.setPacienteId(pacienteAct.getId());
        turnoDTOActualizar.setOdontologoId(odontologoAct.getId());
        turnoDTOActualizar.setFecha(nuevaFecha);
        turnoService.guardarTurno(turnoDTOActualizar);
        turnoService.actualizarTurno(turnoDTOActualizar);
        Optional<TurnoDTO> turnoDTOActualizado = turnoService.buscarTurno(turnoDTOActualizar.getId());

        assertEquals(nuevaFecha,turnoDTOActualizado.get().getFecha());
    }

//    @Test
//    @Order(5)
//    public void eliminarTurno() throws BadRequestException, ResourceNotFoundException {
//        Long idAEliminar = 1L;
//        turnoService.eliminarTurno(idAEliminar);
//
//        ResourceNotFoundException throwm = assertThrows(
//                ResourceNotFoundException.class,
//                () -> turnoService.buscarTurno(idAEliminar).isPresent()
//        );
//
//        assertTrue(throwm.getMessage().contains("No se hallo ningun turno con el id= " + idAEliminar));
//    }


}
