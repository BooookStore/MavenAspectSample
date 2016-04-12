package com.mycompany.app.model;

/**
 * 人物の情報を表します。
 * @author honyaryousuke
 */
public class Person {
 
    private String _firstName;
    
    private String _lstName;
    
    private Integer _age;

    private PhoneNumber _phoneNumber;

    /**
     * 各フィールドを指定された値で初期化します。
     * 
     * @param _firstName
     * @param _lstName
     * @param _age
     * @param _phoneNumber 
     */
    public Person(String _firstName, String _lstName, Integer _age, PhoneNumber _phoneNumber) {
        this._firstName = _firstName;
        this._lstName = _lstName;
        this._age = _age;
        this._phoneNumber = _phoneNumber;
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String _firstName) {
        this._firstName = _firstName;
    }

    public String getLstName() {
        return _lstName;
    }

    public void setLstName(String _lstName) {
        this._lstName = _lstName;
    }

    public Integer getAge() {
        return _age;
    }

    public void setAge(Integer _age) {
        this._age = _age;
    }

    public PhoneNumber getPhoneNumber() {
        return _phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber _phoneNumber) {
        this._phoneNumber = _phoneNumber;
    }

}
