package com.movieplatform.Entity;

public class Admin extends User{
    {
        private String permissionLevel; // e.g., "SUPER" or "STANDARD"

    public Admin(String userId, String name, String email, String password, String permissionLevel) {
        // super() calls the constructor of the User base class
        super(userId, name, email, password, "ADMIN");
        this.permissionLevel = permissionLevel;
    }

        // This is required because getUserType() is abstract in User.java
        @Override
        public String getUserType() {
        return "ADMIN";
    }

        @Override
        public int getRentalDurationDays() {
        return 0; // Admins don't usually rent movies
    }

        // Getters and Setters (Encapsulation)
        public String getPermissionLevel() { return permissionLevel; }
        public void setPermissionLevel(String pl) { this.permissionLevel = pl; }
    }

}
