package com.mycompany.app.addview;

import java.io.File;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;

/**
 *
 * @author honyaryousuke
 */
public class LoadDragImage implements EventHandler<DragEvent> {

    public ImageView targetImageView;

    public LoadDragImage(ImageView targetImageView) {
        this.targetImageView = targetImageView;
    }

    @Override
    public void handle(DragEvent event) {
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasFiles()) {
            success = true;
            String filePath = null;
            for (File file : db.getFiles()) {
                targetImageView.setImage(new Image(file.toURI().toString()));
            }
        }
        event.setDropCompleted(success);
        event.consume();
    }

}
