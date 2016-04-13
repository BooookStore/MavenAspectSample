import com.mycompany.app.App;
import javafx.stage.Stage;
import com.mycompany.app.model.Person;
import javafx.scene.image.Image;
import com.mycompany.app.model.PhoneNumber;

/**
* コンテキストを構築します。
* privateフィールドへアクセス可能です。
*/
privileged aspect InitializeContext {

    before() : execution(void App.start(Stage)) {
        for (int i = 0; i < 10; i++) {
            Person e = new Person.PersonBuilder("KASUMI", "ARIMURA")
                    .setAge(23).setPhoneNumber(new PhoneNumber("XXX-YYY-ZZZ"))
                    .setEmailAddress("ABCDEFG@gmail.com").setAddress("GHTYYII")
                    .setIcon(new Image("http://www.flamme.co.jp/common/profile/kasumi_arimura.jpg")).build();
            App target = (App)thisJoinPoint.getTarget();
            target.addPerson(e);
        }
    }

    public void App.addPerson(Person p) {
        this.personList.add(p);
    }
    
}