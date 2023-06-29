/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.modelo.Estado;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.interfaces.IEstado;
import com.example.demo.interfaceService.IestadoService;

/**
 *
 * @author Mark
 */
@Service
public class EstadoService implements IestadoService {

    @Autowired
    private IEstado data;
    
    @Override
    public List<Estado> listar() {
        return (List<Estado>)data.findAll();
    }

    @Override
    public Optional<Estado> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public int save(Estado p) {
        int res=0;
        Estado estado = data.save(p);
        if(!estado.equals(null)){
            res=1;
        }
        return 0;
        
        
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
    
}
