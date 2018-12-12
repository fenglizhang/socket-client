package test;

import java.util.ArrayList;
import java.util.List;

public class ChouJiang {
	public static void main(String[] args) throws InterruptedException {
		List<String> li=new ArrayList<String>();
		for (int i = 1; i <= 60; i++) {
			li.add(i+"");
		}
		boolean flag=true;
		int count=1;
		
		System.out.println("---------------------中奖号码为如下公示，请持有对应编号的员工上来领取奖品-iphone手机一部。------------------------------");
		while(flag){
			//(数据类型)(最小值+Math.random()*(最大值-最小值+1))
			int b=(int)(1+Math.random()*(60-count));
			if(count ==10){
				flag=false;
			}
			Thread.sleep(3*1000);
			System.out.println("第"+count+"位幸运者  :  "+li.get(b));
			String aa = (String)li.get(b);
			li.remove(aa);
			count++;
		}
		System.out.println("---------------------------公示结束！！！-----------------------------------");
	}
}
