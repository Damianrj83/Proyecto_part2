/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author User
 */
import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Profesional extends Model {
    
    
    @OneToOne()
    @Constraints.Required
    public CreateAccount createAccount;
   // public Login login; nota: se borro el modelo Login, en caso de error restablecer
    
    
    @Id
    @Constraints.Min(10)
    public Long id;
    
    @Formats.DateTime(pattern="dd/MM/yyyy")
    public Date dueDate = new Date();
    
     @Constraints.Required
     public String cedula;
    
	@Constraints.Required
    public String nombre;

	@Constraints.Required
    public String apellido1;
    
        @Constraints.Required
    public String apellido2;
        
     @Constraints.Required
    public boolean genero;
     
//     @Constraints.Required
//    public String fechaNacimiento;
     
     @Constraints.Required
    public String nacionalidad;
     
     
      @Constraints.Required
    public String lugarResidencia;
      
      
    @Constraints.Required
    public String direccionExacta;
    
    
    @Constraints.Required
    public String telefono1;
    
    
    @Constraints.Required
    public String telefono2;
        
    
     @Constraints.Required
    public String nivelAcademico;
     
    @Constraints.Required
    public String tipoDeColegio;
    
    public String estudia;
    
    @Constraints.Required
    public String anoTitulo;
    
    @Constraints.Required
     public String nombreTitulo;
    
    
     @Constraints.Required
      public String institucionTitulo;
    
     public String salarioAspirar;
     
     public String residenciaPreferida;
     
     public String experienciaLaboral;


    public static Finder<Long, Profesional> find = new Finder<Long,Profesional>(Profesional.class);
}
