package com.kessie.EventManagementSystem.Enums;

public enum EventType {
    CONFERENCE("Organization"),
    SEMINAR("Individual"),
    WORKSHOP("Admin"),
    CONCERT("Concert");

    private final String displayName;

    EventType(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }
}
