package dIExample;

public class Monster {
	public String name;
	public int hp;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public Monster(String name, int hp) 
	{
		this.name = name;
		this.hp = hp;
	}
}
