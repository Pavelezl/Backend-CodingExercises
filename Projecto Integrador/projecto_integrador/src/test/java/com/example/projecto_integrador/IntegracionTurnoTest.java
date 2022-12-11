package com.example.projecto_integrador;

import com.example.projecto_integrador.DTO.TurnoDTO;
import com.example.projecto_integrador.model.Domicilio;
import com.example.projecto_integrador.model.Odontologo;
import com.example.projecto_integrador.model.Paciente;
import com.example.projecto_integrador.service.OdontologoService;
import com.example.projecto_integrador.service.PacienteService;
import com.example.projecto_integrador.service.TurnoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegracionTurnoTest {
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private MockMvc mockMvc;

    private void cargarTurnoInicial(){
        Domicilio domicilio= new Domicilio("Calle a",234,"Localidad a","Provincia a");
        Paciente paciente= new Paciente("Rodolfo","Baspineiro","5451",
                LocalDate.of(2022,12,7),new Domicilio("Carrera",14,"Chapinero","Cundinamarca"),"lopera@gmail.com");
        Paciente pacienteGuardado=pacienteService.guardarPaciente(paciente);
        Odontologo odontologo=new Odontologo("1234","Ezequiel","Baspineiro");
        Odontologo odontologoGuardado= odontologoService.guardarOdontologo(odontologo);
        TurnoDTO turnoDTO= new TurnoDTO();
        turnoDTO.setFecha(LocalDate.of(2022,12,07));
        turnoDTO.setPacienteId(pacienteGuardado.getId());
        turnoDTO.setOdontologoId(odontologoGuardado.getId());
        turnoService.guardarTurno(turnoDTO);
    }
    @Test
    public void listadoTurnoTest() throws Exception {
        cargarTurnoInicial();
        MvcResult respuesta=mockMvc.perform(MockMvcRequestBuilders
                        .get("/turnos").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        assertFalse(respuesta.getResponse().getContentAsString().isEmpty());
    }
}
