package alessiovulpinari.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Event")
public class Evento {
    @Id
    @GeneratedValue
    private long event_id;

    @Column(name = "Title")
    private String title;

    @Column(name = "eventDate")
    private LocalDate eventDate;

    @Column(name = "Description")
    private String description;

    @Column(name = "eventType")
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Column(name = "maxParticipants")
    private int maxParticipants;

    public Evento() {
    }

    public Evento(String title, LocalDate eventDate, String description, EventType eventType, int maxParticipants) {
        this.title = title;
        this.eventDate = eventDate;
        this.description = description;
        this.eventType = eventType;
        this.maxParticipants = maxParticipants;
    }

    public long getEvent_id() {
        return event_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "event_id=" + event_id +
                ", title='" + title + '\'' +
                ", eventDate=" + eventDate +
                ", description='" + description + '\'' +
                ", eventType=" + eventType +
                ", maxParticipants=" + maxParticipants +
                '}';
    }
}
