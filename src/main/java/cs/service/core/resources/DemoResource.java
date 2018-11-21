package cs.service.core.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs.service.core.dto.DemoDTO;
import vn.cs123.lib.auth.TokenInfoPOJO;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.util.HashMap;
import java.util.Map;

@Path("/demo")
public class DemoResource extends AbstractResource {
    @Context
    protected SecurityContext sc;

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String demo() {
//
//        TokenInfoPOJO tokenInfoPOJO = (TokenInfoPOJO) sc.getUserPrincipal();
//        return "a";
//    }

    @Path("auth")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String demoAuth(@Context SecurityContext sc) throws JsonProcessingException {
        TokenInfoPOJO tokenInfoPOJO = (TokenInfoPOJO) sc.getUserPrincipal();
        System.out.println(tokenInfoPOJO);
        return new ObjectMapper().writeValueAsString(tokenInfoPOJO.getTenants().get(0).getTenant_id());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        Map<String, Object> mapValue = new HashMap<>();
        mapValue.put("a", 1);
        mapValue.put("b", "1111");
        return outputJson(100, mapValue);
    }

    @Path("/animal/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String updateById(DemoDTO bodyJson, @PathParam("id") int id) {
        return outputJson(id, bodyJson);
    }

    @Path("/animal")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String create(String bodyJson) {
        return outputJson(100, bodyJson);
    }

}
