package com.ticketmanager.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import com.ticketmanager.model.Incident;
import com.ticketmanager.model.Status;
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

    public void updateIncident(int id, Incident updatedIncident){
    	
    	Optional<Incident> original = showById(id);
    	
    	if (original.get().getStatus() == Status.RESOLVED) 
    		return;
    	
    	if (updatedIncident.getStatus() == Status.OPEN) 
    		updatedIncident.setStatus(Status.IN_PROGRESS);
    	
    	StringBuilder hist = new StringBuilder();
    	String timestamp = LocalDateTime.now()
                		   .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    	
    	if (!original.get().getResponsible().equals(updatedIncident.getResponsible())) {
    		hist.append("\n - Responsável alterado."
    			+ original.get().getResponsible() + "->"
    			+ updatedIncident.getResponsible() + " ");
    	}
    	if (!original.get().getDesc().equals(updatedIncident.getDesc())) {
    		hist.append("\n - Descricao Atualizada.");
    	}
    	if (!original.get().getImpacto().equals(updatedIncident.getImpacto())) {
    		hist.append("\n - Impacto alterado."
    			+ original.get().getImpacto() + "->"
    			+ updatedIncident.getImpacto() + " ");    	
    	}
    	if (hist.length() > 0) {
    		updatedIncident.addLog(timestamp + hist.toString());
    	}
    	
    	repository.updateIncident(id, updatedIncident);
    }
    
    public void remove(int id){
    	repository.delete(id);
    }

}
