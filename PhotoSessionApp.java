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

        // Session Table
        buildTable();

        // View All screen
        root.setCenter(buildViewAllScreen());

        // ------ EVENT 1: Add Session Button ------
        btAdd.setOnAction(e -> root.setCenter(buildAddScreen()));

        // ------ EVENT 2: View All Button ------
        // Refresh, show table of all sessions
        btViewAll.setOnAction(e -> {
            refreshTable();
            root.setCenter(buildViewAllScreen());
            lblStatus.setText("Showing all " + log.getTotalSessions()
            + "sessions");
        });

        // ------ EVENT 3: Search Button ------
        // search screen
        btSearch.setOnAction(e -> root.setCenter(buildSearchScreen()));

        // ------ EVENT 4: Statistics Button ------
        // Display summary statistics
        btStats.setOnAction(e -> {
            taOutput.setText(log.toString());
            root.setCenter(taOutput);
            lblStatus.setText("Session statistics");
        });

        Scene scene = new Scene(root, 750, 520);
        primaryStage.setTitle("Nature Photography Session Log");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Build table columns for displaying sessions
     */
    private void buildTable() {
        TableColumn<WildlifeSession, String> colDate = new TableColumn<>("Date");
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<WildlifeSession, String> colLocation = new TableColumn<>("Location");
        colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        colLocation.setPrefWidth(180);

        TableColumn<WildlifeSession, String> colSpecies = new TableColumn<>("Species");
        colSpecies.setCellValueFactory(new PropertyValueFactory<>("species"));
        colSpecies.setPrefWidth(140);

        TableColumn<WildlifeSession, Double> colDuration = new TableColumn<>("Hours");
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));

        tableView.getColumns().addAll(colDate, colLocation, colSpecies, colDuration);
    }

    /**
     * Reload table from SessionLog
     */
    private void refreshTable() {
        tableView.getItems().clear();
        for (Session s : log.getSessions()) {
            if (s instanceof WildlifeSession) {
                tableView.getItems().add((WildlifeSession) s);
            }
        }
    }

    /** Screen: table of all sessions */
    private BorderPane buildViewAllScreen() {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10));
        pane.setCenter(tableView);
        return pane;
    }

    /** Screen: Add Session form */
    private GridPane buildAddScreen() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(8);
        grid.setPadding(new Insets(10));

        grid.add(new Label("Date (YYYY-MM-DD):"), 0,0);
        grid.add(tfDate,                          1,0);
        grid.add(new Label("Location:"),          0,1);
        grid.add(tfLocation,                      1,1);
        grid.add(new Label("Weather:"),           0,2);
        grid.add(tfWeather,                       1,2);
        grid.add(new Label("Equipment:"),         0,3);
        grid.add(tfEquipment,                     1,3);
        grid.add(new Label("Duration (hours):"),  0,4);
        grid.add(tfDuration,                      1,4);
        grid.add(new Label("Species:"),           0,5);
        grid.add(tfSpecies,                       1,5);
        grid.add(new Label("Number sighted:"),    0,6);
        grid.add(tfNumber,                        1,6);
        grid.add(cbInMotion,                      1,7);
        grid.add(new Label("Best shot:"),         0,8);
        grid.add(tfShotDesc,                      1,8);
        grid.add(new Label("Notes:"),             0,9);
        grid.add(taNotes,                         1,9);

        Button btSave = new Button("Save Session");
        grid.add(btSave, 1, 10);

        // ------ EVENT: Save button with input validation ------
        btSave.setOnAction(e -> saveSession());

        return grid;
    }

    /** Validate form and save new WildlifeSession log */
    private void saveSession() {
        try {
            // Error for valid numbers
            double duration = Double.parseDouble(tfDuration.getText().trim());
            int number = Integer.parseInt(tfNumber.getText().trim());

            // error for location, can't be blank
            if (tfLocation.getText().trim().isEmpty()) {
                lblbStatus.setText("Error: Location required");
                return;
            }

            // Create session using Update 3 class
            WildlifeSession ws = new WildlifeSession(
                tfDate.getText().trim(),
                tfLocation.getText().trim(),
                tfWeather.getText().trim(),
                tfEquipment.getText().trim(),
                taNotes.getText().trim(),
                duration,
                tfSpecies.getText().trim(),
                number,
                cbInMotion.isSelected(),
                tfShotDesc.getText().trim()
            );

            log.addSession(ws);
            clearForm();
            lblStatus.setText("Session saved! Total sessions: " + log.getTotalSessions());          
        } 
        catch (NumberFormatException ex) {
            lblStatus.setText("Error: Duration and Number sighted must be numeric");
        }
    }
}