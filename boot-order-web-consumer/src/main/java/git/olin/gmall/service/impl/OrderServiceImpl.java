package git.olin.gmall.service.impl;



import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import git.olin.gmall.bean.UserAddress;
import git.olin.gmall.service.OrderService;
import git.olin.gmall.service.UserService;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;


/**
 * 1.将服务提供者注册到中心（暴露服务）
 * 1）、导入dubbo依赖（2.6.2）和操作zookeeper的客户端（curator）
 * 2）、配置服务提供者
 * 2.让服务消费者去注册中心订阅服务提供者的服务地址
 *
 * @program: order-service-consumer
 * @description: this is a OrderServiceImpl class
 * @author: OlinH
 * @create: 2020-03-09 19:17
 **/
@Service // 暴露服务
public class OrderServiceImpl implements OrderService {
    @Reference(loadbalance = "random", timeout = 1000) // 引用服务提供者暴露的服务，相当于@Autowired
//    @Reference(url = "127.0.0.1:20880") // 注册中心宕机之后，采用dubbo直连
    UserService userService;

    @HystrixCommand(fallbackMethod = "fallBackFun")
    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户id:" + userId);
        // 1、查询用户的收货地址
        List<UserAddress> addressList = userService.getUserAddressList(userId);
       return addressList;
    }

    /** 
    * @Description: fallBackFun：服务器容错之后调用此方法 
    * @Param: [userId] 
    * @return: java.util.List<git.olin.gmall.bean.UserAddress> 
    * @Author: OlinH 
    * @Date: 2020/3/18 
    */
    public List<UserAddress> fallBackFun(String userId) {

       return Arrays.asList(new UserAddress(-1,"测试地址","-1", "测试","-1","Y"));
    }
}
