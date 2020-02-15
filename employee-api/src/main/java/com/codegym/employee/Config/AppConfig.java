package com.codegym.employee.Config;

import com.codegym.employee.Service.EmployeeService;
import com.codegym.employee.Service.impl.EmployeeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {
    @Bean
    public EmployeeService employeeService(){
        return new EmployeeServiceImpl();
    }
}
