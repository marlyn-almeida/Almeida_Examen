package com.microservicio.doctor.controller;

import com.microservicio.doctor.model.Doctor;
import com.microservicio.doctor.repository.DoctorRepository;
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
@RequestMapping("/api/doctores")
@CrossOrigin(origins = "http://localhost:5500")  // Cambia el origen según lo necesites
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    // Método para crear un doctor
    @PostMapping
    public ResponseEntity<?> crearDoctor(@Valid @RequestBody Doctor doctor, BindingResult bindingResult) {
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
            // Guardar el doctor en la base de datos
            Doctor doctorGuardado = doctorRepository.save(doctor);
            return ResponseEntity.status(HttpStatus.CREATED).body(doctorGuardado);
        } catch (Exception e) {
            // Captura y loguea cualquier excepción
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Método GET para obtener todos los doctores
    @GetMapping
    public ResponseEntity<Iterable<Doctor>> obtenerTodosLosDoctores() {
        Iterable<Doctor> doctores = doctorRepository.findAll();
        return ResponseEntity.ok(doctores);
    }

    // Método GET para obtener un doctor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> obtenerDoctorPorId(@PathVariable Long id) {
        return doctorRepository.findById(id)
                .map(doctor -> ResponseEntity.ok().body(doctor))
                .orElse(ResponseEntity.notFound().build());
    }
}
