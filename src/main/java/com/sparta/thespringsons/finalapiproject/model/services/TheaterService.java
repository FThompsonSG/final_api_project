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

    public Optional<Theater> getTheaterById(String id) {
        return theatersRepository.findById(id);
    }

    public List<Theater> getTheatersByZipcode(String zipcode) {
        List<Theater> zipcodesList = getAllTheaters().stream()
                .filter(theater -> theater.getLocation().getAddress().getZipcode().contains(zipcode))
                .toList();
        return zipcodesList;
    }

    public Theater saveTheater(Theater theater) throws Exception {
        try {
            theatersRepository.save(theater);
            return theater;
        } catch (Exception e) {
            throw new Exception("Failed to save theater - invalid args");
        }
    }

    public Theater updateTheater(Theater theater, Integer theater_id) throws Exception {
            Optional<Theater> retrievedTheater = getTheaterByTheaterId(theater_id);
            if (retrievedTheater.isEmpty()) {
                throw new Exception("Theater ID cannot be found");
            } else {
                Theater theaterToUpdate = retrievedTheater.get();
                theaterToUpdate = theater;
                theaterToUpdate.setTheaterId(theater_id);
                theatersRepository.save(theaterToUpdate);
                return theaterToUpdate;
            }
    }

    public String deleteTheater(Integer theater_id) throws Exception {
        Optional<Theater> theater = theatersRepository.getTheaterByTheaterId(theater_id);

        if (theater.isEmpty()) {
            throw new Exception("No theater found for given ID.");
        } else {
            theatersRepository.delete(theater.get());
            return "Theater deleted";
        }

    }

}