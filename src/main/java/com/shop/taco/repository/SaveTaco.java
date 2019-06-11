package com.shop.taco.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.shop.taco.model.TacoIngredients;

@Repository
public class SaveTaco {
	public TacoIngredients findOne(String id) {
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
}
