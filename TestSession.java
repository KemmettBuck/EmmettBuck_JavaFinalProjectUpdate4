/**
 * TestSession.java
 * Test class for Session and WildlifeSession classes.
 * Tests constructors, getters, setters, validation, and toString.
 * Test data based on real Acadia National Park photography sessions
 * taken July 4-10, 2025.
 *
 * Author: Kira Buck
 * Course: Java Programming - Ivy Tech Community College
 * Final Project: Nature Photography Session Log
 */
public class TestSession {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("   Testing Session & WildlifeSession");
        System.out.println("========================================\n");

        // -----------------------------------------------
        // Test 1: No-arg constructor
        // -----------------------------------------------
        System.out.println("--- Test 1: No-arg constructor ---");
        WildlifeSession s1 = new WildlifeSession();
        System.out.println("Date (expect 'Unknown'):     " + s1.getDate());
        System.out.println("Location (expect 'Unknown'): " + s1.getLocation());
        System.out.println("Species (expect 'Unknown'):  " + s1.getSpecies());
        System.out.println("Duration (expect 0.0):       " + s1.getDuration());
        System.out.println();

        // -----------------------------------------------
        // Test 2: Full constructor - Puffin session
        // -----------------------------------------------
        System.out.println("--- Test 2: Full constructor - Puffin session ---");
        WildlifeSession puffinSession = new WildlifeSession(
            "2025-07-05",
            "Acadia National Park, Maine",
            "Foggy, 62F",
            "Canon EOS 7D, 100-400mm lens",
            "Photographed puffins both in the water and in flight. " +
            "Fog prevented whale sightings on the cruise.",
            4.0,
            "Atlantic Puffin",
            8,
            true,
            "Puffin captured in full flight over the ocean"
        );
        System.out.println(puffinSession.toString());
        System.out.println();

        // -----------------------------------------------
        // Test 3: Getter methods
        // -----------------------------------------------
        System.out.println("--- Test 3: Getter methods ---");
        System.out.println("Date:              " + puffinSession.getDate());
        System.out.println("Location:          " + puffinSession.getLocation());
        System.out.println("Weather:           " + puffinSession.getWeather());
        System.out.println("Equipment:         " + puffinSession.getEquipmentUsed());
        System.out.println("Duration:          " + puffinSession.getDuration());
        System.out.println("Species:           " + puffinSession.getSpecies());
        System.out.println("Number of Species: " + puffinSession.getNumberOfSpecies());
        System.out.println("In Motion:         " + puffinSession.isSubjectInMotion());
        System.out.println("Shot Description:  " + puffinSession.getShotDescription());
        System.out.println("Notes:             " + puffinSession.getSessionNotes());
        System.out.println();

        // -----------------------------------------------
        // Test 4: Setter methods - update to goose session
        // -----------------------------------------------
        System.out.println("--- Test 4: Setter methods - update to goose session ---");
        puffinSession.setDate("2025-07-06");
        puffinSession.setLocation("Acadia National Park, Maine");
        puffinSession.setWeather("Partly cloudy, 67F");
        puffinSession.setSpecies("Canada Goose");
        puffinSession.setNumberOfSpecies(1);
        puffinSession.setSubjectInMotion(true);
        puffinSession.setShotDescription("Goose in action with wings fully spread");
        puffinSession.setSessionNotes("Caught a goose mid-flap, great action shot");
        System.out.println("Updated Date:     " + puffinSession.getDate());
        System.out.println("Updated Location: " + puffinSession.getLocation());
        System.out.println("Updated Species:  " + puffinSession.getSpecies());
        System.out.println("Updated Number:   " + puffinSession.getNumberOfSpecies());
        System.out.println("Updated Motion:   " + puffinSession.isSubjectInMotion());
        System.out.println("Updated Shot:     " + puffinSession.getShotDescription());
        System.out.println();

        // -----------------------------------------------
        // Test 5: Validation - negative duration
        // -----------------------------------------------
        System.out.println("--- Test 5: Validation - negative duration ---");
        puffinSession.setDuration(-5.0);
        System.out.println("Duration after setting -5.0 (expect 0.0): "
            + puffinSession.getDuration());
        System.out.println();

        // -----------------------------------------------
        // Test 6: Validation - negative numberOfSpecies
        // -----------------------------------------------
        System.out.println("--- Test 6: Validation - negative numberOfSpecies ---");
        puffinSession.setNumberOfSpecies(-3);
        System.out.println("Number after setting -3 (expect 0): "
            + puffinSession.getNumberOfSpecies());
        System.out.println();

        // -----------------------------------------------
        // Test 7: toString after updates
        // -----------------------------------------------
        System.out.println("--- Test 7: toString after updates ---");
        System.out.println(puffinSession.toString());
        System.out.println();

        System.out.println("========================================");
        System.out.println("   Session Tests Complete");
        System.out.println("========================================");
    }
}
