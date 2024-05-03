/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.App;

import java.time.*;
import java.time.Month;
import java.util.logging.Logger;

/**
 *rappresenta un pugile
 * 
 * @author Studente
 */
public class Pugile 
{
    private int idNumerico, categoriaDiPeso;
    private String nome,cognome;
    private String[] record;
    LocalDate dataDiNascita;

    public Pugile(int idNumerico, int categoriaDiPeso, String nome, String cognome, String[] record, LocalDate dataDiNascita)
    {
        this.idNumerico = idNumerico;
        this.categoriaDiPeso = categoriaDiPeso;
        this.nome = nome;
        this.cognome = cognome;
        this.record = record;
        this.dataDiNascita = dataDiNascita;
    }

    public Pugile(Pugile pugile)
    {
        this.idNumerico = pugile.getIdNumerico();
        this.categoriaDiPeso = pugile.getCategoriaDiPeso();
        this.nome = pugile.getNome();
        this.cognome = pugile.getCognome();
        this.record = pugile.getRecord();
        this.dataDiNascita = pugile.getDataDiNascita();
    }
    public int getIdNumerico() 
    {
        return idNumerico;
    }

    public int getCategoriaDiPeso() 
    {
        return categoriaDiPeso;
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
    
    public String visualizzaRecord() 
    {
        String s=" record: ";
        for(int i=0;i<record.length;i++)
        {
            s+=record[i];
        }
        return s;
    }

    public LocalDate getDataDiNascita()
    {
        return dataDiNascita;
    }

    public void setIdNumerico(int idNumerico)
    {
        this.idNumerico = idNumerico;
    }

    public void setCategoriaDiPeso(int categoriaDiPeso)
    {
        this.categoriaDiPeso = categoriaDiPeso;
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

    public void setDataDiNascita(LocalDate dataDiNascita)
    {
        this.dataDiNascita = dataDiNascita;
    }
    
    public void AggiornaRecord(boolean vittoria,Pugile pugile)
    {
        if(vittoria==true)
            for(int i=0;i<=pugile.record.length; i++)
            {
                if(pugile.record[i]==null)
                    pugile.record[i]="W";
            }
        if(vittoria==false)
            for(int i=0;i<=pugile.record.length; i++)
            {
                if(pugile.record[i]==null)
                    pugile.record[i]="S";
            }
        else
            for(int i=0;i<=pugile.record.length; i++)
            {
                if(pugile.record[i]==null)
                    pugile.record[i]="P";
            }
        
    }
    

    
    @Override
    public String toString() 
    {
        
        return "Pugile{" + "Nome=" + nome + ", Cognome=" + cognome +  ", dataDiNascita=" + dataDiNascita + ", categoria di peso " + categoriaDiPeso + " libre" + '}';
    }
    
   
    
}
