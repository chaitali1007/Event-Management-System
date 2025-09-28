package com.campus.model;
import java.sql.Date;
import java.sql.Time;

public class Event {
    private int eventId, capacity, createdBy;
    private String title, description, venue;
    private Date eventDate;
    private Time eventTime;

    public int getEventId(){return eventId;} public void setEventId(int eventId){this.eventId=eventId;}
    public int getCapacity(){return capacity;} public void setCapacity(int capacity){this.capacity=capacity;}
    public int getCreatedBy(){return createdBy;} public void setCreatedBy(int createdBy){this.createdBy=createdBy;}
    public String getTitle(){return title;} public void setTitle(String title){this.title=title;}
    public String getDescription(){return description;} public void setDescription(String description){this.description=description;}
    public String getVenue(){return venue;} public void setVenue(String venue){this.venue=venue;}
    public Date getEventDate(){return eventDate;} public void setEventDate(Date eventDate){this.eventDate=eventDate;}
    public Time getEventTime(){return eventTime;} public void setEventTime(Time eventTime){this.eventTime=eventTime;}
}
