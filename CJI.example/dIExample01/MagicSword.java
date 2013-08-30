package dIExample01;
import java.util.Random;

public class MagicSword implements IAttackStrategy 
{
	private Random _random = new Random();
	public void AttackTarget(Monster monster) 
	{
		int loss = (_random.nextDouble()<0.5)?100:200;
		if(200 == loss)
		{
			System.out.println("出现暴击!!!");
		}
		monster.Notify(loss);
	}

}
