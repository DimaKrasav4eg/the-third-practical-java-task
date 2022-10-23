package thirdmission;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Address {
	
	// В задании указано, что все поля класса строковые, но мне кажется,
	// что хранение данных в массиве будет более удобно, поэтому создяю
	// константу для хранения его длины.
	private final static int ADRESS_LEN = 7;
	
	/**
	 * Разделитель элементво в функции {@link Address#toString()}
	 */
	private final static String TOSTRING_SEP = ":";
	/**
	 * Разделитель, который использует {@link Address#commaSplit(String)}
	 */
	private final static String COMMA_SEP = ","; 
	/**
	 * Разделители, которые использует {@link Address#allSplit(String)}
	 */
	private final static String ALL_SEPS = ",.;";
	
	
	//[0] - country, [1] - region, [2] - city
	//[3] - street,  [4] - house,  [5] - build, [6] - flat
	private final String[] adress = new String[ADRESS_LEN];
	
	/**
	 * По входной строке заполняет {@link Address}
	 * @param s
	 * @return this
	 */
	public Address commaSplit(String s) {
		
		final String[] sSplited = s.split(COMMA_SEP);
		if (sSplited.length != ADRESS_LEN) {
			throw new InputMismatchException("incorrect number of data in the input string!");
		}
		for (int i = 0; i < ADRESS_LEN; ++i) {
			String str = sSplited[i].trim();
			if (str.isEmpty()) {
				throw new InputMismatchException("extra separator detected!");
			}
			this.adress[i] = str;
		}
		return this;
	}
	
	/**
	 * По входной строке заполняет {@link Address}
	 * @param s - String
	 * @return this - Address
	 */
	public Address allSplit(String s) {
		StringTokenizer tokens = new StringTokenizer(s, ALL_SEPS);
		if (tokens.countTokens() != ADRESS_LEN) {
			throw new InputMismatchException("incorrect number of data in the input string!");
		}
		for (int i = 0; i < ADRESS_LEN; ++i) {
			try {
				this.adress[i] = tokens.nextToken().trim();
			}
			catch (final NoSuchElementException e) {
				throw new InputMismatchException("incorrect number of data in the input string!");
			}
			if (this.adress[i].isEmpty()) {
				throw new InputMismatchException("extra separator detected!");
			}
		}
		return this;
	}
	
	
	/**
	 * Представляет класс {@link Address} в виде строки
	 * @return String
	 */
	public String toString() {
		StringBuilder prod = new StringBuilder("Adress[adress={");
		for (int i = 0; i < ADRESS_LEN; ++i) {
			prod.append(adress[i]);
			if (i != ADRESS_LEN-1) {
				prod.append(TOSTRING_SEP);
			}
		}
		return prod.append("}]").toString();
	}
}
