package assertTest;

/*
 * jvm 断言默认是关闭的。断言是可以局部开启的
 * 选择菜单：Run ---> Run... ---> 选择 Arguments 选项卡
 * 在 VM arguments 文本框中输入： -ea   
 * 注意 中间没有空格，如果输入-da表示禁止断言。
 * 然后关闭该窗口，提示保存，然后保存就开启了断言。
 */
public class AssertTest 
{
	public static void main(String[] args) 
	{
        //断言1结果为true，则继续往下执行，且不打印“断言1没有问题，Go！”
        assert true : "断言1没有问题，Go！"; 

        //断言2结果为false,程序终止
        assert false : "断言失败，此表达式的信息将会在抛出异常的时候输出！"; 
	}
}
