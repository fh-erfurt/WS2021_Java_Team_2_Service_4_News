package de.fherfurt.fetcher;

public interface IPersonService {
    IPerson getPersonFromId(int id);
    String getLastNameFromId(int id);
}
