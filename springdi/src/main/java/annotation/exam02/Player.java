package annotation.exam02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("player")
public class Player implements AbstractPlayer {
	@Autowired
	AbstarctDice d;
	@Value("0")
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