package de.fherfurt.fetcher;

import java.util.prefs.Preferences;

public class UserPreferences {
    private Preferences userPreferences;

    public void setNecessaryAuthor() {
        userPreferences = Preferences.userRoot().node(this.getClass().getName());
        userPreferences.put("necessaryAuthor", ""); // (Key, defaultValue)
    }

    public String getNecessaryAuthor() {
        userPreferences = Preferences.userRoot().node(this.getClass().getName());
        return userPreferences.get("necessaryAuthor","");
    }
/*
    private String necessaryAuthor;
    private String blacklistedAuthor;

    private String necessaryFaculty;
    private String blacklistedFaculty;

    public String getBlacklistedAuthor() {
        return blacklistedAuthor;
    }

    public String getNecessaryAuthor() {
        return necessaryAuthor;
    }

    public void setNecessaryAuthor(String necessaryAuthor) {
        this.necessaryAuthor = necessaryAuthor;
    }

    public void setBlacklistedAuthor(String blacklistedAuthor) {
        this.blacklistedAuthor = blacklistedAuthor;
    }

    public String getNecessaryFaculty() {
        return necessaryFaculty;
    }

    public void setNecessaryFaculty(String necessaryFaculty) {
        this.necessaryFaculty = necessaryFaculty;
    }

    public String getBlacklistedFaculty() {
        return blacklistedFaculty;
    }

    public void setBlacklistedFaculty(String blacklistedFaculty) {
        this.blacklistedFaculty = blacklistedFaculty;
    }

 */
}
