/**
 * TestSessionLog.java
 * Test class for the SessionLog manager class.
 * Tests adding sessions, searching, statistics, and edge cases.
 * Test data based on real Acadia National Park photography sessions
 * taken July 4-10, 2025 using Canon EOS 7D with 100-400mm lens
 * and Samsung S25 Ultra for macro shots.
 *
 * Author: Kira Buck
 * Course: Java Programming - Ivy Tech Community College
 * Final Project: Nature Photography Session Log
 */
public class TestSessionLog {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("         Testing SessionLog");
        System.out.println("========================================\n");

        // Create a SessionLog
        SessionLog log = new SessionLog();

        // -----------------------------------------------
        // Test 1: Empty log
        // -----------------------------------------------
        System.out.println("--- Test 1: Empty log ---");
        System.out.println("Total sessions (expect 0): " + log.getTotalSessions());
        System.out.println("Total hours (expect 0.0):  " + log.getTotalHours());
        System.out.println("Most frequent location:    " + log.getMostFrequentLocation());
        System.out.println("Most frequent subject:     " + log.getMostFrequentSubject());
        System.out.println();

        // -----------------------------------------------
        // Create real Acadia session data
        // -----------------------------------------------

        // Session 1: Puffins in water and in flight
        WildlifeSession puffinSession = new WildlifeSession(
            "2025-07-05",
            "Acadia National Park, Maine",
            "Foggy, 62F",
            "Canon EOS 7D, 100-400mm lens",
            "Photographed puffins both in the water and in flight. " +
            "No whales visible due to heavy fog on the cruise.",
            4.0,
            "Atlantic Puffin",
            8,
            true,
            "Puffin captured in full flight over the ocean"
        );

        // Session 2: Canada Goose wing action
        WildlifeSession gooseSession = new WildlifeSession(
            "2025-07-06",
            "Acadia National Park, Maine",
            "Partly cloudy, 67F",
            "Canon EOS 7D, 100-400mm lens",
            "Caught a goose mid-flap near the shoreline",
            2.0,
            "Canada Goose",
            1,
            true,
            "Goose in action with wings fully spread"
        );

        // Session 3: Chipmunk on a rock
        WildlifeSession chipmunkSession = new WildlifeSession(
            "2025-07-06",
            "Acadia National Park, Maine",
            "Partly cloudy, 67F",
            "Canon EOS 7D, 100-400mm lens",
            "Chipmunk was very cooperative and stayed still on the rock",
            1.0,
            "Eastern Chipmunk",
            1,
            false,
            "Chipmunk sitting still on a mossy rock"
        );

        // Session 4: Seagull bathing and in flight
        WildlifeSession seagullSession = new WildlifeSession(
            "2025-07-07",
            "Bar Harbor, Maine",
            "Sunny, 71F",
            "Canon EOS 7D, 100-400mm lens",
            "Got great shots of seagulls bathing and in flight. " +
            "Also photographed unknown birds both in flight and stationary.",
            3.0,
            "Herring Seagull",
            6,
            true,
            "Seagull in action mid-bath with water splashing"
        );

        // Session 5: Sunfish fin
        WildlifeSession sunfishSession = new WildlifeSession(
            "2025-07-05",
            "Atlantic Ocean, off Boothbay Harbor, Maine",
            "Foggy, 60F",
            "Canon EOS 7D, 100-400mm lens",
            "Spotted a sunfish fin just above the water surface " +
            "during the whale watch cruise",
            0.5,
            "Ocean Sunfish",
            1,
            false,
            "Sunfish dorsal fin breaking the surface"
        );

        // Session 6: Macro mushrooms - Samsung S25 Ultra
        WildlifeSession mushroomSession = new WildlifeSession(
            "2025-07-08",
            "Acadia National Park, Maine",
            "Overcast, 65F",
            "Samsung S25 Ultra (macro mode)",
            "Found two different mushroom species on the forest floor. " +
            "Used macro mode on the S25 Ultra for close-up detail shots.",
            1.5,
            "Wild Mushroom",
            2,
            false,
            "Close-up macro of mushroom cap showing fine gill detail"
        );

        // Session 7: Macro flowers - Samsung S25 Ultra
        WildlifeSession flowerSession = new WildlifeSession(
            "2025-07-08",
            "Acadia National Park, Maine",
            "Overcast, 65F",
            "Samsung S25 Ultra (macro mode)",
            "Photographed two different wildflower species using macro mode. " +
            "Also got a detailed macro shot of a weathered log.",
            1.0,
            "Wild Flower",
            2,
            false,
            "Macro shot of flower petals showing fine texture detail"
        );

        // -----------------------------------------------
        // Test 2: Adding sessions
        // -----------------------------------------------
        System.out.println("--- Test 2: Adding sessions ---");
        log.addSession(puffinSession);
        log.addSession(gooseSession);
        log.addSession(chipmunkSession);
        log.addSession(seagullSession);
        log.addSession(sunfishSession);
        log.addSession(mushroomSession);
        log.addSession(flowerSession);
        System.out.println("Total sessions (expect 7): " + log.getTotalSessions());
        System.out.println();

        // -----------------------------------------------
        // Test 3: Total hours
        // -----------------------------------------------
        System.out.println("--- Test 3: Total hours ---");
        System.out.println("Total hours (expect 13.0): " + log.getTotalHours());
        System.out.println();

        // -----------------------------------------------
        // Test 4: Search by location - Acadia
        // -----------------------------------------------
        System.out.println("--- Test 4: Search by location 'Acadia' ---");
        System.out.println("Results (expect 6):");
        for (Session s : log.searchByLocation("Acadia")) {
            System.out.println("  - " + s.getDate() + " | " + s.getLocation());
        }
        System.out.println();

        // -----------------------------------------------
        // Test 5: Search by location - Bar Harbor
        // -----------------------------------------------
        System.out.println("--- Test 5: Search by location 'Bar Harbor' ---");
        System.out.println("Results (expect 1):");
        for (Session s : log.searchByLocation("Bar Harbor")) {
            System.out.println("  - " + s.getDate() + " | " + s.getLocation());
        }
        System.out.println();

        // -----------------------------------------------
        // Test 6: Search by subject - Puffin
        // -----------------------------------------------
        System.out.println("--- Test 6: Search by subject 'Puffin' ---");
        System.out.println("Results (expect 1):");
        for (Session s : log.searchBySubject("Puffin")) {
            WildlifeSession ws = (WildlifeSession) s;
            System.out.println("  - " + ws.getDate() + " | " + ws.getSpecies());
        }
        System.out.println();

        // -----------------------------------------------
        // Test 7: Search by subject - Samsung macro shots
        // -----------------------------------------------
        System.out.println("--- Test 7: Search by subject 'Wild' ---");
        System.out.println("Results (expect 2 - mushroom and flower):");
        for (Session s : log.searchBySubject("Wild")) {
            WildlifeSession ws = (WildlifeSession) s;
            System.out.println("  - " + ws.getDate() + " | " + ws.getSpecies()
                + " | " + ws.getEquipmentUsed());
        }
        System.out.println();

        // -----------------------------------------------
        // Test 8: Search with no results
        // -----------------------------------------------
        System.out.println("--- Test 8: Search with no results ---");
        System.out.println("Search 'Yellowstone' (expect 0): "
            + log.searchByLocation("Yellowstone").size());
        System.out.println();

        // -----------------------------------------------
        // Test 9: Most frequent location
        // -----------------------------------------------
        System.out.println("--- Test 9: Most frequent location ---");
        System.out.println("Most frequent (expect 'Acadia National Park, Maine'): "
            + log.getMostFrequentLocation());
        System.out.println();

        // -----------------------------------------------
        // Test 10: Most frequent subject
        // -----------------------------------------------
        System.out.println("--- Test 10: Most frequent subject ---");
        System.out.println("Most frequent subject: "
            + log.getMostFrequentSubject());
        System.out.println();

        // -----------------------------------------------
        // Test 11: Adding null session (validation)
        // -----------------------------------------------
        System.out.println("--- Test 11: Adding null session ---");
        log.addSession(null);
        System.out.println("Total sessions after null add (expect 7): "
            + log.getTotalSessions());
        System.out.println();

        // -----------------------------------------------
        // Test 12: toString summary
        // -----------------------------------------------
        System.out.println("--- Test 12: SessionLog toString ---");
        System.out.println(log.toString());
        System.out.println();

        // -----------------------------------------------
        // Test 13: Display all sessions
        // -----------------------------------------------
        System.out.println("--- Test 13: Display all sessions ---");
        for (Session s : log.getSessions()) {
            System.out.println(s.toString());
            System.out.println();
        }

        System.out.println("========================================");
        System.out.println("      SessionLog Tests Complete");
        System.out.println("========================================");
    }
}
