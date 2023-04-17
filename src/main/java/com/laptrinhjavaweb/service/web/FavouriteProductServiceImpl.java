package com.laptrinhjavaweb.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dao.FavouriteProductDao;
import com.laptrinhjavaweb.entity.FavouriteProduct;
import com.laptrinhjavaweb.entity.Favourites;
import com.laptrinhjavaweb.entity.Products;

@Service
public class FavouriteProductServiceImpl implements IFavouriteProductService {
	@Autowired
	private FavouriteProductDao favouriteProductDao;
	
	@Override
	public int createOneFavouriteProduct(FavouriteProduct f) {
		return favouriteProductDao.createOneFavouriteProduct(f);
	}
	
	@Override
	public List<Favourites> findAllProductFavourite() {
		return favouriteProductDao.findAllProductFavourite();
	}
}
