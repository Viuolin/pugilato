/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.App;

import java.time.LocalDateTime;

/**
 *
 * @author Studente
 */
public class App
{

    public static void main(String[] args)
    {
        String nome = null, cognome = null;
        Pugile p1=new Pugile(nome, cognome, args, LocalDateTime.MIN);
        System.out.println(p1.toString());
    }
}
