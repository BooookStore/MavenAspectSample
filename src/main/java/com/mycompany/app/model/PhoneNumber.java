package com.mycompany.app.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 電話番号を表します。
 * @author honyaryousuke
 */
public class PhoneNumber {

    @NotBlank
    @Length(min=0,max=100)
    private final StringProperty _phoneNumber = new SimpleStringProperty();

    /**
     * コンストラクタ
     * 
     * @param _phoneNumber 
     */
    public PhoneNumber(String _phoneNumber) {
        this._phoneNumber.set(_phoneNumber);
    }

    public String getPhoneNumber() {
        return _phoneNumber.get();
    }

    public void setPhoneNumber(String _phoneNumber) {
        this._phoneNumber.set(_phoneNumber);
    }

    public StringProperty getPhoneNumberProperty(){
        return _phoneNumber;
    }
    
    @Override
    public String toString() {
        return "PhoneNumber{" + "_phoneNumber=" + _phoneNumber + '}';
    }
    
}
