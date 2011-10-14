package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Event extends Model
{
   public String title;

   public Event(String title)
   {
      this.title = title;
   }
}