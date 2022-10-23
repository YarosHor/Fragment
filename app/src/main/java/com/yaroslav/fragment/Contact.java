package com.yaroslav.fragment;

public class Contact {
    int id;
    String name;
    String surname1;
    String surname2;
    String birth;
    String company;
    String email;
    String phone1;
    String phone2;
    String adress;

    public Contact(int id, String name, String surname1, String surname2, String birth, String company, String email, String phone1, String phone2, String adress) {
        this.id = id;
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.birth = birth;
        this.company = company;
        this.email = email;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname1() {
        return surname1;
    }

    public String getSurname2() {
        return surname2;
    }

    public String getBirth() {
        return birth;
    }

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone1() {
        return phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getAdress() {
        return adress;
    }
}
