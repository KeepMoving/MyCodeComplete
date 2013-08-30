package dIExample01;

public class Monster 
{
	public String Name;
	public int HP;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int hp) {
		HP = hp;
	}
	
	public Monster(String name, int hp) 
	{
		this.Name = name;
		this.HP = hp;
	}
	
	public void Notify(int loss)
	{
		if(this.HP <= 0)
		{
			System.out.println("此怪物已死"); 
			return;
		}
		
		this.HP -= loss;
		if(this.HP <= 0)
		{
			System.out.println("怪物" + this.Name + "被打死");
		}
		else
		{
			System.out.println("怪物" + this.Name + "损失" + loss + "HP");
		}
	}
}
