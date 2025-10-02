package com.yourname.therapy.repository;

import com.yourname.therapy.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByTherapistIdAndAppointmentDateAndStartTimeLessThanAndEndTimeGreaterThan(
        Long therapistId, LocalDate date, LocalTime endTime, LocalTime startTime);
}