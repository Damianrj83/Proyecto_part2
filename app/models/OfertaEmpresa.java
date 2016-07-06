/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
    
 import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;


/**
 *
 * @author User
 */
@Entity
public class OfertaEmpresa extends Model {
    
    
    @Id
    @Constraints.Min(10)
    public Long id;
    
    public String cargo;
    
    @Constraints.Required
    public String empresa;
    
    public String descripcionEmpleo;
    
    public String referencia;
    
    @Constraints.Required
    public String tipoIndustria;
    
    public String categoria;
    
    @Constraints.Required
    public String nivel;
    
    public String personalACargo;
    
    public String vacantes;
    
    public String estudiosMinimos;
    
    @Constraints.Required
    public String experienciaMinima;
    
    public String requisitosMinimos;
    
    @Constraints.Required
    public String residenciaPreferencia;
    
    
    
     public static Finder<Long, OfertaEmpresa> find = new Finder<Long,OfertaEmpresa>(OfertaEmpresa.class);
}
