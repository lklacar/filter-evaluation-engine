# Filter Expression Language (FEL)

Filter Expression Language (FEL) is a lightweight, open-source Java library that simplifies filtering collections of objects using human-readable string expressions. FEL aims to provide an intuitive and flexible way to apply filters to your data without writing verbose and complex code.

## Features

- Simple and intuitive string-based filter expressions
- Integration with Java streams
- Lightweight and easy to use

## Installation

To include FEL in your project, add the following dependency to your `pom.xml` if you are using Maven:

```xml
<dependency>
    <groupId>rs.qubit</groupId>
    <artifactId>filter-expression-language</artifactId>
    <version>1.0.0</version>
</dependency>
```

If you are using Gradle, add the following to your `build.gradle`:

```groovy
implementation 'rs.qubit:filter-expression-language:1.0.0'
```

## Usage

Here's a quick example to get you started with FEL:

```java
package rs.qubit.fel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static rs.qubit.fel.engine.FilterEngine.fel;

public class Main {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    static class Address {
        private String street;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    static class User {
        private String firstName;
        private String lastName;
        private Address address;
    }

    public static void main(String[] args) {

        var users = List.of(
                User.builder().firstName("John").lastName("Doe").address(Address.builder().street("Wall Street").build()).build(),
                User.builder().firstName("Jane").lastName("Doe").address(Address.builder().street("Wall Street").build()).build(),
                User.builder().firstName("Alice").lastName("Smith").address(Address.builder().street("Main Street").build()).build()
        );

        var filteredUsers = users
                .stream()
                .filter(fel("address.street = 'Main Street'"))
                .toList();

        System.out.println(filteredUsers);
    }
}
```

### Explanation

1. **Define Your Classes:** Create the classes you want to filter. In this example, we have `User` and `Address` classes.

2. **Initialize Your Data:** Create a list of users with different addresses.

3. **Apply the Filter:** Use the `fel` method to define your filter expression. In this case, we're filtering users whose `address.street` is `"Main Street"`.

4. **Filter and Collect:** Use Java streams to apply the filter and collect the results.

5. **Output the Results:** Print the filtered list of users.

## Language Specification

FEL expressions support a variety of operations to filter your data effectively. Here's a breakdown of the supported expressions:

### Basic Expressions

- **Parentheses:** `(expression)` - Group expressions to control evaluation order.
- **Logical NOT:** `NOT expression` - Negate a boolean expression.
- **Equality:** `left = right` - Check if two expressions are equal.
- **Inequality:** `left != right` - Check if two expressions are not equal.
- **Comparison:**
    - `left > right` - Check if `left` is greater than `right`.
    - `left < right` - Check if `left` is less than `right`.
    - `left >= right` - Check if `left` is greater than or equal to `right`.
    - `left <= right` - Check if `left` is less than or equal to `right`.

### Logical Operations

- **Logical AND:** `left AND right` - Combine two expressions with logical AND.
- **Logical OR:** `left OR right` - Combine two expressions with logical OR.

### Literals

- **String:** `'string'` - Represents a string literal.
- **Number:**
    - `123` - Represents an integer.
    - `123.45` - Represents a double.
- **Boolean:** `true` or `false` - Represents a boolean value.
- **Null:** `null` - Represents a null value.
- **Date and Time:** `YYYY-MM-DD` or `YYYY-MM-DDTHH:MM:SS` - Represents date and time values.

### Identifiers and Fields

- **Identifiers:** `identifier` - Represents a variable or field name.
- **Field Access:** `object.field` - Access fields within objects.

### Example Expressions

- **Equality Check:** `firstName = 'John'` - Filters objects where `firstName` is `John`.
- **Inequality Check:** `age != 30` - Filters objects where `age` is not `30`.
- **Logical AND:** `firstName = 'John' AND lastName = 'Doe'` - Filters objects where `firstName` is `John` and `lastName` is `Doe`.
- **Logical OR:** `age < 20 OR age > 60` - Filters objects where `age` is less than `20` or greater than `60`.
- **Nested Fields:** `address.street = 'Main Street'` - Filters objects where `address.street` is `Main Street`.

## Contributing

Contributions are welcome! Please feel free to submit a pull request or open an issue to improve the library.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any inquiries or feedback, please reach out to [Luka](mailto:luka@example.com).

---

This README provides an overview of how to use the Filter Expression Language (FEL) library. For more detailed documentation and examples, please refer to the project's repository.