package com.cognizant.moviecruiser.dao;

public class FavoritesEmptyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FavoritesEmptyException() {
		super("Favorites list is empty");
	}

}
