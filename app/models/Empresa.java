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
public class Empresa extends Model {
    
    @Id
    @Constraints.Min(10)
    public Long id;

	@Constraints.Required
    public String nombre;

	@Constraints.Required
    public String cfi;
    
        @Constraints.Required
    public String tipoEmpresa;
        
         @Constraints.Required
    public String descripcion;
        

    public static Finder<Long, Empresa> find = new Finder<Long,Empresa>(Empresa.class);
}

