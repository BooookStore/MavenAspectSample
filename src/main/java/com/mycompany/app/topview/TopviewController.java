package com.mycompany.app.topview;

import com.mycompany.app.model.Person;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * topviewのコントロールです。
 *
 * @author honyaryousuke
 */
public class TopviewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Test code...
        Person p = new Person.PersonBuilder("first","second").build();
        personList.getItems().add(p);
    }    
    
    @FXML
    private ListView<Person> personList;
    
}
