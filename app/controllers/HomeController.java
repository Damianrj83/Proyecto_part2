package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import play.data.Form;
import play.mvc.*;
import models.CreateAccount;
//import models.Login;
import play.data.FormFactory;
import play.data.validation.Constraints;
import views.html.*;
import controllers.ProfesionalController;
import controllers.EmpresaController;
import javax.swing.JOptionPane;



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
    boolean booleanTipo;
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
        } if(error2!=1) {//Si no tiene errores
            CreateAccount infoRegistro = pregForm.get();
            infoRegistro.save();
            pregForm = formFactory.form(CreateAccount.class);
          
              if(tipoUsuario(infoRegistro)){
                  
            return redirect(routes.ProfesionalController.crearMainGet());
            
            }else{
            
            return redirect(routes.EmpresaController.crearMainEmpresaGet());
            
            }
            
        }//Fin if error
        return ok(registro.render("Recepción de formulario correcto.", pregForm, routes.HomeController.crearRegistroPost()));//hacer un metodo que reemplace esto
    }
    
    //Login
    
    public Result crearSesionGet() {
        Form<CreateAccount> pregForm = formFactory.form(CreateAccount.class);
        return ok(login.render("Formulario", pregForm, routes.HomeController.crearSesionPost()));
    }

    public  Result crearSesionPost() {
        Form<CreateAccount> pregForm = formFactory.form(CreateAccount.class).bindFromRequest();
        if (pregForm.hasErrors()) {
             error1 =1;
            return badRequest(login.render("Encontramos errores", pregForm, routes.HomeController.index()));
            
        } if(error1!=1) {// Si no tiene errores
            CreateAccount preg = pregForm.get();
            boolean sesion;
          //CreateAccount.authenticate(preg.email, preg.contrasena);//devuelve true o false //Va y lo busca en la base de datos para comprobar las existencia del email y contrasena
          //   session(preg.email, preg.contrasena) ;
             //preg.save();//la informacion no se tiene que guardar sino se tiene que comparar, ya que al momento de Registrarse
             //esa accion ya se realizo, por tanto solo se autentica 
            pregForm = formFactory.form(CreateAccount.class);
            //preg.tipoUsuario.equals("");
            if(tipoUsuario(preg)){
            return redirect(routes.ProfesionalController.crearMainGet());
            
            }else{
            
            return redirect(routes.EmpresaController.crearMainEmpresaGet());
            
            }
            
        }
        return ok(login.render("Recepción de formulario correcto.", pregForm, routes.HomeController.crearSesionPost()));
        //la ventana login.scala.html va a recibir 3 parametros(String message, form(objeto), ruta)=
        //@(message: String,  searchForm: Form[CreateAccount], postUrl: play.api.mvc.Call)
        
    }//Fin 
    
    public boolean tipoUsuario(CreateAccount obj){
        //booleanTipo = false;
        if(obj.tipoUsuario.equals("Profesional")){
                 booleanTipo = true;           
        }else if(obj.tipoUsuario.equals("Empresa")){
            booleanTipo = false;
        }
        return booleanTipo;
    }///Fin tipoUsuario
    
    
//    public static Result sustitution(){
//    
//    return ok(registro.render("Recepción de formulario correcto.", pregForm, routes.HomeController.crearRegistroPost()));
//    }
    
}//Fin controller



   
 
