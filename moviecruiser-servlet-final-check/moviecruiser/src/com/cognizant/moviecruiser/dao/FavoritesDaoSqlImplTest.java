package com.cognizant.moviecruiser.dao;
import java.util.List;
import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoSqlImplTest {
	public static void testAddCartItem() {
		new FavoritesDaoSqlImpl().addFavoriteMovies(1,4); 
	}

	public static void testGetAllFavoriteMovies() throws FavoritesEmptyException {		
		Favorites favorites = new FavoritesDaoSqlImpl(). getAllFavoriteMovies(1);		
		List<Movies> MoviesList=favorites.getMoviesList();		
		System.out.format("%-10s%-20s%-20s%-10s","ID","TITLE","GROSS","GENRE");
		System.out.println();		
		for(Movies movies : MoviesList)
		{
		System.out.format("%-10s%-20s%-20s%-10s",movies.getId(),movies.getTitle(),movies.getGross(),movies.getGenre());
		System.out.println();		
		}
		System.out.println("No Of Favorites :"+  favorites.getTotal());
	}
	
	public static void testRemoveFavoriteMovies() throws FavoritesEmptyException {
		new FavoritesDaoSqlImpl().removeFavoriteMovies(1,5);		
	}

public static void main(String[] args) throws FavoritesEmptyException {
	testAddCartItem() ;
	testGetAllFavoriteMovies();
	testRemoveFavoriteMovies();
}

}