package di.setter03;


import java.util.Random;
public class Dice extends Random implements AbstarctDice{
	public Dice() {
		// TODO Auto-generated constructor stub
		System.out.println("DICE 생성자");
	}
	
	@Override
	public int getDiceValue(){
		return nextInt(6)+1;
	}
}

