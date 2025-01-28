package com.examen_almeida.asignacion_service.controller;

import com.examen_almeida.asignacion_service.model.PacienteDoctor;
import com.examen_almeida.asignacion_service.service.PacienteDoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignaciones")
public class PacienteDoctorController {

    private final PacienteDoctorService service;

    public PacienteDoctorController(PacienteDoctorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PacienteDoctor> asignarPacienteADoctor(
            @RequestParam Long pacienteId,
            @RequestParam Long doctorId,
            @RequestParam String fechaAsignacion) {
        PacienteDoctor asignacion = service.asignarPacienteADoctor(pacienteId, doctorId, fechaAsignacion);
        return ResponseEntity.ok(asignacion);
    }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<PacienteDoctor>> listarDoctoresPorPaciente(@PathVariable Long pacienteId) {
        return ResponseEntity.ok(service.listarDoctoresPorPaciente(pacienteId));
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<PacienteDoctor>> listarPacientesPorDoctor(@PathVariable Long doctorId) {
        return ResponseEntity.ok(service.listarPacientesPorDoctor(doctorId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRelacion(@PathVariable Long id) {
        service.eliminarRelacion(id);
        return ResponseEntity.noContent().build();
    }
}
