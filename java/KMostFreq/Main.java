package KMostFreq;

public class Main {
	public static void main(String[] args) {
		KthMostFreq kFreq = new KthMostFreq(3, 2);
		kFreq.insert("D");
		kFreq.insert("D");
		kFreq.insert("D");
		kFreq.insert("D");
		System.out.println((kFreq.getKmostWords()));
		kFreq.insert("F");
		kFreq.insert("F");
		kFreq.insert("A");
		kFreq.insert("A");
		kFreq.insert("A");
		kFreq.insert("F");
		kFreq.insert("B");
		kFreq.insert("C");
		kFreq.insert("C");
		kFreq.insert("B");
		kFreq.insert("B");
		kFreq.insert("B");
		System.out.println((kFreq.getKmostWords()));

	}
}
