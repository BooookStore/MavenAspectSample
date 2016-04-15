package com.mycompany.app.addview;

import com.mycompany.app.model.Person;
import com.mycompany.app.model.PhoneNumber;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

        iconImageView.setOnDragOver((DragEvent event) -> {
            Dragboard db = event.getDragboard();
            if (db.hasFiles()) {
                event.acceptTransferModes(TransferMode.COPY);
            } else {
                event.consume();
            }
        });

        iconImageView.setOnDragDropped(new LoadDragImage(iconImageView));
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

    @FXML
    void cancelButtonClicked(ActionEvent event) {
        firstNameField.getScene().getWindow().hide();
    }

    @FXML
    void addButtonClicked(ActionEvent event) {
        //各フィールドから値を取得
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        Integer age = Integer.getInteger(ageField.getText());
        String phoneNumber = phoneNumberField.getText();
        String emailAddress = emailAddressField.getText();
        String address = addressField.getText();
        Image icon = iconImageView.getImage();

        //入力値からPersonを作成
        Person p = new Person.PersonBuilder(firstName, lastName).setAddress(address)
                .setAge(age).setEmailAddress(emailAddress).setIcon(icon).setPhoneNumber(new PhoneNumber(phoneNumber))
                .build();

        //リストへ追加
        targetList.add(p);
    }

}
