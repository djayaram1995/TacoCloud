package com.shop.taco.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shop.taco.model.TacoIngredients;

@Repository
public class SaveTacoTemplate {
	@Autowired
	private JdbcTemplate jdbc;
	public TacoIngredients findOne(String id) {
		 return jdbc.queryForObject(
		 "select id, name, type from Ingredients where id=?",
		 this::psycho, id);
		}
		private TacoIngredients psycho(ResultSet rs, int rowNum)
		 throws SQLException {
			System.out.println(rs.getString("id")+ rs.getString("name")+ rs.getString("type"));
		 return new TacoIngredients(
		 rs.getString("id"),
		 rs.getString("name"),
		 TacoIngredients.Type.valueOf(rs.getString("type")));
		}
}
