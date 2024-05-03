/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
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
    Listas  avionesHangar;
    Listas areaEstac;
    ListaPuertas puertasEmb;
    Listas areaRod;
    //semaforos
    public Semaphore puertaEmbarqueExclusiva;
    public Semaphore puertaDesembarqueExclusiva;
    public Semaphore puertaEmbarque;
    public Semaphore meterEnLista = new Semaphore(1);
    //Locks
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock leer = lock.readLock();
    private Lock escribir = lock.writeLock();
    
    public Aeropuerto(JTextField h, JTextField ArEst, JTextField pt1, JTextField pt2, JTextField pt3, JTextField pt4, JTextField pt5, JTextField pt6, JTextField areaR){
        numPersonas = 3000;
        avionesHangar = new Listas(h);
        areaEstac = new Listas(ArEst);
        puertasEmb = new ListaPuertas(pt1, pt2, pt3, pt4, pt5, pt6);
        areaRod = new Listas(areaR);
        puertaEmbarqueExclusiva = new Semaphore(1);
        puertaDesembarqueExclusiva = new Semaphore(1);
        puertaEmbarque = new Semaphore(4);
        listaPuertaEmbarque = new ArrayList<>(6);
    }
    
    
    // Hangar
    public void AvionEnHangar(Avion av){
        avionesHangar.meter(av);
    }
    
    public void AvionSalirHangar(Avion av){
        avionesHangar.sacar(av);
    }
    
    // Area de estacionamiento
     public void EntrarAreaEstac(Avion av){
        areaEstac.meter(av); //Añade el elemento
    }
    
    public void SalirAreaEstac(Avion av){
        areaEstac.sacar(av);
    }
    
    //puerta de embarque
    public void solicitarPuertaEmbarque(Avion av){
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
    
    public void solicitarPuertaDesembarque(Avion av){
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
    
    
    //gestion de personas
    public void Entrar(int personas){
        escribir.lock();
        try{
            numPersonas += personas;
        }finally { escribir.unlock();}
    }
    
    public int Salir(int personas){
        escribir.lock();
        try{
            numPersonas -= personas;
            
        }finally {escribir.unlock();}
        return personas;
    }
    
    public int NumPersonas(){
        int num = 0;
        leer.lock();
        try{
            num = numPersonas;
        }finally { leer.unlock();}
        return num;
    }
    
    //Area de Rodaje
    public void AvionEnAreaRodaje(Avion av){
        areaRod.meter(av);
    }
    
    public void AvionSalirAreaRod(Avion av){
        areaRod.sacar(av);
    }
    
}
