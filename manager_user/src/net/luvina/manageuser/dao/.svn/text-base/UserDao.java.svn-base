/*
 * Copyright(C) 2010 Luvina Software Company
 *
 * UserLogic.java, Oct 4, 2010 ntmhuong
 */
package net.luvina.manageuser.dao;

import java.util.List;

import net.luvina.manageuser.entities.TblGroup;
import net.luvina.manageuser.entities.TblUser;



/**
 * UserDao
 *
 * @author ntmhuong
 *
 */
public interface UserDao extends BaseDao{

	/**
     * getUserByLoginId
     *
     * @param loginId
     *            String loginId
     * @param password
     *            String password
     * @return TblUser
     */
    public TblUser getUserByLoginId(String loginId, String password) ;

    /**
     * getAllGroups
     *
     * @return List Groups
     */
    public List<TblGroup> getAllGroups();

    /**
     * Get list users
     *
     * @param user UserBean
     * @param offset int
     * @param limit int
     * @return List Users
     */
    public List<TblUser> getListUsers(TblUser user, int offset, int limit) ;

    /**
     * getTotalListUsers
     *
     * @param user
     *            UserBean
     * @return int total users
     */
    public int getTotalUsers(TblUser user) ;

}
