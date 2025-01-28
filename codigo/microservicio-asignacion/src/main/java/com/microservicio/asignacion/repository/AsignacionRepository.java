package com.microservicio.asignacion.repository;

import com.microservicio.asignacion.model.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignacionRepository extends JpaRepository<Asignacion, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
