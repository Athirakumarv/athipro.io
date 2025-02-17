package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoCollectionImpl implements MoviesDao {

	private static List<Movies> moviesList;

	public MoviesDaoCollectionImpl() {
		super();
		if (moviesList == null) {
			moviesList = new ArrayList<Movies>();
			Movies itemOne = new Movies(1L, "Avatar", 2787965087L, true, new DateUtil().convertToDate("15/03/2020"),
					"Science Fiction", true);
			Movies itemTwo = new Movies(2L, "The Avengers", 1518812988L, true,
					new DateUtil().convertToDate("23/12/2020"), "Superhero", false);
			Movies itemThree = new Movies(3L, "Titanic", 2187463944L, true, new DateUtil().convertToDate("21/08/2020"),
					"Romance", false);
			Movies itemFour = new Movies(4L, "Jurassic World", 1671713208L, false,
					new DateUtil().convertToDate("02/07/2020"), "Science Fiction", true);
			Movies itemFive = new Movies(5L, "Avengers:End Game", 2750760348L, true,
					new DateUtil().convertToDate("02/11/2020"), "Superhero", true);
			moviesList.add(itemOne);
			moviesList.add(itemTwo);
			moviesList.add(itemThree);
			moviesList.add(itemFour);
			moviesList.add(itemFive);
		}
	}

	@Override
	public List<Movies> getMoviesListAdmin() {
		return moviesList;
	}

	@Override
	public List<Movies> getMoviesListCustomer() {
		ArrayList<Movies> filterMovies = new ArrayList<Movies>();
		for (Movies movies : moviesList) {
			if (movies.getDateOfLaunch().after(new Date())) {
				if (movies.getActive()) {
					filterMovies.add(movies);
				}
			}
		}
		return filterMovies;
	}

	@Override
	public void modifyMovies(Movies movies) {
		for (int i = 0; i < moviesList.size(); i++) {
			if (moviesList.get(i).getId() == movies.getId()) {
				moviesList.set(i, movies);
			}
		}
	}

	@Override
	public Movies getMovies(long moviesId) {
		for (Movies movies : moviesList) {
			if (movies.getId() == moviesId) {
				return movies;
			}
		}
		return null;
	}

}