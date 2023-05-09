package com.laptrinhjavaweb.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.Bills;
import com.laptrinhjavaweb.entity.Departments;
import com.laptrinhjavaweb.entity.MapperBills;
import com.laptrinhjavaweb.entity.MapperOrderStatistics;
import com.laptrinhjavaweb.entity.MapperProducts;
import com.laptrinhjavaweb.entity.OrderStatistics;
import com.laptrinhjavaweb.entity.Products;

@Repository
public class BillsDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public int createOneBill(Bills b) {
		String code = generateOrderCode();
		b.setCode(code);
		b.setStatus("Chờ xác nhận");
		String sql = "INSERT INTO bills (code, name, user_code, phone, address, email, quantity, total_price, note, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return _jdbcTemplate.update(sql, b.getCode(), b.getName(), b.getUser_code(), b.getPhone(), b.getAddress(), b.getEmail(), b.getQuantity(), b.getTotal_price(), b.getNote(), b.getStatus());
	}
	
	public String generateOrderCode() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
	
	public String getLastBillCode() {
		String sql = "select code from bills where id = (select MAX(id) from bills)";
		return _jdbcTemplate.queryForObject(sql.toString(), new Object[]{}, String.class);
	}
	
	public List<Bills> findAllBillsByUserCode(String user_code) {
		List<Bills> list = new ArrayList<Bills>();
		String sql = "select * from bills where user_code = ? order by created_at DESC";
		list = _jdbcTemplate.query(sql, new MapperBills(), user_code);
		return list;
	}
	
	public Bills findBillsByCode(String code) {
		String sql = "select * from bills where code = ?";
		return _jdbcTemplate.queryForObject(sql, new Object[]{code},new
				 BeanPropertyRowMapper<Bills>(Bills.class));
	}
	
	public List<Bills> findAllBillsUnconfimred() {
		List<Bills> list = new ArrayList<Bills>();
		String sql = "select * from bills where status = 'Chờ xác nhận' order by created_at ASC";
		list = _jdbcTemplate.query(sql, new MapperBills());
		return list;
	}
	
	public List<Bills> findAllBillsConfimred() {
		List<Bills> list = new ArrayList<Bills>();
		String sql = "select * from bills where status = 'Đã xác nhận' order by created_at ASC";
		list = _jdbcTemplate.query(sql, new MapperBills());
		return list;
	}
	
	public int updateStatusOrder(String code) {
		String sql = "UPDATE bills set status = 'Đã xác nhận' where code = ?";
		return _jdbcTemplate.update(sql, code);
	}
	
	public Products findProductBestSale(String start_date, String end_date) {
		String sql = "SELECT products.id, products.code, products.department_id, products.name, products.image, products.price, products.search_name\n"
				+ "FROM products \n"
				+ "INNER JOIN bills_detail ON products.code = bills_detail.product_code\n"
				+ "INNER JOIN bills ON bills_detail.bill_code = bills.code\n"
				+ "WHERE DATE(created_at) BETWEEN ?::date AND ?::date\n"
				+ "GROUP BY products.id, products.code\n"
				+ "HAVING COUNT(bills_detail.product_code) = (\n"
				+ "  SELECT max(sub.count)\n"
				+ "  FROM (\n"
				+ "    SELECT COUNT(bills_detail.product_code) AS count\n"
				+ "    FROM bills_detail\n"
				+ "    GROUP BY bills_detail.product_code\n"
				+ "  ) AS sub\n"
				+ ")\n"
				+ "LIMIT 1;";
		return _jdbcTemplate.queryForObject(sql, new Object[]{start_date, end_date},new
				 BeanPropertyRowMapper<Products>(Products.class));
	}
	
	public OrderStatistics findBestInforOrder(String start_date, String end_date) {
		String sql = "select sum(total_price) as total_price, count(code) as total_bills, sum(quantity) as total_quantity from bills \n"
				+ "WHERE DATE(created_at) BETWEEN ?::date AND ?::date";
		return _jdbcTemplate.queryForObject(sql, new Object[]{start_date, end_date},new
				 BeanPropertyRowMapper<OrderStatistics>(OrderStatistics.class));
	}
	
}
