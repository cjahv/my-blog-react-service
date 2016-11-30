package com.cjahv.model.entity.base;

import com.cjahv.model.entity.User;
import com.sshp.core.model.entity.FullEntityImpl;

import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * 基础详细实体
 * Created by jahv on 2016/11/14.
 */
@MappedSuperclass
public abstract class FullEntity extends BaseEntity implements FullEntityImpl<User> {
  private Date createDate;
  private Date modifyDate;
  private User createUser;
  private User modifyUser;

  @Override
  public Date getCreateDate() {
    return createDate;
  }

  @Override
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  @Override
  public Date getModifyDate() {
    return modifyDate;
  }

  @Override
  public void setModifyDate(Date modifyDate) {
    this.modifyDate = modifyDate;
  }

  @Override
  public User getCreateUser() {
    return createUser;
  }

  @Override
  public void setCreateUser(User createUser) {
    this.createUser = createUser;
  }

  @Override
  public User getModifyUser() {
    return modifyUser;
  }

  @Override
  public void setModifyUser(User modifyUser) {
    this.modifyUser = modifyUser;
  }

  @Override
  public Class<User> userClass() {
    return User.class;
  }
}
