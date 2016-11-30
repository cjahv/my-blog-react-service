package com.cjahv.config;

import com.cjahv.filter.UrlFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * 内容摘要 ：
 * 创建人　 ：陈佳慧
 * 创建日期 ：16/8/24
 */
@Configuration
public class FilterConfig {

  @Bean
  public Filter urlFilter() {
    return new UrlFilter();
  }
}
