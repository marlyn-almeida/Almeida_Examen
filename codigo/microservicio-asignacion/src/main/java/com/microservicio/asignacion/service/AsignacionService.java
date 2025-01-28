package com.microservicio.asignacion.service;

import com.microservicio.asignacion.model.Asignacion;
import com.microservicio.asignacion.repository.AsignacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignacionService {

    @Autowired
    private AsignacionRepository asignacionRepository;

    // Asignar un paciente a un doctor
    public Asignacion asignarPacienteADoctor(Long pacienteId, Long doctorId) {
        Asignacion asignacion = new Asignacion();
        asignacion.setPacienteId(pacienteId);
        asignacion.setDoctorId(doctorId);
        return asignacionRepository.save(asignacion);
    }

    // Cancelar la asignación (eliminar la relación)
    public void cancelarAsignacion(Long pacienteId, Long doctorId) {
        Asignacion asignacion = asignacionRepository.findAll().stream()
                .filter(a -> a.getPacienteId().equals(pacienteId) && a.getDoctorId().equals(doctorId))
                .findFirst()
                .orElse(null);

        if (asignacion != null) {
            asignacionRepository.delete(asignacion);
        }
    }

    // Listar pacientes asignados a un doctor
    public List<Asignacion> obtenerPacientesPorDoctor(Long doctorId) {
        return asignacionRepository.findAll().stream()
                .filter(a -> a.getDoctorId().equals(doctorId))
                .collect(Collectors.toList());
    }

    // Listar doctores asignados a un paciente
    public List<Asignacion> obtenerDoctoresPorPaciente(Long pacienteId) {
        return asignacionRepository.findAll().stream()
                .filter(a -> a.getPacienteId().equals(pacienteId))
                .collect(Collectors.toList());
    }
}
