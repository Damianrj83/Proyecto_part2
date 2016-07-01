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
import models.Empresa;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class EmpresaController extends Controller {

    
    int error1;
    @Inject
    FormFactory formFactory;
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
   public Result crearMainEmpresaGet() {
        return ok(mainEmpresa.render("Formulario", routes.EmpresaController.crearMainEmpresaGet()));
    }
   
   
   public Result crearDescripcionGet(){
        Form<Empresa> empresaForm = formFactory.form(Empresa.class);
       return ok(descripcionEmpresa.render("Descripcion",empresaForm, routes.EmpresaController.crearDescripcionGet()));
   }///
   
   
   
   public Result crearDescripcionPost() {
        Form<Empresa> infoDescripcion = formFactory.form(Empresa.class).bindFromRequest();
        if (infoDescripcion.hasErrors()) {
            error1 =1;
            return badRequest(descripcionEmpresa.render("Encontramos errores", infoDescripcion, routes.EmpresaController.crearDescripcionGet()));
        } if(error1!=1) {//Si no tiene errores
            Empresa infoDescrip = infoDescripcion.get();
            infoDescrip.save();
            infoDescripcion = formFactory.form(Empresa.class);
        }//Fin if error
        return ok(descripcionEmpresa.render("Recepción de formulario correcto.", infoDescripcion, routes.EmpresaController.crearDescripcionPost()));//corregir, aqui va redirecc
    }///

}

