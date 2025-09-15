package com.example.msmatricula.feign;

import com.example.msmatricula.dto.EstudianteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-estudiante")
public interface EstudianteFeign {

    @GetMapping("/estudiantes/{id}")
    EstudianteDTO obtenerEstudiante(@PathVariable("id") Long id);
}
