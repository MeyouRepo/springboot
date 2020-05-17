package com.meyoustu.liangchengj.website;

import org.junit.jupiter.api.Test;

import javax.servlet.annotation.ServletSecurity;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Liangcheng Juves
 * Created at 2020/05/17 11:41
 */
class WebsiteSpringbootApplicationTest {

    @Test
    void main() {
        System.err.println(ServletSecurity.TransportGuarantee.CONFIDENTIAL);
    }
}