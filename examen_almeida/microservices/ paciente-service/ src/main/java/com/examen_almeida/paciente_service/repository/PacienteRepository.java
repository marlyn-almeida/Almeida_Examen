package com.examen_almeida.paciente_service.repository;

import com.examen_almeida.paciente_service.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    // Puedes añadir consultas personalizadas aquí si lo necesitas
}
