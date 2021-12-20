package de.fherfurt.fetcher;

public class DevPerson implements IPerson {
    private String firstName;
    private String lastName;
    private String faculty;
    private String email;
    private String title;

    public DevPerson(String firstName, String lastName, String faculty, String email, String title) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.faculty = faculty;
        this.email = email;
        this.title = title;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() { return lastName; }

    @Override
    public String getFaculty() {
        return faculty;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getTitle() { return title; }

    @Override
    public String getName() {
        return firstName + " " + lastName;
    }
}
