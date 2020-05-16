package com.meyoustu.liangchengj.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author Liangcheng Juves
 * Created at 2020/05/16 17:11
 */
@SpringBootApplication
@ServletComponentScan
@RestController
@Configuration
public class WebsiteSpringbootApplication
        extends WebMvcConfigurationSupport {

    public static void main(String[] args) {
        SpringApplication.run(WebsiteSpringbootApplication.class, args);
    }


    @RequestMapping("/")
    public ModelAndView main() {
        return new ModelAndView("view/html/main.html");
    }


    @RequestMapping("/apks")
    public ModelAndView apks() {
        return new ModelAndView("view/html/apks.html");
    }

    @RequestMapping(value = "/onlinecv", produces = MediaType.APPLICATION_PDF_VALUE)
    public ModelAndView onlinecv() {
        return new ModelAndView("forward:/static/pdf/onlinecv.pdf");
    }


//    @RequestMapping("/e404")
//    public ModelAndView e404() {
//        return new ModelAndView("view/html/e404.html");
//    }


    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/");
        super.addResourceHandlers(registry);
    }


//    @Bean
//    public FilterRegistrationBean registrFilter() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        AntiTheftChainFilter antiTheftChainFilter = new AntiTheftChainFilter();
//        filterRegistrationBean.setFilter(antiTheftChainFilter);
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.setName(antiTheftChainFilter.getClass().getSimpleName());
//        filterRegistrationBean.setOrder(1);
//        return filterRegistrationBean;
//    }

}

