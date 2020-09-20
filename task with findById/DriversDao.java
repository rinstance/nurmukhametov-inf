import java.sql.Connection;
import java.util.Optional;

public class DriversDao {

    private Connection connection;

    public DriversDao(Connection connection) {
        this.connection = connection;
    }

    // TODO: реализовать
	public Optional<Driver> findById(Long id) throws SQLException {
        ResultSet car_set = connection.createStatement().executeQuery(String.format("" +
                "SELECT * FROM car WHERE id = ", id));
        ResultSet driver_set = connection.createStatement().executeQuery(String.format("" +
                "SELECT * FROM driver WHERE id = ", id));
        ArrayList<Car> cars = new ArrayList<>();
        while (car_set.next()) {
            cars.add(new Car(car_set.getLong("id"),
                    car_set.getString("model"),
                    car_set.getString("color"), null));
            if (!driver_set.next())
                return Optional.empty();
        }
        Driver driver = new Driver(
                driver_set.getLong("id"),
                driver_set.getString("first_name"),
                driver_set.getString("last_name"),
                driver_set.getInt("age"), null
        );
        driver.setCar(cars);
        for (Car car : cars) {
            car.setDriver(driver);
        }
        return Optional.of(driver);
    }
}
