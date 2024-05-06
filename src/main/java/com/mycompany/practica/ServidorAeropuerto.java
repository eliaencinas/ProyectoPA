/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Noelia y elia
 */
public class ServidorAeropuerto extends UnicastRemoteObject implements InterfazAeropuerto{
    private Aeropuerto aeropuerto;
    
    public ServidorAeropuerto() throws RemoteException{
        super();
    }
    
    public void obtenerAeropuerto(Aeropuerto aeropuerto) throws RemoteException{
        this.aeropuerto = aeropuerto;
    }
    
    
    public int obtenerNumPasajeros() throws RemoteException {
        return aeropuerto.NumPersonas();
    }

    
    
    public int obtenerNumAvionesHangar() throws RemoteException {
       return aeropuerto.numAvionesHangar();
    }

    
    
    public int obtenerNumAvionesTaller() throws RemoteException {
        return aeropuerto.numAvionesTaller();
    }

    
    
    public int obtenerNumAvionesAreaEst() throws RemoteException {
       return aeropuerto.numAvionesAreaEstac();
    }

    
    
    public int obtenerNumAvionesAreaRod() throws RemoteException {
        return aeropuerto.numAVionesAreaRod();
    }

   
    
    public Listas obtenerColaAvionesAerovia() throws RemoteException {
        return aeropuerto.getAerovia();
    }

    
    
    public void cerrarPista( int numPista) throws RemoteException {
        aeropuerto.getPista().cerrada(numPista);
    }

    
    
    public void abrirPista( int numPista) throws RemoteException {
        aeropuerto.getPista().abierta(numPista);
        
    }
    
}
