package models;

import java.sql.Time;
import java.util.LinkedList;
import java.util.List;
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
    @OneToMany
    public List<Participation> participants = new LinkedList<Participation>();
    
    public static Finder<Integer, Activity> find = new Finder<Integer,Activity>(Activity.class);
    
    @Override
    public String toString(){
    	StringBuilder sb = new StringBuilder();
		sb.append(description);
		sb.append(", le ").append(date).append(", de ");
		sb.append(beginTime).append(" à ");
		sb.append(endTime).append(". \n");
		sb.append("Nb places : ").append(maxPlaces);
    	return "";
    };
}