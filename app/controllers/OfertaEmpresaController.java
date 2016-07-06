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
import models.CreateAccount;
import models.OfertaEmpresa;
//import models.Login;
import play.data.FormFactory;
import play.data.validation.Constraints;
import views.html.*;

/**
 *
 * @author User
 */
public class OfertaEmpresaController extends Controller{
   
   @Inject
    FormFactory formFactory;
   
   int error1;
   
   public Result crearOfertaGet() {
        Form<OfertaEmpresa> ofertaForm = formFactory.form(OfertaEmpresa.class);
        return ok(ofertaEmpresa.render("Formulario", ofertaForm, routes.OfertaEmpresaController.crearOfertaPost()));
    }
   
   
   public Result crearOfertaPost() {
        Form<OfertaEmpresa> ofertaForm = formFactory.form(OfertaEmpresa.class).bindFromRequest();//variable del Form
        if (ofertaForm.hasErrors()) {
            error1 =1;
            return badRequest(ofertaEmpresa.render("Encontramos errores", ofertaForm, routes.OfertaEmpresaController.crearOfertaGet()));
        } else {//Si no tiene errores
            OfertaEmpresa infoDescrip = ofertaForm.get();//Obtiene lo escrito en el Form qur fue almacenado en el Objeto
            infoDescrip.save();//Guarda la informacion en la varible
            ofertaForm = formFactory.form(OfertaEmpresa.class);// Guarda la informacion del Formulario en el Objeto
        }//Fin if error
        return ok(ofertaEmpresa.render("Recepción de formulario correcto.", ofertaForm, routes.OfertaEmpresaController.crearOfertaPost()));//corregir, aqui va redirecc
    }  
   
   
   
   
    
    
}//Fin clase
