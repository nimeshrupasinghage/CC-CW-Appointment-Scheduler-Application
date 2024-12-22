package cw.cloud.appointmentscheduler.repository;

import cw.cloud.appointmentscheduler.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentSchedulerRepository extends JpaRepository<Appointment, Long> {
}