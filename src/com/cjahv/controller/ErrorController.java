package com.cjahv.controller;

import com.sshp.core.model.dto.result.ExceptionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 内容摘要 ：错误控制器
 * 创建人　 ：陈佳慧
 * 创建日期 ：2016年10月20日 15:30
 */
@Controller
public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController {
  private static final String PATH = "/error";

  private final ErrorAttributes errorAttributes;

  @Autowired
  public ErrorController(ErrorAttributes errorAttributes) {
    this.errorAttributes = errorAttributes;
  }

  @RequestMapping(value = PATH, consumes = "application/json")
  @ResponseBody
  public ExceptionResult errorJson(HttpServletRequest request) {
    return new ExceptionResult(getErrorAttributes(request, true));
  }

  @RequestMapping(value = PATH)
  @ResponseBody
  public String errorHtml() {
    return "<!DOCTYPE><html><head><title>:( UFO</title></head><body></body></html>";
  }

  @Override
  public String getErrorPath() {
    return PATH;
  }

  private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
    RequestAttributes requestAttributes = new ServletRequestAttributes(request);
    return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
  }

}
