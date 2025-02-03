package main.study.collection.sort;

public class Product {
	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/collection/sort/Product.java
	
	private String prdId;
	private Integer prdSize;
	
	public Product(String prdId, Integer prdSize) {
		this.prdId = prdId;
		this.prdSize = prdSize;
	}

	/**
	 * @return the prdId
	 */
	public String getPrdId() {
		return prdId;
	}

	/**
	 * @param prdId the prdId to set
	 */
	public void setPrdId(String prdId) {
		this.prdId = prdId;
	}

	/**
	 * @return the prdSize
	 */
	public Integer getPrdSize() {
		return prdSize;
	}

	/**
	 * @param prdSize the prdSize to set
	 */
	public void setPrdSize(Integer prdSize) {
		this.prdSize = prdSize;
	}
	
	
}
