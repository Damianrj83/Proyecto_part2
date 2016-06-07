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
    
    @Id
    @Constraints.Min(10)
    public Long id;

	@Constraints.Required
    public String nombre;

	@Constraints.Required
    public String apellido1;
    
        @Constraints.Required
    public String apellido2;
        
     @Constraints.Required
    public boolean genero;
     
     @Constraints.Required
    public String fechaNacimiento;
     
     
        
        

    public static Finder<Long, Profesional> find = new Finder<Long,Profesional>(Profesional.class);
}
