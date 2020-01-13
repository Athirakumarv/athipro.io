package com.cognizant.moviecruiser.dao;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoCollectionImplTest {

	public static void testAddFavoriteMovies() throws FavoritesEmptyException {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		favoritesDao.addFavoriteMovies(1, 2L);
		favoritesDao.addFavoriteMovies(1, 5L);
		favoritesDao.addFavoriteMovies(1, 1L);
		favoritesDao.addFavoriteMovies(1, 3L);
		Favorites moviesListCustomer = favoritesDao.getAllFavoriteMovies(1);
		System.out.println("User Added Favorites Movies for CheckOut");
		int count = 0;
		for (Movies movies : moviesListCustomer.getMoviesList()) {
			System.out.println(movies);
			count++;
		}
		System.out.println("No of Favorites : " + count);
	}

	public static void testRemoveFavoriteMovies() {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		try {
			favoritesDao.removeFavoriteMovies(1, 2L);
			favoritesDao.removeFavoriteMovies(1, 5L);
			favoritesDao.removeFavoriteMovies(1, 1L);
			// favoritesDao.removeFavoritesItem(1, 3L);
			Favorites moviesListCustomer = favoritesDao.getAllFavoriteMovies(1);
			System.out.println("Movies List for Customer after remove");
			int count = 0;
			for (Movies movies : moviesListCustomer.getMoviesList()) {
				System.out.println(movies);
				count++;
			}
			System.out.println("No of Favorites : " + count);
		} catch (FavoritesEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testGetAllFavoriteMovies() {
	}

	public static void main(String[] args) throws FavoritesEmptyException {
		testAddFavoriteMovies();
		testRemoveFavoriteMovies();
	}

}