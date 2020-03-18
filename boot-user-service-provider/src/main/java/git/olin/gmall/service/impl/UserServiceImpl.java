/*
 * Copyright (c) 2020
 * File:UserServiceImpl.java
 * Date:2020-03-13 17:39:13
 */

package git.olin.gmall.service.impl;



import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import git.olin.gmall.bean.UserAddress;
import git.olin.gmall.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @program: order-service-consumer
 * @description: this is a UserServiceImpl class
 * @author: OlinH
 * @create: 2020-03-13 16:35
 **/
@Service // 暴露服务
@Component
public class UserServiceImpl implements UserService {
    /** 
    * @Description: getUserAddressList 
    * @Param: [userId] 
    * @return: java.util.List<git.olin.gmall.bean.UserAddress> 
    * @Author: OlinH 
    * @Date: 2020/3/13 
    */
    @HystrixCommand
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress userAddress1 = new UserAddress(1,"广州","1","小丽","18385201334","Y");
        UserAddress userAddress2 = new UserAddress(2,"深圳","2","小刚","183878327020","N");
        if(Math.random()>0.5){
            throw new RuntimeException();
        }
        return Arrays.asList(userAddress1,userAddress2);
    }
}
