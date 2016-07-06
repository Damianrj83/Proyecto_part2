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
//import play.db.ebean.Model;

@Entity
public class CreateAccount extends Model {
    
    @Id
    @Constraints.Min(10)
    public Long id;
    
    
    
       @Constraints.Required
//       @MinLenght(6)
//       @MaxLenght(20)
       public String contrasena;

	@Constraints.Required
    public String email;
    
   
    public String tipoUsuario;
        
         public static CreateAccount authenticate(String email, String pass) {
        CreateAccount createAccount = find.where().eq("email", email).findUnique();
        if (createAccount != null) {
            if (pass== createAccount.contrasena) {
                return createAccount;
            }
        }
        return null;
     }//Fin auth

    public static Finder<Long, CreateAccount> find = new Finder<Long,CreateAccount>(CreateAccount.class);
}
