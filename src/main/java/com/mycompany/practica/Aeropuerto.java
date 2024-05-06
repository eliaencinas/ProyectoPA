/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 * Clase que representa un aeropuerto.
 * Esta clase gestiona diferentes aspectos de un aeropuerto, como el hangar, el área de estacionamiento,
 * las puertas de embarque, el área de rodaje, las pistas, las aerovías, los autobuses, etc.
 * @author elia y noelia
 */
public class Aeropuerto {
    // atributos
    private int numPersonas; // Número de personas en el aeropuerto
    JTextField nP; // Campo de texto para mostrar el número de personas
    private boolean parar = false; // Indicador para detener el aeropuerto
    private Log log; // Registro de eventos
    Random rand = new Random(); // Generador de números aleatorios

    // Listas
    Listas  avionesHangar, areaEstac, areaRod,aeroviaADestino, aeroviaAMi, busCiudad, busAeropuerto,avTaller;
    ListaPuertas puertasEmb;
    ListasPistas pistas;
    //semaforos
    public Semaphore puertaEmbarqueExclusiva;
    public Semaphore puertaDesembarqueExclusiva;
    public Semaphore puertaEmbarque;
    public Semaphore pista;
    public Semaphore meterEnLista = new Semaphore(1);
    public Semaphore sTaller = new Semaphore(20,true);
    public Semaphore sInspeccion = new Semaphore(1,true);
    //Locks
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock leer = lock.readLock();
    private Lock escribir = lock.writeLock();
        
    /**
     * Constructor de la clase Aeropuerto.
     * @param log Registro de eventos
     * @param aeroviaDest Lista de aerovía hacia el destino
     * @param aeroviaAMi Lista de aerovía hacia mí
     * @param bC Campo de texto para el autobús de la ciudad
     * @param bA Campo de texto para el autobús del aeropuerto
     * @param numP Campo de texto para el número de personas
     * @param h Campo de texto para el hangar
     * @param ArEst Campo de texto para el área de estacionamiento
     * @param pt1 Campo de texto para la puerta de embarque 1
     * @param pt2 Campo de texto para la puerta de embarque 2
     * @param pt3 Campo de texto para la puerta de embarque 3
     * @param pt4 Campo de texto para la puerta de embarque 4
     * @param pt5 Campo de texto para la puerta de embarque 5
     * @param pt6 Campo de texto para la puerta de embarque 6
     * @param areaR Campo de texto para el área de rodaje
     * @param pista1 Campo de texto para la pista 1
     * @param pista2 Campo de texto para la pista 2
     * @param pista3 Campo de texto para la pista 3
     * @param pista4 Campo de texto para la pista 4
     * @param aero Campo de texto para el aerovía
     * @param taller Campo de texto para el taller
     */
    public Aeropuerto( Log log, Listas aeroviaDest, Listas aeroviaAMi,JTextField bC, JTextField bA,JTextField numP,JTextField h, JTextField ArEst, JTextField pt1, JTextField pt2, JTextField pt3, JTextField pt4, JTextField pt5, JTextField pt6, JTextField areaR, JTextField pista1, JTextField pista2, JTextField pista3, JTextField pista4, JTextField aero,JTextField taller){
        // Inicialización de atributos
        this.aeroviaADestino = aeroviaDest;
        this.aeroviaAMi = aeroviaAMi;
        this.log = log;
        nP = numP;
        numPersonas = 0;
        avionesHangar = new Listas(h);
        areaEstac = new Listas(ArEst);
        puertasEmb = new ListaPuertas(pt1, pt2, pt3, pt4, pt5, pt6);
        areaRod = new Listas(areaR);
        puertaEmbarqueExclusiva = new Semaphore(1);
        puertaDesembarqueExclusiva = new Semaphore(1);
        puertaEmbarque = new Semaphore(4);
        pista = new Semaphore(4);
        pistas = new ListasPistas(pista1, pista2, pista3, pista4);
        busCiudad = new Listas(bC);
        busAeropuerto = new Listas(bA);
        avTaller = new Listas(taller);
    }
    
    
    // Métodos relacionados con el Hangar
    
    /**
     * Método para añadir un avión al hangar.
     * @param av Avión a añadir al hangar
     */
    public void AvionEnHangar(Avion av){
        avionesHangar.meter(av); // Añade el avión al hangar
        log.logEvent("el avion " + av.miId() + "ha entrado en el hangar del aeropuerto " + av.getAeropuertoActual());
        
    }
    
    /**
     * Método para sacar un avión del hangar.
     * @param av Avión a sacar del hangar
     */
    public void AvionSalirHangar(Avion av){
        avionesHangar.sacar(av); // Saca el avión del hangar
        log.logEvent("el avion " + av.miId() + "ha salido del hangar del aeropuerto " + av.getAeropuertoActual());
    }
    
    // Métodos relacionados con el Área de Estacionamiento
    
    /**
     * Método para que un avión entre en el área de estacionamiento.
     * @param av Avión que entra en el área de estacionamiento
     */
    public void EntrarAreaEstac(Avion av){
        areaEstac.meter(av);//Añade el avión al área de estacionamiento
        log.logEvent("el avion " + av.miId() + "ha entrado en el area de estacionamiento del aeropuerto " + av.getAeropuertoActual());
    }
    
        /**
     * Método para que un avión salga del área de estacionamiento.
     * @param av Avión que sale del área de estacionamiento
     */
    public void SalirAreaEstac(Avion av){
        areaEstac.sacar(av); //Saca el avión del área de estacionamiento
        log.logEvent("el avion " + av.miId() + "ha salido del area de estacionamiento del aeropuerto " + av.getAeropuertoActual());
    }
    
    
    // Métodos relacionados con las Puertas de Embarque
    
    /**
     * Método para solicitar una puerta de embarque.
     * @param av Avión que solicita la puerta de embarque
     * @throws InterruptedException
     */
    public void solicitarPuertaEmbarque(Avion av) throws InterruptedException{
        try{
            if(puertaEmbarque.availablePermits() == 0 && puertaEmbarqueExclusiva.availablePermits() == 1){
                puertaEmbarqueExclusiva.acquire();
                meterEnLista.acquire();
                puertasEmb.meter(av, true);
                meterEnLista.release();
                av.embarcar();
                puertasEmb.sacar(av, true);
                //meterEnLista.release();
                puertaEmbarqueExclusiva.release();
            }else{
                puertaEmbarque.acquire();
                meterEnLista.acquire();
                puertasEmb.meter(av, true);
                meterEnLista.release();
                av.embarcar();
                puertasEmb.sacar(av, true);
                //meterEnLista.release();
                puertaEmbarque.release();
            }
        }catch(InterruptedException e){}
    }
    
    /**
     * Método para solicitar una puerta de desembarque.
     * @param av Avión que solicita la puerta de desembarque
     * @throws InterruptedException
     */
    public void solicitarPuertaDesembarque(Avion av) throws InterruptedException{
        try{
            
            if(puertaEmbarque.availablePermits() == 0 && puertaDesembarqueExclusiva.availablePermits() == 1){
                puertaDesembarqueExclusiva.acquire();
                meterEnLista.acquire();
                puertasEmb.meter(av, false);
                meterEnLista.release();
                av.desembarcar();

                puertasEmb.sacar(av, false);

                puertaDesembarqueExclusiva.release();
            }else{
                puertaEmbarque.acquire();
                meterEnLista.acquire();
                puertasEmb.meter(av, false);
                meterEnLista.release();
                av.desembarcar();
                puertasEmb.sacar(av, false);
                //meterEnLista.release();
                puertaEmbarque.release();
            }
        }catch(InterruptedException e){}

    }
    
    // Métodos relacionados con la gestión de personas
    
    /**
     * Método para que las personas entren al aeropuerto.
     * @param personas Número de personas que entran
     */
    public void Entrar(int personas){
        escribir.lock();
            try{
                numPersonas += personas;
                actualizarNumPersonas();
            }finally { escribir.unlock();}
            actualizarNumPersonas();
    }
    
    /**
     * Método para que las personas salgan del aeropuerto.
     * @param personas Número de personas que salen
     * @return Número de personas que salieron
     */
    public int Salir(int personas){
        escribir.lock();
        try{
            numPersonas -= personas;
            actualizarNumPersonas();
        }finally {escribir.unlock();} 
        actualizarNumPersonas();
        return personas;
    }
    
    /**
     * Método para obtener el número de personas en el aeropuerto.
     * @return Número de personas en el aeropuerto
     */
    public int NumPersonas(){
        int num = 0;
        leer.lock();
        try{
            num = numPersonas;
        }finally { leer.unlock();}
        return num;
    }
    
    /**
     * Método para actualizar el número de personas en el aeropuerto.
     */
    public void actualizarNumPersonas(){
        nP.setText(String.valueOf(numPersonas));
    }
    
    // Métodos relacionados con el Área de Rodaje
    
    /**
     * Método para añadir un avión al área de rodaje.
     * @param av Avión que entra en el área de rodaje
     */
    public void AvionEnAreaRodaje(Avion av){
        areaRod.meter(av); // Añade el avión al área de rodaje
        log.logEvent("el avion " + av.miId() + "esta entrando en el area de rodaje del aeropuerto " + av.getAeropuertoActual());
    }
    
    /**
     * Método para sacar un avión del área de rodaje.
     * @param av Avión que sale del área de rodaje
     */
    public void AvionSalirAreaRod(Avion av){
        areaRod.sacar(av); //Saca el avión del área de rodaje
        log.logEvent("el avion " + av.miId() + "esta saliendo del area de rodaje del aeropuerto " + av.getAeropuertoActual());
    }
    
    // Métodos relacionados con las Pistas
    
     /**
     * Método para solicitar una pista para el despegue.
     * @param av Avión que solicita la pista para despegar
     * @throws InterruptedException
     */
    public void solicitarPistaDespegue(Avion av) throws InterruptedException{
        
        while(pista.availablePermits() == 0){
            Thread.sleep(1000 + rand.nextInt(6001));
        }
        pista.acquire();
        pistas.meter(av);
        log.logEvent("el avion " + av.miId() + "esta entrando en la pista del aeropuerto " + av.getAeropuertoActual() + "para despegar");
        Thread.sleep(1000 + rand.nextInt(4001));
        pista.release();
        av.despegar();

        pistas.sacar(av);
    }
    
    /**
     * Método para solicitar una pista para el aterrizaje.
     * @param av Avión que solicita la pista para aterrizar
     * @throws InterruptedException
     */
    public void solicitarPistaAterrizaje(Avion av) throws InterruptedException{
        while(pista.availablePermits() == 0){
            Thread.sleep(1000 + rand.nextInt(6001));
        }
        pista.acquire();
        pistas.meter(av);
        log.logEvent("el avion " + av.miId() + "esta entrando la pista del aeropuerto " + av.getAeropuertoActual() + "para aterrizar");
        pista.release();
        pistas.sacar(av);
            
    }
    
    /**
     * Método para obtener la lista de pistas.
     * @return Lista de pistas
     */
    public ListasPistas getPista(){
        return pistas;
    }
    
    /**
     * Método para meter un avión en la aerovía hacia el destino.
     * @param av Avión que entra en la aerovía hacia el destino
     * @throws InterruptedException
     */
    public void meterAeroviaADestino(Avion av) throws InterruptedException{
        aeroviaADestino.meter(av);
        Thread.sleep((rand.nextInt(16) + 15) *1000);
    }
    
     /**
     * Método para sacar un avión de la aerovía hacia el destino.
     * @param av Avión que sale de la aerovía hacia el destino
     * @throws InterruptedException
     */
    public void salirAeroviaDestino(Avion av) throws InterruptedException{
        aeroviaADestino.sacar(av);
    }
    
     /**
     * Método para meter un avión en la aerovía hacia mí.
     * @param av Avión que entra en la aerovía hacia mí
     * @throws InterruptedException
     */
    public void meterAeroviaAMi(Avion av)throws InterruptedException{
        aeroviaAMi.meter(av);
        Thread.sleep((rand.nextInt(16) + 15) *1000);
        
    }
    
     /**
     * Método para sacar un avión de la aerovía hacia mí.
     * @param av Avión que sale de la aerovía hacia mí
     * @throws InterruptedException
     */
    public void salirAeroviaAMi(Avion av) throws InterruptedException{
        aeroviaAMi.sacar(av);
        
    }
    
    // Métodos relacionados con los autobuses
    
    /**
     * Método para mover un autobús a la ciudad.
     * @param bus Autobús que se mueve a la ciudad
     */
    public void autobusEnCiudad(Autobus bus){
        busAeropuerto.sacar(bus);
        busCiudad.meter(bus); 
    }
    
    /**
     * Método para mover un autobús al aeropuerto.
     * @param bus Autobús que se mueve al aeropuerto
     */

    public void autobusEnAeropuerto(Autobus bus){
       busCiudad.sacar(bus);
       busAeropuerto.meter(bus);   
    }
    
    // Métodos relacionados con el taller
    
    /**
     * Método para solicitar el taller para un avión.
     * @param av Avión que solicita el taller
     * @throws InterruptedException
     */
    public void solicitarTaller(Avion av) throws InterruptedException{
        try{
            avTaller.meter(av);
            sTaller.acquire();
            Thread.sleep(1000);
            realizarInspeccion(av);
            avTaller.sacar(av);
            sTaller.release();
        }catch(InterruptedException e){}
    }
    
    /**
     * Método para realizar una inspección en el taller.
     * @param av Avión que se inspecciona
     * @throws InterruptedException
     */
    public void realizarInspeccion(Avion av) throws InterruptedException{
        try{
            sInspeccion.acquire();
            log.logEvent("el avion " +av.miId()+" esta en taller del aeropuerto de "+av.getAeropuertoActual()+ "realizando una inspeccion");
            av.inspeccionar();
            sInspeccion.release();
            avTaller.sacar(av);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
    
    /**
     * Método para detener el aeropuerto.
     */
    public void detener(){
        this.parar = true; 
        
    }
    
    /**
     * Método para verificar si se debe detener el aeropuerto.
     * @return true si se debe detener, false en caso contrario
     */
    public boolean mirarSiParar(){
        return parar;
    }
    
    /**
     * Método para obtener el número de aviones en el hangar.
     * @return Número de aviones en el hangar
     */
    public int numAvionesHangar(){
        return avionesHangar.longitud();
    }
    
    /**
     * Método para obtener el número de aviones en el área de estacionamiento.
     * @return Número de aviones en el área de estacionamiento
     */
    public int numAvionesAreaEstac(){
       return areaEstac.longitud();
    }
    
    /**
     * Método para obtener el número de aviones en el área de rodaje.
     * @return Número de aviones en el área de rodaje
     */
    public int numAVionesAreaRod(){
        return areaRod.longitud();
    }
    
    /**
     * Método para obtener el número de aviones en el taller.
     * @return Número de aviones en el taller
     */
    public int numAvionesTaller(){
        return avTaller.longitud();
    }

    /**
     * Método para obtener la lista de aerovía hacia el destino.
     * @return Lista de aerovía hacia el destino
     */
    public Listas getAerovia() {
        return aeroviaADestino;
    }   
    
}