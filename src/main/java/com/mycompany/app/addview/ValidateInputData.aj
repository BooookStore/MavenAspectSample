import com.mycompany.app.addview.AddviewController;
import javafx.event.ActionEvent;
import javafx.scene.control.TextInputControl;
import java.util.ArrayList;
import javafx.scene.control.Alert;

privileged aspect ValidateInputData {

    void around(AddviewController cont,ActionEvent event) : execution(void AddviewController.addButtonClicked(ActionEvent)) 
                                        && target(cont) && args(event) {
        System.out.println("validation.");
        
        ArrayList<String> inputField = new ArrayList<>();
        inputField.add(cont.firstNameField.getText());
        inputField.add(cont.lastNameField.getText());

        for (String str : inputField) {
            if ("".equals(str)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("エラー");
                alert.setHeaderText("名前が未入力です。");
                alert.setContentText("名前を入力してください。");

                alert.showAndWait();
                
                return;
            }
        }

        proceed(cont,event);
    }

}