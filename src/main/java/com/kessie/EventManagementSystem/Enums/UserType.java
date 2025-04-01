package com.kessie.EventManagementSystem.Enums;

public enum UserType {
    ORGANIZATION("Organization"),
    INDIVIDUAL("Individual"),
    ADMIN("Admin");

    private final String displayName;

    UserType(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }
}
