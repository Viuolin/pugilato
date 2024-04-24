/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.App;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.logging.Logger;

/**
 *
 * @author Studente
 */
public class Pugile 
{
    private String nome,cognome;
    private String[] record;
    LocalDateTime dataDiNascita;

    public Pugile(String nome, String cognome, String[] record, LocalDateTime dataDiNascita) 
    {
        this.nome = nome;
        this.cognome = cognome;
        this.record = record;
        this.dataDiNascita = dataDiNascita;
    }

    public String getNome()
    {
        return nome;
    }

    public String getCognome()
    {
        return cognome;
    }

    public String[] getRecord() 
    {
        return record;
    }

    public LocalDateTime getDataDiNascita()
    {
        return dataDiNascita;
    }

    public void setNome(String Nome) 
    {
        this.nome = nome;
    }

    public void setCognome(String Cognome) 
    {
        this.cognome = cognome;
    }

    public void setRecord(String[] Record) 
    {
        this.record = record;
    }

    public void setDataDiNascita(LocalDateTime dataDiNascita)
    {
        this.dataDiNascita = dataDiNascita;
    }

    @Override
    public String toString() 
    {
        return "Pugile{" + "Nome=" + nome + ", Cognome=" + cognome + ", Record=" + record + ", dataDiNascita=" + dataDiNascita + '}';
    }
    
   
    
}
