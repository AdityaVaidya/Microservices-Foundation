package advance;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        String[] names = new String[5];

        // Using Optional to handle null values
        Optional<String> firstName = Optional.ofNullable(names[0]);
        if (firstName.isPresent()) {
            System.out.println("First Name: " + firstName.get());
        } else {
            System.out.println("First Name is not present.");
        }

        // Providing a default value with orElse
        String lastName = names[1];
        System.out.println("Last Name: " + Optional.ofNullable(lastName).orElse("Unknown"));

        // Using ifPresent to perform an action when a value is present
        String middleName = names[2];
        Optional.ofNullable(middleName).ifPresent(name -> System.out.println("Middle Name: " + name));

        // Using map to transform the value if present
        String nickname = names[3];
        Optional<String> formattedNickname = Optional.ofNullable(nickname).map(String::toUpperCase);
        System.out.println("Formatted Nickname: " + formattedNickname.orElse("No Nickname"));

        // Using filter to conditionally process the value
        String email = names[4];
        Optional.ofNullable(email)
                .filter(e -> e.contains("@"))
                .ifPresent(e -> System.out.println("Email: " + e));
    }
}
