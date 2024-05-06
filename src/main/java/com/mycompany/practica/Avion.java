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
    private String aeropuertoActual;
    private int numVuelos;
    private int numPasajeros;
    private int capacidadMaxima;
    private Log log;
    private HiloSuperior superior;
    private Aeropuerto aeropuerto;
    private Aeropuerto aeropuertoDestino;
    
    //private int pos;
    private Random rand = new Random();
    private String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    
    public Avion(int id, Aeropuerto aeropuerto, Aeropuerto aeropuertoDestino, Log log, HiloSuperior superior){
        this.aeropuerto = aeropuerto;
        this.aeropuertoDestino = aeropuertoDestino;
        this.superior = superior;
        if (esMadrid(id)){
            aeropuertoActual= "Madrid";
        }else{
            aeropuertoActual = "Barcelona";
        }
        this.log = log;
        char l1 = letras.charAt(rand.nextInt(letras.length()));
        char l2 = letras.charAt(rand.nextInt(letras.length()));
        this.id = "" + l1 + l2 + "-" + crearId(id);
        this.numVuelos = 0;
        this.capacidadMaxima = rand.nextInt(201) + 100;
        super.setName(String.valueOf(this.id));
        log.logEvent(" el avión " + miId() + " es creado en el aeropuerto de " + aeropuertoActual);
        System.out.println(getMarcaTiempo()+ " Avion " + this.id + " es creado ");
        
    }
    private boolean esMadrid(int id){
        return(id % 2 == 0);
    }
    private void aeropuertoActualCambia(){
        if (aeropuertoActual.equals("Madrid")){
            aeropuertoActual = "Barcelona";
        }else{ aeropuertoActual = "Madrid";}
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
    
    
    public void embarcar(){
        int intentos = 0;
        superior.esperar();
        try{
            if ( aeropuerto.NumPersonas() >= capacidadMaxima){
                int pasaj = capacidadMaxima;
                numPasajeros = pasaj;
                superior.esperar();
                aeropuerto.Salir(numPasajeros);
                Thread.sleep(1000 + (rand.nextInt(2001)));
            }else{
                Thread.sleep(1000 + (rand.nextInt(4001)));
                while(aeropuerto.NumPersonas() < capacidadMaxima && intentos < 3){
                    superior.esperar();
                    int numPersonas = aeropuerto.NumPersonas(); // coge el num de personas q hay en el aeopuerto
                    int numAsientosDisponibles = capacidadMaxima - numPasajeros; // calcula el num
                    int pasajerosASubir = Math.min(numAsientosDisponibles, numPersonas);
                    numPasajeros += pasajerosASubir;
                    aeropuerto.Salir(pasajerosASubir);
                    Thread.sleep(1000 + (rand.nextInt(2001)));
                    intentos++;
                }
                log.logEvent("el avion " + miId() + "esta embarcando en el aeropuerto de " + getAeropuertoActual() +" "+ numPasajeros + " personas");
            }
        }catch (InterruptedException e) {}
        System.out.println( " Avion " + id + " suben " + numPasajeros + " pasajeros");
    }
    
    public void desembarcar(){
        try{
            superior.esperar();
            aeropuerto.Entrar(numPasajeros);
            log.logEvent("el avion " + miId() + "esta desembarcando en el aeropuerto de " + getAeropuertoActual() +" "+ numPasajeros + " personas");
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
            superior.esperar();
            sleep(1000);
            aeropuerto.AvionSalirHangar(this);
            superior.esperar();
            aeropuerto.EntrarAreaEstac(this);
            superior.esperar();
           while(true){
                recorrerAeropuertoOrigen();
                superior.esperar();
                aeropuerto.meterAeroviaADestino(this);
                superior.esperar();
                this.numVuelos = this.getNumVuelos() + 1;
                superior.esperar();
                aeropuertoActualCambia();
                recorrerAeropuertoDestino();
                superior.esperar();
                if(debeIrHangar()){
                    aeropuertoDestino.AvionEnHangar(this);
                    superior.esperar();
                    sleep(15000 + rand.nextInt(15001));
                    aeropuertoDestino.AvionSalirHangar(this);
                    superior.esperar();
                    aeropuertoDestino.EntrarAreaEstac(this);
                }else{
                    aeropuerto.EntrarAreaEstac(this);
                }
                superior.esperar();
                continuarAeropuertoDestino();
                superior.esperar();
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
        superior.esperar();
        sleep(1000);
        aeropuerto.SalirAreaEstac(this);
        superior.esperar();
        aeropuerto.solicitarPuertaEmbarque(this);
        superior.esperar();
        sleep(800);
        aeropuerto.actualizarNumPersonas();
        superior.esperar();
        aeropuerto.AvionEnAreaRodaje(this);
        superior.esperar();
        sleep(1000 +(rand.nextInt(4001)));
        aeropuerto.AvionSalirAreaRod(this);
        superior.esperar();
        sleep(1000+(rand.nextInt(2001)));
        aeropuerto.solicitarPistaDespegue(this);
    }
    
    public void recorrerAeropuertoDestino() throws InterruptedException{
        
        superior.esperar();
        aeropuerto.salirAeroviaDestino(this);
        superior.esperar();
        aeropuertoDestino.solicitarPistaAterrizaje(this);
        superior.esperar();
        aeropuertoDestino.AvionEnAreaRodaje(this);
        sleep(3000 + rand.nextInt(6001));
        superior.esperar();
        aeropuertoDestino.AvionSalirAreaRod(this);
        superior.esperar();
        aeropuertoDestino.solicitarPuertaDesembarque(this);
        superior.esperar();
        aeropuertoDestino.EntrarAreaEstac(this);
        sleep(1000 + rand.nextInt(4001));
    }
    
    public void continuarAeropuertoDestino() throws InterruptedException{
        superior.esperar();
        aeropuertoDestino.solicitarPuertaEmbarque(this);
        superior.esperar();
        sleep(800);
        superior.esperar();
        aeropuertoDestino.actualizarNumPersonas();
        superior.esperar();
        aeropuertoDestino.AvionEnAreaRodaje(this);
        superior.esperar();
        sleep(1000 +(rand.nextInt(4001)));
        superior.esperar();
        aeropuertoDestino.AvionSalirAreaRod(this);
        superior.esperar();
        sleep(1000+(rand.nextInt(2001)));
        superior.esperar();
        aeropuertoDestino.solicitarPistaDespegue(this);
        superior.esperar();
        aeropuertoDestino.meterAeroviaADestino(this);
        superior.esperar();
        aeropuertoDestino.salirAeroviaDestino(this);
        superior.esperar();
        aeropuertoActualCambia();
        superior.esperar();
        aeropuerto.solicitarPistaAterrizaje(this);
        superior.esperar();
        aeropuerto.AvionEnAreaRodaje(this);
        superior.esperar();
        sleep(3000 + rand.nextInt(6001));
        superior.esperar();
        aeropuerto.AvionSalirAreaRod(this);
        superior.esperar();
        aeropuerto.solicitarPuertaDesembarque(this);
        superior.esperar();
        aeropuerto.EntrarAreaEstac(this);
        superior.esperar();
        sleep(1000 + rand.nextInt(4001));
        superior.esperar();
        //aeropuerto.solicitarTaller(this);
        if(debeIrHangar()){
            aeropuertoDestino.AvionEnHangar(this);
            superior.esperar();
            sleep(15000 + rand.nextInt(15001));
            superior.esperar();
            aeropuertoDestino.AvionSalirHangar(this);
            superior.esperar();
            aeropuertoDestino.EntrarAreaEstac(this);
                 
        }else{
            aeropuerto.EntrarAreaEstac(this);
        }
        
    }
    public String getAeropuertoActual(){
        return aeropuertoActual;
    }
    
    public boolean debeIrHangar(){
        return rand.nextBoolean();
    }
    
    private String getMarcaTiempo(){
        return java.time.LocalTime.now().toString();
    }
}
