package com.example.msmatricula.controller;

import com.example.msmatricula.dto.MatriculaResponse;
import com.example.msmatricula.entity.Matricula;
import com.example.msmatricula.service.MatriculaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService service;

    public MatriculaController(MatriculaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Matricula> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Matricula obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Matricula guardar(@RequestBody Matricula matricula) {
        return service.guardar(matricula);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
