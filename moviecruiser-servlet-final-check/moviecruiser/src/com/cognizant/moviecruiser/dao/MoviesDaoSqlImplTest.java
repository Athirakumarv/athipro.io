package com.cognizant.moviecruiser.dao;
import java.util.List;
import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoSqlImplTest {
	public static void testGetMoviesListAdmin() {		
		List<Movies> moviesList = new MoviesDaoSqlImpl().getMoviesListAdmin();
		System.out.format("%-10s%-20s%-15s%-15s%-20s%-20s%-15s", "ID", "TITLE", "GROSS", "ACTIVE", "DATE OF LAUNCH",
				"GENRE", "HAS TEASER");
		System.out.println();
		String active;
		String hasTeaser;
		for (Movies movies : moviesList) {
			if (movies.getActive() == true)
				active = "Yes";
			else
				active = "No";
			if (movies.getTeaser() == true)
				hasTeaser= "Yes";
			else
				hasTeaser = "No";

			System.out.format("%-10s%-20s%-15s%-15s%-20s%-20s%-15s", movies.getId(), movies.getTitle(),
					movies.getGross(), active, movies.getDateOfLaunch(), movies.getGenre(), hasTeaser);
			System.out.println();
		}
	}

	public static void testGetMoviesListCustomer() {		
		List<Movies> moviesList = new MoviesDaoSqlImpl().getMoviesListCustomer();
		System.out.format("%-10s%-20s%-15s%-15s%-20s%-20s%-15s", "ID", "TITLE", "GROSS", "ACTIVE", "DATE OF LAUNCH",
				"GENRE", "HAS TEASER");
		System.out.println();
		String active;
		String hasTeaser;
		for (Movies movies : moviesList) {
			if (movies.getActive() == true)
				active = "Yes";
			else
				active = "No";
			if (movies.getTeaser() == true)
				hasTeaser= "Yes";
			else
				hasTeaser = "No";

			System.out.format("%-10s%-20s%-15s%-15s%-20s%-20s%-15s", movies.getId(), movies.getTitle(),
					movies.getGross(), active, movies.getDateOfLaunch(), movies.getGenre(), hasTeaser);
			System.out.println();
		}
	}

	public static void testModifyMovies() {			
		Movies movies = new Movies(5L, "Popoyee", 5200098000L, true, new DateUtil().convertToDate("02/11/2022"), "Horror",
				true);
		new MoviesDaoSqlImpl().modifyMovies(movies);
		List<Movies> moviesList = new MoviesDaoSqlImpl().getMoviesListAdmin();			
		System.out.println("After Modification");
		System.out.format("%-10s%-20s%-15s%-15s%-20s%-20s%-15s", "ID", "TITLE", "GROSS", "ACTIVE", "DATE OF LAUNCH",
				"GENRE", "HAS TEASER");
		System.out.println();
		String active;
		String hasTeaser;
		for (Movies movies1 : moviesList) {
			if (movies.getActive() == true)
				active = "Yes";
			else
				active = "No";
			if (movies.getTeaser() == true)
				hasTeaser= "Yes";
			else
				hasTeaser = "No";

			System.out.format("%-10s%-20s%-15s%-15s%-20s%-20s%-15s", movies1.getId(), movies1.getTitle(),
					movies1.getGross(), active, movies1.getDateOfLaunch(), movies1.getGenre(), hasTeaser);
			System.out.println();
		}
	}
	
	public static void testGetMovies() {		
		long moviesId = 4;
		Movies movies = new MoviesDaoSqlImpl().getMovies(moviesId);		
		System.out.format("%-10s%-20s%-15s%-15s%-20s%-20s%-15s", "ID", "TITLE", "GROSS", "ACTIVE", "DATE OF LAUNCH",
				"GENRE", "HAS TEASER");
		System.out.println();
		String active;
		String hasTeaser;		
			if (movies.getActive() == true)
				active = "Yes";
			else
				active = "No";
			if (movies.getTeaser() == true)
				hasTeaser= "Yes";
			else
				hasTeaser = "No";

			System.out.format("%-10s%-20s%-15s%-15s%-20s%-20s%-15s", movies.getId(), movies.getTitle(),
					movies.getGross(), active, movies.getDateOfLaunch(), movies.getGenre(), hasTeaser);
			System.out.println();
		}	

	public static void main(String[] args) {
		testGetMoviesListAdmin();
		testGetMoviesListCustomer();
		testModifyMovies();
		testGetMovies();
	}
	
}


