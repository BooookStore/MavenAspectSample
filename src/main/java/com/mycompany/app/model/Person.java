package com.mycompany.app.model;

/**
 * 人物の情報を表します。
 * 名前を表している_firstNameと_lastNameの二つのフィールドはnullが許可されません。
 * 
 * @author honyaryousuke
 */
public class Person {
 
    private String _firstName;
    
    private String _lastName;
    
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
    private Person(PersonBuilder pb){
        _firstName = pb.firstName;
        _lastName = pb.lastName;
        _age = pb.age;
        _phoneNumber = pb.phoneNumber;
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String _firstName) {
        this._firstName = _firstName;
    }

    public String getLstName() {
        return _lastName;
    }

    public void setLstName(String _lstName) {
        this._lastName = _lstName;
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
