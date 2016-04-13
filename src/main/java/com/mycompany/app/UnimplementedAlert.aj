import com.mycompany.app.topview.TopviewController;
import javafx.event.ActionEvent;

aspect UnimplementedAlert {

    before() : execution(void TopviewController.addButtonClicked(ActionEvent)) {
        System.out.println("Alert window show");
    }

}
