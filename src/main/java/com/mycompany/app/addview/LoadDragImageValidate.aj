import com.mycompany.app.addview.LoadDragImage;
import java.io.File;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.control.Alert;

aspect LoadDragImageValidate {

    void around(DragEvent event) : execution(void LoadDragImage.handle(DragEvent)) && args(event) {
        Dragboard db = event.getDragboard();
        if(db.hasFiles()) {
            String filePath;
            for (File file : db.getFiles()){
                filePath = file.toURI().toString();
                System.out.println(filePath);
                System.out.println(validatePath(filePath));

                if(!validatePath(filePath)) {
                    //アラートを表示
                    System.out.println("Alert");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("エラー");
                    alert.setHeaderText("画像の拡張子が合っていません。");
                    alert.setContentText("対応している拡張子はjpeg,pngのみです。");

                    alert.showAndWait();

                    return;
                } 
            }
        }

        proceed(event);
    }

    private boolean validatePath(String path){
        int index = path.lastIndexOf(".");
        String ext = path.substring(index).substring(1);

        if( ext.equals("jpeg") || ext.equals("png")) {
            return true;
        }
        return false;
    }

}