package git.olin.gmall.controller;

import git.olin.gmall.bean.UserAddress;
import git.olin.gmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: boot-dubbo-study
 * @description: this is a OrderController class
 * @author: OlinH
 * @create: 2020-03-15 20:55
 **/
@Controller // 控制器注解
public class OrderController {
    @Autowired // 自动装配
    OrderService orderService;

    @ResponseBody // 返回json类型的数据
    @RequestMapping("/initOrder") // 请求RESTful类型的网址
    // @RequestParam("uid")请求RESTful类型的网址所带参数，
    // 如：http://localhost:8081/initOrder?uid=2
    public List<UserAddress> initOrder(@RequestParam("uid") String userId){
        return orderService.initOrder(userId);
    }
}
