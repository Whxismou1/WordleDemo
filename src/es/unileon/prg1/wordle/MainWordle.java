package es.unileon.prg1.wordle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MainWordle {	
	private static final Logger logger = LogManager.getLogger(MainWordle.class);
	public static void main(String[] args) throws WordleException {
		Wordle wordle;
		WordleTextUI ui;
		logger.info("Se crean los objetos wordle y wordleTextUI");

		if (args.length != 3){
			System.out.println("Error Sintaxis: source longWord numTries");
			logger.error("Error de sintaxis al introducir los args");

		} else {
			try{
				String dictionary = args[0];
				int length =Integer.parseInt(args[1]);
				int numTries =Integer.parseInt(args[2]);
				logger.info("Se guardan los args que intoduce el usuario. Diccionario: " + dictionary + ", longitud: " + length + ", Intentos: " + numTries);
				

				wordle = new Wordle(dictionary, length, numTries);
				logger.info("Se crea un wordle al que se le pasan los args introducidos por el usuario");
			
				ui = new WordleTextUI(wordle);
				logger.info("Se le pasa el objeto wordle creado a la interfaz");

				ui.init();
				logger.info("Se ejecuta el bucle de inicio del wordleTextUI");
			}catch(NumberFormatException e){
				System.out.println("longWord, numTries accepts only numbers & source a String");
				System.out.println("Syntax: MainWordle source longWord numTries");
				logger.error("El formato introducido por el usuario es incorrecto");
			}
		}
	}
}