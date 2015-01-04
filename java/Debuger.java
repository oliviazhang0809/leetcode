import java.math.BigInteger;





public class Debuger {

	public static void main(String[] args) {
		byte term1 = (byte) 0x0a, term2 = (byte) 0x80;
		System.out.println(btg(term2));
	}


	public static int btg(int n) {
		return n ^ (n >> 1);
	}

	public static BigInteger btg(BigInteger n) {
		return n.xor(n.shiftRight(1));
	}

}
