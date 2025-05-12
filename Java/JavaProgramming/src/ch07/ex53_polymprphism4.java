package ch07;

public class ex53_polymprphism4 {

	public static void main(String[] args) {
		ZooKeeper james = new ZooKeeper();
		
		Animal lion = new Lion();
		james.feed(lion);
		
		Animal rabbit = new Rabbit();
		james.feed(rabbit);
		
		Animal monkey = new Monkey();
		james.feed(monkey);
	}

}
