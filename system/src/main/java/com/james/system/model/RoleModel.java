package com.james.system.model;

/**
 * Created by eronzen on 11/24/2016.
 */
public class RoleModel extends BaseModel{

    private String name;

    private String discription;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
