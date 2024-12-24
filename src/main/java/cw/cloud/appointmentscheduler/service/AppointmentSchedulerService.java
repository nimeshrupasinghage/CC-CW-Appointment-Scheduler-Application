package cw.cloud.appointmentscheduler.service;

import cw.cloud.appointmentscheduler.entity.Appointment;
import cw.cloud.appointmentscheduler.repository.AppointmentSchedulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentSchedulerService {
    @Autowired
    private AppointmentSchedulerRepository appointmentRepository;

    public Appointment scheduleAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    public void cancelAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    public Appointment updateAppointment(Long id, Appointment appointment) {
        Appointment existingAppointment = getAppointmentById(id);
        existingAppointment.setDate(appointment.getDate());
        existingAppointment.setTime(appointment.getTime());
        return appointmentRepository.save(existingAppointment);
    }

}
