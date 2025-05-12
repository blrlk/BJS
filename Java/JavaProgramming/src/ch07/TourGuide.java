package ch07;

//각각의 클래스마다 역할 부여
//TourGuide가 객체를 생성하도록
public class TourGuide {
	private Providable tour = new KoreaTour();
//	private Providable tour = new JapanTour();
	
	public void leisureSports() {
		tour.leisureSports();
	}
	
	public void sightseeing() {
		tour.sightseeing();
	}

	public void food() {
		tour.food();
	}
}
