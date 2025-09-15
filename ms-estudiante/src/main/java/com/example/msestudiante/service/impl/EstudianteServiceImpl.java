package com.example.msestudiante.service.impl;

import com.example.msestudiante.entity.Estudiante;
import com.example.msestudiante.repository.EstudianteRepository;
import com.example.msestudiante.service.EstudianteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository repository;

    public EstudianteServiceImpl(EstudianteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Estudiante> listar() {
        return repository.findAll();
    }

    @Override
    public Estudiante obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Estudiante guardar(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
