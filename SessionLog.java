/**
 * SessionLog.java
 * Manager class that stores and manages all photography sessions.
 * Uses an ArrayList to hold Session objects and provides methods
 * to add, retrieve, search, and summarize sessions.
 *
 * Author: Kira Buck
 * Course: Java Programming - Ivy Tech Community College
 * Final Project: Nature Photography Session Log
 */
import java.util.ArrayList;

public class SessionLog {

    // Private ArrayList to hold all sessions
    private ArrayList<Session> sessions;

    /**
     * No-arg constructor - creates an empty session log
     */
    public SessionLog() {
        sessions = new ArrayList<>();
    }

    // -------------------------
    // Core methods
    // -------------------------

    /**
     * Adds a new session to the log
     * @param session the session to add
     */
    public void addSession(Session session) {
        if (session == null) {
            System.out.println("Warning: Cannot add a null session.");
            return;
        }
        sessions.add(session);
    }

    /**
     * Returns the full list of all sessions
     * @return ArrayList of all sessions
     */
    public ArrayList<Session> getSessions() {
        return sessions;
    }

    /**
     * Returns the total number of sessions logged
     * @return total number of sessions
     */
    public int getTotalSessions() {
        return sessions.size();
    }

    /**
     * Returns the total hours spent across all sessions
     * @return total hours as a double
     */
    public double getTotalHours() {
        double total = 0;
        for (Session s : sessions) {
            total += s.getDuration();
        }
        return total;
    }

    // -------------------------
    // Search methods
    // -------------------------

    /**
     * Searches sessions by location keyword (case-insensitive)
     * @param keyword the location keyword to search for
     * @return ArrayList of matching sessions
     */
    public ArrayList<Session> searchByLocation(String keyword) {
        ArrayList<Session> results = new ArrayList<>();
        for (Session s : sessions) {
            if (s.getLocation().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(s);
            }
        }
        return results;
    }

    /**
     * Searches wildlife sessions by species keyword (case-insensitive)
     * @param keyword the species keyword to search for
     * @return ArrayList of matching WildlifeSession objects
     */
    public ArrayList<Session> searchBySubject(String keyword) {
        ArrayList<Session> results = new ArrayList<>();
        for (Session s : sessions) {
            // Only WildlifeSession objects have species data
            if (s instanceof WildlifeSession) {
                WildlifeSession ws = (WildlifeSession) s;
                if (ws.getSpecies().toLowerCase().contains(keyword.toLowerCase())) {
                    results.add(ws);
                }
            }
        }
        return results;
    }

    // -------------------------
    // Statistics methods
    // -------------------------

    /**
     * Finds the most frequently visited location across all sessions
     * @return the location name that appears most often
     */
    public String getMostFrequentLocation() {
        if (sessions.isEmpty()) {
            return "No sessions logged yet.";
        }

        String mostFrequent = "";
        int highestCount = 0;

        // Compare each location against all others and count matches
        for (Session s : sessions) {
            int count = 0;
            for (Session other : sessions) {
                if (s.getLocation().equalsIgnoreCase(other.getLocation())) {
                    count++;
                }
            }
            if (count > highestCount) {
                highestCount = count;
                mostFrequent = s.getLocation();
            }
        }
        return mostFrequent;
    }

    /**
     * Finds the most frequently photographed species across wildlife sessions
     * @return the species name that appears most often
     */
    public String getMostFrequentSubject() {
        if (sessions.isEmpty()) {
            return "No sessions logged yet.";
        }

        String mostFrequent = "";
        int highestCount = 0;

        for (Session s : sessions) {
            if (s instanceof WildlifeSession) {
                WildlifeSession ws = (WildlifeSession) s;
                int count = 0;
                for (Session other : sessions) {
                    if (other instanceof WildlifeSession) {
                        WildlifeSession otherWs = (WildlifeSession) other;
                        if (ws.getSpecies().equalsIgnoreCase(otherWs.getSpecies())) {
                            count++;
                        }
                    }
                }
                if (count > highestCount) {
                    highestCount = count;
                    mostFrequent = ws.getSpecies();
                }
            }
        }
        return mostFrequent.isEmpty() ? "No wildlife sessions logged." : mostFrequent;
    }

    /**
     * Returns a formatted summary of all session statistics
     * @return a String summary of the session log
     */
    @Override
    public String toString() {
        return "=== Session Log Summary ===" +
               "\nTotal Sessions:           " + getTotalSessions() +
               "\nTotal Hours in the Field: " + getTotalHours() +
               "\nMost Visited Location:    " + getMostFrequentLocation() +
               "\nMost Photographed Subject:" + getMostFrequentSubject();
    }

    public class void main(String[] args) {
        launch(args);
    }
}
