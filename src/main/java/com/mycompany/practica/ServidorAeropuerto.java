/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author NoeliaUni
 */
public class ServidorAeropuerto extends UnicastRemoteObject implements InterfazAeropuerto{

    public ServidorAeropuerto() throws RemoteException{
        super();
    }
    
    @Override
    public int obtenerNumPasajeros(Aeropuerto aeropuerto) throws RemoteException {
        return aeropuerto.NumPersonas();
    }

    @Override
    public int obtenerNumAvionesHangar(Aeropuerto aeropuerto) throws RemoteException {
       return aeropuerto.numAvionesHangar();
    }

    @Override
    public int obtenerNumAvionesTaller(Aeropuerto aeropuerto) throws RemoteException {
        return aeropuerto.numAvionesTaller();
    }

    @Override
    public int obtenerNumAvionesAreaEst(Aeropuerto aeropuerto) throws RemoteException {
       return aeropuerto.numAvionesAreaEstac();
    }

    @Override
    public int obtenerNumAvionesAreaRod(Aeropuerto aeropuerto) throws RemoteException {
        return aeropuerto.numAVionesAreaRod();
    }

    @Override
    public Listas obtenerColaAvionesAerovia(Aeropuerto aeropuerto) throws RemoteException {
        return aeropuerto.getAerovia();
    }

    @Override
    public void cerrarPista(Aeropuerto aeropuerto, int numPista) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void abrirPista(Aeropuerto aeropuerto, int numPista) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
