package com.example.msmatricula.feign;

import com.example.msmatricula.dto.CursoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-curso")
public interface CursoFeign {

    @GetMapping("/cursos/{id}")
    CursoDTO obtenerCurso(@PathVariable("id") Long id);
}
