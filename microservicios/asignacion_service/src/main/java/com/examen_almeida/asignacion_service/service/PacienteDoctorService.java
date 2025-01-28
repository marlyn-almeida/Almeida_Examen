package com.examen_almeida.asignacion_service.service;

import com.examen_almeida.asignacion_service.model.PacienteDoctor;
import com.examen_almeida.asignacion_service.repository.PacienteDoctorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteDoctorService {

    private final PacienteDoctorRepository repository;

    public PacienteDoctorService(PacienteDoctorRepository repository) {
        this.repository = repository;
    }

    // Asignar un paciente a un doctor
    public PacienteDoctor asignarPacienteADoctor(Long pacienteId, Long doctorId, String fechaAsignacion) {
        PacienteDoctor asignacion = new PacienteDoctor();
        asignacion.setPacienteId(pacienteId);
        asignacion.setDoctorId(doctorId);
        asignacion.setFechaAsignacion(LocalDate.parse(fechaAsignacion));
        return repository.save(asignacion);
    }

    // Listar doctores asignados a un paciente
    public List<PacienteDoctor> listarDoctoresPorPaciente(Long pacienteId) {
        return repository.findByPacienteId(pacienteId);
    }

    // Listar pacientes asignados a un doctor
    public List<PacienteDoctor> listarPacientesPorDoctor(Long doctorId) {
        return repository.findByDoctorId(doctorId);
    }

    // Eliminar una relación por ID
    public void eliminarRelacion(Long id) {
        Optional<PacienteDoctor> relacion = repository.findById(id);
        if (relacion.isPresent()) {
            repository.delete(relacion.get());
        }
    }
}
