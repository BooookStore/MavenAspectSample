package com.mycompany.app.model;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author honyaryousuke
 */
public class PersonTest {

    public PersonTest() {
    }

    //JavaFXライブラリを使用すためのコード-----------------------------------
    public static class AsNonApp extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            // noop
        }
    }

    @BeforeClass
    public static void setUpClass() throws InterruptedException {
        System.out.printf("About to launch FX App\n");
        Thread t = new Thread("JavaFX Init Thread") {
            public void run() {
                Application.launch(AsNonApp.class, new String[0]);
            }
        };
        t.setDaemon(true);
        t.start();
        System.out.printf("FX App thread started\n");
        Thread.sleep(500);
    }
    //ここまで-------------------------------------------------------------

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * ゲッター、セッターメソッドのテスト
     */
    @Test
    public void getter_setter_check() {

        //セットアップ
        PhoneNumber pn = new PhoneNumber("111222333");
        Image icon = new Image("http://www.flamme.co.jp/common/profile/kasumi_arimura.jpg");

        Person p = new Person.PersonBuilder("Book", "Store").setAge(22)
                .setPhoneNumber(pn).setEmailAddress("ABC").setAddress("EFG")
                .setIcon(icon).build();

        //検証
        Assert.assertEquals("Book", p.getFirstName());
        Assert.assertEquals("Store", p.getLastName());
        Assert.assertEquals((Integer) 22, p.getAge());
        Assert.assertEquals(pn, p.getPhoneNumber());
        Assert.assertEquals("ABC", p.getEmailAddress());
        Assert.assertEquals("EFG", p.getAddress());
        Assert.assertEquals(icon, p.getIcon());
    }

    @Test
    public void getter_setter_check_base() {

        //セットアップ
        Person p = new Person.PersonBuilder("A", "B").build();

        //検証
        Assert.assertEquals("A", p.getFirstName());
        Assert.assertEquals("B", p.getLastName());
        Assert.assertEquals((Integer) 0, p.getAge());
        Assert.assertNotNull(p.getPhoneNumber());
        Assert.assertEquals("None address", p.getEmailAddress());
        Assert.assertEquals("None address", p.getAddress());
        Assert.assertNotNull(p.getIcon());
    }
}
