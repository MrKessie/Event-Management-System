package com.kessie.EventManagementSystem.Enums;

public enum Role {
    ROLE_ORGANIZER("Organizer"),
    ROLE_ATTENDEE("Attendee"),
    ROLE_ADMIN("Admin");

    private final String displayName;

    Role(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }
}
