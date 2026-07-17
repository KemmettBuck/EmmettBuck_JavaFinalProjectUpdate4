/**
 * PhotoSessionApp.java
 * JavaFX GUI for Nature Photography Session Log
 * Provide GUI to add sessions, view sessions,
 * search by location/species, and view statistics
 * 
 * Author: Kira Emmett Buck
 * Course: Java - Ivy Tech Community College
 * Final Project: Nature Photography Session Log
 */
import javax.swing.text.TableView;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PhotoSessionApp extends Application {

    // Data manager - holds all sessions
    private SessionLog log = new SessionLog();

    // Table displays sessions on main screen
    private TableView<WildlifeSession> tableView = new TableView<>();

    // Status Label
    private Label lblStatus = new Label("Nature Photography Session Log");

    // Text area for stats output
    private TextArea taOutput = new TextArea();

    // ------ Session Form Fields ------
    private TextField tfDate        = new TextField();
    private TextField tfLocation    = new TextField();
    private TextField tfWeather     = new TextField();
    private TextField tfEquipment   = new TextField();
    private TextField tfDuration    = new TextField();
    private TextField tfSpecies     = new TextField();
    private TextField tfNumber      = new TextField();
    private CheckBox  cbInMotion    = new CheckBox("Subject was in Motion");
    private TextField tfShotDesc    = new TextField();
    private TextArea  taNotes       = new TextArea();

    // ------ Search field ------
    private TextField tfSearch      = new TextField();

    @Override
    public void start(Stage primaryStage) {

        // ------ Toolbar with Nav buttons ------
        Button btAdd        = new Button("Add Session");
        Button btViewAll    = new Button("View All Sessions");
        Button btSearch     = new Button("Search");
        Button btStats      = new Button("Statistics");

        HBox toolbar        = new HBox(10);
        toolbar.setPadding(new Insets(10));
        toolbar.setAlignment(Pos.CENTER);
        toolbar.getChildren().addAll(btAdd, btViewAll, btSearch, btStats);

        // ------ Center area ------
        BorderPane root = new BorderPane();
        root.setTop(toolbar);
        root.setBottom(lblStatus);
        BorderPane.setMargin(lblStatus, new Insets(8));

    }
}