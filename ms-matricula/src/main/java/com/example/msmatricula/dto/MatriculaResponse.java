package com.example.msmatricula.dto;

import com.example.msmatricula.entity.Matricula;
import lombok.Data;

@Data
public class MatriculaResponse {
    private Long id;
    private EstudianteDTO estudiante;
    private CursoDTO curso;
    private String fechaMatricula;

    public MatriculaResponse(Matricula matricula, EstudianteDTO estudiante, CursoDTO curso) {
        this.id = matricula.getId();
        this.estudiante = estudiante;
        this.curso = curso;
        this.fechaMatricula = matricula.getFechaMatricula().toString();
    }
}
