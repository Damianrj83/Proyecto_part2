package controllers;

import play.mvc.*;
import models.Estudiante;
import java.util.*;
import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class EstudianteController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
		List<Estudiante> estudiantes = Estudiante.find.all();
        return ok(estudiante.render("Esto Muestas al estudiante"));
    }

}
