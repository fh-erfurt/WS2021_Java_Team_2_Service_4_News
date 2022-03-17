package de.fherfurt.persons.client;

import de.fherfurt.persons.client.transfer.objects.IPerson;

import java.util.Optional;

public interface PersonsClient {
    /**
     *
     * This Methode "findPersonUsingIteratorByPersonID" will
     * find a Person from the ArrayList by
     * the PersonID with an Iterator.
     * @param PersonID - this Parameter is needed for the Searching.
     * @return Optional (Perosn) with all her/his values
     *
     */
    Optional<IPerson> findPersonUsingIteratorBy(int PersonID);

    /**
     * This methode "findPersonAvatarBy" will find a Person Avatar from a HashMap
     * through a PersonID - Key.
     * @param PersonID
     * @return byte Code which return an byte[] of a Person
     */
    byte[] findPersonAvatarBy(int PersonID);
}