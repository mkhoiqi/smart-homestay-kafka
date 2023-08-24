package com.rzq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class PaymentApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(PaymentApp.class, args);
    }
}
