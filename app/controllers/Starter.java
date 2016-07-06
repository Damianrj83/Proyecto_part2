/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.HashMap;
//import java.util.Map;
//
//import com.lowagie.text.DocumentException;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import play.data.Form;
import play.mvc.*;


import play.data.FormFactory;
import play.data.validation.Constraints;
import views.html.*;
import models.Profesional;
/**
 *
 * @author User
 */

@Inject
FormFactory formFactory;

public class Starter extends Controller {
    


//	public static void main(String[] args) throws FileNotFoundException, DocumentException {
//		PDFGenerator gen = new PDFGenerator("templates/", ".html");
//
//		Map<String, Object> model = new HashMap<>();
//		model.put("message", "Hallo Welt!");
//
//		gen.generate(new File("/tmp/test.pdf"), "profesional.scala", model);
//	}

}