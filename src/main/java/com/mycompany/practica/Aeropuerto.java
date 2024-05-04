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
 *
 * @author elia y noelia
 */
public class Aeropuerto {
    // atributos
    private int numPersonas;
    //Array
    ArrayList<String> listaPuertaEmbarque;
    //Random 
    Random rand = new Random();
    // Listas
    Listas  avionesHangar, areaEstac, areaRod,aerovia, busCiudad, busAeropuerto,avTaller;
    ListaPuertas puertasEmb;
    ListasPistas pistas;
    //semaforos
    public Semaphore puertaEmbarqueExclusiva;
    public Semaphore puertaDesembarqueExclusiva;
    public Semaphore puertaEmbarque;
    public Semaphore meterEnLista = new Semaphore(1);
    public Semaphore sTaller = new Semaphore(20,true);
    public Semaphore sInspeccion = new Semaphore(1,true);
    //Locks
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock leer = lock.readLock();
    private Lock escribir = lock.writeLock();
    private Lock parada = new ReentrantLock();
    private Condition parado = parada.newCondition();
    JTextField nP;
    private boolean parar = false;
    
    public Aeropuerto(JTextField bC, JTextField bA,JTextField numP,JTextField h, JTextField ArEst, JTextField pt1, JTextField pt2, JTextField pt3, JTextField pt4, JTextField pt5, JTextField pt6, JTextField areaR, JTextField pista1, JTextField pista2, JTextField pista3, JTextField pista4, JTextField aero,JTextField taller){
        nP = numP;
        numPersonas = 0;
        avionesHangar = new Listas(h);
        areaEstac = new Listas(ArEst);
        puertasEmb = new ListaPuertas(pt1, pt2, pt3, pt4, pt5, pt6);
        areaRod = new Listas(areaR);
        puertaEmbarqueExclusiva = new Semaphore(1);
        puertaDesembarqueExclusiva = new Semaphore(1);
        puertaEmbarque = new Semaphore(4);
        listaPuertaEmbarque = new ArrayList<>(6);
        pistas = new ListasPistas(pista1, pista2, pista3, pista4);
        aerovia = new Listas(aero);
        busCiudad = new Listas(bC);
        busAeropuerto = new Listas(bA);
        avTaller = new Listas(taller);
    }
    
    
    // Hangar
    public void AvionEnHangar(Avion av){
        if(mirarSiParar()){
            try{
                parado.await();
            }catch(InterruptedException ex){
                Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            avionesHangar.meter(av);
        }
    }
    
    public void AvionSalirHangar(Avion av){
        if(mirarSiParar()){
            try{
                parado.await();
            }catch(InterruptedException ex){
                Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            avionesHangar.sacar(av);
        }
    }
    
    // Area de estacionamiento
     public void EntrarAreaEstac(Avion av){
        if(mirarSiParar()){
            try{
                parado.await();
            }catch(InterruptedException ex){
                Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            areaEstac.meter(av);//Añade el elemento
        } 
    }
    
    public void SalirAreaEstac(Avion av){
        if(mirarSiParar()){
            try{
                parado.await();
            }catch(InterruptedException ex){
                Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            areaEstac.sacar(av);
        }
    }
    
    //puerta de embarque
    public void solicitarPuertaEmbarque(Avion av){
        if(mirarSiParar()){
            try{
                parado.await();
            }catch(InterruptedException ex){
                Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
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
        }catch (InterruptedException e){}
        }
    }
    
    public void solicitarPuertaDesembarque(Avion av) throws InterruptedException{
        if(mirarSiParar()){
            try{
                parado.await();
            }catch(InterruptedException ex){
                Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
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
            }catch (InterruptedException e){}
    }
    }
    
    //gestion de personas
    public void Entrar(int personas){
        if(mirarSiParar()){
            try{
                parado.await();
            }catch(InterruptedException ex){
                Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            escribir.lock();
            try{
                numPersonas += personas;
                actualizarNumPersonas();
            }finally { escribir.unlock();}
        } 
    }
    
    public int Salir(int personas){
        if(mirarSiParar()){
            try{
                parado.await();
            }catch(InterruptedException ex){
                Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            escribir.lock();
        try{
            numPersonas -= personas;
            actualizarNumPersonas();
        }finally {escribir.unlock();}
        }  
        return personas;
    }
    
    public int NumPersonas(){
        int num = 0;
        leer.lock();
        try{
            num = numPersonas;
        }finally { leer.unlock();}
        
        if(mirarSiParar()){
            try{
                parado.await();
            }catch(InterruptedException ex){
                Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return num;
    }
    
    public void actualizarNumPersonas(){
        nP.setText(String.valueOf(numPersonas));
    }
    
    //Area de Rodaje
    public void AvionEnAreaRodaje(Avion av){
        if(mirarSiParar()){
            try{
                parado.await();
            }catch(InterruptedException ex){
                Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            areaRod.meter(av);
        }
    }
    
    public void AvionSalirAreaRod(Avion av){
        if(mirarSiParar()){
            try{
                parado.await();
            }catch(InterruptedException ex){
                Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            areaRod.sacar(av);
        }
    }
    
    public void solicitarPistaDespegue(Avion av){
        if(mirarSiParar()){
            try{
                parado.await();
            }catch(InterruptedException ex){
                Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            int numPista = obtenerPista(av);
            pistas.meter(av);
            av.despegar();
            pistas.sacar(av);
        }
    }
    
    public void solicitarPistaAterrizaje(Avion av){
        if(mirarSiParar()){
            try{
                parado.await();
            }catch(InterruptedException ex){
                Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            int numPista = obtenerPista(av);
            pistas.meter(av);
            av.aterrizar();
            pistas.sacar(av);
        }
    }
    
    
    public int obtenerPista(Avion av){
        if(mirarSiParar()){
            try{
                parado.await();
            }catch(InterruptedException ex){
                Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            for(int i = 1; i <= 4; i++){
            if(!pistas.estaOcupada(i, av)){
                return i;
            }
            }
        }
        return -1;
    }
    
    public void meterEnAerovia(Avion av) throws InterruptedException{
        if(mirarSiParar()){
            try{
                parado.await();
            }catch(InterruptedException ex){
                Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            aerovia.meter(av);
            Thread.sleep(15000 + (rand.nextInt(16000)));
        }
        
    }

    public void autobusEnCiudad(Autobus bus){
        if(mirarSiParar()){
            try{
                parado.await();
            }catch(InterruptedException ex){
                Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            busAeropuerto.sacar(bus);
            busCiudad.meter(bus);
        }
    }
    
    public void autobusEnAeropuerto(Autobus bus){
        if(mirarSiParar()){
            try{
                parado.await();
            }catch(InterruptedException ex){
                Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            busCiudad.sacar(bus);
            busAeropuerto.meter(bus);
        }
        
    }
    
    public void solicitarTaller(Avion av) throws InterruptedException{
        if(mirarSiParar()){
            try{
                parado.await();
            }catch(InterruptedException ex){
                Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
           try{
            avTaller.meter(av);
            sTaller.acquire();
            Thread.sleep(1000);
            realizarInspeccion(av);
            avTaller.sacar(av);
            sTaller.release();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }  
        }        
    }
    
    public void realizarInspeccion(Avion av) throws InterruptedException{
        try{
            sInspeccion.acquire();
            av.inspeccionar();
            sInspeccion.release();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
    
    public void detener(){
        this.parar = true;
    }
    
    public boolean mirarSiParar(){
        return this.parar;
    }
    public void continuar(){
        parada.lock();
        try{
            this.parar = false;
            parado.signalAll();
        }finally{
            parada.unlock();
        }
    }
}
