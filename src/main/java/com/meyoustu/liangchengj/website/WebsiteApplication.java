package com.meyoustu.liangchengj.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author Liangcheng Juves
 * Created at 2020/5/14 17:12
 */
@SpringBootApplication
@Controller
@Configuration
public class WebsiteApplication extends WebMvcConfigurationSupport {

    public static void main(String[] args) {
        SpringApplication.run(WebsiteApplication.class, args);
    }


    @RequestMapping("/")
    public ModelAndView main() {
        return new ModelAndView("view/html/main.html");
    }


    @RequestMapping("/apks")
    public ModelAndView apks() {
        return new ModelAndView("view/html/apks.html");
    }

    @RequestMapping("/onlinecv")
    public ModelAndView onlinecv() {
        return new ModelAndView("forward:/static/pdf/onlinecv.pdf");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/");
        super.addResourceHandlers(registry);
    }
}
