package com.microservicio.doctor.service;

import com.microservicio.doctor.model.Doctor;
import com.microservicio.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> obtenerTodos() {
        return doctorRepository.findAll();
    }

    public Doctor guardar(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor obtenerPorId(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        doctorRepository.deleteById(id);
    }
}
