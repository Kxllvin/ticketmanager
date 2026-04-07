package com.ticketmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ticketmanager.model.Impacto;
import com.ticketmanager.model.Incident;
import com.ticketmanager.model.Status;
import com.ticketmanager.service.IncidentService;

public class App 
{
    public static void main( String[] args ) {
        
        IncidentService incidenteService = new IncidentService();
        int idTicket;
        String titulo;
        String desc;
        String responsible;
        Scanner scanner = new Scanner(System.in);

        while (true){

        System.out.println("\n=== TicketManager ===");
        System.out.println("1 - Registrar incidente");
        System.out.println("2 - Listar incidentes");
        System.out.println("3 - Buscar por ID");
        System.out.println("4 - Remover incidente");
        System.out.println("0 - Sair");
        System.out.println("Escolha uma opção: ");

        int option = scanner.nextInt();
        scanner.nextLine();

        if (option == 0) break;

        switch (option) {
            case 1 -> {
                System.out.println("ABERTURA DE TICKET:");
                
                idTicket = incidenteService.showAll()
		    					.stream()
		    					.mapToInt(incident -> incident.getIdTicket())
		    					.max()
		    					.orElse(0) + 1;
                
                System.out.println("Título: ");
                titulo = scanner.nextLine();

                System.out.println("Descrição: ");
                desc = scanner.nextLine();

                System.out.println("Responsável: ");
                responsible = scanner.nextLine();

                System.out.println("Impacto: ");
                Impacto impacto = Impacto.valueOf(scanner.nextLine().toUpperCase());
                
                Incident incident = new Incident(desc, idTicket, titulo, responsible, impacto);
                incidenteService.register(incident);
            }

            case 2 -> {
                List<Incident> allIncidents = incidenteService.showAll();
                    if (allIncidents == null)
                        allIncidents = new ArrayList<>();

                System.out.println("LISTA DE INCIDENTES:");
                System.out.println(String.format("%-10s %-25s %-15s %-10s","ID", "Data/Hora", "Status", "Impacto"));

                for(Incident incident : allIncidents){
                    System.out.println(String.format("%-10s %-25s %-15s %-10s", incident.getIdTicket(), incident.getDataHora(), incident.getStatus(), incident.getImpacto()));
                    System.out.println(incident.getTitulo());
                    System.out.println(incident.getDesc());
                    System.out.println(incident.getResponsible());
                    System.out.println("---");
               }
            }

            case 3 ->{
                System.out.println("CONSULTA INCIDENTE:");

                int pesquisaId;

                System.out.println("Informe o ID: ");
                pesquisaId = scanner.nextInt();
                scanner.nextLine();

                incidenteService.showById(pesquisaId).ifPresentOrElse(
                    incident -> {
                    System.out.println(String.format("%-10s %-25s %-15s %-10s",
                        incident.getIdTicket(),   
                        incident.getDataHora(),
                        incident.getStatus(),
                        incident.getImpacto()));
                    System.out.println(incident.getTitulo());
                    System.out.println(incident.getDesc());
                    System.out.println(incident.getResponsible());
                    System.out.println("---");
                    },
                    () -> System.out.println("Incidente não encontrado.")
                );
            }

            case 4 ->{
                System.out.println("APAGAR INCIDENTE:");

                System.out.println("Informe o ID: ");
                int removeId = scanner.nextInt();
                scanner.nextLine();
                incidenteService.showById(removeId).ifPresentOrElse(
                	incident -> {
                		incidenteService.remove(removeId);
                        System.out.println("Incidente removido.");
                	},
                	() -> System.out.println("Incidente não encontrado.")
                );
                }
                    
            } default -> {
                System.out.println("Encerrando...");
                scanner.close();
            }
        }

           /* if(option != 1 && option != 2 && option != 3 && option != 4){
                return; */
            }
        }
}
