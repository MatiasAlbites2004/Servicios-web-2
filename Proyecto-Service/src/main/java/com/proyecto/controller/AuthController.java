package com.proyecto.controller;

import com.proyecto.dto.LoginRequest;
import com.proyecto.model.Usuario;
import com.proyecto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req){
        boolean ok = usuarioService.validarCredenciales(req.getUsername(), req.getPassword());
        if(!ok) return ResponseEntity.status(401).body("Usuario o clave inválidos");
        Usuario u = usuarioService.buscarPorUsername(req.getUsername()).get();
        u.setPassword(null);
        return ResponseEntity.ok(u);
    }
}
