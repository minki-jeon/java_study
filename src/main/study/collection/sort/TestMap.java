package main.study.collection.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMap {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/collection/sort/TestMap.java

	private static final Logger logger = LoggerFactory.getLogger(TestMap.class)
			;
	public static void main(String[] args) {
		Map<String, String> addr = new HashMap<String, String>();
		addr.put("가가가1", "1");
		addr.put("나나나2", "1");
		addr.put("가가가1", "1");
		addr.put("다다다0", "1");
		
//		logger.info("# Map에 담긴 자료 : {}", addr);
		System.out.println("# Map에 담긴 자료 : " + addr);
		
		Set<String> set = addr.keySet();
		Object[] hmKeys = set.toArray();
		Arrays.sort(hmKeys, nameSorter);	// 이름순 정렬
		
		for (int i = 0; i < hmKeys.length; i++) {
			String key = (String) hmKeys[i];
//			logger.info("# key = {}", key);
			System.out.println("# key = " + key);
		}
		
	}
	
	public static Comparator<Object> nameSorter = (s1, s2) -> {
		String ss1 = (String) s1;
		String ss2 = (String) s2;
		//* 오름차순 (
		return (-1) * ss2.compareTo(ss1);
//		return ss1.compareTo(ss2);
	};

}
