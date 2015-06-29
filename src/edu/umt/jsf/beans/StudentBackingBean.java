package edu.umt.jsf.beans;

import edu.umt.db.BaseEntity;
import edu.umt.db.DatabaseManager;
import edu.umt.db.entities.Student;
import edu.umt.exceptions.StudentDetailsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;

/**
 * Created by tb189431e on 6/29/15.
 */
public class StudentBackingBean implements Serializable{
    private Logger log = LoggerFactory.getLogger(StudentBackingBean.class);
    private List<Student> students;
    private Student studentToView;
    private boolean editFieldState = true;


    public List<Student> getStudents() {
        if((students == null) || students.isEmpty()) {
            students = DatabaseManager.getRecords(Student.class);
        }
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentToView() {
        return studentToView;
    }

    public void setStudentToView(Student studentToView) {
        this.studentToView = studentToView;
    }

    public boolean isEditFieldState() {
        return editFieldState;
    }

    public void setEditFieldState(boolean editFieldState) {
        this.editFieldState = editFieldState;
    }

    public String studentDetailAction() throws Exception{
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        try{
            BaseEntity record= DatabaseManager.getRecord(new Student(), new Integer(request.getParameter("employeeId")));
            if (record instanceof Student)
                studentToView = (Student) record;
        }catch(Exception e){
            if (studentToView == null) throw new StudentDetailsException("Could not retrieve Student.");
        }
        return "student-details";
    }

    public void updateStudentAction(){
        DatabaseManager.saveRecord(studentToView);
        editFieldState = true;
    }

    public String studentUpdatedAction() {
        return "student-updated";
    }

    /*Method to endable fields*/
    public void enableFields(){
        editFieldState = false;
    }
}
