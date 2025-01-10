package main.study.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/collection/HashMapDemo.java

	public static void main(String[] args) {
		Map<String, Double> hm = new HashMap<String, Double>();
//		hm.put("홍길동이", new Double(1240.34));
//		hm.put("김영순이", new Double(223.39));
//		hm.put("퀵군", new Double(1378.00));
//		hm.put("글라이더님", new Double(9999.55));
//		hm.put("존 도", new Double(-122.08));
//		hm.put("한효주님", null);
		hm.put("홍길동이", Double.valueOf(1240.34));
		hm.put("김영순이", Double.valueOf(223.39));
		hm.put("퀵군", Double.valueOf(1378.00));
		hm.put("글라이더님", Double.valueOf(9999.55));
		hm.put("존 도", Double.valueOf(-122.08));
		hm.put("한효주님", null);
		
		// 맵 엔트리의 콜렉션 집합
		Set<?> set = hm.entrySet();
		
		// 반복자
		Iterator<?> i = set.iterator();
		
		// 출력
		while(i.hasNext()) {
//			Map.Entry me = (Map.Entry) i.next();
			Map.Entry<String, Double> me = (Map.Entry<String, Double>) i.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
		
		// 존 도에 1000 추가
		double bonus = hm.get("존 도").doubleValue();
//		hm.put("존 도", new Double(bonus + 1000));
		hm.put("존 도", Double.valueOf(bonus + 1000));
		System.out.println("존 도's new deposit: " + hm.get("존 도"));
		
		//* Test - Map.Entry
		for (Map.Entry<String, Double> entry : hm.entrySet()) {
		    System.out.print("key : " + entry.getKey());
		    System.out.println(", value : " + entry.getValue());
		}
		
	}

}
