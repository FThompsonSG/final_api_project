package com.sparta.thespringsons.finalapiproject.model.entities;

import com.sparta.thespringsons.finalapiproject.model.fields.Location;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("theaters")
public class TheaterDTO {
    @Id
    String id;
    public Location location;
    public int theaterId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public TheaterDTO(String id, Location location, int theaterId) {
        this.id = id;
        this.location = location;
        this.theaterId = theaterId;
    }
}
