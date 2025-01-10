package main.study.collection;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableDemo {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/collection/HashTableDemo.java

	public static void main(String[] args) {
		Hashtable<String, Double> ht = new Hashtable<String, Double>();
		Enumeration<String> names;
		String str;

//		ht.put("홍길동이", new Double(1240.34));
//		ht.put("김영순이", new Double(223.39));
//		ht.put("퀵군", new Double(1378.00));
//		ht.put("글라이더님", new Double(9999.55));
//		ht.put("존 도", new Double(-122.08));
//		ht.put("한효주님",  new Double(55.77));
		ht.put("홍길동이", Double.valueOf(1240.34));
		ht.put("김영순이", Double.valueOf(223.39));
		ht.put("퀵군", Double.valueOf(1378.00));
		ht.put("글라이더님", Double.valueOf(9999.55));
		ht.put("존 도", Double.valueOf(-122.08));
		ht.put("한효주님",  Double.valueOf(55.77));
		
		names = ht.keys();
		while (names.hasMoreElements()) {
			str = (String) names.nextElement();
			System.out.println(str + ": " + ht.get(str));
		}
		System.out.println();
		
		double bonus = ((Double) ht.get("존 도")).doubleValue();
//		ht.put("존 도", new Double(bonus + 1000));
		ht.put("존 도", Double.valueOf(bonus + 1000));
		System.out.println("존 도's new deposit: " + ht.get("존 도"));
	}

}
