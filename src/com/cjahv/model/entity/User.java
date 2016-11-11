package com.cjahv.model.entity;

import javax.persistence.*;

/**
 * 内容摘要 ：用户实体
 * 创建人　 ：陈佳慧
 * 创建日期 ：2016年10月19日 17:45
 */
@Entity
@Table(name = "users")
public class User extends BaseEntity {
  private String email;
  private String username;
  private String password;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
