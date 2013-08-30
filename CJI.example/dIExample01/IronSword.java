package dIExample01;
public class IronSword implements IAttackStrategy 
{
	public void AttackTarget(Monster monster) 
	{
		monster.Notify(50);
	}
}