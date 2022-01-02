package de.fherfurt.fetcher;

import java.time.LocalDateTime;

public class DevAppointmentService implements IAppointmentService {

    @Override
    public void createAppointment(String name, LocalDateTime date) {
        if (name != null && date != null) {
            System.out.println("Successfully created an appointment on the " + date.toString() + " with name: " + name);
        }
    }
}
