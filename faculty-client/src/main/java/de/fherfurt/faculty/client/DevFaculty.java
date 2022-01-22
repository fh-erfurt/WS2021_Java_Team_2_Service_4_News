package de.fherfurt.faculty.client;

import de.fherfurt.faculty.client.transfer.objects.IFaculty;

public class DevFaculty implements IFaculty {
    String name;
    String address;

    public DevFaculty(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getName() {
        return name;
    }
}
