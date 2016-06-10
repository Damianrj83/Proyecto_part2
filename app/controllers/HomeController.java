package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import play.data.Form;
import play.mvc.*;
import models.CreateAccount;
import models.Login;
import play.data.FormFactory;
import play.data.validation.Constraints;
import views.html.*;
import controllers.ProfesionalController;
import controllers.EmpresaController;
import controllers.CurriculumProfesionalController;


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
    int error1;
    int error2;
    CreateAccount crearCuenta;
    public Result index() {
        return ok(index.render("LINK-JOB"));
    }
    
    //CreateAccount
     public Result crearRegistroGet() {
        Form<CreateAccount> pregForm = formFactory.form(CreateAccount.class);
        return ok(registro.render("Formulario", pregForm, routes.HomeController.crearRegistroPost()));
    }

    public Result crearRegistroPost() {
        Form<CreateAccount> pregForm = formFactory.form(CreateAccount.class).bindFromRequest();
        if (pregForm.hasErrors()) {
            error2 =1;
            return badRequest(registro.render("Encontramos errores", pregForm, routes.HomeController.index()));
        } if(error2!=1) {
            CreateAccount preg = pregForm.get();
            preg.save();
            pregForm = formFactory.form(CreateAccount.class);
            //IF para comprobar el tipoUsuario
           
//            if(crearCuenta.tipoUsuario == "Profesional"){
//                //AQUI VA REDIRECCIONAMIENTO
//                return redirect(routes.ProfesionalController.crearMainGet());
//            }if(crearCuenta.tipoUsuario == "Empresa"){
//                //AQUI VA REDIRECCIONAMIENTO
//                return redirect(routes.EmpresaController.crearMainEmpresaGet());
//            }
            //AQUI VA REDIRECCIONAMIENTO, redireccionar a 
        }//Fin if error
        return ok(registro.render("Recepción de formulario correcto.", pregForm, routes.HomeController.crearRegistroPost()));
    }
    
    //Login
    
    public Result crearSesionGet() {
        Form<Login> pregForm = formFactory.form(Login.class);
        return ok(login.render("Formulario", pregForm, routes.HomeController.crearSesionPost()));
    }

    public Result crearSesionPost() {
        Form<Login> pregForm = formFactory.form(Login.class).bindFromRequest();
        if (pregForm.hasErrors()) {
             error1 =1;
            return badRequest(login.render("Encontramos errores", pregForm, routes.HomeController.index()));
            
        } if(error1!=1) {
            Login preg = pregForm.get();
            preg.save();
            pregForm = formFactory.form(Login.class);
            //AQUI VA REDIRECCIONAMIENTO, redireccionar a 
            return redirect(routes.CurriculumProfesionalController.crearCurriculumProfesionalGet());//routes.ProfesionalController.crearMainGet() aqui va
        }
        return ok(login.render("Recepción de formulario correcto.", pregForm, routes.HomeController.crearSesionPost()));
        //la ventana login.scala.html va a recibir 3 parametros(String message, form(objeto), ruta)=
        //@(message: String,  searchForm: Form[CreateAccount], postUrl: play.api.mvc.Call)
    }
    
    
    

}
