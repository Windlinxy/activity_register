package com.bluemsun.filter;

import com.bluemsun.dto.JsonResult;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * CORS跨域过滤器
 *
 * @description: CORS跨域过滤器
 * @author: 姚斯腾
 * @create: 2021-10-08 14:22
 **/
public class LoginCheckFilter implements Filter {

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
        if(uri.contains("users/login") || uri.contains(".")){
            chain.doFilter(request, response);
        }else {
            HttpSession session = request.getSession();
            if(session.getAttribute(session.getId())!=null){
                chain.doFilter(request, response);
            }else {
                Map<String, Object> map = new HashMap<>();
                map.put("status", -1);
                map.put("msg", "未登录");
                PrintWriter out;
                String jsonString;
                try {
                    out = response.getWriter();
                    Gson gson = new Gson();
                    jsonString =  gson.toJson(map);
                    out.println(jsonString);
                    out.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


}
