import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class Prueba {
	private BinaryString bitset1, bitset2, bitset3, bitset4, bitset5;
	private String pruebaString2 = "1010101010", pruebaString3 = "100101", pruebaString4 = "0110101", pruebaString5 = "1111000";

	@Before
	public void antesDelTest(){
		bitset1 = new BinaryString(10);
		bitset2 = new BinaryString(pruebaString2);
		bitset3 = new BinaryString(pruebaString3);
		bitset4 = new BinaryString(pruebaString4);
		bitset5 = new BinaryString(pruebaString5);
	}
	
	//Comprobamos si al inicializar el bitset el tamaño es el esperado
	@Test
	public void testLength(){
		assertEquals(10, bitset1.length());
		assertEquals(10, bitset2.length());
	}
	
	@Test
	public void testSetBit(){
		bitset3.set(1,'1');
		assertEquals('1', bitset3.get(1));
	}
	
	@Test(expected = BinaryStringException.class)
	public void testFetOutOfLimitBit(){
		bitset4.get(56);
	}
	
	@Test(expected = BinaryStringException.class)
	public void testSetOutOfLimitBit(){
		bitset4.set(56, '0');
	}
	
	@Test
	public void testSetOutOfLimitV2(){
		try{
			bitset4.set(56, '0');
			fail("Se esperaba la excepcion BinaryStringException");
		}catch(BinaryStringException e){
			
		}
	}
	
	@Test(expected = BinaryStringException.class)
	public void testInvalidBitValue(){
		bitset4.set(1, 'c');
	}
	
	@Test
	public void testToString(){
		assertEquals(" 1111000", bitset5.toString());
	}
}
