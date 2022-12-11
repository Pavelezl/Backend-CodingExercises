package com.example.projecto_integrador.service;

import com.example.projecto_integrador.exception.ResourceNotFoundException;
import com.example.projecto_integrador.model.Odontologo;
import com.example.projecto_integrador.repository.OdontologoRepository;
import org.apache.el.stream.Optional;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {

    private OdontologoRepository odontologoRepository;
    private static final Logger LOGGER=Logger.getLogger(OdontologoService.class);
    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public List<Odontologo> listarOdontologos(){
        LOGGER.info("Se inició una operación de listado de odontologos");
        return odontologoRepository.findAll();
    }
    public Odontologo guardarOdontologo(Odontologo odontologo){
        LOGGER.info("Se inició una operación de guardado del odontologo con apellido: "+
                odontologo.getApellido());
        return odontologoRepository.save(odontologo);
    }
    public void actualizarOdontologo(Odontologo odontologo){
        LOGGER.info("Se inició una operación de actualización del odontologo con id="+
                odontologo.getId());
        odontologoRepository.save(odontologo);
    }
    public void eliminarOdontologo(Long id) throws ResourceNotFoundException {
        //el se va a encargar de emitir la exception
        Optional<Odontologo> odontologoAEliminar=buscarOdontologoXId(id);
        if (odontologoAEliminar.ifPresent()){
            odontologoRepository.deleteById(id);
            LOGGER.warn("Se realizo una operación de eliminación del odontologo con" +
                    "id="+id);
        }
        else{
            throw new ResourceNotFoundException("El odontologo a eliminar no existe" +
                    " en la base de datos, se intentó encontrar sin éxito en id= "+id);
        }

    }
    public Optional<Odontologo> buscarOdontologoXId(Long id){
        LOGGER.info("Se inició una operación de búsqueda del odontologo con id="+id);
        return odontologoRepository.findById(id);
    }


}
