package com.cjahv.filter;

import com.sshp.mcv.filter.AbstractHttpFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 内容摘要 ：
 * 创建人　 ：陈佳慧
 * 创建日期 ：2016年10月25日 09:51
 */
public class UrlFilter extends AbstractHttpFilter {
  @Override
  public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
    String uri = request.getRequestURI();
    request.getHeader("Accept");
    if (uri.endsWith(".html")) request.getRequestDispatcher("/index.html").forward(request, response);
    else chain.doFilter(request, response);
  }
}
