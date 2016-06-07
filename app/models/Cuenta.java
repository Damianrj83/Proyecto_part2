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
public class Cuenta extends Model {
    
    @Id
    @Constraints.Min(10)
    public Long id;

	@Constraints.Required
    public String contrasenaActual;

	@Constraints.Required
    public String nuevaContrasena;
    
        @Constraints.Required
    public String repetir;
        
       
    public static Finder<Long, Cuenta> find = new Finder<Long,Cuenta>(Cuenta.class);
}

