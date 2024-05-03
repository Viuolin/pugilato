/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.App;

import eccezioni.MatchNonValido;
import eccezioni.PosizioneNonValida;
import eccezioni.PosizioneOccupata;
import eccezioni.PosizioneVuota;
import eccezioni.combattentiNonInseriti;

/**
 *
 * @author Studente
 */
public class Campionato 
{
     private static final int NUM_INCONTRI=4;
     private Incontro[] match;
     
     public Campionato()
     {
         match=new Incontro[NUM_INCONTRI];
         for(int i=0;i<NUM_INCONTRI;i++)
        {
            match[i]=new Incontro();
        }
     }
     
     public void setPugile(Pugile pugile,int numMatchInserimento,int posizione) throws PosizioneOccupata, PosizioneNonValida, MatchNonValido
     {
         if(numMatchInserimento<0 || numMatchInserimento>=NUM_INCONTRI)
             throw new MatchNonValido();
         match[numMatchInserimento].setCombattente(pugile, posizione);
     }
     
     public Pugile getPugile(int numMatchInserimento,int posizione) throws MatchNonValido, PosizioneNonValida, PosizioneVuota
     {
         Pugile pugile;
         if (numMatchInserimento<0 || numMatchInserimento>=NUM_INCONTRI)
             throw new MatchNonValido();
        pugile=match[numMatchInserimento].getCombattente(posizione);
        return pugile;
         
     }
     
     public void rimuoviPugile(int numMatchInserimento, int posizione) throws MatchNonValido, PosizioneNonValida, PosizioneVuota
     {
         if(numMatchInserimento<0 || numMatchInserimento>NUM_INCONTRI)
             throw new MatchNonValido();
         match[numMatchInserimento].rimuoviCombattente(posizione);
         
     }

    
    @Override
    public String toString() 
    {
        String s="Campionato:";
        for(int i=0; i<NUM_INCONTRI; i++)
        {
        s+="\n match "+ i + match[i].toString();
        }
        return s;
    }
     
    
}
