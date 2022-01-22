package de.fherfurt.appointment.client;

import java.time.LocalDateTime;

public class DevAppointmentService implements IAppointmentService {

    @Override
    public void createAppointment(String name, LocalDateTime date) {
        if (name != null && date != null) {

        }
    }
}
