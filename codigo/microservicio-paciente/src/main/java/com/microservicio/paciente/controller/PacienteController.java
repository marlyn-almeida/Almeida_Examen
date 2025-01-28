package com.microservicio.paciente.controller;

import com.microservicio.paciente.model.Paciente;
import com.microservicio.paciente.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "http://localhost:5500")  // Cambia el origen según lo necesites
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    // Método para crear un paciente
    @PostMapping
    public ResponseEntity<?> crearPaciente(@Valid @RequestBody Paciente paciente, BindingResult bindingResult) {
        // Verificar si hay errores de validación
        if (bindingResult.hasErrors()) {
            List<String> errores = new ArrayList<>();
            // Recoger los errores de validación
            for (ObjectError error : bindingResult.getAllErrors()) {
                errores.add(error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errores);  // Devolver los errores con un código 400
        }

        try {
            // Guardar el paciente en la base de datos
            Paciente pacienteGuardado = pacienteRepository.save(paciente);
            return ResponseEntity.status(HttpStatus.CREATED).body(pacienteGuardado);
        } catch (Exception e) {
            // Captura y loguea cualquier excepción
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Método GET para obtener todos los pacientes
    @GetMapping
    public ResponseEntity<Iterable<Paciente>> obtenerTodosLosPacientes() {
        Iterable<Paciente> pacientes = pacienteRepository.findAll();
        return ResponseEntity.ok(pacientes);
    }

    // Método GET para obtener un paciente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> obtenerPacientePorId(@PathVariable Long id) {
        return pacienteRepository.findById(id)
                .map(paciente -> ResponseEntity.ok().body(paciente))
                .orElse(ResponseEntity.notFound().build());
    }
}
