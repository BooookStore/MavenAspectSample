package com.mycompany.app.model;

/**
 * 電話番号を表します。
 * @author honyaryousuke
 */
class PhoneNumber {

    private String _phoneNumber;

    public PhoneNumber(String _phoneNumber) {
        this._phoneNumber = _phoneNumber;
    }

    public String getPhoneNumber() {
        return _phoneNumber;
    }

    public void setPhoneNumber(String _phoneNumber) {
        this._phoneNumber = _phoneNumber;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" + "_phoneNumber=" + _phoneNumber + '}';
    }
    
}
