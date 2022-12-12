package com.example.projecto_integrador.controller;


import com.example.projecto_integrador.exception.ResourceNotFoundException;
import com.example.projecto_integrador.model.Paciente;
import com.example.projecto_integrador.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> registrarNuevoPaciente (@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.guardarPaciente(paciente));
    }

    @PutMapping
    public ResponseEntity<String> actualizarPaciente (@RequestBody Paciente paciente) throws ResourceNotFoundException {
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPaciente(paciente.getId());
        if (pacienteBuscado.isPresent()){
            pacienteService.actualizarPaciente(paciente);
            return ResponseEntity.ok().body("Se actualizo el paciente con el apellido: " + paciente.getApellido());
        }
        throw new ResourceNotFoundException("No se encontro ningun paciente con el id de: = " + paciente.getId());
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodosLosPacientes () {
        return ResponseEntity.ok(pacienteService.buscarTodosPaciente());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPaciente (@RequestParam("id") Long id) throws ResourceNotFoundException {
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPaciente(id);
        if (pacienteBuscado.isPresent()){
            pacienteService.eliminarPaciente(id);
            return ResponseEntity.ok().body("Se actualizo el paciente con el apellido: " + pacienteBuscado.get().getApellido());
        }
        throw new ResourceNotFoundException("No se encontro ningun paciente con el id de: = " + id);
    }


}
