/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.App;

import eccezioni.PosizioneNonValida;
import eccezioni.PosizioneOccupata;
import eccezioni.PosizioneVuota;
import java.time.*;

/**
 *
 * @author Studente
 */
public class App
{

    public static void main(String[] args) throws PosizioneNonValida, PosizioneOccupata, PosizioneVuota
    {
        String nome = "Ryan", cognome = "Garcia";
        String[] record={"W","W","W","W","W","W","W","W","W","W","W"};
        LocalDate dataDiNascita=LocalDate.of(1998, Month.AUGUST, 8); 
        Pugile p1=new Pugile(1, 135, nome, cognome, record, dataDiNascita);
        Incontro inc1=new Incontro();
        inc1.setCombattente(p1, 0);
        inc1.setCombattente(p1, 1);
        inc1.eliminaCombattente( 0);
        System.out.println(inc1.toString());
        
    }
}
