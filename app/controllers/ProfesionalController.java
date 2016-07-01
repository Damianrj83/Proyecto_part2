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


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ProfesionalController extends Controller {

    @Inject
    FormFactory formFactory;
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
  
    //Main
     public Result crearMainGet() {
        return ok(mainProfesional.render("Formulario", routes.ProfesionalController.crearMainGet()));
    }
     
      public Result crearCurriculumGet() {
        return ok(curriculumProfesional.render("Formulario", routes.ProfesionalController.crearCurriculumGet()));
    }
      
      
//      public Result crearConfigCuentaGet() {
//        return ok(cuentaConfig.render("Formulario", routes.ProfesionalController.crearConfigCuentaGet()));
//    }

//      public Result crearCurriculumGet() {
//        return ok(redConfig.render("Formulario", routes.ProfesionalController.crearConfigRedGet()));
//    }     
  
    //@routes.ProfesionalController.crearCurriculumGet()
}
