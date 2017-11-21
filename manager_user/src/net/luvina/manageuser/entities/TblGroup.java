/*
 * Copyright(C) 2010 Luvina Software Company
 *
 * GroupBean.java, Oct 4, 2010 ntmhuong
 */
package net.luvina.manageuser.entities;

import java.io.Serializable;

/**
 * TblGroup
 * @author ntmhuong
 *
 */
public class TblGroup implements Serializable {
    private int id;
    private String name;

    /**
     * Contructor
     * @param id int ID
     * @param name String groupName
     */
    public TblGroup(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
