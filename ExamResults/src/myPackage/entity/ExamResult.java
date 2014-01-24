package myPackage.entity;

import java.io.Serializable;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class ExamResult{
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	
	Key studentID;
	String studentName;
	String score1;
	String score2;
	
	public ExamResult(){
		
	}
	
	public ExamResult(Key ID, String name, String s1, String s2){
		this.studentID = ID;
		this.studentName = name;
		this.score1 = s1;
		this.score2 = s2;
	}
	
	public void setIdNumber(Key id){
		this.studentID = id;
	}
	
	public void setStudentName(String name){
		this.studentName = name;
	}
	
	public void setExam1Grade(String score1){
		this.score1 = score1;
	}
	
	public void setExam2Grade(String score2){
		this.score2 = score2;
	}
	
	
	public Key getID(){
		return this.studentID;
	}
	
	public String getName(){
		return this.studentName;
	}
	
	public String getScore1(){
		return this.score1;
	}
	
	public String getScore2(){
		return this.score2;
	}
	
	
}