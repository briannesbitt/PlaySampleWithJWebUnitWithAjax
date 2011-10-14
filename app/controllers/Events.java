package controllers;

import models.Event;
import models.JsonResponse;
import play.data.validation.Required;
import play.data.validation.Validation;
import play.mvc.Controller;

import java.util.List;

public class Events extends Controller
{
   public static void add(@Required String title)
   {
      if (Validation.hasErrors())
      {
         renderJSON(JsonResponse.createError(Validation.error("title").message()));
      }

      Event event = new Event(title);
      event.title = title;
      event.save();

      renderJSON(JsonResponse.createOk("Created Event with Id:" + event.id));
   }
   public static void list()
   {
      List<Event> events = Event.all().fetch();
      render(events);
   }
}