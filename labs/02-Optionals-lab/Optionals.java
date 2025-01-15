import Models.UserProfile;

import java.util.List;
import java.util.Optional;

public class Optionals {
  public static void main(String[] args) {
    new Optionals();
  }

  public Optionals() {
    UserProfile userProfile = new UserProfile("John Doe", "a@b.com");
    Optionals.printUserProfile(userProfile);

    userProfile.setPhoneNumber(Optional.of("123-456-7890"));
    Optionals.getPhoneNumber(userProfile);

    List<UserProfile> users = List.of(
        new UserProfile("Alice", "y@z.com"),
        (new UserProfile("Bob", "c@d.com"))
            .setAddress(Optional.of("123 Main St"))
            .setPhoneNumber(Optional.of("123-456-7890"))
    );
    Optionals.filterUsersWithAddress(users);

    Optionals.updateAddress(userProfile, "123 Main St");
  }

  private static void printUserProfile(UserProfile userProfile) {
    System.out.println("+++ Task 1");

    System.out.println("Name: " + userProfile.getUsername());
    System.out.println("Age: " + userProfile.getEmail());

    userProfile.getPhoneNumber().ifPresentOrElse(
        phone -> System.out.println("Phone: " + phone),
        () -> System.out.println("Phone: N/A")
    );

    userProfile.getAddress().ifPresentOrElse(
        address -> System.out.println("Address: " + address),
        () -> System.out.println("Address: N/A")
    );
  }

  private static void getPhoneNumber(UserProfile userProfile) {
    System.out.println("+++ Task 2");

    userProfile.getPhoneNumber().ifPresentOrElse(
        phone -> System.out.println("Phone: " + phone),
        () -> System.out.println("Phone: N/A")
    );
  }

  private static void filterUsersWithAddress(List<UserProfile> users) {
    System.out.println("+++ Task 3");

    users.stream()
        .filter(user -> user.getAddress().isPresent())
        .forEach(user -> System.out.println(user.getUsername()));
  }

  private static void updateAddress(UserProfile user, String newAddress) {
    System.out.println("+++ Task 4");

    user.setAddress(Optional.of(newAddress));
    user.getAddress().ifPresentOrElse(
        address -> System.out.println("Address: " + address),
        () -> System.out.println("Address: N/A")
    );
  }
}
