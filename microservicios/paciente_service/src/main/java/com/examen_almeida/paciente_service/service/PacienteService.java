package com.examen_almeida.paciente_service.service;

import com.examen_almeida.paciente_service.model.Paciente;
import com.examen_almeida.paciente_service.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    public Paciente obtenerPorId(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
    }

    public Paciente guardarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente actualizarPaciente(Long id, Paciente paciente) {
        Paciente existente = obtenerPorId(id);
        existente.setNombre(paciente.getNombre());
        existente.setApellido(paciente.getApellido());
        existente.setEmail(paciente.getEmail());
        existente.setEdad(paciente.getEdad());
        return pacienteRepository.save(existente);
    }

    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}
