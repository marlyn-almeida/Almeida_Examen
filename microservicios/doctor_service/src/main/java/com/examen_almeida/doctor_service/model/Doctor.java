package com.examen_almeida.doctor_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "doctores")
@Data  // Lombok genera los getters, setters, toString, equals, hashCode
@NoArgsConstructor  // Lombok genera el constructor sin parámetros
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    @Column(nullable = false)
    private String apellido;

    @NotBlank(message = "La especialidad no puede estar vacía")
    @Size(min = 2, max = 50, message = "La especialidad debe tener entre 2 y 50 caracteres")
    @Column(nullable = false)
    private String especialidad;


}
