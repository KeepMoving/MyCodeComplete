package dIExample;

public class Test 
{
	public static void main(String[] args) 
	{
		Monster monster1 = new Monster("小怪A",50);
		Monster monster2 = new Monster("小怪B",50);
		Monster monster3 = new Monster("关主",200);
		Monster monster4 = new Monster("最终Boss",1000);
		
		Role role = new Role();
		
		role.WeaponTag = "WoodSword";
		role.Attack(monster1);
		
		role.WeaponTag = "IronSword";
		role.Attack(monster2);
		role.Attack(monster3);
		
		role.WeaponTag = "MagicSword";
		role.Attack(monster3);
		role.Attack(monster4);
		role.Attack(monster4);
		role.Attack(monster4);
		role.Attack(monster4);
		role.Attack(monster4);
	}

}
