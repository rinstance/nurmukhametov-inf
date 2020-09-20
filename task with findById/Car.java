public class Car {
    private Long id;
    private String model;
    private String color;
	private Driver driver;
	
	 public void setCars(Driver driver) {
        this.driver = driver;
    }
}
