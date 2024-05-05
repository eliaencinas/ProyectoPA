/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.practica;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author NoeliaUni
 */
public interface InterfazAeropuerto extends Remote {
    int obtenerNumPasajeros(Aeropuerto aeropuerto) throws RemoteException;
    int obtenerNumAvionesHangar(Aeropuerto aeropuerto) throws RemoteException;
    int obtenerNumAvionesTaller(Aeropuerto aeropuerto) throws RemoteException;
    int obtenerNumAvionesAreaEst(Aeropuerto aeropuerto) throws RemoteException;
    int obtenerNumAvionesAreaRod(Aeropuerto aeropuerto) throws RemoteException;
    Listas obtenerColaAvionesAerovia(Aeropuerto aeropuerto) throws RemoteException;
    void cerrarPista(Aeropuerto aeropuerto, int numPista) throws RemoteException;
    void abrirPista(Aeropuerto aeropuerto, int numPista) throws RemoteException;
}
