package es.unileon.prg1.wordle;

import java.util.Random;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * Esta clase obtiene todas las palbras contenidas en el diccionario y realiza algunas operaciones con ella
 *
 * @author G-6R
 *
 */
public class Dictionary {
    private static final Logger logger = LogManager.getLogger(Dictionary.class);
    private Source source;
    private int longitud;
    private String[] palabrasLongitud;;


    /**
     * Constructor de la clase Dictionary
     *
     * @param dictionary Este parámetro obtiene el diccionario seleccionado
     * @param longitudPalabra Este parametro es la longitud de la palabra que se busca
     * @throws WordleException Excepción de tipo WordleException
     */
    public Dictionary(String dictionary, int longitudPalabra) throws WordleException {
        this.source = new Source(dictionary);
        this.longitud=longitudPalabra;
        this.cargaDiccionario();
        
        logger.info("Se devuelve el array de las palabras de una misma longitud");
    }
    
    /**
	 * metodo que carga el diccionario
	 */
	private void cargaDiccionario() {
		int tam = 0;
		for (this.source.first(); this.source.hasNext();) {
			String line = this.source.getNext();
			line = this.quitaEspacios(line);
			if(this.longitud == line.length()) {
				tam++;
			}
		}
		this.palabrasLongitud = new String[tam];
		int cont = 0;
		for (this.source.first(); this.source.hasNext();) {
			String line = this.source.getNext();
			line = this.quitaEspacios(line);
			if(this.longitud == line.length()) {
				this.palabrasLongitud[cont] = line;
				cont++;
			}
		}
	}

	/**
	 * Metodo privado que sirve para quitar los espacios
	 * @param line
	 * @return
	 */
	private String quitaEspacios(String line) {
		line = line.replaceAll(" ", "");
		line = line.replaceAll("\t", "");
		line = line.replaceAll("\r", "");
		return line;
	}

    /**
     * Este método se usa para coger una palabra random del tamaño deseado.
     *
     * @param dictionary Este parámetro es el objeto source que referencia a la ruta del diccionario.
     * @param lenght     Este parámetro es la longitiud de la palabra deseada.
     * @return  Nos devuelve una palabra de tipo string
     */
    public String randomWord() {
        int longitudVector = this.palabrasLongitud.length;
        Random randomNumber = new Random();
        randomNumber.setSeed(System.currentTimeMillis());
        int numeroRandom = randomNumber.nextInt(longitudVector);
        String word = this.palabrasLongitud[numeroRandom];
        logger.info("Se devuelve la palabra secreta");
        return word;
    }

    /**
     * Método booleano que dice si la palabra está o no en el diccionario
     * @param word es la palabra que se comprueba
     * @return Devuelve un booleano, false si la palabra no está en el diccionario y true si sí está
     */
    public boolean isInDictionary(String word){
    	boolean cond = false;
    	int i = 0;
    	while(i < this.palabrasLongitud.length && cond == false) {
    		if(this.palabrasLongitud[i].equalsIgnoreCase(word) == true) {
				cond = true;
			}
    		i++;
    	}
		
        logger.info("Se devuelve si la palabra esta o no esta en el diccionario");
        return cond;
    }
}