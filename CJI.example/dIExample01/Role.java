package dIExample01;
public class Role 
{
	public IAttackStrategy Weapon;

	public IAttackStrategy getWeapon() {
		return Weapon;
	}

	public void setWeapon(IAttackStrategy weapon) {
		Weapon = weapon;
	}
	
	public void Attack(Monster monster)
	{
		this.Weapon.AttackTarget(monster);
	}
}
