/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.flying.zsbn.commons;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public final class SecurityContext implements Serializable {

  private static final long serialVersionUID = 1L;

  private SecurityContext() {
    super();
  }

  private final static ThreadLocal<OperateInfo> operateInfoThreadLocal = new ThreadLocal<OperateInfo>();
  private final static ThreadLocal<HttpServletRequest> requestThreadLocal = new ThreadLocal<HttpServletRequest>();

  public final static void setOperateInfo(OperateInfo operateInfo) {
    operateInfoThreadLocal.set(operateInfo);
  }

  public final static OperateInfo getOperateInfo() {
    return operateInfoThreadLocal.get();
  }

  public final static void removeOperateInfo() {
    operateInfoThreadLocal.remove();
  }

  public final static void setRequest(HttpServletRequest request) {
    requestThreadLocal.set(request);
  }

  public final static HttpServletRequest getRequest() {
    return requestThreadLocal.get();
  }

  public final static void removeRequest() {
    requestThreadLocal.remove();
  }

}