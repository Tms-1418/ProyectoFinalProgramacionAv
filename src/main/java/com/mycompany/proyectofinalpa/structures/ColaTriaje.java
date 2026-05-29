package com.mycompany.proyectofinalpa.structures;

import com.mycompany.proyectofinalpa.model.TurnoMedico;
import java.util.ArrayList; 

public class ColaTriaje{
    private ArrayList<TurnoMedico> cola;
    
    public ColaTriaje(){
        cola = new ArrayList<>();
    }
    
    public void encolar (TurnoMedico turno){
        int i = 0;
        while (i<cola.size() && cola.get(i).getNivelTriaje()<= 
                turno.getNivelTriaje()){
            i++;
        }
        cola.add(i, turno);
    }
    
    public TurnoMedico desencolar(){
        if (cola.isEmpty())return null;
        return cola.remove(0);
    }
    
    public TurnoMedico verSiguiente(){
        if (cola.isEmpty())return null;
        return cola.get(0);
    }
    
    public boolean estaVacia(){
        return cola.isEmpty();
    }
    
    public ArrayList<TurnoMedico> getTodos(){
        return cola;
    }
    
}