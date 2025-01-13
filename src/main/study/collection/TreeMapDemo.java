package main.study.collection;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/collection/TreeMapDemo.java

	public static void main(String[] args) {
		Map<String, Double> tm = new TreeMap<String, Double>();
		tm.put("홍길동이", Double.valueOf(1240.34));
		tm.put("김영순이", Double.valueOf(223.39));
		tm.put("퀵군", Double.valueOf(1378.00));
		tm.put("글라이더님", Double.valueOf(9999.55));
		tm.put("존 도", Double.valueOf(-122.08));
		tm.put("한효주님", null);
		
		Set<?> set = tm.entrySet();
		
		Iterator<?> i = set.iterator();
		
		while(i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
		
		double bonus = tm.get("존 도").doubleValue();
		tm.put("존 도", Double.valueOf(bonus + 1000));
		System.out.println("존 도's new deposit: " + tm.get("존 도"));
		
	}

}
