package com.mycompany.app.model;

import com.mycompany.app.App;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

/**
 * 人物の情報を表します。 名前を表している_firstNameと_lastNameの二つのフィールドはnullが許可されません。
 *
 * @author honyaryousuke
 */
public class Person {

    private StringProperty _firstName;

    private StringProperty _lastName;

    private IntegerProperty _age;

    private ObjectProperty<PhoneNumber> _phoneNumber;

    private StringProperty _emailAddress;

    private StringProperty _address;

    private ObjectProperty<Image> _icon;

    /**
     * 各フィールドを指定された値で初期化します。
     *
     * @param _firstName
     * @param _lstName
     * @param _age
     * @param _phoneNumber
     */
    private Person(PersonBuilder pb) {
        _firstName = new SimpleStringProperty(pb.firstName);
        _lastName = new SimpleStringProperty(pb.lastName);
        _age = new SimpleIntegerProperty(pb.age);
        _phoneNumber = new SimpleObjectProperty<>(pb.phoneNumber);
        _emailAddress = new SimpleStringProperty(pb.emailAddress);
        _address = new SimpleStringProperty(pb.address);
        _icon = new SimpleObjectProperty<>(pb.icon);
    }

    //_firstNameへの取得、設定メソッド
    public String getFirstName() {
        return _firstName.get();
    }

    public void setFirstName(String value) {
        _firstName.set(value);
    }

    public StringProperty getFirstNameProperty() {
        return _firstName;
    }

    //_lastNameへの取得、設定メソッド
    public String getLastName() {
        return _lastName.get();
    }

    public void setLastName(String value) {
        _lastName.set(value);
    }

    public StringProperty getLastNameProperty() {
        return _lastName;
    }

    //_ageへの取得、設定メソッド
    public Integer getAge() {
        return _age.get();
    }

    public void setAge(Integer value) {
        _age.set(value);
    }

    public IntegerProperty getAgeProperty() {
        return _age;
    }

    //_phoneNumberへの取得、設定メソッド
    public PhoneNumber getPhoneNumber() {
        return _phoneNumber.get();
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        _phoneNumber.set(phoneNumber);
    }

    public ObjectProperty<PhoneNumber> getPhoneNumberProperty() {
        return _phoneNumber;
    }

    //_emailAddressへの取得、設定メソッド
    public String getEmailAddress() {
        return _emailAddress.get();
    }

    public void setEmailAddress(String address) {
        _emailAddress.set(address);
    }

    public StringProperty getEmailAddressProperty() {
        return _emailAddress;
    }

    //_Addressへの取得、設定メソッド
    public String getAddress() {
        return _address.get();
    }

    public void setAddress(String address) {
        _address.set(address);
    }

    public StringProperty getAddressProperty() {
        return _address;
    }

    //_iconへの取得、設定メソッド
    public Image getIcon() {
        return _icon.get();
    }

    public void setIcon(Image address) {
        _icon.set(address);
    }

    public ObjectProperty<Image> getIconProperty() {
        return _icon;
    }

    public static class PersonBuilder {

        private String firstName = "None Name";
        private String lastName = "None Name";
        private Integer age = 0;
        private PhoneNumber phoneNumber = new PhoneNumber("None Number");
        private String emailAddress = "None address";
        private String address = "None address";
        private Image icon = new Image(App.class.getResource("./img/Flag_of_None.png").toString());

        public PersonBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public PersonBuilder setAge(Integer age) {
            if (age == null) {
                return this;
            }
            this.age = age;
            return this;
        }

        public PersonBuilder setPhoneNumber(PhoneNumber pn) {
            if (pn == null) {
                return this;
            }
            this.phoneNumber = pn;
            return this;
        }

        public PersonBuilder setEmailAddress(String emailAddress) {
            if (emailAddress == null) {
                return this;
            }
            this.emailAddress = emailAddress;
            return this;
        }

        public PersonBuilder setAddress(String address) {
            if (address == null) {
                return this;
            }
            this.address = address;
            return this;
        }

        public PersonBuilder setIcon(Image icon) {
            if (icon == null) {
                return this;
            }
            this.icon = icon;
            return this;
        }

        public Person build() {
            return new Person(this);
        }

    }

}
