package Models;

import java.util.Optional;

public class UserProfile {
  private String username;
  private String email;
  private Optional<String> phoneNumber = Optional.empty();
  private Optional<String> address = Optional.empty();

  public UserProfile(String username, String email) {
    this.username = username;
    this.email = email;
  }

  public String getUsername() {
    return this.username;
  }

  public UserProfile setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getEmail() {
    return this.email;
  }

  public UserProfile setEmail(String email) {
    this.email = email;
    return this;
  }

  public Optional<String> getPhoneNumber() {
    return this.phoneNumber;
  }

  public UserProfile setPhoneNumber(Optional<String> phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  public Optional<String> getAddress() {
    return this.address;
  }

  public UserProfile setAddress(Optional<String> address) {
    this.address = address;
    return this;
  }
}
