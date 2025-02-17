package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.cognizant.moviecruiser.model.Movies;

public class MoviesDaoSqlImpl implements MoviesDao {
 public static final String GET_ALL_MOVIES_ADMIN = "select * from movie_list";
 public static final String GET_ALL_MOVIES_CUSTOMER = "select * from movie_list where movie_list.mo_active='Yes' and movie_list.mo_date_of_launch>=CURDATE()";
 public static final String MODIFY_MOVIES="update movie_list set mo_title=?,mo_gross=?,mo_active=?,mo_date_of_launch=?,mo_genre=?,mo_teaser=? where mo_id=?";	
 public static final String GET_MOVIES= "select * from movie_list where mo_id= ? ";
 
 public List<Movies> getMoviesListAdmin() {
		ArrayList<Movies> moviesList= new ArrayList<>();
		Connection connection =  ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try { 
			statement=connection.prepareStatement(GET_ALL_MOVIES_ADMIN);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Movies movies = new Movies();
				movies.setId(resultSet.getLong("mo_id"));
				movies.setTitle(resultSet.getString("mo_title"));
				movies.setGross(resultSet.getLong("mo_gross"));
				movies.setActive(resultSet.getString("mo_active").equals("Yes"));
				movies.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movies.setGenre(resultSet.getString("mo_genre"));
				movies.setTeaser(resultSet.getString("mo_teaser").equals("Yes"));
				moviesList.add(movies);
			}
		}catch(SQLException e) {
			e.printStackTrace();		
		}finally {
			try {
				if(connection != null)
					connection.close();
				if(statement != null)
					statement.close();
				if(resultSet != null)
					resultSet.close();				
			}catch(SQLException e) {
				System.out.println("Connection is not closed");
		}
		}
		return moviesList;
	}

	@Override
	public List<Movies> getMoviesListCustomer() {
		ArrayList<Movies> moviesList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet=null;
		try {
			statement = connection.prepareStatement(GET_ALL_MOVIES_CUSTOMER);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Movies movies = new Movies();
				movies.setId(resultSet.getLong("mo_id"));
				movies.setTitle(resultSet.getString("mo_title"));
				movies.setGross(resultSet.getLong("mo_gross"));
				movies.setActive(resultSet.getString("mo_active").equals("Yes"));
				movies.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movies.setGenre(resultSet.getString("mo_genre"));
				movies.setTeaser(resultSet.getString("mo_teaser").equals("Yes"));
				moviesList.add(movies);
			}
		}catch(SQLException e) {
			e.printStackTrace();		
		}finally {
			try {
				if(connection != null)
					connection.close();
				if(statement != null)
					statement.close();
				if(resultSet != null)
					resultSet.close();				
			}catch(SQLException e) {
				System.out.println("Connection is not closed");
		}
		}
		return moviesList;
	}
		
	@Override
	public void modifyMovies(Movies movies) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(MODIFY_MOVIES);
			statement.setLong(7, movies.getId());
			statement.setString(1, movies.getTitle());
			statement.setLong(2, movies.getGross());
			statement.setString(3, movies.getActive()?"Yes":"No");
			statement.setDate(4, new java.sql.Date(movies.getDateOfLaunch().getTime()));
			statement.setString(5, movies.getGenre());
			statement.setString(6, movies.getTeaser()?"Yes":"No");
			int noOfRows = statement.executeUpdate();
			if (noOfRows > 0) {
				return;
			}
		} catch (SQLException e) {
			System.out.println("Update not done");
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("Connection is not closed");
			}
		}
		return;
	}

	@Override
	public Movies getMovies(long moviesId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Movies movies= null;
		try {
			preparedStatement = connection.prepareStatement(GET_MOVIES);
			preparedStatement.setLong(1, moviesId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				movies = new Movies();
				movies.setId(resultSet.getLong("mo_id"));
				movies.setTitle(resultSet.getString("mo_title"));
				movies.setGross(resultSet.getLong("mo_gross"));
				movies.setActive(resultSet.getString("mo_active").equals("Yes"));
				movies.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movies.setGenre(resultSet.getString("mo_genre"));
				movies.setTeaser(resultSet.getString("mo_teaser").equals("Yes"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
		return movies;
	}
	
}
