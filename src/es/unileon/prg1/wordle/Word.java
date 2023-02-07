package es.unileon.prg1.wordle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Esta clase trabaja con las palabras del juego: las divide en letras, las colorea o las pasa a tipo String
 *
 * @author G-6R
 */
public class Word {
    private static final Logger logger = LogManager.getLogger(Word.class);
    private Letter[] letters;


    /**
     * Constructor de la clase Word
     * @param word Recibe una palabra de tipo string
     */
    public Word(String word){
        this.letters = new Letter[word.length()];
        for(int i = 0; i < word.length(); i++){
            this.letters[i] = new Letter(word.charAt(i));
        }
        logger.info("Introduce las letras de la palabra en un array de tipo letter");
        logger.info("Llegan los parametros al constructor de word");
    }
    
    /**
     * Constructor que recibe el array con las letters coloreadas
     * @param letters
     */
    public Word(Letter[] letters) {
    	this.letters = letters;
    }
    
    /**
	 * Constructor de la clase que crea una palabra vac�a
	 * 
	 * @param num
	 */
	public Word(int num) {
		this.letters = new Letter[num];
		createEmptyWord();
	}

	/**
	 * Metodo encargado de crear la palabra vacia
	 */
	private void createEmptyWord() {
		char letra = ' ';
		for (int i = 0; i < this.letters.length; i++) {
			this.letters[i] = new Letter(letra);
		}
	}


    /**
     * Metodo utilizado para comparar caracter a caracter la palabra secreta y la introducida y colorearla
     * @param newword Recibe la palabra introducida por el usuario
     * @return Devuelve una palabra coloreada
     */
    public Word compare(Word word) throws WordleException{
    	for (int i = 0; i < this.letters.length; i++) {
			Letter letra = word.getLetter(i);
			if (letra.equals(this.letters[i])) {
				this.letters[i].setColor(Colors.GREEN);
				word.getLetter(i).setColor(Colors.GREEN);

			}
		}
		for (int i = 0; i < this.letters.length; i++) {
			if(this.letters[i].getColor() == Colors.BLUE) {
				int j = 0;
				boolean found = false;
				while(j < this.letters.length && !found) {
					if(this.letters[i].equals(word.getLetter(j)) && word.getLetter(j).getColor()== Colors.BLUE) {
						found = true;
						this.letters[i].setColor(Colors.YELLOW);
						word.getLetter(j).setColor(Colors.YELLOW);
					}
					j++;
				}
			}
		}
		return new Word(this.letters);
		
    }
    
    /**
     * Metodo que devuelve la letra de la posicion
     * @param position
     * @return letra en la posicion dada
     * @throws WordleException
     */
	public Letter getLetter(int position) throws WordleException {
		
		if(position < 0 || position >= this.letters.length) {
			logger.warn("La posicion es incorrecta");
			throw new WordleException("Posicion incorrecta");
		}
		return this.letters[position];
	}
	
	/**
	 * Metodo booleano que comprueba si la palabra es correcta
	 * @return
	 */
	public boolean correctWord() {
		boolean correct=true;
		int j =0;
		while (correct == true && j < this.letters.length) {
			if (this.letters[j].getColor() != Colors.GREEN) {
				correct= false;
			}
			j++;
		}
			return correct;
	}
	
	/**
	 * Metodo toString sin colorear
	 */
    public String toStringColor(){
        StringBuilder finalWord = new StringBuilder();
        for (Letter letter : letters){
            finalWord.append(letter.toStringColored());
        }
        return finalWord.toString();
    }

    /**
	 * Metodo toString con las letters coloreadas
	 */
    public String toString(){
        StringBuilder finalWord = new StringBuilder();
        for (Letter letter : letters){
            finalWord.append(letter.getLetter());
        }
        return finalWord.toString();
    }
}