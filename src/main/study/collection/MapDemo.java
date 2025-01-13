package main.study.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/collection/MapDemo.java

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "홍길동이");
		map.put(2, "Samsig");
		map.put(3, "Harunote");
		map.put(100, "kakao");
		System.out.println(map);
		System.out.println(map.get(100));
		
		// Key or Value 유무 체크
		System.out.println(map.containsKey(3));
		System.out.println(map.containsKey(4));
		System.out.println(map.containsValue("Samsig"));
		System.out.println(map.containsValue("github"));
		
		// Key Set
		Set<Integer> keys = map.keySet();
		System.out.println(keys);
		
	}

}
