/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progetto_cavalli;

/**
 *
 * @author lucascarabattoli
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaraCavallo {  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Inserisci la lunghezza del percorso della gara (in metri): ");
        int lunghezzaGara = scanner.nextInt();

        
        System.out.println("Inserisci il numero dei cavalli che partecipano: ");
        int numCavalli = scanner.nextInt();
        scanner.nextLine();  

        
        List<Thread> cavalli = new ArrayList<>();

        
        for (int i = 0; i < numCavalli; i++) {
            System.out.println("Inserisci il nome del cavallo " + (i + 1) + ": ");
            String nomeCavallo = scanner.nextLine();

           
            Cavallo cavallo = new Cavallo(nomeCavallo, 0, lunghezzaGara);
            
           
            Thread cavalloThread = new Thread(cavallo);  
            cavalli.add(cavalloThread);  
        }

       
        System.out.println("La gara è iniziata!");
        for (Thread cavallo : cavalli) {
            cavallo.start(); 
        }

       
        for (Thread cavallo : cavalli) {
            try {
                cavallo.join(); 
            } catch (InterruptedException e) {
                System.out.println("La gara è stata interrotta.");
            }
        }

        
        System.out.println("La gara è finita!");
    }
}

