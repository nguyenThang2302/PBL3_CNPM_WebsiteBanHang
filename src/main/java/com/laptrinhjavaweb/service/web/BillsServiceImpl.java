package com.laptrinhjavaweb.service.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.Dto.CartDto;
import com.laptrinhjavaweb.dao.BillDetailDao;
import com.laptrinhjavaweb.dao.BillNotificationDao;
import com.laptrinhjavaweb.dao.BillsDao;
import com.laptrinhjavaweb.entity.BillDetail;
import com.laptrinhjavaweb.entity.BillNotification;
import com.laptrinhjavaweb.entity.BillProduct;
import com.laptrinhjavaweb.entity.Bills;
import com.laptrinhjavaweb.entity.OrderStatistics;
import com.laptrinhjavaweb.entity.Products;

@Service
public class BillsServiceImpl implements IBillsService {
	@Autowired
	private BillsDao billsDao;
	@Autowired
	private BillDetailDao billDetailDao;
	@Autowired
	private BillNotificationDao billNotificationDao;
	
	@Override
	public int createOneBill(Bills b) {
		return billsDao.createOneBill(b);
	}
	
	public void AddBillDetail(HashMap<String, CartDto> carts) {
		String billCode = billsDao.getLastBillCode();
		BillNotification billNotification = new BillNotification();
		billNotification.setBill_code(billCode);
		
		
		for(Map.Entry<String, CartDto> itemCart : carts.entrySet()) {
			BillDetail billDetail = new BillDetail();
			billDetail.setProduct_code(itemCart.getValue().getProduct().getCode());
			billDetail.setBill_code(billCode);
			billDetail.setQuantity(itemCart.getValue().getQuantity());
			billDetail.setTotal_price(itemCart.getValue().getTotalPrice());
			billDetailDao.createBillDetail(billDetail);
		}
		billNotificationDao.createBillNotification(billNotification);
	}
	
	@Override
	public List<Bills> findAllBillsByUserCode(String user_code) {
		return billsDao.findAllBillsByUserCode(user_code);
	}
	
	@Override
	public Bills findBillsByCode(String code) {
		return billsDao.findBillsByCode(code);
	}
	
	@Override
	public List<BillProduct> findProductInBillByCode(String bill_code) {
		return billDetailDao.findProductInBillByCode(bill_code);
	}
	
	@Override
	public int createBillNotification(BillNotification bn) {
		return billNotificationDao.createBillNotification(bn);
	}
	
	@Override
	public List<BillNotification> findAllBillNotification() {
		return billNotificationDao.findAllBillNotification();
	}
	
	@Override
	public int CountNotification() {
		return billNotificationDao.CountNotification();
	}
	
	@Override
	public List<Bills> findAllBillsUnconfimred() {
		return billsDao.findAllBillsUnconfimred();
	}
	
	@Override
	public int updateStatusOrder(String code) {
		return billsDao.updateStatusOrder(code);
	}
	
	@Override
	public int deleteNotificationByCode(String bill_code) {
		return billNotificationDao.deleteNotificationByCode(bill_code);
	}
	
	@Override
	public List<Bills> findAllBillsConfimred() {
		return billsDao.findAllBillsConfimred();
	}
	
	@Override
	public Bills findBillUnconfirmedByCode(String code) {
		return billNotificationDao.findBillUnconfirmedByCode(code);
	}
	
	@Override
	public Bills findBillComfirmedByCode(String code) {
		return billNotificationDao.findBillComfirmedByCode(code);
	}
	
	@Override
	public Products findProductBestSale(String start_date, String end_date) {
		return billsDao.findProductBestSale(start_date, end_date);
	}
	
	@Override
	public OrderStatistics findBestInforOrder(String start_date, String end_date) {
		return billsDao.findBestInforOrder(start_date, end_date);
	}
}
