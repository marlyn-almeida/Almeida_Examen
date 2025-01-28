package com.microservicio.asignacion.controller;

import com.microservicio.asignacion.model.Asignacion;
import com.microservicio.asignacion.service.AsignacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaciones")
public class AsignacionController {

    @Autowired
    private AsignacionService asignacionService;

    // Asignar un paciente a un doctor
    @PostMapping("/asignar")
    public ResponseEntity<Asignacion> asignarPacienteADoctor(@RequestParam Long pacienteId, @RequestParam Long doctorId) {
        Asignacion asignacion = asignacionService.asignarPacienteADoctor(pacienteId, doctorId);
        return ResponseEntity.ok(asignacion);
    }

    // Listar pacientes bajo la atención de un doctor
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Asignacion>> obtenerPacientesPorDoctor(@PathVariable Long doctorId) {
        List<Asignacion> asignaciones = asignacionService.obtenerPacientesPorDoctor(doctorId);
        return ResponseEntity.ok(asignaciones);
    }

    // Listar doctores asignados a un paciente
    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<Asignacion>> obtenerDoctoresPorPaciente(@PathVariable Long pacienteId) {
        List<Asignacion> asignaciones = asignacionService.obtenerDoctoresPorPaciente(pacienteId);
        return ResponseEntity.ok(asignaciones);
    }

    // Cancelar la relación entre un paciente y un doctor
    @DeleteMapping("/cancelar")
    public ResponseEntity<Void> cancelarAsignacion(@RequestParam Long pacienteId, @RequestParam Long doctorId) {
        asignacionService.cancelarAsignacion(pacienteId, doctorId);
        return ResponseEntity.noContent().build();
    }
}
