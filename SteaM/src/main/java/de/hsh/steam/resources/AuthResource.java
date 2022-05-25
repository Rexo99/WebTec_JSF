
package de.hsh.steam.resources;

import de.hsh.steam.services.SteamService;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("auth")
@RequestScoped
public class AuthResource {

    public AuthResource() {
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authorize(LoginData data) {
        //SteamTest.initData(); 
        
        String user = data.getUsername();
        String pwd = data.getPwd();
        boolean valid = SteamService.getInstance().login(user, pwd);
        if (valid){
            System.out.println("user logged in: " + user);
            return Response.status(Response.Status.OK)
                .entity("user logged in: " + user)
                .build();
        }
        else {                 
            return Response.status(Response.Status.UNAUTHORIZED)
                .entity("user unauthorized: " + user)
                .build();
        }
    }
        
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(LoginData data) {
        boolean valid = SteamService.getInstance().login(data.getUsername(), data.getPwd());

        if (valid){
            MessageData md = new MessageData("user created in: ");
            System.out.println("user logged in " + data.getUsername());
            return Response.status(Response.Status.CREATED)
                .entity(md)
                .build();
        }
        else {                 
            MessageData md = new MessageData("user unauthorized: ");
            return Response.status(Response.Status.NOT_ACCEPTABLE)
                .entity(md)
                .build();
        } 
    }
}
