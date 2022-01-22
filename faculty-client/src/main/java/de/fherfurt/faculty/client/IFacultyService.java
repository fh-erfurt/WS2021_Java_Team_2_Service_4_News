package de.fherfurt.faculty.client;

import de.fherfurt.faculty.client.transfer.objects.IFaculty;

public interface IFacultyService {
    IFaculty getFacultyByName(String name);
}
