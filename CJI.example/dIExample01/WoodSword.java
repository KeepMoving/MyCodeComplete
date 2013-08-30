package dIExample01;
public class WoodSword implements IAttackStrategy 
{
	public void AttackTarget(Monster monster) 
	{
		monster.Notify(20);
	}
}
