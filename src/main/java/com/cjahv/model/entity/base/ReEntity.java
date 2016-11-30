package com.cjahv.model.entity.base;

import com.sshp.mcv.entity.ReEntityImpl;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 逻辑删除实体
 * Created by jahv on 2016/11/14.
 */
@MappedSuperclass
public abstract class ReEntity extends BaseEntity implements ReEntityImpl {
  private boolean deleteStatus;

  @Override
  @Column(name = "delete_status")
  public boolean getDeleteStatus() {
    return deleteStatus;
  }

  @Override
  public void setDeleteStatus(boolean deleteStatus) {
    this.deleteStatus = deleteStatus;
  }
}
