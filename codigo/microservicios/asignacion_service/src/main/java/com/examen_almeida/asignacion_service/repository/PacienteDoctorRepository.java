package com.examen_almeida.asignacion_service.repository;

import com.examen_almeida.asignacion_service.model.PacienteDoctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteDoctorRepository extends JpaRepository<PacienteDoctor, Long> {

    // Buscar por ID de paciente
    List<PacienteDoctor> findByPacienteId(Long pacienteId);

    // Buscar por ID de doctor
    List<PacienteDoctor> findByDoctorId(Long doctorId);
}
