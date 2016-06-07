/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;

public class BookingPageFXML extends LogInFXML{

    private String BusRoot,BusTime,BusDate;
    private String TrainName,TrainDate;
    private String ShowTime,ShowDate;

    @FXML
    private CheckBox Bog2Dha;
    @FXML
    private CheckBox Dha2Bog;
    @FXML
    private CheckBox Dha2Chi;
    @FXML
    private DatePicker dpBus;
    @FXML
    private CheckBox am10;
    @FXML
    private CheckBox pm4;
    @FXML
    private Button SelectSeatBus;

    @FXML
    private void BograToDhaka(ActionEvent event) {
        BusRoot = "BograToDhaka";
    }
    @FXML
    private void DhakaToBogra(ActionEvent event) {
        BusRoot = "DhakaToBogra";
    }
    @FXML
    private void DhakaToChittagong(ActionEvent event) {
        BusRoot = "DhakaToChittagong";
    }
    @FXML
    private void DatePickedBus(ActionEvent event) {
        BusDate = dpBus.getValue().toString();
    }
    @FXML
    private void Bus10AM(ActionEvent event) {
        BusTime = "10AM";
    }
    @FXML
    private void Bus4PM(ActionEvent event) {
        BusTime = "4PM";
    }

    @FXML
    private void BusSelectSeat(ActionEvent event) {
        Pane root;
        try {
            root = FXMLLoader.load(getClass().getResource("BookingBusSeat.fxml"));
            Stage stage=new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            System.out.println("Writing....");

            ClientController.OutToServer.writeBytes("Bus" + '\n');
            System.out.println(BusDate+BusRoot+BusTime);

            ClientController.OutToServer.writeBytes(BusRoot + '\n');
            ClientController.OutToServer.writeBytes(BusDate + '\n');
            ClientController.OutToServer.writeBytes(BusTime + '\n');
        } catch (Exception ex) {
            printStackTrace();
        }

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private CheckBox Train1;
    @FXML
    private CheckBox Train2;
    @FXML
    private CheckBox Train3;
    @FXML
    private DatePicker dpTrain;
    @FXML
    private Button SelectSeatTrain;


    @FXML
    private void Subarna(ActionEvent event) {
        TrainName = "Subarna Express";
    }
    @FXML
    private void Laalmoni(ActionEvent event) {
        TrainName = "Laalmoni Express";
    }
    @FXML
    private void Moitree(ActionEvent event) {
        TrainName = "Moitree Express";
    }
    @FXML
    private void DatePickedTrain(ActionEvent event){
        TrainDate = dpTrain.getValue().toString();
    }

    @FXML
    private void TrainSelectSeat(ActionEvent event) throws IOException {
        Pane root = FXMLLoader.load(getClass().getResource("BookingTrainSeat.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        System.out.println("Writing....");

        ClientController.OutToServer.writeBytes("Train" + '\n');
        System.out.println(TrainName+TrainDate);

        ClientController.OutToServer.writeBytes(TrainName + '\n');
        ClientController.OutToServer.writeBytes(TrainDate+ '\n');

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private CheckBox pm6;
    @FXML
    private CheckBox pm10;
    @FXML
    private DatePicker dpTheatre;
    @FXML
    private Button SelectSeatTheatre;


    @FXML
    private void Theatre6PM(ActionEvent event) { ShowTime = "6PM";
    }
    @FXML
    private void Theatre10PM(ActionEvent event) { ShowTime = "10PM";
    }
    @FXML
    private void DatePickedTrain(ActionEvent event){ ShowDate = dpTheatre.getValue().toString();
    }


    @FXML
    private void TheatreSelectSeat(ActionEvent event) throws IOException {
        Pane root = FXMLLoader.load(getClass().getResource("BookingTheatreSeat.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        System.out.println("Writing....");

        ClientController.OutToServer.writeBytes("Theatre" + '\n');
        System.out.println(ShowTime+ShowDate);

        ClientController.OutToServer.writeBytes(ShowDate + '\n');
        ClientController.OutToServer.writeBytes(ShowTime + '\n');

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}