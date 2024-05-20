package com.ot.shop.product.data.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductDto {
	private Long id;
	private String name;
	private String content;
	private String image;
	private Integer price;
	
}
