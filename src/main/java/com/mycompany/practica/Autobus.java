/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

import java.util.Random;

/**
 * Clase que modela un autobús en el aeropuerto.
 * Extiende de Thread para poder ejecutar en un hilo independiente.
 * @author elia y noelia
 */
public class Autobus extends Thread{
    
    private String id; // Identificador del autobús
    private String aeropuertoActual; // Aeropuerto actual del autobús
    private int numPasajeros; // Número de pasajeros en el autobús
    private Aeropuerto a; // Aeropuerto al que pertenece el autobús
    private Log log; // Registro de eventos
    private HiloSuperior superior; // Objeto para sincronización
    private final Random rand = new Random(); // Generador de números aleatorios

    /**
     * Constructor de la clase Autobus.
     * @param id Identificador del autobús
     * @param a Aeropuerto al que pertenece el autobús
     * @param log Registro de eventos
     * @param superior Objeto para sincronización
     */
    public Autobus(int id, Aeropuerto a, Log log, HiloSuperior superior){ 
        this.id = "B-" + crearId(id); // Genera el identificador del autobús
        this.a = a;
        this.log = log;
        this.superior = superior;
        // Determina el aeropuerto actual del autobús en base a su identificador
        if (esMadrid(id)){
            aeropuertoActual = "Madrid";
        }else{ aeropuertoActual = "Barcelona";}
        // Registra la creación del autobús en el log y en la consola
        log.logEvent(" Bus " + this.id + " es creado en el aeropuerto de " + aeropuertoActual);
        System.out.println(getMarcaTiempo()+ " Bus " + this.id + " es creado ");
    }
    
    /**
     * Verifica si el identificador corresponde a Madrid.
     * @param id Número de identificación del autobús
     * @return true si el identificador corresponde a Madrid, false en caso contrario
     */
    private boolean esMadrid(int id){
        return(id % 2 == 0); // Si es par, el autobús pertenece a Madrid
    }
    
    /**
     * Genera el identificador del autobús en base a un número dado.
     * @param id Número de identificación del autobús
     * @return Identificador generado del autobús
     */
    private String crearId(int id){
        String ident;
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
     * Devuelve el identificador del autobús.
     * @return Identificador del autobús
     */
    public String miId(){
        return id;
    }
    
    /**
     * Registra la llegada del autobús al aeropuerto.
     */
    public void entrarAeropuerto(){
        a.autobusEnAeropuerto(this);
        log.logEvent(" Bus " + miId() + " ha llegado al aeropuerto de " + aeropuertoActual);
    }
        
    /**
     * Registra la llegada del autobús a la ciudad.
     */
    public void entrarCiudad(){
        a.autobusEnCiudad(this);
        log.logEvent(" Bus " + miId() + "ha llegado a " + aeropuertoActual);    
    }
    
    /**
     * Método principal que se ejecuta cuando se inicia el hilo del autobús.
     */
    @Override
    public void run(){
       while(true){
           try{
                
                entrarCiudad(); // Llega a la ciudad
                superior.esperar(); // Espera la sincronización
                numPasajeros = rand.nextInt(51); // Genera un número aleatorio de pasajeros
                Thread.sleep((rand.nextInt(4) + 2) * 1000); // Simula la duración de una acción
                superior.esperar(); // Espera la sincronización
                rutaAeropuerto(); // Realiza una acción específica
                superior.esperar(); // Espera la sincronización
                entrarAeropuerto(); // Llega al aeropuerto
                a.Entrar(numPasajeros); // Registra la entrada de pasajeros al aeropuerto
                superior.esperar(); // Espera la sincronización
                Thread.sleep((rand.nextInt(4) + 2) * 1000); // Simula la duración de una acción
                superior.esperar(); // Espera la sincronización
                if (a.NumPersonas() >= 50) {
                    numPasajeros = rand.nextInt(51); // Genera un número aleatorio de pasajeros
                } else {
                    if (a.NumPersonas() <= 0) {
                        numPasajeros = 0; // No hay pasajeros
                    } else {
                        numPasajeros = rand.nextInt(a.NumPersonas()); // Genera un número aleatorio de pasajeros
                    }
                }
                superior.esperar(); // Espera la sincronización
                a.Salir(numPasajeros); // Registra la salida de pasajeros del aeropuerto
                superior.esperar(); // Espera la sincronización
                rutaCiudad(); // Realiza una acción específica
                numPasajeros = 0; // Resetea el número de pasajeros
                superior.esperar(); // Espera la sincronización

            }catch (InterruptedException e){}
       }    
    }
    
    /**
     * Simula el trayecto del autobús hacia el aeropuerto.
     * @throws InterruptedException Si hay interrupción durante la simulación
     */
    private void rutaAeropuerto() throws InterruptedException{
        System.out.println(getMarcaTiempo() + " Bus " + id + " va al aeropuerto ");
        Thread.sleep((rand.nextInt(6)+ 5) * 1000); //Tiempo del trayecto al aeropuerto
    }
    
     /**
     * Simula el trayecto del autobús de regreso a la ciudad.
     * @throws InterruptedException Si hay interrupción durante la simulación
     */
    private void rutaCiudad() throws InterruptedException{
        System.out.println(getMarcaTiempo() + " Bus " + id + " vuelve a la ciudad ");
        Thread.sleep((rand.nextInt(6) + 5) * 1000); //Tiempo del trayecto a la ciudad
    }
    
    /**
     * Devuelve el aeropuerto actual del autobús.
     * @return Aeropuerto actual del autobús
     */
    public String getAeropuertoActual(){
        return aeropuertoActual;
    }
    
    /**
     * Devuelve la marca de tiempo actual como una cadena de texto.
     * @return Marca de tiempo actual
     */
    private String getMarcaTiempo(){
        return java.time.LocalTime.now().toString();
    }
}
