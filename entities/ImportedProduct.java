package com.rodrigo.aula131.entities;

public class ImportedProduct extends Product{
	
	private Double customsFeed;
	
	public ImportedProduct () {
		super();
	}

	public ImportedProduct(String name, Double price, Double customsFeed) {
		super(name, price);
		this.customsFeed = customsFeed;
	}

	public Double getCustomsFeed() {
		return customsFeed;
	}

	public void setCustomsFeed(Double customsFeed) {
		this.customsFeed = customsFeed;
	}
	
	public Double totalPrice() {
		return super.getPrice() + customsFeed;
	}
	
	
	@Override
	public String priceTag() {
		return super.getName()
				+" $ "
				+ String.format("%.2f", totalPrice())
				+ " (Customs fee: $ "
				+ String.format("%.2f", customsFeed)
				+ ")";
	}

}

