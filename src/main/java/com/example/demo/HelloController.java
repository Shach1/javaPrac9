package com.example.demo;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ButtonBar.ButtonData;

public class HelloController
{
    LabClass app = new LabClass();

    public void setAllert(String title, String msg, boolean error)
    {
        Alert alert;
        if (error) {alert = new Alert(AlertType.ERROR);}
        else {alert = new Alert(AlertType.INFORMATION);}
        alert.setTitle(title);
        alert.setHeaderText(msg);
        var buttonTypeCancel = new ButtonType("Ok", ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();
    }

    @FXML
    private TextArea listStudentsTextArea;

    @FXML
    private Button addStudentButton;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField scoreField;

    @FXML
    private Button sortStudentButton;

    @FXML
    private TextField surNameField;

    @FXML
    private TextField lastNameFieldForSerch;

    @FXML
    private Button serchStrudentButton;

    @FXML
    void initialize()
    {
        serchStrudentButton.setOnAction(actionEvent ->
        {
            try
            {
                String student = app.serchStudentForLastName(lastNameFieldForSerch.getText());
                setAllert("Студент найден", student, false);
            }
            catch (StudentNotFoundException | EmptyStringExeption e) {setAllert("Ошибка", e.getMessage(), true);}
        });

        addStudentButton.setOnAction(actionEvent ->
        {
            try
            {
                app.addStudent(firstNameField.getText(), lastNameField.getText(), surNameField.getText(),Integer.parseInt(scoreField.getText()));
                listStudentsTextArea.setText(app.getListOfStudents());
            }
            catch (EmptyStringExeption | NumberFormatException e) {setAllert("Ошибка", e.getMessage(), true);}
        });

        sortStudentButton.setOnAction(actionEvent ->
        {
            try
            {
                app.sortStudents();
                listStudentsTextArea.setText(app.getListOfStudents());
                setAllert("Уведомление", "Список студентов отсортирован колличеству очков", false);
            }
            catch (StudentNotFoundException | EmptyStringExeption e) {setAllert("Ошибка", e.getMessage(), true);}
        });
    }
}