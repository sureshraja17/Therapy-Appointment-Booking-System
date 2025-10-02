package com.yourname.therapy.service;

import com.yourname.therapy.model.Appointment;
import com.yourname.therapy.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public String bookAppointment(Appointment appointment) {
        List<Appointment> conflict = appointmentRepository
            .findByTherapistIdAndAppointmentDateAndStartTimeLessThanAndEndTimeGreaterThan(
                appointment.getTherapistId(),
                appointment.getAppointmentDate(),
                appointment.getEndTime(),
                appointment.getStartTime()
            );
        if(!conflict.isEmpty()) return "Time slot already booked.";
        appointmentRepository.save(appointment);
        return "Appointment booked successfully.";
    }
}