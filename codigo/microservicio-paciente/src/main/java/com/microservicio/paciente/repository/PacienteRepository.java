package com.microservicio.paciente.repository;

import com.microservicio.paciente.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    // No es necesario añadir más métodos si solo deseas las operaciones CRUD básicas.
}
