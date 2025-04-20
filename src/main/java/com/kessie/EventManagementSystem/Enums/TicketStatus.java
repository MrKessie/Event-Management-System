package com.kessie.EventManagementSystem.Enums;

public enum TicketStatus {
    AVAILABLE("Available"),
    RESERVED("Reserved"),
    SOLD("Sold"),
    USED("Used"),
    CANCELLED("Cancelled");

    private final String displayName;

    TicketStatus(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }
}
