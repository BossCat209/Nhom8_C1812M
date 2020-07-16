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
public class AddWarehouse {
    private int id;
    private String name_add;
    private String link_add;
    private int id_user_add;
    private Date created_at;
    private Date updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_add() {
        return name_add;
    }

    public void setName_add(String name_add) {
        this.name_add = name_add;
    }

    public String getLink_add() {
        return link_add;
    }

    public void setLink_add(String link_add) {
        this.link_add = link_add;
    }

    public int getId_user_add() {
        return id_user_add;
    }

    public void setId_user_add(int id_user_add) {
        this.id_user_add = id_user_add;
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
