package org.pentaho.plugin.j2ee;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Path("/j2ee/api/test")
public class TestResource {

  private static final Log log = LogFactory.getLog(TestResource.class);

  @GET
  public String reply() throws Exception {
    return "<html>It works!</html>";
  }

}
