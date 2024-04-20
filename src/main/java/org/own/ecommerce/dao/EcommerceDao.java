package org.own.ecommerce.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.own.ecommerce.dto.Merchant;
import org.own.ecommerce.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EcommerceDao {
	@Autowired
	private EntityManager entityManager;
	
	public Merchant saveMerchant(Merchant merchant) {
		EntityTransaction t = entityManager.getTransaction();
		entityManager.persist(merchant);
		t.begin();
		t.commit();
		return merchant;
	}
	
	public Merchant updateMerchant(Merchant merchant, int id) {
		EntityTransaction t = entityManager.getTransaction();
		Merchant m = entityManager.find(Merchant.class, id);
		if(m!=null) {
			m.setName(merchant.getName());
			m.setEmail(merchant.getEmail());
			m.setGst_number(merchant.getGst_number());
			m.setPassword(merchant.getPassword());
			m.setPhone(merchant.getPhone());
			t.begin();
			t.commit();
			return merchant;
		}
		return null;
	}
	
	public Merchant findMerchantById(int id) {
		return entityManager.find(Merchant.class, id);
	}
	public boolean deleteMerchant(int id) {
		Merchant m = entityManager.find(Merchant.class, id);
		EntityTransaction t = entityManager.getTransaction();
		if(m!=null) {
			entityManager.remove(m);
			t.begin();
			t.commit();
			return true;
		}
		else {
			return false;
		}
	}
	public Product saveProduct(Product product, int merchant_id) {
		Merchant m = entityManager.find(Merchant.class, merchant_id);
		EntityTransaction t = entityManager.getTransaction();
		if(m!=null) {
			product.setMerchant(m);
			m.getProducts().add(product);
			entityManager.persist(product);
			t.begin();
			t.commit();
			return product;
		}else {
			return null;
		}
		
	}
}
