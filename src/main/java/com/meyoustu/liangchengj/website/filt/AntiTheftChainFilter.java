package com.meyoustu.liangchengj.website.filt;

import com.meyoustu.liangchengj.website.util.DateUtil;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Liangcheng Juves
 * Created at 2020/05/16 17:47
 */
@Order(1)
@WebFilter("/*")
public class AntiTheftChainFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        String reqUri = ((HttpServletRequest) servletRequest).getRequestURI();

        String[] protectSuffixes = {
                ".js", ".css", ".xml",
                ".json", ".ico", ".png",
                ".jpg", ".svg", ".jpeg",
                ".txt", ".vue", ".apk",
                ".exe", ".jdk", ".xz",
                ".html", ".htm", ".xls",
                ".xtd", ".java", ".class",
                ".cpp", ".c", ".go", ".dart",
                ".py"
        };

        int index = 0;
        for (String suffix : protectSuffixes) {
            index++;
            if (reqUri.endsWith(suffix) ||
                    reqUri.endsWith(suffix + "/") ||
                    (reqUri.contains(suffix) && reqUri.contains("?"))) {
                String headerName = "Referer";
                String referer = ((HttpServletRequest) servletRequest).getHeader(headerName);
                referer = referer == null ?
                        ((HttpServletRequest) servletRequest).getHeader(headerName.toLowerCase()) :
                        referer;

                if (referer != null) {
                    if (((HttpServletRequest) servletRequest).getRequestURL().toString().startsWith(referer)) {
                        filterChain.doFilter(servletRequest, servletResponse);
                    } else {
                        jsResp(servletResponse);
                    }
                } else {
                    jsResp(servletResponse);
                }

            } else if (index == protectSuffixes.length) {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }


    }


    private void jsResp(ServletResponse servletResponse)
            throws IOException {
        String js = "<!-- @author Liangcheng Juves -->" +
                "<!-- Created at " + DateUtil.format("yyyy/MM/dd HH:mm") + " -->" +
                "<script type=\"application/javascript\">" +
                "window.onload=function(){window.history.back();" +
                "alert('Sorry, you don\\'t have permission to do this!')}</script>";

        servletResponse.setContentType("text/html;charset=utf-8");
        OutputStream os = servletResponse.getOutputStream();
        os.write(js.getBytes());
        os.flush();
        os.close();
    }


}
