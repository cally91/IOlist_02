package com.biz.iolist.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.biz.iolist.Dao.ProductDao;
import com.biz.iolist.config.DBConnection;
import com.biz.iolist.model.ProductVO;

import oracle.jdbc.driver.DBConversion;

/*
 * 상품정보의 등록 수정 삭제 
 */
public class ProductService {

	SqlSession sqlSession =null;
	ProductDao proDao =null;
	Scanner scan = null;
	
	public ProductService() {
		sqlSession= DBConnection.getSessionFactory().openSession(true);
		proDao =(ProductDao) sqlSession.getMapper(ProductDao.class);
		scan =new Scanner(System.in);
	}
			
	public void viewProduct() {
		System.out.println("========================================");
		System.out.println("삼양식품 - 상품 정보");
		System.out.println("------------------------------------------");
		System.out.println("상품코드\t상품이름\t매입단가\t매출단가");
		List<ProductVO> proList= proDao.selectAll();
		for (ProductVO vo :proList) {
			System.out.print(vo.getP_code()+"\t\t");
			System.out.print(vo.getP_name()+"\t\t");
			System.out.print(vo.getP_iprice()+"\t\t");
			System.out.print(vo.getP_opruce());
			
		}
	}
	public boolean insertPRO() {
		System.out.println("===========================");
		System.out.println("매입 매출 등록");
		System.out.println("--------------------------");
		//while(true) {
		System.out.print("상품코드입력>>");
		String strCode =scan.nextLine();
		System.out.print("상품이름 입력>>");
		String strName =scan.nextLine();
		System.out.print("매입단가>>");
		String strIprice =scan.nextLine();
		int intIprice =Integer.valueOf(strIprice);
		System.out.print("매출단가>>");
		String strOpruce =scan.nextLine();
		int intOpruse =Integer.valueOf(strOpruce);
		
		ProductVO vo = new ProductVO(strCode,strName,intIprice,intOpruse);
		if(proDao.insert(vo) >0) return true;
		else return false;
	}
	public boolean updatePRO() {
		System.out.println("===================");
		System.out.println("거래정보 수정");
		System.out.println("===========================");
		System.out.print("수정할 상품코드>>");
		String strCode =scan.nextLine();
		
		ProductVO vo=proDao.fianByCode(strCode);
		if(vo==null) {
			System.out.println("해당 상품이 없습니다.");
			return false;
		}
		System.out.printf("(%s)상품이름>>",vo.getP_name());
		String strName =scan.nextLine();
		System.out.printf("(%d) 매입 단가>>",vo.getP_iprice());
		String strIprice = scan.nextLine();
		int intIprice =Integer.valueOf(strIprice);
		System.out.printf("(%d) 매출단가 >>",vo.getP_opruce());
		String strOpruce =scan.nextLine();
		int intOpruce = Integer.valueOf(strOpruce);
		
		vo.setP_name(strName);
		vo.setP_iprice(intIprice);
		vo.setP_opruce(intOpruce);
		
		
		if (proDao.updade(vo)>0)return true;
		else return false;
		
	}
	public boolean delerePRO() {
		System.out.print("삭제할 내역>>");
		String strCode = scan.nextLine();

		ProductVO vo =proDao.fianByCode(strCode);
		System.out.println(vo);
		System.out.print("정말 삭제할건가요?(YES)>>");
		String config = scan.nextLine();
		if (config.equalsIgnoreCase("YES")) {
			if(proDao.delete(strCode)>0) return true;
			else return false;
		}
		return false;
	}
}
