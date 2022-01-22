package de.fherfurt.appointment.client;

import java.time.LocalDateTime;

public interface IAppointmentService {
    void createAppointment(String name, LocalDateTime date);
}
