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
public class OutWarehouse {
    private int id;
    private String name_out;
    private String link_out;
    private int id_user_out;
    private Date created_at;
    private Date updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_out() {
        return name_out;
    }

    public void setName_out(String name_out) {
        this.name_out = name_out;
    }

    public String getLink_out() {
        return link_out;
    }

    public void setLink_out(String link_out) {
        this.link_out = link_out;
    }

    public int getId_user_out() {
        return id_user_out;
    }

    public void setId_user_out(int id_user_out) {
        this.id_user_out = id_user_out;
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
