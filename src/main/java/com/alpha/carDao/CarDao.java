package com.alpha.carDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alpha.carDto.Car;

import ConnectionPool.ConnectionPool;

public class CarDao {

    Connection connection = ConnectionPool.getConnectionObject();

    public Car saveCar(Car car) {
        String query = "INSERT INTO carinfo (id, name, brand, cost, manu_year) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, car.getId());
            preparedStatement.setString(2, car.getName());
            preparedStatement.setString(3, car.getBrand());
            preparedStatement.setInt(4, car.getCost());
            preparedStatement.setInt(5, car.getManufact_year());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    public Car updateCar(Car car) {
        String query = "UPDATE carinfo SET name = ?, brand = ?, cost = ?, manu_year = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, car.getName());
            preparedStatement.setString(2, car.getBrand());
            preparedStatement.setInt(3, car.getCost());
            preparedStatement.setInt(4, car.getManufact_year());
            preparedStatement.setInt(5, car.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    public boolean deleteCar(int id) {
        String query = "DELETE FROM carinfo WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Car getCarById(int id) {
        String query = "SELECT * FROM carinfo WHERE id = ?";
        Car car = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setName(resultSet.getString("name"));
                car.setBrand(resultSet.getString("brand"));
                car.setCost(resultSet.getInt("cost"));
                car.setManufact_year(resultSet.getInt("manu_year"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    public List<Car> getAllCars() {
        String query = "SELECT * FROM carinfo";
        List<Car> cars = new ArrayList<Car>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setName(resultSet.getString("name"));
                car.setBrand(resultSet.getString("brand"));
                car.setCost(resultSet.getInt("cost"));
                car.setManufact_year(resultSet.getInt("manu_year"));
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }
}
