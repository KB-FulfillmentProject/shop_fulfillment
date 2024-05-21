package com.ot.shop.admin.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ot.shop.admin.controller.AdminController;
import com.ot.shop.admin.data.dto.AdminLoginRequestDTO;
import com.ot.shop.admin.data.dto.NonMemberOrderRequestDTO;
import com.ot.shop.admin.service.AdminService;

import com.ot.shop.product.data.dto.ProductResponseDTO;
import com.ot.shop.product.service.ProductService;


@RestController
@RequestMapping("/api/v1/shop-fulfillment")
public class AdminControllerImpl implements AdminController {

	private final AdminService adminService;
	private final ProductService productService;
	
	@Autowired
	public AdminControllerImpl(AdminService adminService, ProductService productService) {
		this.adminService = adminService;
		this.productService = productService;
	}

//	@GetMapping("/getAllOrders")
//	public ResponseEntity<List<NonMemberOrderRequestDTO>> getAllOrders() {
//		List<NonMemberOrderRequestDTO> orders = adminService.findAllOrder();
//		
//		return ResponseEntity.status(HttpStatus.OK).body(orders);
//	}
	
	@GetMapping("/selectAllOrders")
    public ModelAndView selectAllOrders() {
        List<NonMemberOrderRequestDTO> orders = adminService.findAllOrder();
        
        ModelAndView mav = new ModelAndView("selectAllOrder");
        mav.addObject("orders", orders);
        
        return mav;

    }

	 @GetMapping("/login")
	    public ModelAndView showLoginPage() {
		 ModelAndView mav = new ModelAndView("login");
		 return mav;  
	 }
	 
	@PostMapping("/loginCheck")
	public ModelAndView loginCheck(@RequestParam(value = "id", required = false, defaultValue = "") String id) {
	    ModelAndView mav = new ModelAndView();
	    
	    AdminLoginRequestDTO loginResult = adminService.login(id);
	    
	    if (loginResult.getId() != null) {
	        //login success
	        System.out.println(" success loginResult : " + loginResult);
	        mav.addObject("loginResult", loginResult);
	        mav.setViewName("index");
	    } else {
	        //login fail
	        System.out.println("fail loginResult : " + loginResult);
	        mav.setViewName("fail");
	    }
	    
	    return mav;
	}
	
	@GetMapping("/createProduct")
	public ModelAndView createProduct() {
		ModelAndView mav = new ModelAndView("createProduct");
		return mav;
	}
	
	
	
//	@GetMapping("/getAllProducts")
//	public ModelAndView getAllProducts() {
//	    List<ProductResponseDTO> products = productService.findAllProduct();
//	    
//	    ModelAndView mav = new ModelAndView();
//	    mav.addObject("products", products);
//	    mav.setViewName("selectAllProduct"); // 렌더링할 뷰의 이름
//	    
//	    return mav;
//	}
	
	@GetMapping("/selectAllProduct")
	public ModelAndView selectAllProduct() {
		List<ProductResponseDTO> products = productService.findAllProduct();

		
		ModelAndView mav = new ModelAndView("selectAllProduct");
		mav.addObject("products", products);
		return mav;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	

	

}
