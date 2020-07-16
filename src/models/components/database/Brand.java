/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.components.database;

import java.sql.Date;

/**
 *
 * @author huanh
 */
public class Brand {
    private int id;
    private String name_brand;
    private String email_brand;
    private int phone_brand;
    private String address_brand;
    private Date created_at;
    private Date updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_brand() {
        return name_brand;
    }

    public void setName_brand(String name_brand) {
        this.name_brand = name_brand;
    }

    public String getEmail_brand() {
        return email_brand;
    }

    public void setEmail_brand(String email_brand) {
        this.email_brand = email_brand;
    }

    public int getPhone_brand() {
        return phone_brand;
    }

    public void setPhone(int phone_brand) {
        this.phone_brand = phone_brand;
    }

    public String getAddress_brand() {
        return address_brand;
    }

    public void setAddress_brand(String address_brand) {
        this.address_brand = address_brand;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
