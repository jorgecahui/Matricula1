package com.example.msmatricula.dto;

import lombok.Data;

@Data
public class CursoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private int creditos;
}
