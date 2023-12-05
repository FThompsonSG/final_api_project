package com.sparta.thespringsons.finalapiproject.model.services;

import com.sparta.thespringsons.finalapiproject.model.entities.Theater;
import com.sparta.thespringsons.finalapiproject.model.repositories.TheatersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {

    private final TheatersRepository theatersRepository;

    @Autowired
    public TheaterService(TheatersRepository theatersRepository) {
        this.theatersRepository = theatersRepository;
    }

    public List<Theater> getAllTheaters() {
        return theatersRepository.findAll();
    }

    public Optional<Theater> getTheaterByTheaterId(int theater_id) {
        return theatersRepository.getTheaterByTheaterId(theater_id);
    }

    public String saveTheater(Theater theater) {
        try {
            theatersRepository.save(theater);
            return "Saved";
        } catch (Exception e) {
            return "Failed to save";
        }
    }

}
