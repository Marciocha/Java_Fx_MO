package com.sdajava.java_fx;

import com.sdajava.java_fx.model.Person;
import com.sdajava.java_fx.view.PersonOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Person> personData = FXCollections.observableArrayList();

    public Main(){
        //wypelnimy liste

        personData.addAll(new Person("Marta", "Ostrowska"));
        personData.addAll(new Person("Anna", "Kowalska"));
        personData.addAll(new Person("Agata", "Nowak"));
        personData.addAll(new Person("Nikodem", "Kotek"));
        personData.addAll(new Person("Lukasz", "Wrona"));
        personData.addAll(new Person("Sylwia", "Pieniezna"));

    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Ksiazka adresowa");

        initRootLayout();
        showPersonOverview();

    }

    public void initRootLayout(){

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Main.class.getResource("view/RootLayout.fxml"));   //jezeli mamy dodatkowe pliki i chcemy sie do nich dobrac metoda get resource zwraca url-a przeszukuje wszystkie katologi pod src
            rootLayout = fxmlLoader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showPersonOverview() {

        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);

            PersonOverviewController controller = loader.getController();
            controller.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        launch(args);
    }
}

