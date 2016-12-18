package models;

import java.sql.Time;
import java.sql.Date;
import com.avaje.ebean.Model;
import javax.persistence.*;

@Entity
public class Activity extends Model {
    @Id
    public Integer id;
    public Date date;
    public Time beginTime;
    public Time endTime;
    public int maxPlaces;
    public String description;
    
    public static Finder<Integer, Activity> find = new Finder<Integer,Activity>(Activity.class);
}