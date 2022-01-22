package de.fherfurt.persons.client;

import de.fherfurt.persons.client.transfer.objects.IPerson;

public interface IPersonService {
    IPerson getPersonFromId(int id);
    String getLastNameFromId(int id);
}
