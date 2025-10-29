package com.proyecto.service;

import com.proyecto.model.Usuario;
import com.proyecto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Usuario registrar(Usuario u){
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return usuarioRepository.save(u);
    }

    public Optional<Usuario> buscarPorUsername(String username){
        return usuarioRepository.findByUsername(username);
    }

    public boolean validarCredenciales(String username, String rawPassword){
        Optional<Usuario> uOpt = usuarioRepository.findByUsername(username);
        if(uOpt.isEmpty()) return false;
        return passwordEncoder.matches(rawPassword, uOpt.get().getPassword());
    }
}
