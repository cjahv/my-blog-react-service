package com.cjahv.service;

import com.cjahv.model.entity.User;
import com.sshp.mcv.service.BaseService;

/**
 * 用户服务
 * Created by jahv on 2016/11/11.
 */
public class UserService extends BaseService<User> {

  /**
   * 登录用户操作
   * @param name 用户名或邮箱
   * @param pass 用户密码
   * @return 错误消息 [null:登录成功]
   */
  public String login(String name,String pass) {
    return null;
  }
}
