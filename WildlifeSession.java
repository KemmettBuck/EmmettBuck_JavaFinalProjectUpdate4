/**
 * WildlifeSession.java
 * Child class extending Session.
 * Adds fields specific to wildlife photography outings including
 * species observed, number of species, motion status, and shot description.
 *
 * Author: Kira Buck
 * Course: Java Programming - Ivy Tech Community College
 * Final Project: Nature Photography Session Log
 */
public class WildlifeSession extends Session {

    // Private data fields specific to wildlife sessions
    private String species;
    private int numberOfSpecies;
    private boolean subjectInMotion;
    private String shotDescription;

    /**
     * No-arg constructor with default values
     */
    public WildlifeSession() {
        super(); // calls Session no-arg constructor
        this.species         = "Unknown";
        this.numberOfSpecies = 0;
        this.subjectInMotion = false;
        this.shotDescription = "None";
    }

    /**
     * Full constructor with all fields
     * @param date            the date of the session
     * @param location        the location of the session
     * @param weather         the weather conditions
     * @param equipmentUsed   the camera and lens used
     * @param sessionNotes    personal notes from the session
     * @param duration        how long the session lasted in hours
     * @param species         the species photographed
     * @param numberOfSpecies the number of individual animals sighted
     * @param subjectInMotion whether the subject was in motion
     * @param shotDescription description of the best shot taken
     */
    public WildlifeSession(String date, String location, String weather,
                           String equipmentUsed, String sessionNotes,
                           double duration, String species,
                           int numberOfSpecies, boolean subjectInMotion,
                           String shotDescription) {
        super(date, location, weather, equipmentUsed, sessionNotes, duration);
        this.species         = species;
        this.numberOfSpecies = numberOfSpecies;
        this.subjectInMotion = subjectInMotion;
        this.shotDescription = shotDescription;
    }

    // -------------------------
    // Getter methods
    // -------------------------

    /** @return the species photographed */
    public String getSpecies() {
        return species;
    }

    /** @return the number of individual animals sighted */
    public int getNumberOfSpecies() {
        return numberOfSpecies;
    }

    /** @return whether the subject was in motion */
    public boolean isSubjectInMotion() {
        return subjectInMotion;
    }

    /** @return the description of the best shot */
    public String getShotDescription() {
        return shotDescription;
    }

    // -------------------------
    // Setter methods
    // -------------------------

    /** @param species the species to set */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * Sets number of species - validates not negative
     * @param numberOfSpecies the number of animals sighted
     */
    public void setNumberOfSpecies(int numberOfSpecies) {
        if (numberOfSpecies < 0) {
            System.out.println("Warning: Number of species cannot be negative. Setting to 0.");
            this.numberOfSpecies = 0;
        } else {
            this.numberOfSpecies = numberOfSpecies;
        }
    }

    /** @param subjectInMotion whether the subject was in motion */
    public void setSubjectInMotion(boolean subjectInMotion) {
        this.subjectInMotion = subjectInMotion;
    }

    /** @param shotDescription description of the best shot */
    public void setShotDescription(String shotDescription) {
        this.shotDescription = shotDescription;
    }

    /**
     * Returns a formatted string description of the wildlife session
     * Overrides the abstract toString() from Session
     * @return a full description of the session
     */
    @Override
    public String toString() {
        return "=== Wildlife Session ===" +
               "\nDate:              " + getDate() +
               "\nLocation:          " + getLocation() +
               "\nWeather:           " + getWeather() +
               "\nEquipment Used:    " + getEquipmentUsed() +
               "\nDuration (hours):  " + getDuration() +
               "\nSpecies:           " + species +
               "\nNumber Sighted:    " + numberOfSpecies +
               "\nSubject In Motion: " + subjectInMotion +
               "\nBest Shot:         " + shotDescription +
               "\nNotes:             " + getSessionNotes();
    }
}
