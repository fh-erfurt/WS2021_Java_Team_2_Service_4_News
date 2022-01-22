package de.fherfurt.persons.client;

import de.fherfurt.persons.client.transfer.objects.IPerson;

import java.util.HashMap;

public class DevPersonService implements IPersonService {
    HashMap<Integer, DevPerson> personMap;

    public DevPersonService() {
        personMap = new HashMap<Integer, DevPerson>();
        personMap.put(1, new DevPerson("Heidi", "Sinning", "Informationstechnologie", "heidi.sinning@fh-erfurt.de", "Prof. Dr.-Ing. "));
        personMap.put(2, new DevPerson("Uwe", "Adler", "Informationstechnologie", "uwe.adler@fh-erfurt.de", "Dr.-Ing. "));
        personMap.put(3, new DevPerson("Jens", "Mischner", "Architektur und Stadtplanung", "jens.mischner@fh-erfurt.de", "Prof. Dr.-Ing."));
        personMap.put(4, new DevPerson("Max", "Mustermann", "Informationstechnologie", "max.mustermann@fh-erfurt.de", "Student"));
        personMap.put(5, new DevPerson("Maxi", "Musterfrau", "Angewandte Sozialwissenschaften", "maxi.musterfrau@fh-erfurt.de", "Student"));
    }

    @Override
    public IPerson getPersonFromId(int id) {
        return personMap.get(id);
    }

    @Override
    public String getLastNameFromId(int id) {
        return personMap.get(id).getLastName();
    }


}
