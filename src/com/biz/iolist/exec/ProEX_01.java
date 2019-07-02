package com.biz.iolist.exec;

import org.apache.ibatis.session.SqlSession;

import com.biz.iolist.Dao.ProductDao;
import com.biz.iolist.Service.ProductService;
import com.biz.iolist.Service.mainService;
import com.biz.iolist.config.DBConnection;
import com.biz.iolist.model.ProductVO;

public class ProEX_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	 ProductService pService = new ProductService();
	 mainService mainService= new mainService();
//	 pService.viewProduct();
//	 pService.insertPRO();
//	 pService.updatePRO();
		mainService.start();
	}

}
