package cw.cloud.appointmentscheduler.controller;

import cw.cloud.appointmentscheduler.entity.Appointment;
import cw.cloud.appointmentscheduler.service.AppointmentSchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentScheduleController {

    @Autowired
    private AppointmentSchedulerService appointmentService;

    @PostMapping
    public ResponseEntity<Appointment> scheduleAppointment(@RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentService.scheduleAppointment(appointment));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAppointmentById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelAppointment(@PathVariable Long id) {
        appointmentService.cancelAppointment(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> rescheduleAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentService.updateAppointment(id, appointment));
    }

    @GetMapping("/welcome")
    public String getWelcomeMessage() {
        return "Appointment Scheduler";
    }
}