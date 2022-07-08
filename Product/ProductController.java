package com.hibernateTask.Product;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ProductController {

	@Autowired
	SessionFactory factory;
	
	@GetMapping("loaddetails")
	Product loadDetails () {
		Session session = factory.openSession();
		System.out.println("factory>>>>>>>>>>" + factory);
		Product product=session.load(Product.class, 1);
		return product;
	}
//	@GetMapping("loadAllDetails")
//	ArrayList<Product> loadAllDetails() {
//		Session session = factory.openSession();
//		System.out.println("factory>>>>>>>>>>" + factory);
//		
//		Query query= session.createQuery("from Product");
//		
//		ArrayList<Product> alP = (ArrayList<Product>) query.list();
//		for (Product product : alP) {
//			return product;
//		}
		
		
	@GetMapping("products")
	ArrayList<Product> fetchbyname (@RequestParam ("page")String page){
		Session session =factory.openSession();
		Criteria ctr = session.createCriteria(Product.class);
		ctr.add(Restrictions.eq("product_type", "Wholesale"));
				ArrayList<Product> al = (ArrayList<Product>) ctr.list();
		for (Product product : al) {
			System.out.println(product);
		}
		return al;
	}
	
	}

