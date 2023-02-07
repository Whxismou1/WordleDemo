package es.unileon.prg1.wordle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Esta clase lleva a cabo la interfaz de usuario del juego WORDLE
 * 
 * @author G-6R
 * 
 */
public class WordleTextUI {

	private Wordle wordle;

	public WordleTextUI(Wordle wordle) {
		this.wordle = wordle;
	}

	public void init() {
		boolean seguir = true;
		System.out.println(this.wordle.toString());
		Keyboard keyboard = new Keyboard();
		this.imprimeEstado();
		do {
			String word = keyboard.readString();
			if (!word.toUpperCase().equals("SALIR")) {
				try {
					this.wordle.isAdd(word.toUpperCase());
					this.wordle.paint();
					if (this.wordle.isDefeat() || this.wordle.isWin()) {

						seguir = false;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println(this.wordle.toString());
				this.imprimeEstado();
			} else {
				seguir = false;
			}
		} while (seguir);
	}
	
	public void imprimeEstado() {
		try {
			if (this.wordle.isWin()) {
				System.out.println("ENHORABUENA!");
			} else {
				if (this.wordle.isDefeat() == true) {
					System.out.println(
							"Has perdido porque no te quedan mas intentos y no has encontrado la palabra secreta:");
					System.out.println(this.wordle.getWordSecret());
				} else {
					System.out
							.println("Introducir una palabra de " + this.wordle.getWordSecret().length() + " letras\n");
					System.out.println("(o \"Salir\" para abandonar wordle\n");
					System.out.println("Intentos disponibles: " + this.wordle.returnTries());
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}