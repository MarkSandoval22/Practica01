/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.interfaceService;

import com.example.demo.modelo.Estado;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Mark
 */
public interface IestadoService {
    
    public List<Estado>listar();
    public Optional<Estado>listarId(int id);
    public int save(Estado p);
    public void delete(int id);
    
}
