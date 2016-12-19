package controllers;

import java.util.Date;
import java.util.List;

import javax.inject.Singleton;

import models.Activity;
import models.Participation;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

@Singleton
public class ChoiceController extends Controller {

	/*private final Counter counter;

	@Inject
	public ChoiceController(Counter counter) {
		this.counter = counter;
	}*/
	public ChoiceController() {
	}

	public Result choice(String email) {
		Participation participation = Participation.find.where().eq("email", email).findUnique();
		if (participation == null) {
			List<Activity> activities = Activity.find.all();
			StringBuilder sb = new StringBuilder("Faites un choix parmi : \n");
			for (Activity activity : activities) {
				if (activity.date.after(new Date())){
					
					// calcul des places restantes
					int nbPlacesRestantes = activity.maxPlaces - activity.participants.size();
					if (nbPlacesRestantes >0){
						sb.append(activity.description).append(" (").append(nbPlacesRestantes).append(" places restantes)\n");
					}
				}
			}
			//return ok(sb.toString());
			return ok(makeChoice.render(sb.toString()));

		} else {
			Activity activity = participation.activity;
			StringBuilder sb = new StringBuilder("Voici ce que vous avez sélectionné :");
			sb.append(" : ").append(activity.description).append("\n");
			sb.append("le ").append(activity.date).append(", de ");
			sb.append(activity.beginTime).append(" à ");
			sb.append(activity.endTime).append("\n");
			sb.append("Nb places : ").append(activity.maxPlaces);
			//return ok(sb.toString());
			return ok(viewChoice.render(sb.toString()));
		}
	}

}
