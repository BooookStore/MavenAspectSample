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

    before(App app) : execution(void App.start(Stage)) && target(app) {
        Person sample1 = new Person.PersonBuilder("有村", "架純")
                .setAge(23).setPhoneNumber(new PhoneNumber("XXX-YYY-ZZZ"))
                .setEmailAddress("ABCDEFG@gmail.com").setAddress("兵庫県伊丹市")
                .setIcon(new Image("http://www.flamme.co.jp/common/profile/kasumi_arimura.jpg")).build();

        Person sample2 = new Person.PersonBuilder("松崎","しげる")
                .setAge(66).setPhoneNumber(new PhoneNumber("XXX-YYY-ZZZ"))
                .setEmailAddress("JJJKKKLLL@gmail.com").setAddress("東京都江戸川区")
                .setIcon(new Image("http://up.gc-img.net/post_img_web/2015/08/sLs5clTgTA2N7OO_16133.jpeg")).build();

        App target = (App)thisJoinPoint.getTarget();

        app.addPerson(sample1);
        app.addPerson(sample2);
    }

    public void App.addPerson(Person p) {
        this.personList.add(p);
    }
    
}