package com.mycompany.proyectofinalpa.model;

public class SignosVitales {
    
    private double temperatura;
    private int frecuenciaCardiaca;
    private int saturacionOxigeno;
    private int nivelDolor;
    private String motivoConsulta;
    
    public double getTemperatura(){
        return temperatura;
    }
    public void setTemperatura(double temperatura){
        this.temperatura = temperatura;
    }
    
    
    public int getFrecuenciaCardiaca(){
        return frecuenciaCardiaca;
    }
    public void setFrecuenciaCardiaca(int frecuenciaCardiaca){
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }
    
    
    public int getSaturacionOxigeno(){
        return saturacionOxigeno;
    }
    public void setSaturacionOxigeno(int saturacionOxigeno){
        this.saturacionOxigeno = saturacionOxigeno;
    }
    
    
    public int getNivelDolor(){
        return nivelDolor;
    }
    public void setNivelDolor(int nivelDolor){
        this.nivelDolor = nivelDolor; 
    }
    
    
    public String getMotivoConsulta(){
        return motivoConsulta;
    }
    public void setMotivoConsulta(String motivoConsulta){
        this.motivoConsulta = motivoConsulta;
    }
}
