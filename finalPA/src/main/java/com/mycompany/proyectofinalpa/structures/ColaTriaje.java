package com.mycompany.proyectofinalpa.structures;

import com.mycompany.proyectofinalpa.model.TurnoMedico;

import java.util.PriorityQueue;
import java.util.Comparator;

public class ColaTriaje {

    private PriorityQueue<TurnoMedico> cola;

    public ColaTriaje() {

        cola = new PriorityQueue<>(
            Comparator.comparingInt(TurnoMedico::getNivelTriaje)
        );

    }

    public void encolar(TurnoMedico turno) {

        cola.add(turno);

    }

    public TurnoMedico desencolar() {

        return cola.poll();

    }

    public TurnoMedico verSiguiente() {

        return cola.peek();

    }

    public boolean estaVacia() {

        return cola.isEmpty();

    }

}