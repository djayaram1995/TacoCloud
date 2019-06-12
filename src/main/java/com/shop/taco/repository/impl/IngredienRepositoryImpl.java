package com.shop.taco.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shop.taco.model.TacoIngredients;
import com.shop.taco.repository.IngredientRepository;

@Repository
public class IngredienRepositoryImpl implements IngredientRepository {

	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public List<TacoIngredients> findAll() {
		return (List<TacoIngredients>) jdbc.query("select id, name, type from Ingredient",
				this::mapRowtoIngredient);
	}

	@Override
	public TacoIngredients findOneJdbc(String id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/springjdbc", "root", "root");
			statement = connection.prepareStatement("select id, name, type from ingredients");
			resultSet = statement.executeQuery();

			TacoIngredients ingredient = null;
			while (resultSet.next()) {
				System.out.println(resultSet.getString("id"));
				System.out.println(resultSet.getString("name"));
				System.out.println(resultSet.getString("type"));
				ingredient = new TacoIngredients(resultSet.getString("id"), resultSet.getString("name"),
						TacoIngredients.Type.valueOf(resultSet.getString("type")));
			}
			return ingredient;
		} catch (SQLException e) {
			// ??? What should be done here ???
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
		return null;
	}

	public TacoIngredients findOne(String id) {
		return jdbc.queryForObject("select id, name, type from Ingredient where id=?", this::mapRowtoIngredient, id);
	}

	private TacoIngredients mapRowtoIngredient(ResultSet rs, int rowNum) throws SQLException {
		System.out.println(rs.getString("id") + rs.getString("name") + rs.getString("type"));
		return new TacoIngredients(rs.getString("id"), rs.getString("name"),
				TacoIngredients.Type.valueOf(rs.getString("type")));
	}
	@Override
	public TacoIngredients save(TacoIngredients ingredient) {
		// TODO Auto-generated method stub
		return null;
	}

}
