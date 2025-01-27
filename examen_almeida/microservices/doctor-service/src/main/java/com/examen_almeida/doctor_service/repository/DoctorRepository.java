package java.com.examen_almeida.doctor_service.repository;

import java.com.examen_almeida.doctor_service.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    // Puedes añadir consultas personalizadas aquí si lo necesitas
}
