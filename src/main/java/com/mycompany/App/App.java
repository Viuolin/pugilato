/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.App;

import eccezioni.MatchNonValido;
import eccezioni.PosizioneNonValida;
import eccezioni.PosizioneOccupata;
import eccezioni.PosizioneVuota;
import eccezioni.combattentiNonInseriti;
import java.time.*;
import utilita.ConsoleInput;
import utilita.Menu;
import utilita.TextFile;

/**
 *
 * @author Studente
 */
public class App
{

    public static void main(String[] args) throws PosizioneNonValida, PosizioneOccupata, PosizioneVuota, MatchNonValido, combattentiNonInseriti
    {
        String nome = "Ryan", cognome = "Garcia";
        String[] record1=new String[100];
        String[] record2=new String[100];
        LocalDate dataDiNascita=LocalDate.of(1998, Month.AUGUST, 8); 
        Pugile p1=new Pugile(1, 135, nome, cognome, record1, dataDiNascita);
        Pugile p2=new Pugile(2, 135, "Gervonta", "Davis", record2 , dataDiNascita);
        Incontro inc1=new Incontro();
        inc1.setCombattente(p1, 0);
        inc1.setCombattente(p2, 1);
        System.out.println(inc1.toString());
        Campionato campionatoJacobino=new Campionato();
        
        int numVociMenu=10;
        String[] vociMenu=new String[numVociMenu];
        Menu menu;
        int voceMenuScelta;
        ConsoleInput tastiera=new ConsoleInput();
        TextFile f1 = null;
        
        campionatoJacobino.setPugile(p1, 1, 1);
        campionatoJacobino.setPugile(p2, 2, 1);
        System.out.println(p1.visualizzaRecord());
        System.out.println(p2.toString());
        inc1.setEsito(0);
        System.out.println(p2.visualizzaRecord());
        
        
        vociMenu[0]="0 -->\tEsci";
        vociMenu[1]="1 -->\tVisualizza ranking";
        vociMenu[2]="2 -->\tAggiungi combattente (posizione)";
        vociMenu[3]="3 -->\tCerca combattente ( posizione)";
        vociMenu[4]="4 -->\tElimina combattente (posizione)";
        vociMenu[5]="5 -->\tMostra incontri di uno specifico ";
        vociMenu[6]="6 -->\tMostra elenco dei volumi presenti ordinato alfabeticamente per titolo";
        vociMenu[7]="7 -->\tesporta volumi in formato CSV";

        
    }
}
