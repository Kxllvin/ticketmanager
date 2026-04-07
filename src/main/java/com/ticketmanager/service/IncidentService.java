package com.ticketmanager.service;

import java.util.List;
import java.util.Optional;

import com.ticketmanager.model.Incident;
import com.ticketmanager.repository.IncidentRepository;

public class IncidentService {

    private IncidentRepository repository;

    public IncidentService() {
        this.repository = new IncidentRepository();
    }

    public void register(Incident incident){
        repository.save(incident);
    }

    public List<Incident> showAll() {
        return repository.findAll();
    }

    public Optional<Incident> showById(int id){
        return repository.findById(id);
    }

    public void remove(int id){
        repository.delete(id);
    }

}
