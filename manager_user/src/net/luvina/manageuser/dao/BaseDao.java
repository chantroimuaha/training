/*
 * Copyright(C) 2010 Luvina Software Company
 *
 * BaseDao.java, Oct 4, 2010 ntmhuong
 */
package net.luvina.manageuser.dao;

/**
 * @author ntmhuong
 *
 */
public interface BaseDao {


    /**
     * connectToDB
     *
     * @return true: connectToDB success
     *  false: connectToDB unsuccess
     */
    public boolean connectToDB();

    /**
     * closeConnect
     */
    public void closeConnect();

}
