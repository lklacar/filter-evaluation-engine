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
                .filter(Fel.filter("address.street = 'Main Street'"))
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
- **Logical NOT:** `! expression` - Negate a boolean expression.
- **Equality:** `left = right` - Check if two expressions are equal.
- **Inequality:** `left != right` - Check if two expressions are not equal.
- **Comparison:**
    - `left > right` - Check if `left` is greater than `right`.
    - `left < right` - Check if `left` is less than `right`.
    - `left >= right` - Check if `left` is greater than or equal to `right`.
    - `left <= right` - Check if `left` is less than or equal to `right`.

### Logical Operations

- **Logical AND:** `left && right` - Combine two expressions with logical &&.
- **Logical OR:** `left || right` - Combine two expressions with logical ||.

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
- **Logical AND:** `firstName = 'John' && lastName = 'Doe'` - Filters objects where `firstName` is `John` and `lastName` is `Doe`.
- **Logical OR:** `age < 20 || age > 60` - Filters objects where `age` is less than `20` or greater than `60`.
- **Nested Fields:** `address.street = 'Main Street'` - Filters objects where `address.street` is `Main Street`.

## Performance Considerations

Filter Expression Language (FEL) is designed to be lightweight and efficient for filtering collections of objects. However, when working with large datasets or complex filter expressions, consider the following performance considerations:

- **Filter Expression Complexity:** Complex filter expressions may impact performance, especially when they involve nested conditions or operations that require extensive computation. It's advisable to test and optimize filter expressions for performance-critical applications.

- **Data Set Size:** While FEL is efficient for typical use cases, performance can vary with the size of the dataset being filtered. For large datasets, consider implementing pagination or batch processing to manage memory usage and improve performance.

- **Testing and Benchmarking:** Before deploying FEL in production, conduct thorough testing and benchmarking to ensure that performance meets your application's requirements. Identify and optimize any bottlenecks that may arise from filter expression evaluation.

By understanding these considerations and optimizing where necessary, you can leverage FEL effectively for filtering operations while maintaining optimal performance in your applications.

Here's a section that includes examples with real-world data:

## Examples with Real-World Data

To demonstrate the versatility and practical application of Filter Expression Language (FEL), here are some examples using real-world data scenarios:

### Filtering Users by Age and City

Consider a scenario where you have a list of users with associated cities and ages. You can use FEL to filter users based on specific criteria:

```java
@Test
void filterUsersByAgeAndCity() {
    var users = List.of(
            new User("John", 25, LocalDateTime.now(), new Address("Belgrade", "Nemanjina", 4)),
            new User("Jane", 30, LocalDateTime.now(), new Address("Novi Sad", "Trg Slobode", 1)),
            new User("Mark", 35, LocalDateTime.now(), new Address("Belgrade", "Knez Mihailova", 2)),
            new User("Marko", 35, LocalDateTime.now(), new Address("Belgrade", "Knez Mihailova", 2))
    );

    var filter = Fel.filter("age >= 30 && address.city = 'Belgrade'");

    var filteredUsers = users.stream().filter(filter).toList();

    assertEquals(2, filteredUsers.size());
    assertEquals("Mark", filteredUsers.get(0).getName());
    assertEquals("Marko", filteredUsers.get(1).getName());
}
```

### Filtering Products by Price and Stock Availability

In an e-commerce application, you might want to filter products based on their price and availability status:

```java
@Test
void filterProductsByPriceAndStock() {
    var products = List.of(
            new Product("Laptop", 1200.00, true),
            new Product("Smartphone", 700.00, false),
            new Product("Tablet", 300.00, true),
            new Product("Monitor", 150.00, true)
    );

    var filter = Fel.filter("price < 500 && inStock = true");

    var filteredProducts = products.stream().filter(filter).toList();

    assertEquals(2, filteredProducts.size());
    assertEquals("Tablet", filteredProducts.get(0).getName());
    assertEquals("Monitor", filteredProducts.get(1).getName());
}
```

### Filtering Users by Date of Creation

Filtering users based on the date they were created can be essential for applications that manage user lifecycle:

```java
@Test
void filterNewUsers() {
    var now = LocalDateTime.now();
    var users = List.of(
            new User("Alice", 22, now.minusDays(1), new Address("Paris", "Rue de Rivoli", 7)),
            new User("Bob", 28, now.minusMonths(6), new Address("Berlin", "Unter den Linden", 5)),
            new User("Charlie", 35, now, new Address("London", "Baker Street", 221))
    );

    var filter = Fel.filter("createdAt > " + now.minusHours(3));

    var filteredUsers = users.stream().filter(filter).toList();

    assertEquals(1, filteredUsers.size());
    assertEquals("Charlie", filteredUsers.get(0).getName());
}
```

These examples showcase how FEL can be used to filter diverse datasets effectively, demonstrating its utility across different types of applications and scenarios.

This section provides concrete examples using real-world data scenarios, demonstrating how FEL can be applied to filter users, products, and other entities based on various criteria.


## Contributing

Contributions are welcome! Please feel free to submit a pull request or open an issue to improve the library.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any inquiries or feedback, please reach out to [Luka](mailto:luka@example.com).

---

This README provides an overview of how to use the Filter Expression Language (FEL) library. For more detailed documentation and examples, please refer to the project's repository.