package org.pentaho.plugin.j2ee;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.EnumerationUtils;

public class MutableServletConfig implements ServletConfig {
  
  private String servletName;
  private Hashtable initParams;
  
  public MutableServletConfig(String servletName) {
    this.servletName = servletName;
  }
  
  public void setInitParameters(Map<String, String> params) {
    initParams = new Hashtable(params);
  }
  
  @Override
  public String getInitParameter(String name) {
    String value = (String)initParams.get(name);
    System.err.println("getting ["+name+"] value = ["+value+"]");
    return value;
  }

  @Override
  public Enumeration getInitParameterNames() {
    for (Object paramName : EnumerationUtils.toList(initParams.keys())) {
      System.err.println(paramName);
    }
    return initParams.keys();
  }

  @Override
  public ServletContext getServletContext() {
    return null;
  }

  @Override
  public String getServletName() {
    return servletName;
  }
}
