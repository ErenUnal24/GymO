package model;

public class user {
	
	private int  age, height, weight, fat, muscle, ssn;

	String name, surname, password, payment, expiration, position, workout;
	
	String workout1 = "Squat: 5x5\n"
			+ "Bench Press: 5x5\n"
			+ "Barbell Row: 5x5\n"
			+ "\n"
			+ "Squat: 5x5\n"
			+ "Ohp: 5x5\n"
			+ "Deadlift: 5x5";
	String workout2 = "Side Lateral: 4x10\n"
			+ "Shoulder Press: 4x10\n"
			+ "Dumbell Row: 4x8\n"
			+ "Dumbell Shrug: 4x8\n"
			+ "\n"
			+ "Leg Curl: 4x10\n"
			+ "Leg Extension: 4x10\n"
			+ "Barbell Squat: 4x8\n"
			+ "Lunge: 4x8";

 

	public user( String name,  String surname,int ssn,String password,int age, int height, int weight, int fat, int muscle, String workout) { /* String payment,
			String expiration, String position) {*/
		
		this.name = name;
		this.surname = surname;
		this.ssn = ssn;
		this.password = password;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.fat = fat;
		this.muscle = muscle;
		this.workout = workout;
		/*this.payment = payment;
		this.expiration = expiration;
		this.position = position;
		*/
		
		
	}

	

	public user() {
		
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getFat() {
		return fat;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	public int getMuscle() {
		return muscle;
	}

	public void setMuscle(int muscle) {
		this.muscle = muscle;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	
	public String getWorkout() {
		return workout;
	}

	public void setWorkout(String workout) {
		this.workout = workout;
	}

	

	

	
	
	
}
