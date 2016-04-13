import com.mycompany.app.topview.TopviewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

/**
* 未実装のボタンがクリックされた場合、アラートを表示します。
*/
aspect UnimplementedAlert {

    /**
    * アラートを表示するポイントカットとアドバイス。
    */
    before() : execution(void TopviewController.*ButtonClicked(ActionEvent)) 
            && !execution(void TopviewController.addButtonClicked(ActionEvent)) {
        showAndWaitAlert();
    }

    /**
    * アラートを表示。
    */
    public void showAndWaitAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("エラー");
        alert.setHeaderText("未実装の機能です。");
        alert.setContentText("この機能はまだ実装されていません。");
        
        alert.showAndWait();
    }

}