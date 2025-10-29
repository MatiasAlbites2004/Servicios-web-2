package com.proyecto;

import com.proyecto.model.*;
import com.proyecto.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner init(UsuarioRepository repo, BCryptPasswordEncoder encoder) {
        return args -> {
            if (repo.findByUsername("eduardo").isEmpty()) {
                Usuario u = new Usuario();
                u.setUsername("eduardo");
                u.setPassword(encoder.encode("123456"));
                u.setRole("USER");
                repo.save(u);
                System.out.println("Usuario por defecto creado: eduardo / 123456");
            }
        };
    }
}
