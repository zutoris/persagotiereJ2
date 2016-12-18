package models;

import java.sql.Time;
import java.sql.Date;
import com.avaje.ebean.Model;
import javax.persistence.*;

@Entity
public class Participation extends Model {

    @Id
    public int id;
    public String email;
    public Activity activity;
    
    public static Finder<Integer, Participation> find = new Finder<Integer,Participation>(Participation.class);
}
