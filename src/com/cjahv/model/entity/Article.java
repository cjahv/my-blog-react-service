package com.cjahv.model.entity;

import com.cjahv.model.entity.base.FullReEntity;
import com.cjahv.model.entity.base.ReEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 文章实体
 * Created by jahv on 2016/11/14.
 */
@Entity
@Table(name = "article")
public class Article extends FullReEntity {
  private String title;
  private String content;
}
