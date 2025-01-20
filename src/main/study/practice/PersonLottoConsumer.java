package main.study.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PersonLottoConsumer implements Consumer<List<PersonLotto>> {

	public void accept(List<PersonLotto> personLottoList) {
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
