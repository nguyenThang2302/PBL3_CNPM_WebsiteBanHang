package com.laptrinhjavaweb.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.FavouriteProduct;
import com.laptrinhjavaweb.entity.Favourites;
import com.laptrinhjavaweb.entity.Products;

@Service
public interface IFavouriteProductService {
	@Autowired
	public int createOneFavouriteProduct(FavouriteProduct f);
	@Autowired
	public List<Favourites> findAllProductFavourite();
}
