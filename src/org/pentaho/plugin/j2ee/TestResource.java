/*
 * The MIT License
 * 
 * Copyright (c) 2011, Aaron Phillips
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.pentaho.plugin.j2ee;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;


@Component
@Path("/j2ee/api/test")
public class TestResource {

  @GET
  public String reply() throws Exception {
    return "<html>This is an html response</html>";
  }

  class TestJson {
    private String a = "This is a JSON response";

    private String b = "bsdf";

    public TestJson() {};

    public String getA() {
      return a;
    }

    public String getB() {
      return b;
    }

  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/json")
  public TestJson getJson() throws Exception {
    return new TestJson();
  }
  
  @POST
  public void doPost(String postBody) {
    System.out.println("doing POST with post body ["+postBody+"]");
  }
  
  @PUT
  public void doPut(String putBody) {
    System.out.println("doing PUT with put body ["+putBody+"]");
  }
  
  @DELETE
  public void doDelete() {
    System.out.println("Deleting test reosource");
  }
}
