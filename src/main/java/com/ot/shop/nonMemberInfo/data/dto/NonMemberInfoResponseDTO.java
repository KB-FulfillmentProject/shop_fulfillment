package com.ot.shop.nonMemberInfo.data.dto;

import com.ot.shop.product.data.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NonMemberInfoResponseDTO {
	
	private String orderNumber;
	
	private Product product;
	private String name;
	private String email;
	private String email2;
	private String hp1;
	private String hp2;
	private String hp3;
	private String address;
	private String zipcode;
	
	private char aggrement1;
	private char aggrement2;
	private char aggrement3;
	private int orderCount;	
}	
