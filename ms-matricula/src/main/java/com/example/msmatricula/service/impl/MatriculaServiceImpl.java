package com.example.msmatricula.service.impl;

import com.example.msmatricula.dto.CursoDTO;
import com.example.msmatricula.dto.EstudianteDTO;
import com.example.msmatricula.entity.Matricula;
import com.example.msmatricula.feign.CursoFeign;
import com.example.msmatricula.feign.EstudianteFeign;
import com.example.msmatricula.repository.MatriculaRepository;
import com.example.msmatricula.service.MatriculaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    private final MatriculaRepository repository;
    private final EstudianteFeign estudianteFeign;
    private final CursoFeign cursoFeign;

    public MatriculaServiceImpl(MatriculaRepository repository,
                                EstudianteFeign estudianteFeign,
                                CursoFeign cursoFeign) {
        this.repository = repository;
        this.estudianteFeign = estudianteFeign;
        this.cursoFeign = cursoFeign;
    }

    @Override
    public List<Matricula> listar() {
        return repository.findAll();
    }

    @Override
    public Matricula obtenerPorId(Long id) {
        Matricula matricula = repository.findById(id).orElse(null);
        if (matricula != null) {
            EstudianteDTO estudiante = estudianteFeign.obtenerEstudiante(matricula.getEstudianteId());
            CursoDTO curso = cursoFeign.obtenerCurso(matricula.getCursoId());
        }
        return matricula;
    }

    @Override
    public Matricula guardar(Matricula matricula) {
        EstudianteDTO estudiante = estudianteFeign.obtenerEstudiante(matricula.getEstudianteId());
        CursoDTO curso = cursoFeign.obtenerCurso(matricula.getCursoId());

        if (estudiante == null || curso == null) {
            throw new RuntimeException("Estudiante o curso no existen");
        }

        return repository.save(matricula);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
