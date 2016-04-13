package com.mycompany.app.topview;

import com.mycompany.app.model.Person;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
    void addButtonClicked(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("エラー");
        alert.setHeaderText("未実装の機能です。");
        alert.setContentText("この機能はまだ実装されていません。");
        
        alert.showAndWait();
    }

    @FXML
    void removeButtonClicked(ActionEvent event) {
        System.out.println("remove button clicked.");
    }

    @FXML
    void saveButtonClicked(ActionEvent event) {
        System.out.println("save button clicked.");
    }

    /**
     * PersonをpersonListViewに表示するセルを表します。
     */
    public static class PersonCellView extends ListCell<Person> {

        @Override
        public void updateItem(Person item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null) {
                Label label = new Label(item.getFirstName() + " " + item.getLstName());
                setGraphic(label);
            }
        }

    }

}
