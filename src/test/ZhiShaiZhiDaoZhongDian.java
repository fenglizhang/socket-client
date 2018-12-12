package test;

import java.util.Scanner;

public class ZhiShaiZhiDaoZhongDian {

	public static void main(String[] args) {
		System.out.println("---------------游戏开始----------------");
		boolean flag = true;
		int count=1;
		Scanner scanner = new Scanner(System.in);
		while (flag) {
			System.out.println("输入任何值摇动筛子。。。");
			String b=scanner.next();
			int a=(int)(1+Math.random()*6);
			System.out.println("筛子朝上面的值为： "+a);
			switch (a) {
			case 1:
				count = count(count+1);
				break;
			case 2:
				count=count(count+2);
				break;
			case 3:
				count=count(count+3);

				break;
			case 4:
				count=count(count+4);

				break;
			case 5:
				count=count(count+5);

				break;
			case 6:
				count=count(count+6);

				break;
			default:
				break;
			}
			
			if(count==17){
				flag=false;
			}

		}

	}
	
	private static int count(int count){
		//向前进一步。
		if(count==2||count==5||count==6||count==9||count==10||count==12||count==13||count==15){
			System.out.println(">>>>>>>前进一步>>>>>");
			return count;
		}
		if(count==3){
			System.out.println("进入快速通道，直达9>>>>>>");
			return 9;
		}
		if(count==4){
			System.out.println("<<<<<后退两步");
			return 2;
		}
		if(count==14){
			System.out.println("<<<<<<<<<回退到6");
			return 6;
		}
		if(count==7||count==11){
			System.out.println("<<<<<<<<返回到起点");
			return 1;
		}
		if(count==8){
			System.out.println("进入快速通道，直达13>>>>>>");
			return 13;
		}
		if(count==16){
			System.out.println("<<<<<<后退三步");
			return 13;
		}
		if(count>=17){
			System.out.println("***到达终点，游戏结束***");
			return 17;
		}
		return count;
	}
	
}

