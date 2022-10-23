package thirdmission;

import static org.junit.jupiter.api.Assertions.*;

import java.util.InputMismatchException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class AddressTest {

	private final static String[] GOOD = {
		"Country,  Region  ,City,  Street, House, Build, Flat",
		"Country;  Region  ;City, Street   . House ; Build , Flat"
	};
	private final static String[] BAD1 = {
			"Country,  Region  ,City,  Street, House, , Flat",             // missing segment
			"Country,  Region  ,City, Street, House, Build, Build , Flat", // extra segment
			"Country,  Region  ,City,  Street, House, Build  Flat",        // missing separator
	};
	
	private final static String[] BAD2 = {
			"Country;  Region  ;City, Street. House; Build; Build , Flat", // extra segment
			"Country;  Region  ;City, Street   . ; Build , Flat",          // missing segment
			"Country,  Region  ,City .  Street;House, Build  Flat"         // missing separator
	};
	
	private final static String ANSWER = "Adress[adress={Country:Region:City:Street:House:Build:Flat}]";

	Address adr1;
	Address adr2;
	
// По идее объекты должны создаваться здесь, 
// но ругается что ссылки на объекты = null
	
//	@BeforeEach
//	void setUp() throws Exception {
//		Address adr1 = new Address();
//		Address adr2 = new Address();
//	}

	@Test
	void testCommaSplit() {
		Address adr1 = new Address();
		final String ans1 = adr1.commaSplit(GOOD[0]).toString();
		
		assertEquals(ans1, ANSWER);
	}

	@Test
	void testAllSplit() {
		Address adr2 = new Address();
		final String ans2 = adr2.allSplit(GOOD[1]).toString();
		
		assertEquals(ans2, ANSWER);
	}
	
	@Test
	void testThrowsException(){
		Address adr = new Address();
		Assertions.assertThrows(InputMismatchException.class, () -> {
	    	adr.commaSplit(BAD1[0]);
	    });
		Assertions.assertThrows(InputMismatchException.class, () -> {
	    	adr.commaSplit(BAD1[1]);
	    });
		Assertions.assertThrows(InputMismatchException.class, () -> {
	    	adr.commaSplit(BAD1[2]);
	    });
		Assertions.assertThrows(InputMismatchException.class, () -> {
	    	adr.allSplit(BAD2[0]);
	    });
		Assertions.assertThrows(InputMismatchException.class, () -> {
	    	adr.allSplit(BAD2[1]);
	    });
		Assertions.assertThrows(InputMismatchException.class, () -> {
	    	adr.allSplit(BAD2[2]);
	    });
	}

}
