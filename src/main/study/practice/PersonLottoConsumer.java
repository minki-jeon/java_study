package main.study.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class PersonLottoConsumer implements Consumer<List<PersonLotto>> {

	public void accept(List<PersonLotto> personLottoList) {
        /** 당첨 결과 출력 **/
        System.out.println("당첨 개수 출력:");
        for (PersonLotto person : personLottoList) {
        	System.out.println(person.getName() + ": " + Arrays.toString(person.getNumbers()));
            System.out.println(person.getName() + " 당첨 개수: " + person.getWinCount() + ", 보너스 일치: " + person.isBonus());
        }

        /** 당첨번호와 일치하는 개수가 많은 사람의 이름과 개수 출력 (보너스 제외) **/
		int maxWinCount = 0;		// 가장 많이 맞춘 개수
        int winCount = 0;			// 맞춘 개수
        List<String> maxCntPersons = new ArrayList<String>();	// 가장 많이 맞춘 사람
        for (PersonLotto person : personLottoList) {
        	winCount = person.getWinCount();
        	
        	if (winCount < 1 || winCount < maxWinCount)	continue;
        	
        	if (winCount > maxWinCount) {
        		/** 당첨번호 개수가 이전 사람보다 많은 경우 **/
        		if (maxWinCount != 0) maxCntPersons.clear();        		
    			maxWinCount = winCount;
        		maxCntPersons.add(person.getName());
        	} else {
        		/** 당첨번호 개수가 동일한 경우 **/
        		maxCntPersons.add(person.getName());
        	}
        }
        //* 출력
        if (maxWinCount != 0) {
        	System.out.println("당첨번호를 " + maxWinCount + "개로 가장 많은 숫자를 맞춘 사람: " + maxCntPersons);
        } else {
        	System.out.println("당첨번호를 맞춘 사람이 존재하지 않습니다.");
        }
	}
}
