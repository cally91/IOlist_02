package com.biz.iolist.Dao;

import java.util.List;

import com.biz.iolist.model.ProductVO;

public interface ProductDao {
//DB의 5가지 CRUD를 정리
	public  List<ProductVO> selectAll();
	public ProductVO fianByCode(String p_code);
	
	public int insert(ProductVO vo);
	public int updade(ProductVO vo);
	public int delete(String p_code); 
		
	
		
	
	
}
