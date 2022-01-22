package de.fherfurt.faculty.client;

import de.fherfurt.faculty.client.transfer.objects.IFaculty;

import java.util.HashMap;

public class DevFacultyService implements IFacultyService{
    HashMap<String, DevFaculty> faculties;

    public DevFacultyService() {
        faculties = new HashMap<String, DevFaculty>();

        faculties.put("Gebaeudetechnik_und_Informatik", new DevFaculty("Gebaeudetechnik_und_Informatik", "Altonaer Str. 25, 99085 Erfurt"));
        faculties.put("Architektur_und_Stadtplaung", new DevFaculty("Architektur_und_Stadtplaung", "Altonaer Str. 25, 99085 Erfurt"));
        faculties.put("Angewandte_Sozialwisschenschaft", new DevFaculty("Angewandte_Sozialwisschenschaft", "Altonaer Str. 25, 99085 Erfurt"));
        faculties.put("AllFaculties", new DevFaculty("AllFaculties", "Altonaer Str. 25, 99085 Erfurt"));
        faculties.put("Wirtschaft_Logistik_Verkehr", new DevFaculty("Wirtschaft_Logistik_Verkehr", "Altonaer Str. 25, 99085 Erfurt"));
    }

    @Override
    public IFaculty getFacultyByName(String name) {
        return faculties.get(name);
    }
}
