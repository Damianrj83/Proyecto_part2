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
//import javax.naming.spi.DirStateFactory.Result;
import play.data.Form;
import play.mvc.*;
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
   
   
     public Result listarOfertas() {
        List<OfertaEmpresa> ofertas = OfertaEmpresa.find.all();

        return ok(ofertaPublicada.render("Listado de ofertas", ofertas));
    }
   
     
//      public Result editarOfertaGet(Long id) {
//        OfertaEmpresa instancia = OfertaEmpresa.find.byId(id);
//        Form<Pregunta> pregForm = formFactory.form(OfertaEmpresa.class).fill(instancia);
//        return ok(ofertaEmpresa.render("Formulario de oferta",
//                pregForm, routes.OfertaEmpresaController.editarOfertaPost(id)));
//    }
//
//    public Result editarOfertaPost(Long id) {
//        OfertaEmpresa instancia = OfertaEmpresa.find.byId(id);
//        Form<OfertaEmpresa> pregForm = formFactory.form(OfertaEmpresa.class
//        ).fill(instancia).bindFromRequest();
//
//        if (pregForm.hasErrors()) {
//            return badRequest(ofertaEmpresa.render(
//                    "Encontramos errores", pregForm,
//                    routes.OfertaEmpresaController.editarOfertaPost(id)
//            ));
//        }
//        
//        OfertaEmpresa preg = pregForm.get();
//        instancia.cargo = preg.cargo;
//        instancia.tipo = preg.tipo;
//        instancia.requerida = preg.requerida;
//        instancia.textoAyuda = preg.textoAyuda;
//        instancia.save();
//        return redirect(routes.OfertaEmpresaController.listarOfertas());
//    }
    
    
}//Fin clase
