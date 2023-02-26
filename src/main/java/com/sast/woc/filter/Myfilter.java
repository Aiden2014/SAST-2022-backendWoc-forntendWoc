package com.sast.woc.filter;

import com.auth0.jwt.interfaces.Claim;
import com.sast.woc.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

//过滤器
@Slf4j
public class Myfilter implements Filter {
    private String[] noFilters;
    @Override
    public void init(FilterConfig filterConfig){
        log.info("启动过滤器");
        // 初始化不过滤的路径
        String noFilter = filterConfig.getInitParameter("noFilter");
        if(noFilter != null && noFilter.length() > 0){
            noFilters = noFilter.split(",");
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        //如果这个路径是过滤路径则直接返回
        if (isFilter(request)){
            log.info("{}不需要过滤",request.getRequestURI());
            System.out.println(servletRequest.getParameter("userName"));
            filterChain.doFilter(servletRequest,servletResponse);
            System.out.println(request.getParameter("password"));
        }else{
            try {
            final HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.setHeader("Access-Control-Allow-Headers", "token, Origin, X-Requested-With, Content-Type, Accept");//告诉前端 CORS 的设置，允许访问token
            //获取token
            String token = request.getHeader("Token");
            if(token == null || token.isEmpty()){
                throw new RuntimeException("token不能为空");
            }
            Map<String, Claim> userData = JwtUtil.valifyToken(token);
            if(userData == null){
                throw new RuntimeException("token不合法");
            }
                String name = userData.get("userName").asString();
                Integer role = userData.get("role").asInt();
                ServletRequestWrapper requestWrapper = new ServletRequestWrapper(servletRequest);
                if(role == 0&&(!request.getRequestURI().equals("/admin/find_user_info")||(request.getRequestURI().equals("/admin/find_user_info")&&!requestWrapper.getParameter("userName").equals(name)))){
                    throw new RuntimeException("无权限");//过滤普通用户和管理员
                }
                filterChain.doFilter(servletRequest, servletResponse);
            } catch (RuntimeException e) {
                servletRequest.setAttribute("filter.error",e);
                request.getRequestDispatcher("/error/errorToken").forward(servletRequest,servletResponse);//过滤器向控制器抛出异常从而让拦截器接受到并统一返回格式
            }
        }

    }

    //判断RUL是否包含不过滤路径
    public boolean isFilter(HttpServletRequest request){
        String requestURI = request.getRequestURI();
        for (String noFilter : noFilters){
            if(requestURI.contains(noFilter)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy(){
        jakarta.servlet.Filter.super.destroy();
        log.info("终止");
    }
}
