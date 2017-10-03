
package controllers;

import play.mvc.*;
import views.html.*;

public class ResultExampleController extends Controller {

    public Result result() {
        Result ok = ok("Hello world!");
        Result notFound = notFound();
        Result pageNotFound = notFound("<h1>Page not found</h1>").as("text/html");
     // Result badRequest = badRequest(views.html.form.render(formWithErrors));
        Result oops = internalServerError("Oops");
        Result anyStatus = status(488, "Strange response type");

     // return anyStatus;
     // return redirect("/count");
        return temporaryRedirect("/count");
    }

}
