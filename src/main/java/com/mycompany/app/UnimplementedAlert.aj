import com.mycompany.app.topview.TopviewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

aspect UnimplementedAlert {

    before() : execution(void TopviewController.addButtonClicked(ActionEvent)) {
        showAndWaitAlert();
    }

    public void showAndWaitAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("エラー");
        alert.setHeaderText("未実装の機能です。");
        alert.setContentText("この機能はまだ実装されていません。");
        
        alert.showAndWait();
    }

}