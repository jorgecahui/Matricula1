package com.example.mscurso.service.impl;

import com.example.mscurso.entity.Curso;
import com.example.mscurso.repository.CursoRepository;
import com.example.mscurso.service.CursoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository repository;

    public CursoServiceImpl(CursoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Curso> listar() {
        return repository.findAll();
    }

    @Override
    public Curso obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Curso guardar(Curso curso) {
        return repository.save(curso);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
