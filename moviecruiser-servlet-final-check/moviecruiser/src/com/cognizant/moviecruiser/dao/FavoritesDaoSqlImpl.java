package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoSqlImpl implements FavoritesDao {
	public static final String ADD_MOVIES_TO_FAVORITES = "insert into favorites(fv_us_id,fv_mo_id) values(?,?)";
	public static final String GET_MOVIES_FROM_FAVORITES = "select mo_id,mo_title,mo_gross,mo_genre from favorites inner join movie_list on mo_id=fv_mo_id inner join user on us_id=favorites.fv_us_id where us_id=?";
	public static final String GET_NUMBER_OF_FAVORITES = "select us_id,count(mo_id) as 'No.of.Favorites' from favorites inner join movie_list on mo_id=fv_mo_id	inner join user on us_id=fv_us_id where us_id=?";
	public static final String REMOVE_FAVORITES = "delete from favorites where fv_us_id=? and fv_mo_id=? limit 1";

	public void addFavoriteMovies(long userId, long moviesId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(ADD_MOVIES_TO_FAVORITES);
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, moviesId);
			int noOfRows = preparedStatement.executeUpdate();
			System.out.println("Number of rows affected" + noOfRows);
		} catch (SQLException e) {
			System.out.println("Data not inserted");
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.out.println("Connection is not closed");
			}
		}
	}

	@Override
	public Favorites getAllFavoriteMovies(long userId) throws FavoritesEmptyException {
		ArrayList<Movies> moviesList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ResultSet resultSetTotal = null;
		Movies movies = null;
		Favorites favorites = new Favorites();
		try {
			statement = connection.prepareStatement(GET_MOVIES_FROM_FAVORITES);
			statement.setLong(1, userId);
			resultSet = statement.executeQuery();
			System.out.println("Number of rows affected" + resultSet);
			while (resultSet.next()) {
				movies = new Movies();
				movies.setId(resultSet.getLong("mo_id"));
				movies.setTitle(resultSet.getString("mo_title"));
				movies.setGross(resultSet.getLong("mo_gross"));
				movies.setGenre(resultSet.getString("mo_genre"));
				moviesList.add(movies);
			}
			if (moviesList.size() == 0) {
				throw new FavoritesEmptyException();
			}
			favorites.setMoviesList(moviesList);
			preparedStatement = connection.prepareStatement(GET_NUMBER_OF_FAVORITES);
			preparedStatement.setLong(1, userId);
			resultSetTotal = preparedStatement.executeQuery();
			System.out.println("Number of rows affected" + resultSetTotal);
			while (resultSetTotal.next()) {
				favorites.setTotal(resultSetTotal.getInt("No.of.Favorites"));
			}
		} catch (SQLException e) {
			System.out.println("Data not displayed");
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (resultSetTotal != null)
					resultSetTotal.close();
				if (statement != null)
					statement.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.out.println("Connection is not closed");
			}
		}
		return favorites;
	}

	@Override
	public void removeFavoriteMovies(long userID, long moviesId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(REMOVE_FAVORITES);
			statement.setLong(1, userID);
			statement.setLong(2, moviesId);
			int noOfRows = statement.executeUpdate();
			System.out.println("Number of rows affected" + noOfRows);
		} catch (SQLException e) {
			System.out.println("Data is not deleted");
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				System.out.println("Connection is not closed");
			}
		}
	}

}
