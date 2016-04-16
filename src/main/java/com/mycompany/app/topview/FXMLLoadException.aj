import javafx.stage.Stage;
import com.mycompany.app.topview.TopviewController;
import javafx.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;
import javafx.scene.control.Alert;

import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.PrintWriter;
import java.io.StringWriter;
import javafx.scene.control.TextArea;

aspect FXMLLoadException {
    
    pointcut illegalStateException(IllegalStateException e) : handler(IllegalStateException) && args(e);

    pointcut topView() : withincode(void TopviewController.addButtonClicked(ActionEvent));

    before(IllegalStateException e) : illegalStateException(e) && topView() {
        System.out.println("FXML Load error.");

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("エラー");
        alert.setHeaderText("ウィンドウが作成できません。");
        alert.setContentText(e.getMessage());

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        //例外メッセージ表示
        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }

}