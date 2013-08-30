package dIExample;
import java.util.Random;


public class Role {
	private Random _random = new Random();
	
	public String WeaponTag;

	public String getWeaponTag() {
		return WeaponTag;
	}

	public void setWeaponTag(String weaponTag) {
		WeaponTag = weaponTag;
	}
	
	public void Attack(Monster monster)
	{
		if(monster.hp <= 0)
		{
			System.out.println("此怪物已死");
			return;
		}
		
		if("WoodSword" == this.WeaponTag)
		{
			monster.hp -= 20;
			if(monster.hp <= 0)
			{
				System.out.println("攻击成功！怪物" + monster.name + "已死亡");
			}
			else
			{
				System.out.println("攻击成功！怪物" + monster.name + "损失20HP");
			}
		}
		else if("IronSword" == this.WeaponTag)
		{
			monster.hp -= 50;
			if(monster.hp <= 0)
			{
				System.out.println("攻击成功！怪物" + monster.name + "已死亡");
			}
			else
			{
				System.out.println("攻击成功！怪物" + monster.name + "损失50HP");
			}
		}	
		else if("MagicSword" == this.WeaponTag)
		{
			int loss = (_random.nextDouble() < 0.5)?100:200;
			monster.hp -= loss;
			if(200 == loss)
			{
				System.out.println("出现暴击!!!");
			}
			
			if(monster.hp <= 0)
			{
				System.out.println("攻击成功！怪物" + monster.name + "已死亡");
			}
			else
			{
				System.out.println("攻击成功！怪物" + monster.name + "损失" + loss + "HP");
			}
		}
		else
		{
			System.out.println("角色手里没有武器,无法攻击!");

		}
	}
}
