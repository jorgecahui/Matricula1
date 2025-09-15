package com.example.msestudiante.service;

import com.example.msestudiante.entity.Estudiante;

import java.util.List;

public interface EstudianteService {
    List<Estudiante> listar();
    Estudiante obtenerPorId(Long id);
    Estudiante guardar(Estudiante estudiante);
    void eliminar(Long id);
}
