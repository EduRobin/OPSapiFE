package cz.educanet.logreg;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    private UserManager userManager;
    @Inject
    private LoginManager loginManager;

    @POST
    public Response register(
            @FormParam("fullname") String fullname,
            @FormParam("username") String username,
            @FormParam("password") String password,
            @FormParam("email")     String email)
    {

        User tempUser = new User(fullname, username, email, password);

        if(userManager.existByUsername(username)) {
            return Response.status(Response.Status.valueOf("Tento uživatel už existuje")).build();
        } else {
            userManager.saveUser(tempUser);
            return Response.ok("Uživatel uspesne vytvořen").build();
        }
    }

    @POST
    public Response loginUser(
            @FormParam("username") String username,
            @FormParam("password") String password
    ) {
        User user = userManager.getUserLogin(username, password);
        if (user == null){
            return Response.status(Response.Status.BAD_REQUEST).entity("Špatnš zadáno").build();
        } else {
            loginManager.loggedUser = user;
            return Response.ok("uživatel se uspěšně přihlásil").build();
        }

    }

    @GET
    public Response getLoggedUser(){
        return Response.ok(loginManager.loggedUser).build();
    }
    @DELETE
    public Response logoutUser(){
        loginManager.loggedUser = null;
        return Response.ok("User logged out").build();
    }
}
