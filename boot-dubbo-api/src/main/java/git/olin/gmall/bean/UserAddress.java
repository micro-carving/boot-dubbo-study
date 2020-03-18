/*
 * Copyright (c) 2020
 * File:UserAddress.java
 * Date:2020-03-08 18:22:08
 */

package git.olin.gmall.bean;

import java.io.Serializable;

/**
 * @program: user-service-provider
 * @description: this is a UserAddress bean
 * @author: OlinH
 * @create: 2020-03-08 18:21
 **/
public class UserAddress implements Serializable {
    private Integer id;
    private String userAddress;     // 用户地址
    private String userId;          //用户id
    private String consignee;          //收货人
    private String phoneNum;          //电话号码
    private String isDefault;          //是否为默认地址 Y-是    N-否

    public UserAddress() {
        super();
    }

    /** 
    * @Description: UserAddress 
    * @Param: [id, userAddress, userId, consignee, phoneNum, isDefault] 
    * @return:  
    * @Author: OlinH 
    * @Date: 2020/3/9 
    */
    public UserAddress(Integer id, String userAddress, String userId, String consignee, String phoneNum, String isDefault) {
        this.id = id;
        this.userAddress = userAddress;
        this.userId = userId;
        this.consignee = consignee;
        this.phoneNum = phoneNum;
        this.isDefault = isDefault;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    /** 
    * @Description: toString 
    * @Param: [] 
    * @return: java.lang.String 
    * @Author: OlinH 
    * @Date: 2020/3/9 
    */
    @Override
    public String toString() {
        return "UserAddress{" +
                "id=" + id +
                ", userAddress='" + userAddress + '\'' +
                ", userId='" + userId + '\'' +
                ", consignee='" + consignee + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", isDefault='" + isDefault + '\'' +
                '}';
    }
}