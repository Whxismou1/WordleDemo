package es.unileon.prg1.wordle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Esta clase lleva acabo la ejecución del juego y la unión entre todas las
 * demás clases
 *
 * @author G-6R
 *
 */
public class Wordle {
	private static final Logger logger = LogManager.getLogger(Wordle.class);
	private int tries;
	private Dictionary dictionary;
	private Board board;
	private String wordSecret;
	private Alphabet teclado;

	/**
	 * Constructor de la clase Wordle
	 * 
	 * @param dictionary Este parametro es el nombre del diccionario
	 * @param length     Este parametro es la longitud de la palabra
	 * @param numTries   Este parametro es el numero de intentos
	 * @throws WordleException Devuelve una excepcion en caso de malfunción
	 */
	public Wordle(String dictionary, int length, int numTries) throws WordleException {
		this.tries = numTries;
		this.dictionary = new Dictionary(dictionary, length);
		this.wordSecret = this.dictionary.randomWord();
		this.board = new Board(length, this.tries);
		this.teclado = new Alphabet();
		logger.info("Se obtienen todos los parametros necesarios a traves del constructor");
	}

	/**
	 * Metodo que nos permite sacar el numero de intentos iniciales que tiene el
	 * usuario para acertar la palabra
	 * 
	 * @return Devuelve el numero de intentos iniciales
	 */
	public int getTries() {
		logger.info("Se devuelven los intentos");
		return this.tries;
	}

	/**
	 * Metodo que devuelve la palabra secreta(es decir la que estamos buscando)
	 * 
	 * @return Devuelve la palabra secreta en tipo string
	 */
	public String getWordSecret() {
		logger.info("Se devuelven la palabra secreta");
		return this.wordSecret;
	}

	/**
	 * Metodo que devuelve la palabra secreta coloreada (de azul)
	 * 
	 * @return Devuelve el string de la palabra secreta coloreada
	 */
	public String coloredWordSecret() {
		Word random = new Word(this.wordSecret);
		return random.toString();
	}

	/**
	 * Metodo booleano que comprueba si la palabra introducida por el usuario está
	 * contenida en el diccionario seleccionado
	 * 
	 * @param word2 este parametro representa la palabra introducida por el usuario
	 * @return devuelve true si la palabra está contenida en el diccionario y false
	 *         en caso contrario
	 */
	public boolean correctWordDictionary(String word2) {
		boolean okay = false;
		if (this.dictionary.isInDictionary(word2) && !word2.equalsIgnoreCase("salir")) {
			logger.info("la palabra introducida por el usuario está contenida en el diccionario seleccionado");
			okay = true;

		}
		return okay;
	}

	/**
	 * Metodo que comprueba si el usuario ha ganado la partida
	 * 
	 * @param word este parametro representa la plabra introducida por le usuario
	 * @return devuelve true si el usuario ha ganado la partida y false en caso
	 *         contrario
	 * @throws WordleException
	 */
	public boolean isWin() throws WordleException {
		return this.board.isWin();
	}

	/**
	 * Metodo que introduce la palabra introducida por el usuario en el
	 * funcionamiento del juego
	 * 
	 * @param newWordd este parametro representa la palabra introducida por el
	 *                 usuario
	 */
	public void isAdd(String newWordd) throws WordleException {
		if (!this.dictionary.isInDictionary(newWordd)) {
			logger.error("No existe la palabra en el diccionario");
			throw new WordleException("No existe la palabra en el diccionario");
		}
		this.board.add(newWordd);
		this.teclado.compare(newWordd);
	}

	/**
	 * 
	 * @throws WordleException
	 */
	public void paint() throws WordleException {
		this.board.paintLast(new Word(wordSecret));
	}

	/**
	 * Metodo booleano que comprueba si el usuario ha perdido
	 * 
	 * @return Devuelve true si el usuario ha perdido, y false si todavía puede
	 *         seguir jugando
	 *
	 */
	public boolean isDefeat() throws WordleException {
		return this.board.isDefeat();
	}

	/**
	 * Metodo que devuelve los intentos sobrantes
	 * 
	 * @return devuelve el entero de los intentos que le quedan al usuario
	 */
	public int returnTries() {
		return this.board.returnTries();
	}

	/**
	 * Metodo que pasa el wordle a tipo string
	 * 
	 * @return devuelve el string del wordle
	 */
	@Override
	public String toString() {
		StringBuilder salida = new StringBuilder();
		salida.append("\n//////\n" + coloredWordSecret() + "\n//////");
		salida.append("\nWORDLE\n");
		salida.append(this.board.toStringColor() + "\n");

		salida.append("\n\n" + this.teclado.toStringColored());

		return salida.toString();
	}

}