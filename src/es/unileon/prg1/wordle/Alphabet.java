package es.unileon.prg1.wordle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/**
 * Esta clase representa al teclado con todas las letra del abecedario y las va
 * coloreando conforme a la palabra introducida por el usuario
 *
 * @author G-6R
 */
public class Alphabet {
	private Letter[] alfhabet;
	private final int NUM_SPECIAL_CHARS = 7;
	private Word wordSecret;
	private static final Logger logger = LogManager.getLogger(Alphabet.class);

	/**
	 * Constructor de la clase Alphabet
	 *
	 */
	public Alphabet() {
		char currentChar = 'A';
		int numLetters = 'Z' - 'A' + 1;
		int totalLetters = numLetters + NUM_SPECIAL_CHARS;

		this.alfhabet = new Letter[totalLetters];

		for (int i = 0; i < numLetters; i++) {
			this.alfhabet[i] = new Letter(currentChar);
			currentChar++;
		}

		alfhabet[26] = new Letter('Á');
		alfhabet[27] = new Letter('É');
		alfhabet[28] = new Letter('Í');
		alfhabet[29] = new Letter('Ó');
		alfhabet[30] = new Letter('Ú');
		alfhabet[31] = new Letter('Ü');
		alfhabet[32] = new Letter('Ñ');

		logger.info("se crea el teclado y se inicializa todas las letras en color gris");
	}

	/**
	 * Este método compara la palabra introducida coloreada con el teclado y pinta
	 * las letras del teclado como las de la palabra
	 * 
	 * @param newWordColored Este parámetro representa la palabra introducida por
	 *                       el usuario de tipo string
	 * @throws WordleException
	 */
	public void compare(String newWordColored) throws WordleException {
		Word newWord = new Word(newWordColored);
		// Word newWorColor=this.wordSecret.compare(newWord);
		for (int j = 0; j < newWordColored.length(); j++) {
			for (int q = 0; q < this.alfhabet.length; q++) {
				if (this.alfhabet[q].equals(newWord.getLetter(j))) {
					this.alfhabet[q].setColor(Colors.GREY);
				}
			}
		}
		
		logger.info(
				"Dentro de un bucle se colorean las letras del teclado con el mismo color que la palabra introducida por el usuario una vez coloreada");
	}

	/**
	 * Este metodo pasa el teclado a tipo string sin color
	 * 
	 * @return Devuelve el teclado convertido a tipo string
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < alfhabet.length; i++) {
			if ((i % 8 == 0) && i != 0) {
				sb.append("\n");
			}
			sb.append(alfhabet[i].toString());
		}
		return sb.toString();
	}

	/**
	 * Este metodo pasa el teclado a tipo string coloreado
	 * 
	 * @return Devuelve el teclado convertido a tipo string
	 */
	public String toStringColored() {
		StringBuilder salida = new StringBuilder();
		for (int w = 0; w < 8; w++) {
			salida.append(this.alfhabet[w].toStringColored());
		}
		salida.append("\n");
		for (int k = 8; k < 16; k++) {
			salida.append(this.alfhabet[k].toStringColored());
		}
		salida.append("\n");
		for (int x = 16; x < 24; x++) {
			salida.append(this.alfhabet[x].toStringColored());
		}
		salida.append("\n");
		for (int q = 24; q < this.alfhabet.length; q++) {
			salida.append(this.alfhabet[q].toStringColored());
		}
		logger.info("Se devuelve el teclado coloreado convertido a string");
		return salida.toString();
	}

}