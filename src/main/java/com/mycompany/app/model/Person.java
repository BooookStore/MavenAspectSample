package com.mycompany.app.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * 人物の情報を表します。
 * 名前を表している_firstNameと_lastNameの二つのフィールドはnullが許可されません。
 * 
 * @author honyaryousuke
 */
public class Person {
 
    private StringProperty _firstName;
    
    private StringProperty _lastName;
    
    private IntegerProperty _age;

    private ObjectProperty<PhoneNumber> _phoneNumber;

    /**
     * 各フィールドを指定された値で初期化します。
     * 
     * @param _firstName
     * @param _lstName
     * @param _age
     * @param _phoneNumber 
     */
    private Person(PersonBuilder pb){
        _firstName = new SimpleStringProperty(pb.firstName);
        _lastName = new SimpleStringProperty(pb.lastName);
        _age = new SimpleIntegerProperty(pb.age);        
        _phoneNumber = new SimpleObjectProperty<>(pb.phoneNumber);
    }

    //_firstNameへの取得、設定メソッド
    public String getFirstName(){
        return _firstName.get();
    }
    
    public void setFirstName(String value){
        _firstName.set(value);
    }
    
    public StringProperty getFirstNameProperty(){
        return _firstName;
    }
    
    //_lastNameへの取得、設定メソッド
    public String getLastName(){
        return _lastName.get();
    }
    
    public void setLastName(String value){
        _lastName.set(value);
    }
    
    public StringProperty getLastNameProperty(){
        return _lastName;
    }
    
    //_ageへの取得、設定メソッド
    public Integer getAge(){
        return _age.get();
    }
    
    public void setAge(Integer value){
        _age.set(value);
    }
    
    public IntegerProperty getAgeProperty(){
        return _age;
    }
    
    //_phoneNumberへの取得、設定メソッド
    public PhoneNumber getPhoneNumber(){
        return _phoneNumber.get();
    }
    
    public void setPhoneNumber(PhoneNumber phoneNumber){
        _phoneNumber.set(phoneNumber);
    }
    
    public ObjectProperty<PhoneNumber> getPhoneNumberProperty(){
        return _phoneNumber;
    }

    public static class PersonBuilder {
        
        private String firstName = "None Name";
        private String lastName = "None Name";
        private Integer age = 0;
        private PhoneNumber phoneNumber = new PhoneNumber("00000000");

        public PersonBuilder(String firstName,String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }
        
        public PersonBuilder setAge(Integer age){
            this.age = age;
            return this;
        }
        
        public PersonBuilder setPhoneNumber(PhoneNumber pn){
            this.phoneNumber = pn;
            return this;
        }
        
        public Person build(){
            return new Person(this);
        }
        
    }

}
