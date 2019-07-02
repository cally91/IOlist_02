package com.biz.iolist.model;

public class ProductVO {


	 private String	 p_code;	//varchar2(5 byte)
	 private String	p_name;	//nvarchar2(50 char)
	 private int p_iprice;	//number
	 private int p_opruce;	//number
	 // gatter,setter,toString
	 
	 public ProductVO() {
			super();
			// TODO Auto-generated constructor stub
		}
	 public ProductVO(String p_code, String p_name, int p_iprice, int p_opruce) {
			super();
			this.p_code = p_code;
			this.p_name = p_name;
			this.p_iprice = p_iprice;
			this.p_opruce = p_opruce;
		}
		 
	

	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_iprice() {
		return p_iprice;
	}
	public void setP_iprice(int p_iprice) {
		this.p_iprice = p_iprice;
	}
	public int getP_opruce() {
		return p_opruce;
	}
	public void setP_opruce(int p_opruce) {
		this.p_opruce = p_opruce;
	}

	@Override
	public String toString() {
		return "ProductVO [p_code=" + p_code + ", p_name=" + p_name + ", p_iprice=" + p_iprice + ", p_opruce="
				+ p_opruce + "]";
	}
	
	 
	

}
