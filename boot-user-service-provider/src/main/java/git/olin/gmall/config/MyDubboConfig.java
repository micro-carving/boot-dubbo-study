package git.olin.gmall.config;

import com.alibaba.dubbo.config.*;
import git.olin.gmall.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: boot-dubbo-study
 * @description: this is a MyDubboConfig class
 * @author: OlinH
 * @create: 2020-03-17 17:32
 **/
@Configuration
public class MyDubboConfig {

    // <dubbo:application name="boot-user-service-provider"></dubbo:application>
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("boot-user-service-provider");
        return applicationConfig;
    }

    // <dubbo:registry  protocol="zookeeper" address="127.0.0.1:2181"></dubbo:registry>
    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("127.0.0.1:2181");
        return registryConfig;
    }

    // <dubbo:protocol name="dubbo" port="20880"></dubbo:protocol>
    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        return protocolConfig;
    }

   /*
       <dubbo:service interface="git.olin.gmall.service.UserService"
        ref="userServiceImpl_01" timeout="1000" version="1.0.0">
            <dubbo:method name="getUserAddressList" timeout="1000"></dubbo:method>
        </dubbo:service>
    */
   @Bean
   public ServiceConfig<UserService> userServiceConfig(UserService userService){
       ServiceConfig<UserService> serviceConfig = new ServiceConfig<>();
       serviceConfig.setInterface(UserService.class);
       serviceConfig.setRef(userService);
       serviceConfig.setVersion("1.0.0");

       // 配置每一个method的信息
       MethodConfig methodConfig = new MethodConfig();
       methodConfig.setName("getUserAddressList");
       methodConfig.setTimeout(1000);

       // 将method的设置保存到Service配置中
       List<MethodConfig> methods = new ArrayList<>();
       methods.add(methodConfig);
       serviceConfig.setMethods(methods);
       return  serviceConfig;
   }

   // <doubbo:monitor address="127.0.0.1:7070"></doubbo:monitor>
    @Bean
    public MonitorConfig monitorConfig(){
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setAddress("127.0.0.1:7070");
        return monitorConfig;
    }
}
