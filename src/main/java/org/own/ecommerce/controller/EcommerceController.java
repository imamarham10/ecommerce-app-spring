package org.own.ecommerce.controller;

import java.util.Scanner;

import org.own.ecommerce.EcommerceConfig;
import org.own.ecommerce.dao.EcommerceDao;
import org.own.ecommerce.dto.Merchant;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EcommerceController {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EcommerceConfig.class);
		EcommerceDao eDao = context.getBean(EcommerceDao.class);
		System.out.println("1.Save Merchant\n2.Update Merchant\n3.Find Merchant by Id\n4.Verify Merchant By Phone and Password");
		System.out.println("5.Verify Merchant By Email and Password\n6. Add Product\n7. Update Product\n8. Find Product By Merchant Id");
		System.out.println("9.Find Product By Brand\n10.Find Product By Category\n11. Delete a merchant by id");
		Scanner sc = new Scanner(System.in);
		switch(sc.nextInt()) {
		case 1: {
			System.out.println("Enter Name, Email, Phone, Gst Number, Password");
			Merchant m = new Merchant();
			m.setName(sc.next());
			m.setEmail(sc.next());
			m.setPhone(sc.nextLong());
			m.setGst_number(sc.next());
			m.setPassword(sc.next());
			m = eDao.saveMerchant(m);
			if(m!=null) {
				System.out.println("Employee saved with id: " + m.getId());
			}else {
				System.out.println("Failed to save employee, try again!");
			}
			break;

		}
		case 2: {
			System.out.println("Enter the merchant id");
			int id = sc.nextInt();
			System.out.println("Enter Name, Email, Phone, Gst Number, Password");
			Merchant m = new Merchant();
			m.setName(sc.next());
			m.setEmail(sc.next());
			m.setPhone(sc.nextLong());
			m.setGst_number(sc.next());
			m.setPassword(sc.next());
			m = eDao.updateMerchant(m, id);
			if(m!=null) {
				System.out.println("Employee updated with id: " + id);
			}else {
				System.out.println("Failed to save employee, try again!");
			}
			break;			
		}
		case 3: {
			System.out.println("Enter the merchant id");
			int id = sc.nextInt();
			Merchant m = eDao.findMerchantById(id);
			if(m!=null) {
				System.out.println(m);
			}else {
				System.out.println("Invalid id!");
			}
			break;
		}
		case 11:{
			System.out.println("Enter the merchant id");
			int id = sc.nextInt();
			boolean flag = eDao.deleteMerchant(id);
			if(flag == true) {
				System.out.println("Merchant has been deleted with id " + id);
			}else {
				System.out.println("Invalid id!");
			}
		}
		}

	}
}
