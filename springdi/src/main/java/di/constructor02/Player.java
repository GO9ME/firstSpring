package di.constructor02;

public class Player implements AbstractPlayer {
	AbstarctDice d;
	int totalValue;

	public Player() {
		// TODO Auto-generated constructor stub
		System.out.println("Player 생성자");
	}

	public Player(AbstarctDice d, int totalValue) {
		super();
		this.d = d;
		this.totalValue = totalValue;
		System.out.println("Player 2 매개변수 생성자");
	}

	@Override
	public void play() {
		totalValue = 0;
		for (int i = 0; i < 3; i++) {
			totalValue += d.getDiceValue();
		}
	}

	@Override
	public int getTotalValue() {
		return totalValue;
	}
}