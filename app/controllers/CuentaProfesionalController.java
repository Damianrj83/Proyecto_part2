/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import play.data.Form;
import play.mvc.*;
import play.data.FormFactory;
import play.data.validation.Constraints;
import views.html.*;
import models.Cuenta;



/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class CuentaProfesionalController extends Controller {

    
    int error1;
    @Inject
    FormFactory formFactory;
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    
          public Result crearConfigCuentaGet() {
              Form<Cuenta> cuentaForm = formFactory.form(Cuenta.class);
        return ok(cuentaConfig.render("Formulario",cuentaForm, routes.CuentaProfesionalController.crearConfigCuentaPost()));
    }
          
          
          public Result crearConfigCuentaPost() {
        Form<Cuenta> cuentaForm = formFactory.form(Cuenta.class).bindFromRequest();//variable del Form
        if (cuentaForm.hasErrors()) {
            error1 =1;
            return badRequest(cuentaConfig.render("Encontramos errores", cuentaForm, routes.CuentaProfesionalController.crearConfigCuentaGet()));
        } if(error1!=1) {//Si no tiene errores
            Cuenta infoForm = cuentaForm.get();//Obtiene lo escrito en el Form qur fue almacenado en el Objeto
            infoForm.save();//Guarda la informacion en la varible
            cuentaForm = formFactory.form(Cuenta.class);// Guarda la informacion del Formulario en el Objeto
        }//Fin if error
        return ok(cuentaConfig.render("Cambio de contrasena correcta correcto.", cuentaForm, routes.CuentaProfesionalController.crearConfigCuentaPost()));//corregir, aqui va redirecc
    }  
   
}

