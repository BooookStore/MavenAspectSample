package com.mycompany.app.addview;

import com.mycompany.app.model.Person;
import com.mycompany.app.model.PhoneNumber;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

public class AddviewController implements Initializable {

    private final ObservableList<Person> targetList;

    public AddviewController(ObservableList<Person> targetList) {
        this.targetList = targetList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        addButton.setOnAction((ActionEvent event) -> {

            if (!checkInputField()) {
                return;
            }

            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            Integer age = Integer.getInteger(ageField.getText());
            String phoneNumber = phoneNumberField.getText();
            String emailAddress = emailAddressField.getText();
            String address = addressField.getText();
            Image icon = iconImageView.getImage();

            Person p = new Person.PersonBuilder(firstName, lastName).setAddress(address)
                    .setAge(age).setEmailAddress(emailAddress).setIcon(icon).setPhoneNumber(new PhoneNumber(phoneNumber))
                    .build();

            targetList.add(p);

            firstNameField.getScene().getWindow().hide();
        });

        iconImageView.setOnDragOver((DragEvent event) -> {
            Dragboard db = event.getDragboard();
            if (db.hasFiles()) {
                event.acceptTransferModes(TransferMode.COPY);
            } else {
                event.consume();
            }
        });

        iconImageView.setOnDragDropped((DragEvent event) -> {
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasFiles()) {
                success = true;
                String filePath = null;
                for (File file : db.getFiles()) {
                    iconImageView.setImage(new Image(file.toURI().toString()));
                }
            }
            event.setDropCompleted(success);
            event.consume();
        });
    }

    @FXML
    private Button cancelButton;

    @FXML
    private ImageView iconImageView;

    @FXML
    private TextField ageField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField emailAddressField;

    @FXML
    private Button addButton;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField addressField;

    private boolean checkInputField() {

        ArrayList<String> inputField = new ArrayList<>();
        inputField.add(firstNameField.getText());
        inputField.add(lastNameField.getText());

        for (String str : inputField) {
            if ("".equals(str)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("エラー");
                alert.setHeaderText("名前が未入力です。");
                alert.setContentText("名前を入力してください。");

                alert.showAndWait();

                return false;
            }
        }

        return true;
    }

}
