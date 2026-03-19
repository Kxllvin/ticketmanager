package com.ticketmanager.repository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ticketmanager.model.Incident;

public class IncidentRepository {

    private static final String FILE_PATH = "data/incidents.json";
    private Gson gson = new Gson();

    public void save(Incident incident) {
        try {
            FileReader reader = new FileReader(FILE_PATH);
            List<Incident> incidents = gson.fromJson(reader, new TypeToken<List<Incident>>(){}.getType());
            if (incidents == null)
                incidents = new ArrayList<>();

            incidents.add(incident);
            reader.close();
            FileWriter writer = new FileWriter(FILE_PATH);
            writer.write(gson.toJson(incidents));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Incident> findAll() {
        List<Incident> incidents = new ArrayList<>();
        try{
            FileReader reader = new FileReader(FILE_PATH);
            incidents = gson.fromJson(reader, new TypeToken<List<Incident>>(){}.getType());
            if (incidents == null)
                incidents = new ArrayList<>();

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return incidents;
    }

    public Optional<Incident> findById(int id){
        List<Incident> incidents = new ArrayList<>();
        try {
            FileReader reader = new FileReader(FILE_PATH);
            incidents = gson.fromJson(reader, new TypeToken<List<Incident>>(){}.getType());
            reader.close();
            if (incidents == null)
                incidents = new ArrayList<>();

            for (Incident incident : incidents) {
                if (incident.getIdTicket() == id){
                    return Optional.of(incident);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

        public void delete(int id) {
        try {
            FileReader reader = new FileReader(FILE_PATH);
            List<Incident> incidents = gson.fromJson(reader, new TypeToken<List<Incident>>(){}.getType());
            if (incidents == null)
                incidents = new ArrayList<>();

            incidents.removeIf(incident -> incident.getIdTicket() == id);
            reader.close();
            FileWriter writer = new FileWriter(FILE_PATH);
            writer.write(gson.toJson(incidents));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}