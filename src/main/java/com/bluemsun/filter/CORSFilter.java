package com.bluemsun.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CORS跨域过滤器
 *
 * @description: CORS跨域过滤器
 * @author: 姚斯腾
 * @create: 2021-10-08 14:22
 **/
public class CORSFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String uri = request.getRequestURI();
        //允许跨域的域名。单个域名、*(匹配所有域名)
        //request.getHeader("Origin") 即直接获取请求头的origin的值，即请求方的域名
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));

        //若要使用cookie，需要设置值为true，表示允许发送cookie（可选）
        response.setHeader("Access-Control-Allow-Credentials", "true");

        //服务器支持的所有请求头字段
        response.setHeader("Access-Control-Allow-Headers",
                "Origin," +
                        "Access-Control-Request-Headers," +
                        "Access-Control-Allow-Headers," +
                        "Content-Type," +
                        "Keep-Alive," +
                        "User-Agent," +
                        "Cache-Control," +
                        "Cookie," +
                        "DNT," +
                        "X-Requested-With," +
                        "X-Mx-ReqToken," +
                        "X-Requested-With," +
                        "If-Modified-Since," +
                        "Accept," +
                        "Connection," +
                        "X-XSRF-TOKEN," +
                        "X-CSRF-TOKEN," +
                        "Authorization");

        //（预检请求）的响应结果，规定了服务器允许客户端使用的请求方法， 如：POST, GET 和 OPTIONS
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE, PATCH");

        //设置（预检请求）的返回结果的过期时间，这里设置响应最大有效时间为 86400 秒，即24 小时
        //即 Access-Control-Allow-Methods 和Access-Control-Allow-Headers 提供的信息可以被缓存多久
        response.setHeader("Access-Control-Max-Age", "86400");

        //设置除了简单响应首部以外，需要暴露给外部的其他首部
        response.setHeader("Access-Control-Expose-Headers", "Authorization");

        chain.doFilter(request, response);
    }


}
