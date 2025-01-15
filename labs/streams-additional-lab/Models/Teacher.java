package Models;

public class Teacher {
  private String name;
  private Integer age;
  private String city;

  public Teacher(String name, int age, String city) {
    this.name = name;
    this.age = age;
    this.city = city;
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
}
