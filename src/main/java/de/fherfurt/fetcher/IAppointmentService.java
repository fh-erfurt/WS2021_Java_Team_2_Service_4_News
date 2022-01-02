package de.fherfurt.fetcher;

import java.time.LocalDateTime;

public interface IAppointmentService {
    void createAppointment(String name, LocalDateTime date);
}
