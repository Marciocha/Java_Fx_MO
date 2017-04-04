package com.sdajava.java_fx.view;

import com.sdajava.java_fx.Main;
import com.sdajava.java_fx.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created by user on 2017-04-04.
 */
public class PersonOverviewController {

    @FXML
    private TableView<Person> personTable;

    @FXML
    private TableColumn<Person, String> firstNameColumn;

    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label streetLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label postalCodeLabel;

    @FXML
    private Label birthdayLabel;

    //referenje do glownej klasy
    private Main main;

    public PersonOverviewController() {
    }

    @FXML
    private void initialize(){
        firstNameColumn.setCellValueFactory(data -> data.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(data -> data.getValue().lastNameProperty());
    }

    public void setMain(Main main){
        this.main = main;
        personTable.setItems(main.getPersonData());
    }
}
