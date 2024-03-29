package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Http.*;

import models.*;
import models.users.*;

// this class returns a user id (email) if a user is logged in
// If not logged in redirect to login page
public class Secured extends Security.Authenticator {

    // Get the email (username) of the tlogged in user
    // null returned if no user logged in - onUnauthorized
    @Override
    public String getUsername(Context ctx) {
        return ctx.session().get("email");
    }

    // If not logged in then open the login page
    @Override
    public Result onUnauthorized(Context ctx) {
        return redirect(controllers.routes.LoginController.login());
    }
}