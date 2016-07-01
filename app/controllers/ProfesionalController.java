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
import models.Cuenta;
import models.Profesional;
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

    int error1;
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
            Form<Profesional> profesionalForm = formFactory.form(Profesional.class);
        return ok(curriculumProfesional.render("Formulario", profesionalForm, routes.ProfesionalController.crearCurriculumGet()));
    }
      
      
    public Result crearCurriculumPost() {
        Form<Profesional> infoDescripcion = formFactory.form(Profesional.class).bindFromRequest();
        if (infoDescripcion.hasErrors()) {
            error1 =1;
            return badRequest(curriculumProfesional.render("Encontramos errores", infoDescripcion, routes.ProfesionalController.crearCurriculumGet()));
        } if(error1!=1) {//Si no tiene errores
            Profesional infoDescrip = infoDescripcion.get();
            infoDescrip.save();
            infoDescripcion = formFactory.form(Profesional.class);
        }//Fin if error
        return ok(curriculumProfesional.render("Recepción de formulario correcto.", infoDescripcion, routes.ProfesionalController.crearCurriculumPost()));//corregir, aqui va redirecc
    }  
      


      
//      public Result crearConfigCuentaGet() {
//        return ok(cuentaConfig.render("Formulario", routes.ProfesionalController.crearConfigCuentaGet()));
//    }

//      public Result crearCurriculumGet() {
//        return ok(redConfig.render("Formulario", routes.ProfesionalController.crearConfigRedGet()));
//    }     
  
    //@routes.ProfesionalController.crearCurriculumGet()
    
    
    
    //    public Result upload() {
//    MultipartFormData<File> body = request().body().asMultipartFormData();
//    FilePart<Cuenta> picture = body.getFile("picture");
//    if (picture != null) {
//        String fileName = picture.getFilename();
//        String contentType = picture.getContentType();
//        File file = picture.getFile();
//        return ok("File uploaded");
//    } else {
//        flash("error", "Missing file");
//        return badRequest();
//    }
}///Fin clase
