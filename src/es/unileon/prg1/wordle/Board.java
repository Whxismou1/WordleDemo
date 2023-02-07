package es.unileon.prg1.wordle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Esta clase muestra el tablero del juego
 *
 * @author G-6R
 *
 */
public class Board{
    private Word[] words;
    private int numTries;
    private int next;
    private int intentosRestantes;
    private static final Logger logger = LogManager.getLogger(Board.class);


    /**
     * Constructor de la Clase Board
     * @param randomWord este parametro es la palabra secreta
     * @param lenght este parametro es la longitud de la palabra
     * @param numTries este parametro indica el numero de intentos para encontrar la palabra secreta
     */
    public Board(int lenght, int numTries){
        this.words= new Word[numTries];
        this.numTries=numTries;
        this.next = 0;
        this.intentosRestantes=numTries;
        for(int i = 0; i < this.words.length; i++) {
        	this.words[i] = new Word(lenght);
        }
        logger.info("Llegan al board la palabra secreta, el array de words y la longitud");
    }

    
    /**
     * Metodo booleano que comprueba si el usuario ha ganado
     * @return si el usuario ha ganado devuelve true, sino devuelve false
     */
    public boolean isWin(){
    	
        boolean isWin=false;
        if(this.next > 0){
            logger.info("el usuario ha adivinado la palabra secreta");
            isWin=this.words[this.next - 1].correctWord();
        }else{
            logger.info("el usuario no ha adivinado la palabra secreta por lo que se le resta un intento");
        }

        return isWin;
    }
    
    
    
    /**
     * Metodo que devuelve el entero de los intentos sobrantes para ganar el juego
     * @return devuelve los intentos que le quedan al usuario en tipo int
     */
    public int returnTries(){
        logger.info("Se devuelven los intentos que le quedan al usuario");
        return this.intentosRestantes;
    }


    /**
     * Metodo que introduce la palabra (si queda sitio) introducida por el usuario en el tablero
     * @param newWord este parametro representa la palabra de tipo string que se quiere introducir en el tablero
     */
    public void add(String newWord) throws WordleException {
        if(this.next<this.numTries){
            logger.info("se anyade una palabra al tablero");
            this.words[this.next]=new Word(newWord);
            this.next++;
            intentosRestantes--;
        } else{
        	logger.error("Error: El tablero esta lleno");
            throw new WordleException("Error: El tablero esta lleno");
            
        }
    }
    
    /**
     * 
     * @param wordSecret
     * @throws WordleException
     */
    public void paintLast(Word wordSecret) throws WordleException {
    	  if(this.next > 0){
              logger.info("el usuario ha adivinado la palabra secreta");
              this.words[this.next - 1].compare(wordSecret);
          }else {
        	  throw new WordleException("No hay palabras anyadidas");
          }
    }

    /**
     * Metodo booleano que comprueba si el usuario se ha quedado sin intentos
     * @return Devuelve true si el usuario ha agotado todos sus intentos, y false si todavía le quedan intentos
     *
     */
    public boolean isDefeat(){
        boolean isDefeat=false;
        if(this.intentosRestantes==0){
            logger.info("al usuario se le acaban los intentos para seguir jugando");
            isDefeat=true;
        }
        return isDefeat;
    }

    /**
     * Metodo que pasa el tablero a string
     * @return Devuelve el tablero convertido a tipo string
     */
	public String toString() {
		StringBuffer salida = new StringBuffer();
		for (int i = 0; i < this.words.length; i++) {
			salida.append(this.words[i].toString() + "\n");
		}
		return salida.toString();
	}
	
	/**
     * Metodo que pasa el tablero a string
     * @return Devuelve el tablero coloreado
     */
	public String toStringColor() {
		StringBuffer salida = new StringBuffer();
		for (int i = 0; i < this.words.length; i++) {
			salida.append(this.words[i].toStringColor() + "\n");
		}
		return salida.toString();
	}

}