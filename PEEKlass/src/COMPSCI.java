import java.time.LocalTime;

public class COMPSCI extends Major {

	//private AllCourses ac = new AllCourses();
	Course cs121;
	Course cs187;
	Course cs311;
	Course cs326;
	Course cs345;
	Course cs377;
	
	LocalTime time09 = LocalTime.parse("09:00");
	LocalTime time10 = LocalTime.parse("10:00");
	LocalTime time11 = LocalTime.parse("11:00");
	LocalTime time12 = LocalTime.parse("12:00");
	LocalTime time13 = LocalTime.parse("13:00");
	LocalTime time14 = LocalTime.parse("14:00");
	LocalTime time15 = LocalTime.parse("15:00");
	LocalTime time16 = LocalTime.parse("16:00");
	LocalTime time17 = LocalTime.parse("17:00");

	public COMPSCI(){
		
		majorName = "COMPSCI";

		CourseNum csNum121 = new CourseNum(this, 121);
		cs121 = new Course(csNum121, "Intro to CS", null, time11, time12, TTH() );

		CourseNum csNum187 = new CourseNum(this, 187);
		cs187 = new Course(csNum187 , "Data Structures", csNum121, time14, time15, TTH() );
		
		CourseNum csNum311 = new CourseNum(this, 311);
		cs311 = new Course(csNum311, "Algorithms", csNum311, time16, time17, MW() );
		
		CourseNum csNum326 = new CourseNum(this, 326);
		cs326 = new Course(csNum326, "Web Programming", csNum187, time16, time17, TTH() );
		
		CourseNum csNum345 = new CourseNum(this, 345);
		cs345 = new Course(csNum345, "Data Management", csNum311, time10, time11, MW() );
		
		CourseNum csNum377 = new CourseNum(this, 377);
		cs377 = new Course(csNum377, "Operating Systems", csNum326, time13, time14, TTH() );
		
		coreList.add(cs121);
		coreList.add(cs187);
		coreList.add(cs311);

		electiveList.add(cs326);
		electiveList.add(cs345);
		electiveList.add(cs377);
	}
	
	public boolean[] MW(){
		boolean[] days = {true, false, true, false, false};
		return days;
	}
	
	public boolean[] TTH(){		
		boolean[] days = {false, true, false, true, false};
		return days;

	}
	
	public Course getCS121(){
		return cs121;
	}
	
	public Course getCS187(){
		return cs187;
	}
	
	public Course getCS311(){
		return cs311;
	}
	
	public Course getCS326(){
		return cs326;
	}
	
	public Course getCS345(){
		return cs345;
	}
	
	public Course getCS377(){
		return cs377;
	}

}
