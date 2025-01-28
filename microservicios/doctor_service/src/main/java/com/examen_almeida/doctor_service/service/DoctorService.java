package com.examen_almeida.doctor_service.service;

import com.examen_almeida.doctor_service.model.Doctor;
import com.examen_almeida.doctor_service.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> listarTodos() {
        return doctorRepository.findAll();
    }

    public Doctor obtenerPorId(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor no encontrado"));
    }

    public Doctor guardarDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor actualizarDoctor(Long id, Doctor doctor) {
        Doctor existente = obtenerPorId(id);
        existente.setNombre(doctor.getNombre());
        existente.setApellido(doctor.getApellido());
        existente.setEspecialidad(doctor.getEspecialidad());
        return doctorRepository.save(existente);
    }

    public void eliminarDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
