/*
 * Copyright (c) 2020
 * File:UserService.java
 * Date:2020-03-08 18:27:08
 */

package git.olin.gmall.service;

import git.olin.gmall.bean.UserAddress;

import java.util.List;

/**
 * @program: user-service-provider
 * @description: this is a UserService interface
 * @author: OlinH
 * @create: 2020-03-08 18:27
 **/
public interface UserService {
    /** 
    * @Description: getUserAddressList按照用户id返回所有的收货地址
    * @Param: [userId] 
    * @return: java.util.List<git.olin.UserAddress> 
    * @Author: OlinH 
    * @Date: 2020/3/9 
    */
    public List<UserAddress> getUserAddressList(String userId);
}
