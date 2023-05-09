package com.laptrinhjavaweb.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.Favourites;
import com.laptrinhjavaweb.entity.MapperFavouites;
import com.laptrinhjavaweb.entity.MapperProducts;
import com.laptrinhjavaweb.entity.Products;

@Repository
public class ProductDao {

	@Autowired
	public JdbcTemplate _jdbcTemplate;

	public List<Products> GetDataSilde(int departmentId) {
		List<Products> list = new ArrayList<Products>();
		String sql = "select * from products where department_id = ?";
		list = _jdbcTemplate.query(sql, new MapperProducts(), departmentId);
		return list;
	}
	
	public List<Products> findAllProducts() {
		List<Products> list = new ArrayList<Products>();
	    String sql = "select * from products order by products.id ASC";
	    list = _jdbcTemplate.query(sql, new MapperProducts());	    
	    return list;
	}

	public int deleteOne(String code) {
		String sqlDeleteDesc = "DELETE FROM product_descriptions WHERE product_code = ?";
	    _jdbcTemplate.update(sqlDeleteDesc, code);
	    
	    String sqlDeleteProduct = "DELETE FROM products WHERE code = ?";
	    return _jdbcTemplate.update(sqlDeleteProduct, code);
	}

	public int createOne(Products p, int department_id) {
		p.setSearch_name(convertToUnsignedString(p.getName()));
		String sql = "INSERT INTO products (code, department_id, name, image, price, search_name) VALUES (?, ?, ?, ?, ?, ?)";
	    int result = _jdbcTemplate.update(sql, p.getCode(), department_id, p.getName(), p.getImage(), p.getPrice(), p.getSearch_name());
	    String descriptionSql = "INSERT INTO product_descriptions (product_code) VALUES (?)";
	    _jdbcTemplate.update(descriptionSql, p.getCode());
	    
	    return result;
	}
	
	public int updateOne(Products p) {
		p.setSearch_name(convertToUnsignedString(p.getName()));
		String sql = "UPDATE products set name = ?, image = ?, price = ?, search_name = ? where code = ?";
		return _jdbcTemplate.update(sql, p.getName(), p.getImage(), p.getPrice(),p.getSearch_name(), p.getCode());
	}
	
	public Products findById(int id) {
		List<Products> list = new ArrayList<Products>();
		String sql="select * from products where id=?";    
			 return _jdbcTemplate.queryForObject(sql, new Object[]{id},new
			 BeanPropertyRowMapper<Products>(Products.class));
	}
	
	public Products findByCode(String code) {
		String sql = "select * from products where code=?";
		return _jdbcTemplate.queryForObject(sql, new Object[]{code},new
				 BeanPropertyRowMapper<Products>(Products.class));
	}
	
	public List<Products> getProductById(int id) {
		List<Products> list = new ArrayList<Products>();
		String sql = "select * from products where id = "+id+"" ;
		list = _jdbcTemplate.query(sql, new MapperProducts());
		return list;
	}
	
	public List<Products>  findByDepartmentId(int id) {
		List<Products> list = new ArrayList<Products>();
		String sql = "select * from products where department_id = ?";
		list = _jdbcTemplate.query(sql, new MapperProducts(), id);
		return list;
	}
	
	public Products findProductById(int id) {
		String sql = "select * from products where id = "+id+"";
		Products product = _jdbcTemplate.queryForObject(sql, new MapperProducts());
		return product;
	}
	
	public List<Products> findAllProductTop(String slug_name) {
		List<Products> list = new ArrayList<Products>();
		String sql = "select products.id, products.code, products.department_id, products.name, products.price, products.search_name, products.image\n"
				+ "from products inner join bills_detail on products.code = bills_detail.product_code\n"
				+ "inner join departments on products.department_id = departments.id\n"
				+ "where departments.slug_name = ?\n"
				+ "group by products.code";
		list = _jdbcTemplate.query(sql, new MapperProducts(), slug_name);
		return list;
	}
	
	public List<Products> findAllProductsNew(String slug_name) {
		List<Products> list = new ArrayList<Products>();
		String sql = "select products.id, products.code, products.department_id, products.name, products.image, products.price, products.search_name\n"
				+ "from products inner join departments on products.department_id = departments.id\n"
				+ "where departments.slug_name = ?\n"
				+ "order by products.id DESC\n"
				+ "LIMIT 8";
		list = _jdbcTemplate.query(sql, new MapperProducts(), slug_name);
		return list;
	}
	
	public List<Products> findAllRelatedProduct(String slug_name) {
		List<Products> list = new ArrayList<Products>();
		String sql = "select products.id, products.code, products.department_id, products.name, products.price, products.search_name, products.image\n"
				+ "from products inner join departments\n"
				+ "on products.department_id = departments.id\n"
				+ "where departments.slug_name = ?";
		list = _jdbcTemplate.query(sql, new MapperProducts(), slug_name);
		return list;
	}
	
	public List<Products> findAllNewProductHome() {
		List<Products> list = new ArrayList<Products>();
		String sql = "select * from products order by(products.id) DESC limit 3";
		list = _jdbcTemplate.query(sql, new MapperProducts());
		return list;
	}
	
	public List<Favourites> findAllFavouriteProductHome() {
		List<Favourites> list = new ArrayList<Favourites>();
		String sql = "select distinct name, price, code, count(code) AS count_favourite, image from products inner join favourite_products on products.code = favourite_products.product_code group by name, price, code order by count_favourite DESC limit 3";
		list = _jdbcTemplate.query(sql, new MapperFavouites());
		return list;
	}
	
	public List<Products> findAllProductTopHome() {
		List<Products> list = new ArrayList<Products>();
		String sql = "select products.id, products.code, products.department_id, products.name, products.price, products.search_name, products.image from products \n"
				+ "inner join bills_detail on products.code = bills_detail.product_code \n"
				+ "group by products.code\n"
				+ "order by count(products.code) DESC limit 3";
		list = _jdbcTemplate.query(sql, new MapperProducts());
		return list;
	}
	
	public String convertToUnsignedString(String str) {
		Map<Character, Character> charMap = new HashMap<>();
	    charMap.put('à', 'a');
	    charMap.put('á', 'a');
	    charMap.put('ả', 'a');
	    charMap.put('ã', 'a');
	    charMap.put('ạ', 'a');
	    charMap.put('ă', 'a');
	    charMap.put('ằ', 'a');
	    charMap.put('ắ', 'a');
	    charMap.put('ẳ', 'a');
	    charMap.put('ẵ', 'a');
	    charMap.put('ặ', 'a');
	    charMap.put('â', 'a');
	    charMap.put('ầ', 'a');
	    charMap.put('ấ', 'a');
	    charMap.put('ẩ', 'a');
	    charMap.put('ẫ', 'a');
	    charMap.put('ậ', 'a');
	    charMap.put('đ', 'd');
	    charMap.put('è', 'e');
	    charMap.put('é', 'e');
	    charMap.put('ẻ', 'e');
	    charMap.put('ẽ', 'e');
	    charMap.put('ẹ', 'e');
	    charMap.put('ê', 'e');
	    charMap.put('ề', 'e');
	    charMap.put('ế', 'e');
	    charMap.put('ể', 'e');
	    charMap.put('ễ', 'e');
	    charMap.put('ệ', 'e');
	    charMap.put('ì', 'i');
	    charMap.put('í', 'i');
	    charMap.put('ỉ', 'i');
	    charMap.put('ĩ', 'i');
	    charMap.put('ị', 'i');
	    charMap.put('ò', 'o');
	    charMap.put('ó', 'o');
	    charMap.put('ỏ', 'o');
	    charMap.put('õ', 'o');
	    charMap.put('ọ', 'o');
	    charMap.put('ô', 'o');
	    charMap.put('ồ', 'o');
	    charMap.put('ố', 'o');
	    charMap.put('ổ', 'o');
	    charMap.put('ỗ', 'o');
	    charMap.put('ộ', 'o');
	    charMap.put('ơ', 'o');
	    charMap.put('ờ', 'o');
	    charMap.put('ớ', 'o');
	    charMap.put('ở', 'o');
	    charMap.put('ỡ', 'o');
	    charMap.put('ợ', 'o');
	    charMap.put('ù', 'u');
	    charMap.put('ú', 'u');
	    charMap.put('ủ', 'u');
	    charMap.put('ũ', 'u');
	    charMap.put('ụ', 'u');
	    charMap.put('ư', 'u');
	    charMap.put('ừ', 'u');
	    charMap.put('ứ', 'u');
	    charMap.put('ử', 'u');
	    charMap.put('ữ', 'u');
	    charMap.put('ự', 'u');
	    charMap.put('ỳ', 'y');
	    charMap.put('ý', 'y');
	    charMap.put('ỷ', 'y');
	    charMap.put('ỹ', 'y');
	    charMap.put('ỵ', 'y');
	 // Chuỗi kết quả sau khi chuyển đổi
	    StringBuilder result = new StringBuilder();
	    // Duyệt từng ký tự trong chuỗi đầu vào
	    for (int i = 0; i < str.length(); i++) {
	        char ch = str.charAt(i);
	        Character unsignedChar = charMap.get(Character.toLowerCase(ch));
	        
	        // Nếu ký tự là tiếng Việt có dấu, thêm ký tự không dấu vào chuỗi kết quả
	        if (unsignedChar != null) {
	            result.append(unsignedChar);
	        }
	        // Nếu ký tự không phải tiếng Việt có dấu, thêm ký tự đó vào chuỗi kết quả
	        else {
	            result.append(ch);
	        }
	    }
	    // Chuyển đổi chuỗi kết quả thành chuỗi viết thường và cách nhau bằng dấu "-"
	    String unsignedStr = result.toString().toLowerCase().replaceAll("\\s+", "-");
	    return unsignedStr;
	}
}
