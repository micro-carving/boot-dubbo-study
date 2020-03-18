package git.olin.gmall;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

/**
 *  
 * 1、导入依赖
 * 1）、导入dubbo-starter
 * 2）、导入dubbo的其他依赖
 *
 * SpringBoot与duboo整合的三种方式
 * 1）、①导入dubbo-starter；②在application.properties配置属性；③使用@Service【暴露服务】使用@Reference【引用服务】。
 * 2）、①保留dubbo-xml配置文件；②导入dubbo-starter；③使用@ImportResource导入dubbo的配置文件即可。
 * 3）、①使用注解API的方式；②将每一组件手动创建到容器中；③让dubbo来扫描其他的组件。
 * @Author: OlinH 
 * @Date: 2020/3/15 
 *
 */
//@EnableDubbo  // 方式一：开启基于注解的dubbo功能
//@ImportResource(locations = "classpath:dubbo-provider.xml") // 方式二
@EnableDubbo(scanBasePackages = "git.olin.gmall")   // 方式三：@DubboComponentScan或者@EnableDubbo
@EnableHystrix // 开启服务容错
@SpringBootApplication
public class BootUserServiceProviderApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(BootUserServiceProviderApplication.class, args);
        System.out.println("服务已启动！");
        System.in.read();
    }
}
