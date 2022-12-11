package com.example.projecto_integrador.service;


import com.example.projecto_integrador.model.Paciente;
import com.example.projecto_integrador.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PacienteService {
    private PacienteRepository pacienteRepository;
    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente guardarPaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public Optional<Paciente> buscarPaciente(Long id){
        return pacienteRepository.findById(id);
    }

    public void actualizarPaciente(Paciente paciente){
        pacienteRepository.save(paciente);
    }

    public void eliminarPaciente(Long id){
        pacienteRepository.deleteById(id);
    }

    public List<Paciente> buscarTodosPaciente (){
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> buscarPacienteByEmail(String email){
        return pacienteRepository.findByEmail(email);
    }

}
