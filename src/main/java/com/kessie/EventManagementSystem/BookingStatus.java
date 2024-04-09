package com.kessie.EventManagementSystem;

public enum BookingStatus {
    PENDING("Pending"),
    CONFIRMED("Confirmed"),
    CANCELLED("Cancelled");

    private final String displayStatus;

    BookingStatus(String displayStatus){
        this.displayStatus = displayStatus;
    }

    public String getDisplayStatus() {
        return displayStatus;
    }
}
