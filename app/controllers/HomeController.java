package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import play.data.Form;
import play.mvc.*;
import models.CreateAccount;
import play.data.FormFactory;
import play.data.validation.Constraints;
import views.html.*;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    @Inject
    FormFactory formFactory;
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    
     public Result crearRegistroGet() {
        Form<CreateAccount> pregForm = formFactory.form(CreateAccount.class);
        return ok(registro.render("Formulario de pregunta", pregForm, routes.HomeController.crearRegistroPost()));
    }

    public Result crearRegistroPost() {
        Form<CreateAccount> pregForm = formFactory.form(CreateAccount.class).bindFromRequest();
        if (pregForm.hasErrors()) {
            return badRequest(registro.render("Encontramos errores",
                    pregForm, routes.HomeController.index()));
        } else {
            CreateAccount preg = pregForm.get();
            preg.save();
            pregForm = formFactory.form(CreateAccount.class);
        }
        return ok(registro.render("Recepción de formulario correcto.", pregForm,
                routes.HomeController.crearRegistroPost()));
    }

}
