package com.example.projecto_integrador.security;

import com.example.projecto_integrador.model.Usuario;
import com.example.projecto_integrador.model.UsuarioRole;
import com.example.projecto_integrador.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class LoadInitialData implements ApplicationRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder cifrador = new BCryptPasswordEncoder();

        String passwordCifrrada = cifrador.encode("clabe1234");

        Usuario usuario = new Usuario("Pablo", "pavelezl", "pablovelezlopera3@gmail.com", passwordCifrrada, UsuarioRole.ROLE_USER);
        Usuario usuarioAdmin = new Usuario("Antonio", "Antua", "admin@admin.com", passwordCifrrada, UsuarioRole.ROLE_ADMIN);

        usuarioRepository.save(usuario);
        usuarioRepository.save(usuarioAdmin);
    }
}