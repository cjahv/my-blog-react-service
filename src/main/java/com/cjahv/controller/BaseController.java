package com.cjahv.controller;


import com.cjahv.model.constant.UserConstant;
import com.cjahv.model.entity.base.BaseEntity;
import com.cjahv.model.entity.User;
import com.cjahv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 内容摘要 ：
 * 创建人　 ：陈佳慧
 * 创建日期 ：2016年10月18日 11:13
 */
public abstract class BaseController<T extends BaseEntity> extends com.sshp.mcv.controller.BaseController<T> {
  private final UserService userService;

  @Autowired
  public BaseController(UserService userService) {
    this.userService = userService;
  }

  /**
   * 获取当前登录用户
   * @return User
   * @see User
   */
  protected User getUser() {
    return (User) session().getAttribute(UserConstant.SESSION_KEY);
  }
}
