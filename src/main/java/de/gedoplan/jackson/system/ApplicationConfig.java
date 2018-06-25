package de.gedoplan.jackson.system;

import io.swagger.jaxrs.config.BeanConfig;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author GEDOPLAN, Dominik Mathmann
 */
@ApplicationPath("/webresources")
public class ApplicationConfig extends Application {

  public ApplicationConfig() {
    BeanConfig beanConfig = new BeanConfig();
    beanConfig.setVersion("1.0.0");
    beanConfig.setSchemes(new String[] { "http" });
    beanConfig.setTitle("jackson-resolver");
    beanConfig.setHost("localhost:8080");
    beanConfig.setBasePath("/webresources");
    beanConfig.setResourcePackage("de.gedoplan.jackson.resource");
    beanConfig.setScan(true);
  }
}
