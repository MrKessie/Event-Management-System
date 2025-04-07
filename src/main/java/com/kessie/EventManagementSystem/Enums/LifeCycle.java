package com.kessie.EventManagementSystem.Enums;

public enum LifeCycle {
    DRAFT("Organization"),
    PUBLISHED("Individual"),
    ONGOING("Admin"),
    COMPLETED("Completed");

    private final String displayName;

    LifeCycle(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }
}
