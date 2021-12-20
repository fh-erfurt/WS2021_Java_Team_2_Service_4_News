package de.fherfurt.fetcher;

import java.util.HashMap;

public class DevFacultyService implements IFacultyService{
    HashMap<String, DevFaculty> faculties;

    DevFacultyService() {
        faculties = new HashMap<String, DevFaculty>();

        faculties.put("Informationstechnologie", new DevFaculty("Informationstechnologie", "Altonaer Str. 25, 99085 Erfurt"));
        faculties.put("Architektur und Stadtplanung", new DevFaculty("Architektur und Stadtplanung", "Altonaer Str. 25, 99085 Erfurt"));
        faculties.put("Angewandte Sozialwissenschaften", new DevFaculty("Angewandte Sozialwissenschaften", "Altonaer Str. 25, 99085 Erfurt"));
        faculties.put("AllFaculties", new DevFaculty("AllFaculties", "Altonaer Str. 25, 99085 Erfurt"));
    }

    @Override
    public IFaculty getFacultyByName(String name) {
        return faculties.get(name);
    }
}
