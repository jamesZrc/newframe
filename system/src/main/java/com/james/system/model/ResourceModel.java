package com.james.system.model;

/**
 * Created by eronzen on 11/24/2016.
 */
public class ResourceModel extends BaseModel{

    private String resource;

    private String discription;

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
