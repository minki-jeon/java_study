package main.study.quiz;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeDiffCalculator {
	/**
	 * SNS 기능 구현을 하는 프로그램을 작성할 때, 현재 읽고 있는 콘텐츠가 몇 시간 전에 작성되었는지 표기하시오. 주어진 조건은 다음과 같습니다.
	 * - input은 yyyy-MM-dd HH:mm:ss(예. 2023-04-18 00:42:24) 형태로 현재 시간보다 과거 시간이다.
	 * - 현재 시간과 비교하여 1시간 이내라면 xx분 전으로 표기(1분 이하는 1분 전으로 표기)
	 * - 24시간 내에 작성되었다면 xx시간 전으로 표기
	 * - 24시간 이후라면 xx일 전으로 표기(월은 고려하지 않음)
	 */
	
	public static void main(String[] args) {
		//* input
//		String input = "2023-04-18 00:42:24";
//		String input = "2025-03-11 00:42:24";
//		String input = "2025-03-11 20:22:24";
		String input = "2025-03-11 20:42:24";
		
		//* formatter
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		//* string to DateTime
		LocalDateTime inputDateTime = LocalDateTime.parse(input, format);
		//* Current DateTime
		LocalDateTime currentDateTime = LocalDateTime.now();
		//* 현재 시간과 비교하기
		String result = calDateTime(inputDateTime, currentDateTime);
		System.out.println(result);
	}

	private static String calDateTime(LocalDateTime inputDateTime, LocalDateTime currentDateTime) {
		//* Duration.between(a, b).getSeconds() : 시간 사이의 간격
		//* Period.between(a, b).getYears()/.getMonths()/.getDays() : 날짜 사이의 간격
		//* ChronoUnit.YEARS/MONTHS/WEEKS/DAYS/HOURS/MINUTES/SECONDS.between(a, b) : 특정 단위의 간격
		
//		long calSeconds = ChronoUnit.SECONDS.between(inputDateTime, currentDateTime);
		long calMinutes = ChronoUnit.MINUTES.between(inputDateTime, currentDateTime);
		if (calMinutes < 1) {
			return "1분 전";
		}
		long calHours = ChronoUnit.HOURS.between(inputDateTime, currentDateTime);
		if (calHours < 1) {
			return calMinutes + "분 전";
		}
		long calDays = ChronoUnit.DAYS.between(inputDateTime, currentDateTime);
		if (calDays < 1) {
			return calHours + "시간 전";
		}

		return calDays + "일 전";
	}

}
