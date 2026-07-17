/**
 * Session.java
 * Abstract parent class for all photography session types.
 * Contains shared fields and behaviors common to any photography outing.
 *
 * Author: Kira Buck
 * Course: Java Programming - Ivy Tech Community College
 * Final Project: Nature Photography Session Log
 */
public abstract class Session {

    // Private data fields
    private String date;
    private String location;
    private String weather;
    private String equipmentUsed;
    private String sessionNotes;
    private double duration;

    /**
     * No-arg constructor with default values
     */
    public Session() {
        this.date          = "Unknown";
        this.location      = "Unknown";
        this.weather       = "Unknown";
        this.equipmentUsed = "Unknown";
        this.sessionNotes  = "";
        this.duration      = 0.0;
    }

    /**
     * Constructor with all fields specified
     * @param date          the date of the session
     * @param location      the location of the session
     * @param weather       the weather conditions during the session
     * @param equipmentUsed the camera and lens used
     * @param sessionNotes  personal notes from the session
     * @param duration      how long the session lasted in hours
     */
    public Session(String date, String location, String weather,
                   String equipmentUsed, String sessionNotes, double duration) {
        this.date          = date;
        this.location      = location;
        this.weather       = weather;
        this.equipmentUsed = equipmentUsed;
        this.sessionNotes  = sessionNotes;
        setDuration(duration); // utilize setter for validation
    }

    // -------------------------
    // Getter methods
    // -------------------------

    /** @return the date of the session */
    public String getDate() {
        return date;
    }

    /** @return the location of the session */
    public String getLocation() {
        return location;
    }

    /** @return the weather conditions */
    public String getWeather() {
        return weather;
    }

    /** @return the equipment used */
    public String getEquipmentUsed() {
        return equipmentUsed;
    }

    /** @return the session notes */
    public String getSessionNotes() {
        return sessionNotes;
    }

    /** @return the duration in hours */
    public double getDuration() {
        return duration;
    }

    // -------------------------
    // Setter methods
    // -------------------------

    /** @param date the date to set */
    public void setDate(String date) {
        this.date = date;
    }

    /** @param location the location to set */
    public void setLocation(String location) {
        this.location = location;
    }

    /** @param weather the weather conditions to set */
    public void setWeather(String weather) {
        this.weather = weather;
    }

    /** @param equipmentUsed the equipment to set */
    public void setEquipmentUsed(String equipmentUsed) {
        this.equipmentUsed = equipmentUsed;
    }

    /** @param sessionNotes the notes to set */
    public void setSessionNotes(String sessionNotes) {
        this.sessionNotes = sessionNotes;
    }

    /**
     * Sets the duration - validates that it is not negative
     * @param duration the duration in hours to set
     */
    public void setDuration(double duration) {
        if (duration < 0) {
            System.out.println("Warning: Duration cannot be negative. Setting to 0.");
            this.duration = 0.0;
        } else {
            this.duration = duration;
        }
    }

    /**
     * Abstract toString method - must be implemented by all subclasses
     * @return a String description of the session
     */
    @Override
    public abstract String toString();
}
