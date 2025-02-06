package main.study.collection.sort.actor;

class Actor implements Comparable<Object> {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/collection/sort/actor/Actor.java

	String name;
	String title;
	int prizeYear;
	
	// Constructor
	public Actor(String name, String title, int birthYear) {
		this.prizeYear = birthYear;
		this.name = name;
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "수상 배우 목록 {" + "배우 = " + name + ", 영화 제목 [" + title + "]" + ", 청룡영화제 남우주연상 수상 연도 = " + prizeYear + "}";
	}
	
	@Override
	public int compareTo(Object o) {
		return name.compareTo(((Actor) o).name);
	}
	
}
