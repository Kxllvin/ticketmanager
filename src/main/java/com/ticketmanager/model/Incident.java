package com.ticketmanager.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Incident {

    private int idTicket;
    private String titulo;
    private String desc;
    private String responsible;
    private Status status;
    private Impacto impacto;
    private List<String> logList;
    private String dataHora;
    

    public Incident(String desc, int idTicket, String titulo, String responsible, Impacto impacto) {
        this.desc = desc;
        this.idTicket = idTicket;
        this.titulo = titulo;
        this.status = Status.OPEN;
        this.impacto = impacto;
        this.responsible = responsible;
        this.logList = new ArrayList<>();
        this.dataHora = LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    public void addLog(String log) {
        this.logList.add(log);
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesc(){
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Impacto getImpacto() {
        return impacto;
    }

    public void setImpacto(Impacto impacto) {
        this.impacto = impacto;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<String> getLogList() {
        return logList;
    }

    public void setLogList(List<String> logList) {
        this.logList = logList;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getDataHora() {
        return dataHora;
    }
   
}
