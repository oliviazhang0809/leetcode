package Bitly;

import java.util.HashMap;

public class Bitly {

	public static void main(String[] args) {
		int base = 26;
		String longUrl1 = "http://www.1point3acres.com/bbs/forum.php?mod=post&action=newthread&fid=145";
		String shortedUrl1 = shortenUrl(longUrl1, base);
		System.out.println(shortedUrl1);
		String longUrl2 = "http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=116375&highlight=uber";
		System.out.println(shortenUrl(longUrl2, base));
		String longUrl3 = "http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=105851&highlight=uber";
		System.out.println(shortenUrl(longUrl3, base));

		System.out.println(getLongUrl(shortedUrl1, base));
	}

	public static final HashMap<Long, String> map = new HashMap<Long, String>();
	public static long count = 34242343;
	public static String baseString = "http://bit.ly/";
	public static char startingChar = 'a';

	public static String shortenUrl(String longUrl, Integer base) { // id + base
																	// ->
																	// character
		long id = count;
		count++;
		map.put(id, longUrl);
		StringBuilder sb = new StringBuilder();
		while (id > 0) {
			char tmp = (char) (id % base + startingChar);
			sb.append(tmp);
			id /= base;
		}
		return baseString + sb.toString(); // return combined url
	}

	public static String getLongUrl(String shortUrl, Integer base) { // character
																		// +
																		// base
																		// -> id
		shortUrl = shortUrl.substring(baseString.length()); // get the changed
															// part
		StringBuilder sb = new StringBuilder(shortUrl).reverse();
		long id = 0;
		for (int i = 0; i < sb.length(); i++) {
			long c = sb.charAt(i) - startingChar;
			id = id * base + c;
		}
		return map.get(id);
	}
}
