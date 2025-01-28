package com.examen_almeida.asignacion_service.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "paciente_doctor")
@Data
@NoArgsConstructor
public class PacienteDoctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long pacienteId; // ID del paciente

    @Column(nullable = false)
    private Long doctorId; // ID del doctor

    @Column(nullable = false)
    private LocalDate fechaAsignacion; // Fecha de asignación
}
