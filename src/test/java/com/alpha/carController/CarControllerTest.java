package com.alpha.carController;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import com.alpha.carDao.CarDao;
import com.alpha.carDto.Car;

public class CarControllerTest {

	@Test
	public void testCreateCar() {
	    Car car = new Car(1, "Model S", "Tesla", 80000, 2023);
	    CarDao carDao = new CarDao();
	    
	    Car savedCar = carDao.saveCar(car);
	    
	    assertNotNull(savedCar);
	    assertEquals(car.getId(), savedCar.getId());
	    assertEquals(car.getName(), savedCar.getName());
	    assertEquals(car.getBrand(), savedCar.getBrand());
	    assertEquals(car.getCost(), savedCar.getCost());
	    assertEquals(car.getManufact_year(), savedCar.getManufact_year());
	    System.out.println("createCar method");
	}
	
	@Test
	public void testUpdateCar() {
	    Car car = new Car(1, "Model S", "Tesla", 90000, 2023);
	    CarDao carDao = new CarDao();
	    
	    Car updatedCar = carDao.updateCar(car);
	    
	    assertNotNull(updatedCar);
	    assertEquals(car.getId(), updatedCar.getId());
	    assertEquals(car.getName(), updatedCar.getName());
	    assertEquals(car.getBrand(), updatedCar.getBrand());
	    assertEquals(car.getCost(), updatedCar.getCost());
	    assertEquals(car.getManufact_year(), updatedCar.getManufact_year());
	    System.out.println("updateCar method");
	}
	
	
	@Test
	public void testFindCarByID() {
	    int id = 1;
	    CarDao carDao = new CarDao();
	    
	    Car car = carDao.getCarById(id);
	    
	    assertNotNull(car);
	    assertEquals(id, car.getId());
	    System.out.println("findCarByID method");
	}
	
	@Test
	public void testDisplayAllCars() {
	    CarDao carDao = new CarDao();
	    
	    List<Car> cars = carDao.getAllCars();
	    
	    assertNotNull(cars);
	    assertFalse(cars.isEmpty());
	    System.out.println("displayAllCars method");
	}
	
	@Test
	public void testDeleteCarByID() {
	    int id = 1;
	    CarDao carDao = new CarDao();
	    
	    boolean isDeleted = carDao.deleteCar(id);
	    
	    assertTrue(isDeleted);
	    System.out.println("deleteCarByID method");
	}


}
