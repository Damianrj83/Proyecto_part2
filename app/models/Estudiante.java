package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Estudiante extends Model {

    @Id
    @Constraints.Min(10)
    public Long id;

    @Constraints.Required
    public String nombre;

	@Constraints.Required
    public String carnet;

	@Constraints.Required
	public String correo;

    public static Finder<Long, Estudiante> find = new Finder<Long,Estudiante>(Estudiante.class);
}
