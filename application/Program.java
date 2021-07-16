package com.rodrigo.aula131.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.rodrigo.aula131.entities.ImportedProduct;
import com.rodrigo.aula131.entities.Product;
import com.rodrigo.aula131.entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			System.out.println("Product #" + (i + 1) + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char choice = sc.next().charAt(0);
			
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			if (choice == 'c') {
				list.add(new Product(name, price));
			}else if (choice == 'i'){
				System.out.print("Customs fee: ");
				double fee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, fee));
			}else {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				String date = sc.next();
				list.add(new UsedProduct(name, price, sdf.parse(date)));
			}
			
		}
		System.out.println();
		System.out.println("PRICE TAGS");
		for( Product pro : list) {
			System.out.println(pro.priceTag());
		}
		
		sc.close();
	}

}
