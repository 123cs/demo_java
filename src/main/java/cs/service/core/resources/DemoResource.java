package cs.service.core.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import vn.cs123.lib.auth.TokenInfoPOJO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("/demo")
public class DemoResource extends AbstractResource {
    @Context
    protected SecurityContext sc;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String demo() {

        TokenInfoPOJO tokenInfoPOJO = (TokenInfoPOJO) sc.getUserPrincipal();
        return "a";
    }

    @Path("auth")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String demoAuth(@Context SecurityContext sc) throws JsonProcessingException {
        TokenInfoPOJO tokenInfoPOJO = (TokenInfoPOJO) sc.getUserPrincipal();
        System.out.println(tokenInfoPOJO);
        return new ObjectMapper().writeValueAsString(tokenInfoPOJO.getTenants().get(0).getTenant_id());
    }



}
