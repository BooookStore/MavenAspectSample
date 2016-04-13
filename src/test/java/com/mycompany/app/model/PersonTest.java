package com.mycompany.app.model;

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
    
    @BeforeClass
    public static void setUpClass() {
    }
    
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
        Person p = new Person.PersonBuilder("Book", "Store").setAge(22)
                .setPhoneNumber(pn).setEmailAddress("ABC").setAddress("EFG").build();
        
        //検証
        Assert.assertEquals("Book", p.getFirstName());
        Assert.assertEquals("Store", p.getLastName());
        Assert.assertEquals((Integer)22, p.getAge());
        Assert.assertEquals(pn, p.getPhoneNumber());
        Assert.assertEquals("ABC", p.getEmailAddress());
        Assert.assertEquals("EFG", p.getAddress());
    }
    
}
