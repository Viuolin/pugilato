/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.App;

import eccezioni.*;

/**
 *
 * @author Studente
 */
public class Incontro
{
     private static final int NUM_COMBATTENTI=2;
     private Pugile[] combattenti;

    public Incontro() 
    {
         combattenti=new Pugile[NUM_COMBATTENTI];    
    }
    
    
    public void setCombattente(Pugile combattente,int posizione) throws PosizioneNonValida, PosizioneOccupata
    {
        if(posizione<0 || posizione>NUM_COMBATTENTI)
            throw new PosizioneNonValida();
        if(combattenti[posizione]!=null)
            throw new PosizioneOccupata();
        combattenti[posizione]=new Pugile(combattente);
    }
         
    public Pugile getCombattente(int posizione) throws PosizioneNonValida, PosizioneVuota
    {
        Pugile p;
        if (posizione<0 || posizione>=(NUM_COMBATTENTI))
            throw new PosizioneNonValida();
        if (combattenti[posizione]==null)
            throw new PosizioneVuota();
        p=combattenti[posizione];
            return new Pugile(p);
    }
          
    public void rimuoviCombattente(int posizione) throws PosizioneNonValida, PosizioneVuota
    {
        if(posizione<0 || posizione>NUM_COMBATTENTI)
            throw new PosizioneNonValida();
        
        if(combattenti[posizione]==null)
            throw new PosizioneVuota();
        combattenti[posizione]=null;
    }
    
     public void setEsito( int posvincitore) throws combattentiNonInseriti, PosizioneNonValida, PosizioneVuota
     {
         if(posvincitore<0 || posvincitore>NUM_COMBATTENTI)
              throw new PosizioneNonValida();
         if(combattenti[0]==null || combattenti[1]==null)
             throw new PosizioneVuota();
         else if(posvincitore==0)
         {
             combattenti[0].AggiornaRecord(true, combattenti[0]);
             combattenti[1].AggiornaRecord(false, combattenti[1]);
         }
         
         else if(posvincitore==1)
         {
             combattenti[1].AggiornaRecord(true, combattenti[1]);
             combattenti[0].AggiornaRecord(false, combattenti[0]);
         }
         
     }
            
            
   
     
    public String toString()
    {
        String s=" ";
        for(int i=0; i<NUM_COMBATTENTI; i++)
        {
            if(i==0 && combattenti[i]==null)
            {
                s+=" combattente non ancora inserito VS ";
            }
            if(i==1 && combattenti[i]==null)
            {
                s+=" combattente non ancora inserito ";
            }
            if(i==0 && combattenti[i]!=null)
            s+=combattenti[i]+" VS ";
            if(i==1 && combattenti[i]!=null)
            s+=combattenti[i];
        }return s;
        
    }
     
}
