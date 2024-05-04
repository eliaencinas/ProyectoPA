/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

import java.util.Random;

/**
 *
 * @author elia y noelia
 */
public class Avion extends Thread{
    //atributos
    private String id;
    private int numVuelos;
    private int numPasajeros;
    private int capacidadMaxima;
    private Aeropuerto aeropuerto;
    
    //private int pos;
    private Random rand = new Random();
    private String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    
    public Avion(int id, Aeropuerto aeropuerto){
        //pos = id;
        this.aeropuerto = aeropuerto;
        char l1 = letras.charAt(rand.nextInt(letras.length()));
        char l2 = letras.charAt(rand.nextInt(letras.length()));
        this.id = "" + l1 + l2 + "-" + crearId(id);
        this.numVuelos = 0;
        this.capacidadMaxima = rand.nextInt(201) + 100;
        super.setName(String.valueOf(this.id));
        
    }
    
    private String crearId(int id){
        String ident = "";
        if (id < 10){
            ident = "000" + id;
        }else if (id < 100 && id > 10){
            ident = "00" + id;
        }else if (id < 1000 && id > 100){
            ident = "0" + id;
        }else{
            ident ="" + id;
        }
        return ident;  
    }
    
    public String miId(){
        return id;
    }
    
    
    public void embarcar(){
        int intentos = 0;
        try{
            if ( aeropuerto.NumPersonas() >= capacidadMaxima){
                int pasaj = capacidadMaxima;
                numPasajeros = pasaj;
                aeropuerto.Salir(numPasajeros);
                Thread.sleep(1000 + (rand.nextInt(2001)));
            }else{
                Thread.sleep(1000 + (rand.nextInt(4001)));
                while(aeropuerto.NumPersonas() < capacidadMaxima && intentos < 3){
                    int numPersonas = aeropuerto.NumPersonas(); // coge el num de personas q hay en el aeopuerto
                    int numAsientosDisponibles = capacidadMaxima - numPasajeros; // calcula el num
                    int pasajerosASubir = Math.min(numAsientosDisponibles, numPersonas);
                    numPasajeros += pasajerosASubir;
                    aeropuerto.Salir(pasajerosASubir);
                    Thread.sleep(1000 + (rand.nextInt(2001)));
                    intentos++;
                } 
            }
        }catch (InterruptedException e) {}
        System.out.println( " Avion " + id + " suben " + numPasajeros + " pasajeros");
    }
    
    public void desembarcar(){
        try{
            aeropuerto.Entrar(numPasajeros);
            System.out.println( " Avion" + id + " bajan " + numPasajeros + " pasajeros");
            Thread.sleep(1000 + (rand.nextInt(2001)));
            numPasajeros = 0;
        }catch (InterruptedException e) {}
        
    }
    
    public void despegar() {
        System.out.println("Avion " + id + " despegando...");
        try {
            sleep(rand.nextInt(4001) + 1000); // Simula el tiempo de despegue
        } catch (InterruptedException e) {}
        System.out.println("Avion " + id + " ha despegado.");
    }

    public void aterrizar() {
        System.out.println("Avion " + id + " aterrizando...");
        try {
            sleep(rand.nextInt(4001) + 1000); // Simula el tiempo de aterrizaje
        } catch (InterruptedException e) {}
        System.out.println("Avion " + id + " ha aterrizado.");
    }
    
    public void run(){
       try{
           while(true){
             aeropuerto.AvionEnHangar(this);
             sleep(1000);
             aeropuerto.AvionSalirHangar(this);
             aeropuerto.EntrarAreaEstac(this);
             sleep(1000);
             aeropuerto.SalirAreaEstac(this);
           
             aeropuerto.solicitarPuertaEmbarque(this);
             sleep(800);
             aeropuerto.AvionEnAreaRodaje(this);
             sleep(1000 +(rand.nextInt(4001)));
             aeropuerto.AvionSalirAreaRod(this);
             sleep(1000+(rand.nextInt(2001)));
             aeropuerto.solicitarPistaDespegue(this);
             aeropuerto.meterEnAerovia(this);
             aeropuerto.solicitarPistaAterrizaje(this);
             aeropuerto.solicitarPuertaDesembarque(this);  
           }
           
           
           
           
        }catch (InterruptedException e) {
            System.out.println("ERROR: " + e.toString() );
        }
    }

    public int getNumVuelos() {
        return numVuelos;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    
    
}
