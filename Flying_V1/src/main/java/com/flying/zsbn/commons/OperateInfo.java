/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.flying.zsbn.commons;

import java.io.Serializable;


public final class OperateInfo implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String sessionId;// SESSION ID
  protected String ip;// 登录IP
  protected String xForwardedFor;// X-Forwarded-For
  protected String userAgent;// USER-AGENT
  protected String browser;// 所用浏览器
  protected String browserVersion;// 所用浏览器版本
  protected String resolution;// 分辨率
  protected String os;// 操作系统

  protected String operateTarget; // 操作目标
  protected String searchKey; // 查询关键字
  protected java.util.Collection<Sort> sortList; // 排序方式

  public final String getSessionId() {
    return sessionId;
  }

  public final void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  public final String getIp() {
    return ip;
  }

  public final void setIp(String ip) {
    this.ip = ip;
  }

  public final String getxForwardedFor() {
    return xForwardedFor;
  }

  public final void setxForwardedFor(String xForwardedFor) {
    this.xForwardedFor = xForwardedFor;
  }

  public final String getUserAgent() {
    return userAgent;
  }

  public final void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }

  public final String getBrowser() {
    return browser;
  }

  public final void setBrowser(String browser) {
    this.browser = browser;
  }

  public final String getBrowserVersion() {
    return browserVersion;
  }

  public final void setBrowserVersion(String browserVersion) {
    this.browserVersion = browserVersion;
  }

  public final String getResolution() {
    return resolution;
  }

  public final void setResolution(String resolution) {
    this.resolution = resolution;
  }

  public final String getOs() {
    return os;
  }

  public final void setOs(String os) {
    this.os = os;
  }

  public final String getOperateTarget() {
    return operateTarget;
  }

  public final void setOperateTarget(String operateTarget) {
    this.operateTarget = operateTarget;
  }

  public final String getSearchKey() {
    return searchKey;
  }

  public final void setSearchKey(String searchKey) {
    this.searchKey = searchKey;
  }

  public final java.util.Collection<Sort> getSortList() {
    return sortList;
  }

  public final void setSortList(java.util.Collection<Sort> sortList) {
    this.sortList = sortList;
  }
}