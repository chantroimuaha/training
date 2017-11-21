/*
 * Copyright(C) 2010 Luvina Software Company
 *
 * UserLogic.java, Oct 4, 2010 ntmhuong
 */
package net.luvina.manageuser.logics;


import java.util.List;

import net.luvina.manageuser.entities.TblGroup;
import net.luvina.manageuser.entities.TblUser;


/**
 * UserLogic
 *
 * @author ntmhuong
 *
 */
public interface UserLogic {

    /**
     * Check existLoginId
     *
     * @param loginId
     *            String loginId
     * @param password
     *            String password
     * @return true: existed
     *  false: not exist
     */
    public Boolean existLoginId(String loginId, String password);

    /**
     * getAllGroups
     *
     * @return List Groups
     */
    public List<TblGroup> getAllGroups();

    /**
     * Get list users
     *
     * @param tblUser TblUser
     * @param offset int
     * @param limit int
     * @return List Users
     */
    public List<TblUser> getListUsers(TblUser tblUser, int offset, int limit);

    /**
     * getTotalListUsers
     *
     * @param tblUser
     *            TblUser
     * @return int total users
     */
    public int getTotalUsers(TblUser tblUser);

}
