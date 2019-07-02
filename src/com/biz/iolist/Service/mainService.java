package com.biz.iolist.Service;

import java.util.Scanner;

public class mainService {
	
	
ProductService proService =null;
Scanner scan =null;

public mainService() {
	proService =new ProductService();
	scan= new Scanner(System.in);
}
public void start() {
 while(true) {
	 proService.viewProduct();
	 
	 System.out.println();
	 System.out.println("================");
	 System.out.println("1.거래등록 2.수정 3.삭제 4.종료");
	 System.out.println("============");
	 System.out.print("업무선택>>");
	 String strmain =scan.nextLine();
	 int intMain =Integer.valueOf(strmain);
	 
	 if(intMain==1) 
		 proService.insertPRO();
		 if(intMain==2)
			 proService.updatePRO();
		 if(intMain==3)
			 proService.delerePRO();
		 if (intMain==4)
			 break;
	 
 }

}
}
