/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class MainEmpresa extends Model {
    
    @Id
    @Constraints.Min(10)
    public Long id;


    public String buscar;

    public static Finder<Long, MainEmpresa> find = new Finder<Long,MainEmpresa>(MainEmpresa.class);
}