package git.olin.gmall;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import java.io.IOException;

@EnableDubbo
@EnableHystrix
@SpringBootApplication
public class BootOrderWebConsumerApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(BootOrderWebConsumerApplication.class, args);
		System.out.println("远程调用已完成！");
		System.in.read();
	}

}
