# Nature Photography Session Log

A JavaFX desktop application for organizing, tracking, and reviewing
nature photography sessions. Built as a final project for Java
Programming at Ivy Tech Community College.

**Author:** Kira Emmett Buck

---

## Overview

Nature photographers often rely on scattered notes or memory to recall
where they shot, what equipment they used, and what subjects they
captured. This application keeps everything in one place, letting a
photographer log field sessions, search past outings, and view summary
statistics about their photography activity.

Session data in this version is stored in memory using Java
collections while the program runs.

---

## Features

- **Add Session** - Form-based entry for logging a photography outing,
  including date, location, weather, equipment, duration, species
  photographed, number sighted, whether the subject was in motion,
  best shot description, and personal notes
- **View All Sessions** - Sortable table displaying every logged session
- **Search** - Filter sessions by location keyword
- **Statistics** - Summary view showing total sessions, total hours in
  the field, most visited location, and most photographed subject
- **Input Validation** - Numeric checks on duration and number sighted,
  and required-field validation on location

---

## Built With

- Java 17
- JavaFX 17 (GUI framework)
- Java Collections (ArrayList for session storage)

---

## Class Structure

| Class | Role |
|-------|------|
| `Session` | Abstract parent class containing fields shared by all session types |
| `WildlifeSession` | Child class extending Session with wildlife-specific fields |
| `SessionLog` | Data manager storing sessions in an ArrayList with search and statistics methods |
| `PhotoSessionApp` | JavaFX application class containing the GUI and event handlers |
| `TestSession` | Test class for Session and WildlifeSession |
| `TestSessionLog` | Test class for SessionLog |

**Relationships:**
- `WildlifeSession` **extends** `Session` (inheritance / IS-A)
- `SessionLog` **contains** an ArrayList of `Session` objects (composition / HAS-A)
- `PhotoSessionApp` **uses** `SessionLog` to manage all data

---

## How to Compile and Run

JavaFX must be installed. Download the JavaFX SDK matching your Java
version from https://gluonhq.com/products/javafx/

From the project folder, compile:
