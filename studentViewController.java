package cse213projects.spring2024.student;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.fxml.FXML;


import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;


public class studentViewController
{
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private ComboBox<String> genderCB;
    @javafx.fxml.FXML
    private TextField phoneNumberTF;
    @javafx.fxml.FXML
    private TextArea addressTF;
    @javafx.fxml.FXML
    private TextField idTF;
    @javafx.fxml.FXML
    private Label messagelabel;
    @FXML
    private TableColumn<Student,Integer> idTableColumn;
    @FXML
    private TableColumn<Student,String> nameTableColumn;
    @FXML
    private TableView<Student> studentTableView;
    @FXML
    private TableColumn<Student,String> genderTableColumn;
    @FXML
    private TextField areaTextFieldforfiltering;
    @FXML
    private ComboBox<String> genderCBforfiltering;

    @javafx.fxml.FXML
    public void initialize() {
        genderCB.getItems().addAll("Male", "Female");
        genderCBforfiltering.getItems().addAll("Male", "Female");
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        genderTableColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
    }

    Student student;
    ArrayList<Student> studentList = new ArrayList<>();

    @javafx.fxml.FXML
    public void showObjectsButtonOnAction(ActionEvent actionEvent) {
        studentTableView.getItems().clear();
        studentTableView.getItems().addAll(studentList);
        for (Student student : studentList) {
            if ((student.getGender().equals(nameTF.getText()) && (student.getAddress().equals(areaTextFieldforfiltering.getText())))){
                studentTableView.getItems().add(student);
            }

        }

    }

    @javafx.fxml.FXML
    public void createButtonOnAction(ActionEvent actionEvent) {
        String name, gender, phoneNumber, address;
        int id;


        name = nameTF.getText();
        gender = genderCB.getPromptText();
        phoneNumber = phoneNumberTF.getText();
        address = addressTF.getText();
        id = Integer.parseInt(idTF.getText());



        student = new Student(name, gender, phoneNumber, address,id);

        /*if (student.getGender().equals("Female")){
            studentList.add(student);
            messagelabel.setText("Student Created Successfully");
        }
        else{
            messagelabel.setText("Student is not Female");
        }*/
        studentList.add(student);
        student.name = name;
        student.gender = gender;
        student.phoneNumber = phoneNumber;
        student.address = address;
        student.id = id;

        nameTF.clear();
        genderCB.setValue(null);
        phoneNumberTF.clear();
        addressTF.clear();
        idTF.clear();






    }
}