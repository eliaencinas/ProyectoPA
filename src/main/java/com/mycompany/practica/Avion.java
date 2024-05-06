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
    private String ciudadOrigen;
    private int numVuelos;
    private int numPasajeros;
    private int capacidadMaxima;
    private boolean enEst;
    private Aeropuerto aeropuerto;
    private Aeropuerto aeropuertoDestino;
    
    //private int pos;
    private Random rand = new Random();
    private String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    
    public Avion(int id, Aeropuerto aeropuerto, Aeropuerto aeropuertoDestino){
        this.aeropuerto = aeropuerto;
        this.aeropuertoDestino = aeropuertoDestino;
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
        }else if (id < 100 && id >= 10){
            ident = "00" + id;
        }else if (id < 1000 && id >= 100){
            ident = "0" + id;
        }else{
            ident ="" + id;
        }
        return ident;  
    }
    
    public String miId(){
        return id;
    }
    
    public String ciudadOrigen(){
        //Obtinen el último dígito del String id que será un número
        char ultimoCaracter = id.charAt(id.length() - 1);
        //Convierte el último caracter en un número entero
        int ultimoDigito = Character.getNumericValue(ultimoCaracter);
        //Verifica si el último dígito es par o impar
        return (ultimoDigito % 2 == 0) ? "Madrid" : "Barcelona";
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
            aeropuerto.AvionEnHangar(this);
            sleep(1000);
            aeropuerto.AvionSalirHangar(this);
            aeropuerto.EntrarAreaEstac(this);
           while(true){
                recorrerAeropuertoOrigen();
                aeropuerto.meterAeroviaADestino(this);
                numVuelos ++;
                recorrerAeropuertoDestino();
                aeropuertoDestino.solicitarTaller(this);
                if(debeIrHangar()){
                    aeropuertoDestino.AvionEnHangar(this);
                    sleep(15000 + rand.nextInt(15001));
                    aeropuertoDestino.AvionSalirHangar(this);
                    aeropuertoDestino.EntrarAreaEstac(this);
                }else{
                    aeropuerto.EntrarAreaEstac(this);
                }
                continuarAeropuertoDestino();
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
    
    public void inspeccionar() throws InterruptedException{
        if(numVuelos % 15 == 0){
            sleep(5000 + rand.nextInt(6000));
            numVuelos = 0;
        }else{
            sleep(1000 + rand.nextInt(6000));
        }
        aeropuerto.solicitarTaller(this);
    }
    
    public void recorrerAeropuertoOrigen() throws InterruptedException{
        sleep(1000);
        aeropuerto.SalirAreaEstac(this);
        aeropuerto.solicitarPuertaEmbarque(this);
        sleep(800);
        aeropuerto.actualizarNumPersonas();
        aeropuerto.AvionEnAreaRodaje(this);
        sleep(1000 +(rand.nextInt(4001)));
        aeropuerto.AvionSalirAreaRod(this);
        sleep(1000+(rand.nextInt(2001)));
        aeropuerto.solicitarPistaDespegue(this);
    }
    
    public void recorrerAeropuertoDestino() throws InterruptedException{
        aeropuerto.salirAeroviaDestino(this);
        aeropuertoDestino.solicitarPistaAterrizaje(this);
        aeropuertoDestino.AvionEnAreaRodaje(this);
        sleep(3000 + rand.nextInt(6001));
        aeropuertoDestino.AvionSalirAreaRod(this);
        aeropuertoDestino.solicitarPuertaDesembarque(this);
        aeropuertoDestino.EntrarAreaEstac(this);
        sleep(1000 + rand.nextInt(4001));
    }
    
    public void continuarAeropuertoDestino() throws InterruptedException{
        aeropuertoDestino.solicitarPuertaEmbarque(this);
        sleep(800);
        aeropuertoDestino.actualizarNumPersonas();
        aeropuertoDestino.AvionEnAreaRodaje(this);
        sleep(1000 +(rand.nextInt(4001)));
        aeropuertoDestino.AvionSalirAreaRod(this);
        sleep(1000+(rand.nextInt(2001)));
        aeropuertoDestino.solicitarPistaDespegue(this);
        aeropuertoDestino.meterAeroviaADestino(this);
        aeropuertoDestino.salirAeroviaDestino(this);
        aeropuerto.solicitarPistaAterrizaje(this);
        aeropuerto.AvionEnAreaRodaje(this);
        sleep(3000 + rand.nextInt(6001));
        aeropuerto.AvionSalirAreaRod(this);
        aeropuerto.solicitarPuertaDesembarque(this);
        aeropuerto.EntrarAreaEstac(this);
        sleep(1000 + rand.nextInt(4001));
        aeropuerto.solicitarTaller(this);
        if(debeIrHangar()){
            aeropuertoDestino.AvionEnHangar(this);
            sleep(15000 + rand.nextInt(15001));
            aeropuertoDestino.AvionSalirHangar(this);
            aeropuertoDestino.EntrarAreaEstac(this);
                 
        }else{
            aeropuerto.EntrarAreaEstac(this);
        }
        
    }
    
    public boolean debeIrHangar(){
        return rand.nextBoolean();
    }
    
}
