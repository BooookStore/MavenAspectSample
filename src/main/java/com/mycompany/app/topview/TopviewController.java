package com.mycompany.app.topview;

import com.mycompany.app.model.Person;
import com.mycompany.app.model.PhoneNumber;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

/**
 * topviewのコントロールです。
 *
 * @author honyaryousuke
 */
public class TopviewController implements Initializable {

    private final ObservableList<Person> observablePersonList;

    /**
     * 表示するPersonを初期化します。
     *
     * @param personList
     */
    public TopviewController(ObservableList<Person> personList) {
        this.observablePersonList = personList;
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        personListView.setItems(observablePersonList);
        personListView.setCellFactory((ListView<Person> param) -> new PersonCellView());
        personListView.getSelectionModel().getSelectedItems().addListener((ListChangeListener.Change<? extends Person> c) -> {
            //リストから人が選択された際に、実行。
            Person selectedPerson = c.getList().get(0);
            
            String personName = selectedPerson.getFirstName() + " " + selectedPerson.getLastName();
            nameLabel.setText(personName);
            ageLabel.setText(Integer.toString(selectedPerson.getAge()));
            phoneNumberLabel.setText(selectedPerson.getPhoneNumber().getPhoneNumber());
            maileAdressLabel.setText("Unimplemented.");
            addressLabel.setText("Unimplemented.");
            
        });
    }

    @FXML   
    private Button addButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button saveButton;

    @FXML
    private ListView<Person> personListView;
    
    @FXML
    private Label nameLabel;
    
    @FXML
    private Label ageLabel;
    
    @FXML
    private Label phoneNumberLabel;
    
    @FXML
    private Label maileAdressLabel;
    
    @FXML
    private Label addressLabel;

    @FXML
    void addButtonClicked(ActionEvent event) {
    }

    @FXML
    void removeButtonClicked(ActionEvent event) {
    }

    @FXML
    void saveButtonClicked(ActionEvent event) {
    }
    
    @FXML
    void modifyButtonClicked(ActionEvent event) {
        
    }

    /**
     * PersonをpersonListViewに表示するセルを表します。
     */
    public static class PersonCellView extends ListCell<Person> {

        @Override
        public void updateItem(Person item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null) {
                Label label = new Label(item.getFirstName() + " " + item.getLastName());
                setGraphic(label);
            }
        }

    }

}