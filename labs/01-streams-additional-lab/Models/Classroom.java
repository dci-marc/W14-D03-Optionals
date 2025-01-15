package Models;

import java.util.List;

public class Classroom {
  private Teacher teacher;
  private List<Student> students;

  public Teacher getTeacher() {
    return this.teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public List<Student> getStudents() {
    return this.students;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }
}
