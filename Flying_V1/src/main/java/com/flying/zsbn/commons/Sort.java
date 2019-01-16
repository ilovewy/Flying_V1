/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.flying.zsbn.commons;

import java.io.Serializable;

/**
 * 排序参数类
 *
 */
public final class Sort implements Serializable {

  private static final long serialVersionUID = 1L;

  public Sort() {
    super();
  }

  public Sort(String property, String direction) {
    super();
    this.property = property;
    this.direction = direction;
  }

  private String direction;
  private String property;

  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public String getProperty() {
    return property;
  }

  public void setProperty(String property) {
    this.property = property;
  }

  public boolean isDesc() {
    return "DESC".equalsIgnoreCase(direction);
  }

  public boolean isAsc() {
    return "ASC".equalsIgnoreCase(direction) || !"DESC".equalsIgnoreCase(direction);
  }

  @Override
  public String toString() {
    return "Sort [direction=" + direction + ", property=" + property + "]";
  }

}