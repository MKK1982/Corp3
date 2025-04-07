package com.Pisquare.Controllers;

import java.sql.*;
import java.util.List;

import com.Pisquare.Beans.Response;

public class DatabaseUtil {

    // JDBC URL, username, and password
    private static final String URL = "jdbc:mysql://localhost:3306/insurance_db";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void insertResponseData(Response response) {
        Connection conn = null;
        PreparedStatement psHead = null, psReason = null, psCategory = null, psSubCategory = null;
        ResultSet generatedKeys = null;

        try {
            conn = getConnection();
            conn.setAutoCommit(false);  // Start transaction

            // 1. Insert into 'head' table
            String headQuery = "INSERT INTO head (requestId, ts) VALUES (?, ?)";
            psHead = conn.prepareStatement(headQuery, Statement.RETURN_GENERATED_KEYS);
            psHead.setString(1, response.getHead().getRequestId());
            psHead.setString(2, response.getHead().getTs());
            psHead.executeUpdate();

            // Get the generated ID for the head table
            generatedKeys = psHead.getGeneratedKeys();
            int headId = 0;
            if (generatedKeys.next()) {
                headId = generatedKeys.getInt(1);
            }

            // 2. Insert into 'reason' table
            String reasonQuery = "INSERT INTO reason (responseCode, responseReason) VALUES (?, ?)";
            psReason = conn.prepareStatement(reasonQuery, Statement.RETURN_GENERATED_KEYS);
            psReason.setString(1, response.getReason().getResponseCode());
            psReason.setString(2, response.getReason().getResponseReason());
            psReason.executeUpdate();

            // 3. Insert into 'category' table
            List<Response.Category> categories = response.getCategories();
            String categoryQuery = "INSERT INTO category (orderNumber, categoryName, categoryDesc, status, icon, modifiedDate, head_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
            psCategory = conn.prepareStatement(categoryQuery, Statement.RETURN_GENERATED_KEYS);
            for (Response.Category category : categories) {
                psCategory.setInt(1, category.getOrder());
                psCategory.setString(2, category.getCategoryName());
                psCategory.setString(3, category.getCategoryDesc());
                psCategory.setString(4, category.getStatus());
                psCategory.setString(5, category.getIcon());
                psCategory.setString(6, category.getModifiedDate());
                psCategory.setInt(7, headId);
                psCategory.executeUpdate();

                // Get the generated ID for the category table
                generatedKeys = psCategory.getGeneratedKeys();
                int categoryId = 0;
                if (generatedKeys.next()) {
                    categoryId = generatedKeys.getInt(1);
                }

                // 4. Insert into 'subcategory' table
                List<Response.Category.SubCategory> subCategories = category.getSubCategories();
                String subCategoryQuery = "INSERT INTO subcategory (subCategoryOrder, subCategoryName, subCategoryDesc, status, icon, modifiedDate, category_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
                psSubCategory = conn.prepareStatement(subCategoryQuery);
                for (Response.Category.SubCategory subCategory : subCategories) {
                    psSubCategory.setInt(1, subCategory.getSubCategoryOrder());
                    psSubCategory.setString(2, subCategory.getSubCategoryName());
                    psSubCategory.setString(3, subCategory.getSubCategoryDesc());
                    psSubCategory.setString(4, subCategory.getStatus());
                    psSubCategory.setString(5, subCategory.getIcon());
                    psSubCategory.setString(6, subCategory.getModifiedDate());
                    psSubCategory.setInt(7, categoryId);
                    psSubCategory.executeUpdate();
                }
            }

            // Commit transaction
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();  // Rollback in case of an error
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            try {
                if (psHead != null) psHead.close();
                if (psReason != null) psReason.close();
                if (psCategory != null) psCategory.close();
                if (psSubCategory != null) psSubCategory.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
