/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

import java.util.Random;

/**
 * Clase que modela un avión en un aeropuerto.
 * Extiende de Thread para poder ejecutar en un hilo independiente.
 * @author elia y noelia
 */
public class Avion extends Thread{
        // Atributos
    private String id; // Identificador del avión
    private String aeropuertoActual; // Aeropuerto actual del avión
    private int numVuelos; // Número de vuelos realizados
    private int numPasajeros; // Número de pasajeros a bordo
    private int capacidadMaxima; // Capacidad máxima de pasajeros
    private Log log; // Registro de eventos
    private HiloSuperior superior; // Objeto para sincronización
    private Aeropuerto aeropuerto; // Aeropuerto de origen
    private Aeropuerto aeropuertoDestino; // Aeropuerto de destino

    // Generador de números aleatorios
    private Random rand = new Random();
    // Cadena de letras para generar identificadores
    private String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    
     /**
     * Constructor de la clase Avion.
     * @param id Identificador del avión
     * @param aeropuerto Aeropuerto de origen
     * @param aeropuertoDestino Aeropuerto de destino
     * @param log Registro de eventos
     * @param superior Objeto para sincronización
     */
    public Avion(int id, Aeropuerto aeropuerto, Aeropuerto aeropuertoDestino, Log log, HiloSuperior superior){
        this.aeropuerto = aeropuerto;
        this.aeropuertoDestino = aeropuertoDestino;
        this.superior = superior;
         // Determina el aeropuerto actual del avión en base a su identificador
        if (esMadrid(id)){
            aeropuertoActual= "Madrid";
        }else{
            aeropuertoActual = "Barcelona";
        }
        this.log = log;
        // Genera el identificador del avión
        char l1 = letras.charAt(rand.nextInt(letras.length()));
        char l2 = letras.charAt(rand.nextInt(letras.length()));
        this.id = "" + l1 + l2 + "-" + crearId(id);
        this.numVuelos = 0;
        // Genera la capacidad máxima de pasajeros del avión
        this.capacidadMaxima = rand.nextInt(201) + 100;
        super.setName(String.valueOf(this.id));
        log.logEvent(" el avión " + miId() + " es creado en el aeropuerto de " + aeropuertoActual);
        System.out.println(getMarcaTiempo()+ " Avion " + this.id + " es creado ");
        
    }
    
    /**
     * Verifica si el identificador corresponde a Madrid.
     * @param id Número de identificación del avión
     * @return true si el identificador corresponde a Madrid, false en caso contrario
     */
    private boolean esMadrid(int id){
        return(id % 2 == 0); // Si es par, el avión pertenece a Madrid
    }
    
    /**
     * Cambia el aeropuerto actual del avión.
     */
    private void aeropuertoActualCambia(){
        if (aeropuertoActual.equals("Madrid")){
            aeropuertoActual = "Barcelona";
        }else{ aeropuertoActual = "Madrid";}
    }
    
     /**
     * Genera el identificador del avión en base a un número dado.
     * @param id Número de identificación del avión
     * @return Identificador generado del avión
     */
    private String crearId(int id){
        String ident = "";
        // Formatea el identificador para asegurar una longitud mínima
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
    
     /**
     * Devuelve el identificador del avión.
     * @return Identificador del avión
     */
    public String miId(){
        return id;
    }
    
    /**
     * Realiza el embarque de pasajeros en el avión.
     */
    public void embarcar(){
        int intentos = 0;
        superior.esperar();
        try{
            // Verifica si el aeropuerto tiene suficientes pasajeros para llenar el avión
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
                // Registra el embarque en el log
                log.logEvent("el avion " + miId() + "esta embarcando en el aeropuerto de " + getAeropuertoActual() +" "+ numPasajeros + " personas");
            }
        }catch (InterruptedException e) {}
        // Imprime el número de pasajeros embarcados en la consola
        System.out.println( " Avion " + id + " suben " + numPasajeros + " pasajeros");
    }
    
    /**
     * Realiza el desembarque de pasajeros del avión.
     */
    public void desembarcar(){
        try{
            superior.esperar();
            aeropuerto.Entrar(numPasajeros);
            // Registra el desembarque en el log
            log.logEvent("el avion " + miId() + "esta desembarcando en el aeropuerto de " + getAeropuertoActual() +" "+ numPasajeros + " personas");
            System.out.println( " Avion" + id + " bajan " + numPasajeros + " pasajeros");
            Thread.sleep(1000 + (rand.nextInt(2001)));
            numPasajeros = 0;
        }catch (InterruptedException e) {}
        
    }
    
    /**
     * Realiza el despegue del avión.
     */
    public void despegar() {
        
        System.out.println("Avion " + id + " despegando...");
        try {
            sleep(rand.nextInt(4001) + 1000); // Simula el tiempo de despegue
        } catch (InterruptedException e) {}
        System.out.println("Avion " + id + " ha despegado.");
    }

    /**
     * Realiza el aterrizaje del avión.
     */
    public void aterrizar() {
        System.out.println("Avion " + id + " aterrizando...");
        try {
            sleep(rand.nextInt(4001) + 1000); // Simula el tiempo de aterrizaje
        } catch (InterruptedException e) {}
        System.out.println("Avion " + id + " ha aterrizado.");
    }
    
    /**
     * Método principal del hilo del avión que simula su funcionamiento.
     */
    public void run(){
       try{
           // Inicia el ciclo de funcionamiento del avión
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

    /**
     * Devuelve el número de vuelos realizados por el avión.
     * @return Número de vuelos
     */
    public int getNumVuelos() {
        return numVuelos;
    }

    /**
     * Devuelve el número de pasajeros a bordo del avión.
     * @return Número de pasajeros
     */
    public int getNumPasajeros() {
        return numPasajeros;
    }

    /**
     * Devuelve la capacidad máxima de pasajeros del avión.
     * @return Capacidad máxima de pasajeros
     */
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    
    /**
     * Realiza una inspección del avión, solicitando mantenimiento si es necesario.
     * @throws InterruptedException si se produce una interrupción durante la inspección
     */
    public void inspeccionar() throws InterruptedException{
        if(numVuelos % 15 == 0){
            sleep(5000 + rand.nextInt(6000));
            numVuelos = 0;
        }else{
            sleep(1000 + rand.nextInt(6000));
        }
        aeropuerto.solicitarTaller(this);
    }
    
    /**
     * Realiza el recorrido del avión por el aeropuerto de origen.
     * @throws InterruptedException si se produce una interrupción durante el recorrido
     */
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
    
    /**
     * Realiza el recorrido del avión por el aeropuerto de destino.
     * @throws InterruptedException si se produce una interrupción durante el recorrido
     */
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
        aeropuerto.solicitarTaller(this);
    }
    
    /**
     * Continúa el recorrido del avión por el aeropuerto de destino después de una parada.
     * @throws InterruptedException si se produce una interrupción durante el recorrido
     */
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
        aeropuerto.solicitarTaller(this);
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
    
    /**
     * Obtiene el aeropuerto actual del avión.
     * @return Aeropuerto actual
     */
    public String getAeropuertoActual(){
        return aeropuertoActual;
    }
    
    /**
     * Determina si el avión debe dirigirse al hangar.
     * @return true si el avión debe dirigirse al hangar, false en caso contrario
     */
    public boolean debeIrHangar(){
        return rand.nextBoolean();
    }
    
    /**
     * Obtiene la marca de tiempo actual.
     * @return Marca de tiempo actual
     */
    private String getMarcaTiempo(){
        return java.time.LocalTime.now().toString();
    }
}
