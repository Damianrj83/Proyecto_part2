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
        return ok(profesional.render("Formulario", profesionalForm, routes.ProfesionalController.crearCurriculumPost()));
    }
      
      
    public Result crearCurriculumPost() {
        Form<Profesional> descripForm = formFactory.form(Profesional.class).bindFromRequest();//variable del Form
        if (descripForm.hasErrors()) {
            error1 =1;
            return badRequest(profesional.render("Encontramos errores", descripForm, routes.ProfesionalController.crearCurriculumGet()));
        } else {//Si no tiene errores
            Profesional infoDescrip = descripForm.get();//Obtiene lo escrito en el Form qur fue almacenado en el Objeto
            infoDescrip.save();//Guarda la informacion en la varible
            descripForm = formFactory.form(Profesional.class);// Guarda la informacion del Formulario en el Objeto
        }//Fin if error
        return ok(profesional.render("Recepción de formulario correcto.", descripForm, routes.ProfesionalController.crearCurriculumPost()));//corregir, aqui va redirecc
    }  
      
//    
//    public static void show(Long id) {
//        Profesional profesional = Profesional.findById(id);
//        render("Informacion de Curriculum", descripForm,  );
//    }
//    
//    
     public Result mostrarCurriculum() {
        List<Profesional> curriculum = Profesional.find.all();

        return ok(mostrarCurriculum.render("Curriculum", curriculum));
    }
     
     
      public Result editarCurriculumGet(Long id) {
        Profesional instancia = Profesional.find.byId(id);
        Form<Profesional> pregForm = formFactory.form(Profesional.class).fill(instancia);
        return ok(profesional.render("Formulario de pregunta",pregForm, routes.ProfesionalController.editarCurriculumPost(id)));
    }

    public Result editarCurriculumPost(Long id) {
        Profesional instancia = Profesional.find.byId(id);
        Form<Profesional> pregForm = formFactory.form(Profesional.class).fill(instancia).bindFromRequest();

        if (pregForm.hasErrors()) {
            return badRequest(profesional.render("Encontramos errores", pregForm, routes.ProfesionalController.editarCurriculumPost(id)
            ));
        }
        
        Profesional preg = pregForm.get();
        instancia.cedula = preg.cedula;
        instancia.apellido1 = preg.apellido1;
        instancia.apellido2 = preg.apellido2;
        instancia.genero = preg.genero;
        instancia.save();
        return redirect(routes.ProfesionalController.mostrarCurriculum());
    }
    

      


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
