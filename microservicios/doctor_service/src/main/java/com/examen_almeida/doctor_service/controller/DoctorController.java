package com.examen_almeida.doctor_service.controller;

import com.examen_almeida.doctor_service.model.Doctor;
import com.examen_almeida.doctor_service.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/doctores")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> obtenerTodos() {
        return doctorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> obtenerPorId(@PathVariable Long id) {
        Doctor doctor = doctorService.obtenerPorId(id);
        return ResponseEntity.ok(doctor);
    }

    @PostMapping
    public ResponseEntity<Doctor> crearDoctor(@Valid @RequestBody Doctor doctor) {
        Doctor nuevoDoctor = doctorService.guardarDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDoctor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> actualizarDoctor(@PathVariable Long id, @Valid @RequestBody Doctor doctor) {
        Doctor doctorActualizado = doctorService.actualizarDoctor(id, doctor);
        return ResponseEntity.ok(doctorActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDoctor(@PathVariable Long id) {
        doctorService.eliminarDoctor(id);
        return ResponseEntity.noContent().build();
    }
}
