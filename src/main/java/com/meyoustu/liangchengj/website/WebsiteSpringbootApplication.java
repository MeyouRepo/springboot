package com.meyoustu.liangchengj.website;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.annotation.ServletSecurity;

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


    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tswsf = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint sc = new SecurityConstraint();
                sc.setUserConstraint(String.valueOf(ServletSecurity.TransportGuarantee.CONFIDENTIAL));

                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                collection.setName("SSL");

                sc.addCollection(collection);
                context.addConstraint(sc);
            }
        };
        tswsf.addAdditionalTomcatConnectors(httpConnector());
        return tswsf;
    }


    @Bean
    public Connector httpConnector() {
        Connector connector = new Connector(/*Http2Protocol.class.getName()*/
                /*"org.apache.coyote.http2.Http2Protocol"*/
                /*Http11NioProtocol.class.getName()*/
                "org.apache.coyote.http11.Http11NioProtocol"
        );
        connector.setScheme("http");
        connector.setPort(80);
        connector.setSecure(false);
        connector.setRedirectPort(443);
        return connector;
    }

}

