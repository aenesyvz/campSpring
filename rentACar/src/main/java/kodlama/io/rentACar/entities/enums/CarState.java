package kodlama.io.rentACar.entities.enums;

public enum CarState {
	Available(0),
	Rented(1),
	Maintenance(2);
    
	private int marks;
	
	CarState(int marks) {
	      this.marks = marks;
	}
	
	public static int getMarks(int model){
		   CarState marks[] = CarState.values();
	       return marks[model].marks;
	}
}
