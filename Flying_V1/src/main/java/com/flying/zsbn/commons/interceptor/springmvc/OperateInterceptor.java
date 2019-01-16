package com.flying.zsbn.commons.interceptor.springmvc;

import com.flying.zsbn.commons.OperateInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.flying.zsbn.commons.OperateInfo;
import com.flying.zsbn.commons.SecurityContext;
import com.flying.zsbn.commons.Sort;
import eu.bitwalker.useragentutils.UserAgent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Type;
import java.util.Collection;

public class OperateInterceptor implements HandlerInterceptor {

  private static final Log log = LogFactory.getLog(OperateInterceptor.class);

  private static final Type SORT_TYPE = new TypeToken<Collection<Sort>>() {
  }.getType();
  private static final Gson GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

  @Override
  public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
    if (log.isInfoEnabled()) {
      log.info("+============================== OperateInterceptor start ==============================+");
    }
    SecurityContext.removeOperateInfo();
    SecurityContext.removeRequest();
    OperateInfo operateInfo = new OperateInfo();
    operateInfo.setSessionId(httpServletRequest.getSession().getId());
    String ip = httpServletRequest.getHeader("x-forwarded-for");
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = httpServletRequest.getHeader("Proxy-Client-IP");
    } else {
      operateInfo.setxForwardedFor(ip);
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = httpServletRequest.getHeader("WL-Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = httpServletRequest.getRemoteAddr();
    }
    operateInfo.setIp(ip);
    String agent = httpServletRequest.getHeader("user-agent");
    UserAgent userAgent = new UserAgent(agent);
    operateInfo.setUserAgent(agent);
    operateInfo.setBrowser(userAgent.getBrowser().getName());
    if (userAgent.getBrowserVersion() != null) {
      operateInfo.setBrowserVersion(userAgent.getBrowserVersion().toString());
    }
    operateInfo.setOs(userAgent.getOperatingSystem().getName());
    operateInfo.setResolution(httpServletRequest.getHeader("resolution"));

    operateInfo.setSearchKey(httpServletRequest.getParameter("searchKey"));
    operateInfo.setOperateTarget(httpServletRequest.getParameter("operateTarget"));
    String sort = httpServletRequest.getParameter("sort");
    if (sort != null && sort.trim().length() > 0) {
      Collection<Sort> sortList = GSON.fromJson(sort, SORT_TYPE);
      operateInfo.setSortList(sortList);
    }
    SecurityContext.setOperateInfo(operateInfo);
    SecurityContext.setRequest(httpServletRequest);
    if (log.isInfoEnabled()) {
      log.info("Operate info is : " + GSON.toJson(operateInfo));
      log.info("+============================== OperateInterceptor end ==============================+");
    }
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, ModelAndView modelAndView) throws Exception {
  }

  @Override
  public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) throws Exception {
  }
}
