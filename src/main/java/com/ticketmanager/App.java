package com.ticketmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ticketmanager.model.Impacto;
import com.ticketmanager.model.Incident;
import com.ticketmanager.service.IncidentService;

public class App {
    public static void main( String[] args ) {
    	
        IncidentService incidenteService = new IncidentService();
        int idTicket;
        String titulo;
        String desc;
        String responsible;
        Impacto impacto = null;
        Scanner scanner = new Scanner(System.in);
        

        while (true){

        System.out.println("\n=== TicketManager ===");
        System.out.println("1 - Registrar incidente");
        System.out.println("2 - Listar incidentes");
        System.out.println("3 - Buscar por ID");
        System.out.println("4 - Remover incidente");
        System.out.println("5 - Atualizar incidente");
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

                System.out.println("Impacto:");
                System.out.println("1 - LOW");
                System.out.println("2 - MEDIUM");
                System.out.println("3 - HIGH");
                System.out.println("4 - CRITICAL");
                System.out.println("Escolha uma opção: ");
                //= Impacto.valueOf(scanner.nextLine().toUpperCase());
                
                while (true) {
                	
                int impactoOpcao = scanner.nextInt();
                scanner.nextLine();
                
                if (impactoOpcao < 1 || impactoOpcao > 4) {
                	System.out.println("Opção inválida. Escolha entre 1 e 4");
                	continue;
                }
                
                impacto = switch (impactoOpcao) {
		            case 1 -> Impacto.LOW;
		            case 2 -> Impacto.MEDIUM;
		            case 3 -> Impacto.HIGH;
		            case 4 -> Impacto.CRITICAL;
		            default -> Impacto.LOW;	
                	};
                break;
                }
                
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
                    System.out.println("Título: " + incident.getTitulo());
                    System.out.println("Descricao: " + incident.getDesc());
                    System.out.println("Responsavel: " + incident.getResponsible());
                    System.out.println("Logs:");
                    for (String log : incident.getLogList()) {
                        String[] linhas = log.split("\\n");
                        for (String linha : linhas) {
                            System.out.println("  " + linha);
                        }
                    }
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
            
            case 5 ->{
            	System.out.println("ATUALIZAR INCIDENTE");
            	
                System.out.println("Informe o ID: ");
                int updIncident = scanner.nextInt();
                scanner.nextLine();
                incidenteService.showById(updIncident).ifPresentOrElse(
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
                               
                            Impacto newImpacto = null;
                            
                            System.out.println("Descrição: ");
                            String newDesc = scanner.nextLine();

                            System.out.println("Responsável: ");
                            String newResponsible = scanner.nextLine();

                            System.out.println("Impacto:");
                            System.out.println("1 - LOW");
                            System.out.println("2 - MEDIUM");
                            System.out.println("3 - HIGH");
                            System.out.println("4 - CRITICAL");
                            System.out.println("Escolha uma opção: ");
                            //= Impacto.valueOf(scanner.nextLine().toUpperCase());
                            
                            while (true) {
                            	
                            int impactoOpcao = scanner.nextInt();
                            scanner.nextLine();
                            
                            if (impactoOpcao < 1 || impactoOpcao > 4) {
                            	System.out.println("Opção inválida. Escolha entre 1 e 4");
                            	continue;
                            }
                            
                            newImpacto = switch (impactoOpcao) {
            		            case 1 -> Impacto.LOW;
            		            case 2 -> Impacto.MEDIUM;
            		            case 3 -> Impacto.HIGH;
            		            case 4 -> Impacto.CRITICAL;
            		            default -> Impacto.LOW;	
                            	};
                            break;
                            }
                            
                            incident.setDesc(newDesc);
                            incident.setResponsible(newResponsible);
                            incident.setImpacto(newImpacto);
                            incidenteService.updateIncident(updIncident, incident);
                                
                    	},
                    	() -> System.out.println("Incidente não encontrado.")
                    );
                
            }
                    
             default -> {
                System.out.println("Encerrando...");
                scanner.close();
            }
        

            }
        }
    }
}
