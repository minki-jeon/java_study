package main.study.collection.sort.actor;

import static java.util.Arrays.asList;
import static java.util.List.of;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilmFestival {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/collection/sort/actor/FilmFestival.java

	private static final Logger logger = LoggerFactory.getLogger(FilmFestival.class);
	
	public static void main(String[] args) {
		/* 청룡영화제 12년간 남우주연상 수상작
		33회(2012) - 최민식(《범죄와의 전쟁: 나쁜놈들 전성시대》)
		34회(2013) - 황정민(《신세계》)
		35회(2014) - 송강호(《변호인》)
		36회(2015) - 유아인(《사도》)
		37회(2016) - 이병헌(《내부자들》)
		38회(2017) - 송강호(《택시운전사》)
		39회(2018) - 김윤석(《1987》)
		40회(2019) - 정우성(《증인》)
		41회(2020) - 유아인(《소리도 없이》)
		42회(2021) - 설경구(《자산어보》)
		43회(2022) - 박해일(《헤어질 결심》)
		44회(2023) - 이병헌(《콘트리트 유토피아》)
		45회(2024) - 황정민(《서울의 봄》)
		 */
		
		Actor[] actors = new Actor[] {
				new Actor("송강호", "택시운전사", 2017),
				new Actor("송강호", "변호인", 2014),
				new Actor("김윤석", "1987", 2018),
				new Actor("설경구", "자산어보", 2021),
				new Actor("황정민", "서울의 봄", 2024),
				new Actor("이병헌", "내부자들", 2016),
				new Actor("유아인", "사도", 2015),
				new Actor("이병헌", "콘트리트 유토피아", 2023),
				new Actor("정우성", "증인", 2019),
				new Actor("최민식", "범죄와의 전쟁: 나쁜놈들 전성시대", 2012),
				new Actor("황정민", "신세계", 2013),
				new Actor("박해일", "헤어질 결심", 2022),
				new Actor("유아인", "소리도 없이", 2020)
		};
		
//		logger.info("### 정렬 전 ###");
		System.out.println("### 정렬 전 ###");
		consoleLog(of(actors));
		
		Arrays.sort(actors);
//		logger.info("### 기본 정렬 후 (배우이름) ###");
		System.out.println("### 기본 정렬 후 (배우이름) ###");
		consoleLog(of(actors));
		
		List<Actor> list = asList(actors);	// 배열을 리스트로 
		Collections.shuffle(list);	// 리스트의 순서를 섞음
		
//		logger.info("### List shuffle 후 ###");
		System.out.println("### List shuffle 후 ###");
		consoleLog(list);
		
		// 리스트를 정렬 (클래스에 정의된 기본 정렬)
		Collections.sort(list);
		
//		logger.info("### List 기본 정렬 후 ###");
		System.out.println("### List 기본 정렬 후 ###");
		consoleLog(list);
		
		// 디폴트 정렬할 수 있는 TreeSet 생성
		Set<Actor> set = new TreeSet<>(list);
		
//		logger.info("### treeset 적용 후 ###");
		System.out.println("### treeset 적용 후 ###");
		consoleLog(set);
		
		// 연동별로 적용한 set
		Set<Actor> yearSet = new TreeSet<>(new PrizeYearComparator());
		yearSet.addAll(list);
		
//		logger.info("### 최신 연도별 정렬 후 ###");
		System.out.println("### 최신 연도별 정렬 후 ###");
		consoleLog(yearSet);
	}
	
	private static void consoleLog(Collection<Actor> collection) {
		for (Actor actor : collection) {
//			logger.info(actor.toString());
			System.out.println(actor.toString());
		}
	}

}
