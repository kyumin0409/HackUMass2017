
public class CourseNum {
	
	Major department;
	int courseNumber;
	
	public CourseNum(Major department, int courseNumber){
		
		this.department = department;
		this.courseNumber = courseNumber;
		
	}
	
	public CourseNum(COMPSCI department2, int courseNumber2) {
		// TODO Auto-generated constructor stub
	}

	public Major getMajor(){
		
		return department;
	}

	public int getCourseNum(){
		
		return courseNumber;
	}
	
}
