package fithmission;


public class PhoneNumber {

	public static void main(String[] args) {
		PhoneNumber num = new PhoneNumber("89125655655");
		System.out.println(num.getNumber());
	}
	/**
	 * Максимальная дляина кода страны
	 */
	public final static int MAX_AREA_DIGITS = 3;
	/**
	 * Минимальная длина кода страны
	 */
	public final static int MIN_AREA_DIGITS = 1;
	/**
	 * Длина тех цифр
	 */
	public final static int EXCH_DIGITS = 3;
	/**
	 * Дина последней части цифр
	 */
	public final static int EXT_DIGITS  = 4;
	/**
	 * Максимальная длина номера
	 */
	public final static int MAX_LEN_NUMBER  = MAX_AREA_DIGITS
			                                 +2*EXCH_DIGITS
			                                 +EXT_DIGITS;
	/**
	 * Минимальная длина номера
	 */
	public final static int MIN_LEN_NUMBER  = MIN_AREA_DIGITS
							                 +2*EXCH_DIGITS
							                 +EXT_DIGITS;
	/**
	 * Символ начала номера в международном формате
	 */
	public final static String PLUS = "+";
	/**
	 * Символ начала номера в России
	 */
	public final static String BEGIN_NUM_RU = "8";
	/**
	 * Цифра начала номера России в международном формате
	 */
	public final static String AREA_RU = "7";
	/** Разделитель для вывода */
	public final static String NUM_FORMAT_SEP1 = "-";
	/** Разделитель для вывода */
	public final static String NUM_FORMAT_SEP2 = "(";
	/** Разделитель для вывода */
	public final static String NUM_FORMAT_SEP3 = ")";
	
	/**
	 * Номер телефона в виде класса {@link PhoneNumber.Number}
	 */
	private final Number number;
	
    public PhoneNumber(String s) {
    	this.number = parse(s);
    }
    /**
     * Класс для хранения номера
     */
	private static class Number {
	    String area;    // area code (3 digits)
	    String exch1;   // exchange  (3 digits)
	    String exch2;   // exchange  (3 digits)
	    String ext;     // extension (4 digits)
	}
    /**
     * Преобразует строку в класс {@link PhoneNumber.Number}
     * с помощью функции {@link PhoneNumber#standardParse(String)}
     * @param s
     * @return prod в виде {@link PhoneNumber.Number}
     */
    private static Number parse(String s) {

    	if (PLUS.equals(s.substring(0,1))) {
    		return standardParse(s.substring(1));
    	}
		else if (BEGIN_NUM_RU.equals(s.substring(0,1)) 
				&& s.length() == MIN_LEN_NUMBER) {
			return standardParse(AREA_RU+s.substring(1));
		}
    	throw new IllegalArgumentException("incorrect format!");
    }
    /**
     * Переводит стандартный формат в класс {@link PhoneNumber.Number}
     * @param s
     * @return prod в виде {@link PhoneNumber.Number}
     */
    private static Number standardParse(String s) {
    	int len = s.length();
    	if (len > MAX_LEN_NUMBER || len < MIN_LEN_NUMBER) {
    		throw new IllegalArgumentException("too long number!");
    	}
    	Number prod = new Number();
    	prod.ext = s.substring(len - EXT_DIGITS);
    	prod.exch2 = s.substring(len - EXT_DIGITS - EXCH_DIGITS, len - EXT_DIGITS);
    	prod.exch1 = s.substring(len - EXT_DIGITS - 2*EXCH_DIGITS, len - EXT_DIGITS - EXCH_DIGITS);
    	prod.area = s.substring(0, len - EXT_DIGITS - 2*EXCH_DIGITS);
    	return prod;
    }
    /**
     * Выводит строку в формат 
     * +<Код страны><Три цифры>–<Три цифры>–<Четыре цифры>
     * @return prod в виде String
     */
    public String getNumber() {
    	return new StringBuilder(PLUS)
    			.append(this.number.area)
    			.append(NUM_FORMAT_SEP2)
    			.append(this.number.exch1)
    			.append(NUM_FORMAT_SEP3)
    			.append(NUM_FORMAT_SEP1)
    			.append(this.number.exch2)
    			.append(NUM_FORMAT_SEP1)
    			.append(this.number.ext)
    			.toString();
    }
	
    
}
