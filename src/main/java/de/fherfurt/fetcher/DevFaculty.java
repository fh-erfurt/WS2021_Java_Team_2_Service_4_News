package de.fherfurt.fetcher;

public class DevFaculty implements IFaculty{
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
