import java.util.List;

public class Driver {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private List<Car> cars;
	
	public void setCars(List<Car> cars) {
        this.cars = cars;
    }  

}
