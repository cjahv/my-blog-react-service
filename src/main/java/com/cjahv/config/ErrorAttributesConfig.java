package com.cjahv.config;

import com.sshp.core.exception.SystemException;
import com.sshp.utils.Encrypt;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Date;
import java.util.Map;

/**
 * 内容摘要 ：统一异常属性处理
 * 创建人　 ：陈佳慧
 * 创建日期 ：2016年01月26日
 */
@Configuration
class ErrorAttributesConfig {
  @Value("${project.trace.pass}")
  private String pass;

  @Bean
  public DefaultErrorAttributes errorAttributes() {
    return new DefaultErrorAttributes() {
      @Override
      @SuppressWarnings("ThrowableResultOfMethodCallIgnored")
      public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> attributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
        Throwable error = super.getError(requestAttributes);
        if (error == null) {
          attributes.put("msg", "没有找到这个页面!");
        } else if (error instanceof SystemException) {
          attributes.put("msg", error.getMessage());
          attributes.put("type", ((SystemException) error).getType());
        } else if (error instanceof MissingServletRequestParameterException) {
          attributes.put("msg", "您必须传递参数[" + ((MissingServletRequestParameterException) error).getParameterName() + "]!");
        } else if (error instanceof HttpRequestMethodNotSupportedException) {
          attributes.put("msg", "不支持的调用方式[" + ((HttpRequestMethodNotSupportedException) error).getMethod() + "]");
        } else if (error instanceof MethodArgumentTypeMismatchException) {
          MethodArgumentTypeMismatchException exception = (MethodArgumentTypeMismatchException) error;
          if (exception.getRequiredType().equals(Date.class)) {
            attributes.put("msg", "无效的日期格式[" + exception.getValue() + "]");
          }
        }
        String code = (String) attributes.get("trace");
        if (StringUtils.isNotEmpty(code)) {
          StringBuilder buffer = new StringBuilder();
          for (int i = 0, j = 0; i < code.length(); i++, j = ++j % pass.length()) {
            buffer.append((char) (code.charAt(i) + pass.charAt(j)));
          }
          attributes.put("trace", Encrypt.base64Encode(buffer.toString()));
        }
        return attributes;
      }
    };
  }
}
