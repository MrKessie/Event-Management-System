package com.kessie.EventManagementSystem.Enums;

public enum TicketType {
    EARLY_BIRD("Early Bird"),
    STANDARD("Standard"),
    VIP("Vip");

    private final String displayName;

    TicketType(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }
}
