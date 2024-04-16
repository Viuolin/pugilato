package com.mycompany._progettolibreria_4a;

import eccezioni.EccezionePosizioneNonValida;
import eccezioni.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilita.TextFile;

/**
 * Rappresenta uno scaffale costituito da
 * NUM_RIPIANI mensole, ciascuna delle quali può 
 * contenere dei libri.
 */
public final class Scaffale{
    private Mensola[] ripiani; //array di mensole
    private final static int NUM_RIPIANI=5;
    
/**
 * Costruttore
 */    
    public Scaffale(){
        ripiani=new Mensola[NUM_RIPIANI];
        //Istanzio una mensola (vuota) per ciascun ripiano
        for(int i=0;i<NUM_RIPIANI;i++){
            ripiani[i]=new Mensola();
        }
    }
    
    public Scaffale(Scaffale scaf){
         ripiani=new Mensola[NUM_RIPIANI];
         Libro lib;
         for(int i=0;i<NUM_RIPIANI;i++){
            ripiani[i]=new Mensola();
            for (int j=0;j<scaf.getNumMaxLibri(i);j++){
                try{
                    lib=scaf.getLibro(i, j);
                    this.setLibro(lib, i, j);
                } 
                catch (EccezioneRipianoNonValido ex){
                    //Non può essere
                } 
                catch (EccezionePosizioneNonValida ex){
                    //non può essere
                } 
                catch (EccezionePosizioneVuota ex){
                    //non fare nulla
                } 
                catch (EccezionePosizioneOccupata ex){
                    //non fare nulla
                }
            }     
         }
    }
    
    /**
     *Inserisce il libro nella posizione "posizione" del ripiano “ripiano”.
        se il ripiano non è valido --> return -3
        se la posizione non è valida --> return -1
        se la posizione è già occupata --> return -2
        se ok  return 0
     * @param libro
     * @param ripiano
     * @param posizione
     * @throws eccezioni.EccezioneRipianoNonValido
     * @throws eccezioni.EccezionePosizioneNonValida
     * @throws eccezioni.EccezionePosizioneOccupata
     */
    
    public void setLibro(Libro libro, int ripiano, int posizione ) throws EccezioneRipianoNonValido, EccezionePosizioneNonValida, EccezionePosizioneOccupata{
        
        if (ripiano<0 || ripiano >=NUM_RIPIANI)
            throw new EccezioneRipianoNonValido();
        ripiani[ripiano].setVolume(libro, posizione);
       /* if(esito>=0)
            return 0; //tutto ok
        else
            return esito; //return -1 o -2
    */
    }
    
    /**
     * Restituisce il libro che si trova 
     * in un certo ripiano, in un certa posizione
     * @param ripiano
     * @param posizione
     * @return 
     * restituisce null se il ripiano non esiste,
     * se la posizione non esiste oppure se
     * nei dati ripiano/posizione non è presente il libro.
     * Negli altri casi restituisce il libro.
     * @throws eccezioni.EccezioneRipianoNonValido
     * @throws eccezioni.EccezionePosizioneNonValida
     * @throws eccezioni.EccezionePosizioneVuota
     */
    public Libro getLibro(int ripiano, int posizione) throws EccezioneRipianoNonValido, EccezionePosizioneNonValida, EccezionePosizioneVuota{
        if (ripiano<0 || ripiano>=NUM_RIPIANI)
            throw new EccezioneRipianoNonValido();
        Libro lib;
        lib=ripiani[ripiano].getVolume(posizione);
        return lib;
    }

    /**
     * Rimuove un volume da un determinato ripiano e una 
     * determinata posizione
     * @param ripiano
     * @param posizione
     * @throws eccezioni.EccezioneRipianoNonValido
     * @throws eccezioni.EccezionePosizioneNonValida
     * @throws eccezioni.EccezionePosizioneVuota
     */
    public void rimuoviLibro(int ripiano, int posizione ) throws EccezioneRipianoNonValido, EccezionePosizioneNonValida, EccezionePosizioneVuota{
       
        if (ripiano<0 || ripiano >=NUM_RIPIANI)
            throw new EccezioneRipianoNonValido();
        ripiani[ripiano].rimuoviVolume(posizione);
    /*    if(esito>=0)
            return 0; //tutto ok
        else
            return esito; //return -1 o -2
    */
    }
    /**
     * restituisce il numero di mensole (ripiani)
     * presenti nello scaffale
     * @return 
     */
    public int getNumRipiani(){
        return NUM_RIPIANI;
    }
    
    /**
     * Restituisce il numero massimo di libri
     * contenuti in uno scaffale
     * @return 
     */
    public int getNumMaxLibri(){
        int contatore=0;
        for (int i=0;i<NUM_RIPIANI;i++){
            contatore+=ripiani[i].getNumMaxVolumi();
        }
        
        return contatore;
    }
    
    /**
     * Restituisce il numero di volumi
     * presenti nello scaffale
     * @return 
     */
    public int getNumLibri(){
        int contaVolumi=0;
        for(int i=0;i<NUM_RIPIANI;i++){
            contaVolumi+=ripiani[i].getNumVolumi();
        }
        return contaVolumi;
    }
    
   /**
    * Restituisce il numero di libri
    * che sono presenti nello specifico ripiano
    * @param ripiano
    * @return 
    *  Se il ripiano non esiste --> return -1
    *  
    */
   public int getNumLibri(int ripiano){
       if (ripiano<0 || ripiano>NUM_RIPIANI)
           return -1;
       return ripiani[ripiano].getNumVolumi();
   }
   
   /**
    * Restituisce il numero massimo di libri
    * che possono essere presenti nello specifico ripiano
    * @param ripiano
    * @return 
    *  Se il ripiano non esiste --> return -1
    *  
    */
   public int getNumMaxLibri(int ripiano){
        if (ripiano<0 || ripiano>NUM_RIPIANI)
           return -1;
       return ripiani[ripiano].getNumMaxVolumi();
   }
  
   /**
    * Restituisce una stringa che contiene i volumi presenti in ciascuno scaffale
    * @return 
    * 
    */
    @Override
   public String toString(){
       String s="";
       for (int i=0;i<NUM_RIPIANI;i++){
           s+="Ripiano "+i+":\n"+ripiani[i].toString();
       }
       return s;
   }
   
   
   public String[] elencoTitoliAutore(String autore){
       Libro lib;
       String[] elencoTitoliAutore;
       
       int contaLibriAutore=0;
       for (int i=0;i<NUM_RIPIANI;i++){
           for(int j=0;j<ripiani[i].getNumMaxVolumi();j++){
               try{
                   lib=this.getLibro(i, j);
                   if (lib.getAutore().equalsIgnoreCase(autore)){
                       contaLibriAutore++;  //sarà la dimensione dell'array
                   }
                   
               } 
               catch (EccezioneRipianoNonValido ex){
                 //Non succederà mai
               } 
               catch (EccezionePosizioneNonValida ex){
                     //Non succederà mai
               } 
               catch (EccezionePosizioneVuota ex){
                  //non fare nulla...
               }
               
           }
       }
       //Se non ci sono libri dell'autore --> return null
       if (contaLibriAutore==0)
           return null;
           
       //Istanzio l'array DINAMICAMENTE (Run time, durante l'esecuzione)
       elencoTitoliAutore=new String[contaLibriAutore];
       
       //Copio i titoli dell'autore nell'array di titoli
       contaLibriAutore=0;
       for (int i=0;i<NUM_RIPIANI;i++){
           for(int j=0;j<ripiani[i].getNumMaxVolumi();j++){
               try{
                   lib=this.getLibro(i, j);
                   if (lib.getAutore().equalsIgnoreCase(autore)){
                       elencoTitoliAutore[contaLibriAutore]=lib.getTitolo();
                       contaLibriAutore++;  //sarà la dimensione dell'array
                   }
               } 
               catch (EccezioneRipianoNonValido ex){
                   //non può essere
               } 
               catch (EccezionePosizioneNonValida ex){
                    //non può essere
               } 
               catch (EccezionePosizioneVuota ex){
                   //non fare nulla...
               } 
           }
       }   
       return elencoTitoliAutore;
   }
   
   public Libro[] elencoLibriPresenti(){
       Libro[] elencoLibriPresenti=new Libro[getNumLibri()];
       Libro lib;
       int c=0; //contatore
       for (int i=0;i<getNumRipiani();i++){
           for(int j=0;j<ripiani[i].getNumMaxVolumi();j++){
               try{
                   lib=getLibro(i, j);
                   elencoLibriPresenti[c]=lib;
                   c++;
               } 
               catch (EccezioneRipianoNonValido ex){
                   //non può essere
               } 
               catch (EccezionePosizioneNonValida ex){
                   //non può essere
               } 
               catch (EccezionePosizioneVuota ex){
                   //non fare nulla
               }     
           }
       }
       return elencoLibriPresenti;
   }
    public void ExportCSV(String name) throws IOException, FileException{
        TextFile f0 = new TextFile(name,'W');
        Libro l0;
        for(int i = 0; i<getNumRipiani(); i++){
            for(int j = 0; j<getNumMaxLibri(); j++){
                try {
                    l0=this.getLibro(i, j);
                    f0.toFile(i+";  "+j+";  "+l0.getTitolo()+";  "+l0.getAutore()+";  "+l0.getNumeroPagine());
                } catch (EccezionePosizioneVuota ex) {
                    //non succederà mai
                } catch (EccezioneRipianoNonValido ex) {
                    //non succederà mai
                } catch (EccezionePosizioneNonValida ex) {
                    //non fare nulla
                }
            }
        }
        f0.closeFile();
    }
   public void ImportCSV(String name) throws IOException{
       TextFile f0 = new TextFile(name, 'R');
       String rigaLetta;
       String[] arrayS;
       String titolo,autore;
       int ripiano,nPagine,posizione;
       
        try {
            rigaLetta = f0.fromFile();
            arrayS = rigaLetta.split(";");
            ripiano = Integer.parseInt(arrayS[0]);
            posizione = Integer.parseInt(arrayS[1]);
            titolo = arrayS[2];
            autore = arrayS[3];
            nPagine = Integer.parseInt(arrayS[4]);
            Libro l0 = new Libro(titolo, autore, nPagine);
            this.setLibro(l0, ripiano, posizione);
        } catch (EccezioneRipianoNonValido ex) {
               
        } catch (EccezionePosizioneNonValida ex) {
               
        } catch (EccezionePosizioneOccupata ex) {
               
        } catch (FileException ex) {
            
        }
       
       
               
   }
   
}
