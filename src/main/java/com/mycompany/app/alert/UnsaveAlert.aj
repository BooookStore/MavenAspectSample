import com.mycompany.app.App;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.stage.WindowEvent;
import java.util.Optional;

aspect UnsaveAlert {

    void around(WindowEvent event) : call(void App.closeProccess(WindowEvent)) && args(event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("警告");
        alert.setHeaderText("変更が保存されていません。");
        alert.setContentText("変更を保存しますか？");
        
        ButtonType buttonTypeOne = new ButtonType("保存");
        ButtonType buttonTypeTwo = new ButtonType("保存しないで閉じる");
        ButtonType buttonTypeCancel = new ButtonType("キャンセル", ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get().getButtonData() == ButtonData.CANCEL_CLOSE) {
            event.consume();
            return;
        }else{
            proceed(event);
        }   
    }

}