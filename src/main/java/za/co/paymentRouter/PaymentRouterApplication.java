package za.co.paymentRouter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
//@EntityScan
@EnableAutoConfiguration
@SpringBootApplication
public class PaymentRouterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentRouterApplication.class, args);
    }
}
