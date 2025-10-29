package com.proyecto.service;
import com.proyecto.model.Producto;
import com.proyecto.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository repo;

    public List<Producto> listar(){ return repo.findAll(); }
    public Optional<Producto> obtener(Long id){ return repo.findById(id); }
    public Producto guardar(Producto p){ return repo.save(p); }
    public Producto actualizar(Long id, Producto p){
        p.setId(id);
        return repo.save(p);
    }
    public boolean eliminarProducto(Long id){
        Optional<Producto> p = repo.findById(id);
        if(p.isPresent()){
            repo.deleteById(id);
            return true; 
        }
        return false; 
    }

}
