package service;

import dao.IDao;
import model.Paciente;

import java.util.List;

public class PacienteService {
    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente guardarPaciente (Paciente paciente){
        return pacienteIDao.guardar(paciente);
    }

    public void eliminarPaciente(Integer id){
        return pacienteIDao.eliminar(id);
    }

    public void actualizarPaciente(Paciente paciente){
        pacienteIDao.actualizar(paciente);
    }

    public Paciente buscarPaciente(Integer id){
        return pacienteIDao.buscar(id);
    }

    public List<Paciente> buscarTodosPaciente(){
        return pacienteIDao.buscarTodo();
    }


}
