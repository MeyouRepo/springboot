//package com.meyoustu.liangchengj.website.controll;
//
//import org.springframework.boot.web.server.ErrorPage;
//import org.springframework.boot.web.server.ErrorPageRegistrar;
//import org.springframework.boot.web.server.ErrorPageRegistry;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//
///**
// * @author Liangcheng Juves
// * Created at 2020/05/16 20:00
// */
//@Configuration
//public class ErrorPageController implements ErrorPageRegistrar {
//    @Override
//    public void registerErrorPages(ErrorPageRegistry registry) {
//        ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND, "/e404");
//        registry.addErrorPages(e404);
//    }
//}
