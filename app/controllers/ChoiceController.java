package controllers;

import javax.inject.*;
import play.*;
import play.mvc.*;
import models.Participation;
import models.Activity;
import java.util.List;

import services.Counter;

/**
 * This controller demonstrates how to use dependency injection to
 * bind a component into a controller class. The class contains an
 * action that shows an incrementing count to users. The {@link Counter}
 * object is injected by the Guice dependency injection system.
 */
@Singleton
public class ChoiceController extends Controller {

    private final Counter counter;

    @Inject
    public ChoiceController(Counter counter) {
       this.counter = counter;
    }

    /**
     * An action that responds with the {@link Counter}'s current
     * count. The result is plain text. This action is mapped to
     * <code>GET</code> requests with a path of <code>/count</code>
     * requests by an entry in the <code>routes</code> config file.
     */
    public Result choice(String email) {
        /*List<Participation> participations = Participation.find.where()
        .ilike("email", email)
        .getList();*/
        // interroger la BDD
        // si email exite, choix déjà fait
    	//return ok(viewChoice.render("Voici ce que vous avez sélectionné :"+email));
    	//if (participations.)
    	return ok("Voici ce que vous avez sélectionné :"+email);
        // sinon
    	//return ok(views.html.makeChoice("Faites un choix."));
    }

}
