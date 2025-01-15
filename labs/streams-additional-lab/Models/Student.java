package Models;

public class Student {
  private String name;
  private Integer age;
  private String city;
  private Double grade;

  public Student(String name, int age, String city, Double grade) {
    this.name = name;
    this.age = age;
    this.city = city;
    this.grade = grade;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return this.age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getCity() {
    return this.city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Double getGrade() {
    return this.grade;
  }

  public void setGrade(Double grade) {
    this.grade = grade;
  }

  public String toJSON() {
    return String.format(
        "{\"name\":\"%s\",\"age\":%d,\"city\":\"%s\",\"grade\":%.1f}",
        this.name, this.age, this.city, this.grade
    );
  }
}
