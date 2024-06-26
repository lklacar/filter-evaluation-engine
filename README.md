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

## Internal Types (`Value`)

In Filter Expression Language (FEL), various internal types are used to represent different kinds of values in filter expressions. These internal types extend the `Value` class and provide a consistent way to handle different data types during filtering operations. Here’s an overview of the internal types used in FEL:

### `LongValue`

Represents integer values, including `Byte`, `Short`, `Integer`, and `Long` types.

**Example:**
```java
new LongValue(123L);
```

### `DoubleValue`

Represents floating-point values, including `Float` and `Double` types.

**Example:**
```java
new DoubleValue(123.45);
```

### `StringValue`

Represents string values, including `Character` and `String` types.

**Example:**
```java
new StringValue("Hello, World!");
```

### `BooleanValue`

Represents boolean values.

**Example:**
```java
new BooleanValue(true);
```

### `DateTimeValue`

Represents date and time values, including `LocalDateTime`, `LocalDate`, and `Instant` types. Internally, `LocalDate` and `Instant` are converted to `LocalDateTime`.

**Example:**
```java
new DateTimeValue(LocalDateTime.now());
```

### `NullValue`

Represents a null value.

**Example:**
```java
new NullValue();
```

### `ObjectValue`

Represents custom objects that do not fall into any of the predefined categories. This type is used for complex objects and relies on additional mappers for conversion.

**Example:**
```java
new ObjectValue(customObject);
```

### Usage in Filter Expressions

These internal types are used during the parsing and evaluation of filter expressions. The `parseValue` method converts external types to their corresponding internal `Value` types, ensuring consistent handling and evaluation of filter criteria.

For example, when evaluating a filter expression, the values of fields and constants are converted to the appropriate `Value` type, and operations (such as equality checks, logical operations, etc.) are performed using these internal types.

### Summary

The internal `Value` types in FEL provide a robust and flexible mechanism to handle various data types consistently during filtering operations. By abstracting the underlying data types into a common `Value` hierarchy, FEL ensures that filter expressions can be evaluated accurately and efficiently, regardless of the complexity or variety of the data being filtered.

## Supported Types

Filter Expression Language (FEL) supports a variety of data types, allowing you to filter collections of objects with diverse attributes. Here's a detailed overview of the supported types and how they are handled within FEL.

### Primitive and Wrapper Types

FEL supports the common primitive and their corresponding wrapper types in Java:

- **Byte:** Automatically converted to `LongValue`.
- **Short:** Automatically converted to `LongValue`.
- **Integer:** Automatically converted to `LongValue`.
- **Long:** Directly mapped to `LongValue`.
- **Float:** Automatically converted to `DoubleValue`.
- **Double:** Directly mapped to `DoubleValue`.
- **Character:** Automatically converted to `StringValue`.
- **String:** Directly mapped to `StringValue`.
- **Boolean:** Directly mapped to `BooleanValue`.

### Date and Time Types

FEL supports the Java `Date and Time` API, allowing you to filter based on various date and time representations:

- **LocalDateTime:** Directly mapped to `DateTimeValue`.
- **LocalDate:** Converted to `DateTimeValue` by setting the time to the start of the day.
- **Instant:** Converted to `DateTimeValue` based on the system's default time zone.

### Enum Types

Enumerations (`enum`) are also supported and are automatically converted to their string representations:

- **Enum:** Automatically converted to `StringValue` using the `enum` name.

### Null Values

FEL gracefully handles null values during the filtering process:

- **Null:** Mapped to a `NullValue`.

### Custom Objects

FEL provides support for custom objects through additional mappers. If a custom object does not have a predefined conversion, FEL attempts to use a user-defined mapper from the `additionalMappers` map. If no mapper is found, FEL checks if the object is a standard Java object and raises an exception if it cannot be converted. Otherwise, the object is treated as an `ObjectValue`.

### Summary

FEL's flexible type support ensures that you can filter collections based

on a wide range of data types, including primitive and wrapper types, date and time representations, enums, and custom objects. By leveraging additional mappers, you can extend FEL's capabilities to handle custom filtering requirements specific to your application.

## Advanced Usage: Custom Mappers

Filter Expression Language (FEL) allows for advanced usage scenarios by supporting custom mappers. Custom mappers can be used to convert data types during the filtering process, enabling more complex filtering conditions that involve custom objects or data transformations.

In this section, we will describe how to use custom mappers with FEL to filter objects based on complex criteria.

### Custom Mapper Example: Filtering Users by Date of Birth

Consider a scenario where you want to filter users based on their date of birth. The users' dates of birth are stored as `Instant` objects, but you want to use a custom mapper to convert these `Instant` objects to a more human-readable `LocalDateTime` format during the filtering process.

Here's how you can achieve this using a custom mapper:

```java
package rs.qubit.fel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.qubit.fel.evaluator.value.DateTimeValue;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

public class Main {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    static class User {
        private String firstName;
        private String lastName;
        private Instant dateOfBirth;
    }

    public static void main(String[] args) {

        var users = List.of(
                new User("John", "Doe", Instant.parse("1990-01-01T00:00:00Z")),
                new User("Jane", "Doe", Instant.parse("1995-01-01T00:00:00Z"))
        );

        var predicate = Fel.filter("dateOfBirth = 1990-01-01T00:00:00")
                .withMapper(Instant.class, instant -> {
                    var localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
                    return new DateTimeValue(localDateTime);
                });

        var filteredUsers = users.stream()
                .filter(predicate)
                .toList();

        System.out.println(filteredUsers);
    }
}
```

### Explanation

1. **Define Your Classes:** Create the `User` class with a `dateOfBirth` field of type `Instant`.

2. **Initialize Your Data:** Create a list of users with different dates of birth.

3. **Define a Custom Mapper:** Use the `withMapper` method to define a custom mapper for the `Instant` class. This mapper converts an `Instant` object to a `LocalDateTime` object, wrapped in a `DateTimeValue`.

4. **Apply the Filter:** Use the `fel` method to define your filter expression. In this example, we're filtering users whose `dateOfBirth` is `"1990-01-01T00:00:00"`.

5. **Filter and Collect:** Use Java streams to apply the filter and collect the results.

6. **Output the Results:** Print the filtered list of users.

### Advanced Usage Scenarios

Custom mappers can be used for a variety of advanced filtering scenarios, such as:

- **Date and Time Conversions:** Convert between different date and time formats, such as `Instant`, `LocalDateTime`, or custom date classes.
- **Custom Object Transformations:** Map custom objects to simpler representations or intermediary values for filtering purposes.
- **Complex Field Access:** Transform nested fields or perform custom calculations on object fields before filtering.

By leveraging custom mappers, you can extend the functionality of FEL to handle complex filtering logic tailored to your application's specific needs.

## Examples with Custom Mappers

### Filtering Orders by Delivery Date

Suppose you have an `Order` class with a `deliveryDate` field of type `Instant`. You can use a custom mapper to filter orders based on their delivery date:

```java
package rs.qubit.fel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.qubit.fel.evaluator.value.DateTimeValue;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Order {
    private String orderId;
    private Instant deliveryDate;
}

public class Main {

    public static void main(String[] args) {

        var orders = List.of(
                new Order("1", Instant.parse("2023-01-01T00:00:00Z")),
                new Order("2", Instant.parse("2024-01-01T00:00:00Z"))
        );

        var predicate = Fel.filter("deliveryDate = 2023-01-01T00:00:00")
                .withMapper(Instant.class, instant -> {
                    var localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
                    return new DateTimeValue(localDateTime);
                });

        var filteredOrders = orders.stream()
                .filter(predicate)
                .toList();

        System.out.println(filteredOrders);
    }
}
```

### Filtering Events by Start Time

Consider an `Event` class with a `startTime` field of type `Instant`. Use a custom mapper to filter events based on their start time:

```java
package rs.qubit.fel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.qubit.fel.evaluator.value.DateTimeValue;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Event {
    private String eventName;
    private Instant startTime;
}

public class Main {

    public static void main(String[] args) {

        var events = List.of(
                new Event("Concert", Instant.parse("2022-06-15T19:00:00Z")),
                new Event("Conference", Instant.parse("2022-06-20T09:00:00Z"))
        );

        var predicate = Fel.filter("startTime = 2022-06-15T19:00:00")
                .withMapper(Instant.class, instant -> {
                    var localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
                    return new DateTimeValue(localDateTime);
                });

        var filteredEvents = events.stream()
                .filter(predicate)
                .toList();

        System.out.println(filteredEvents);
    }
}
```

These examples demonstrate how custom mappers can be used with FEL to filter objects based on various criteria, highlighting the flexibility and power of custom mappers in advanced filtering scenarios.

By incorporating custom mappers, you can tailor FEL to suit your specific filtering needs, ensuring that the library remains a powerful and versatile tool for your Java applications.

## Advanced Usage: Custom Functions

Filter Expression Language (FEL) also supports the usage of custom functions to extend the filtering capabilities. This allows for more complex transformations and evaluations during the filtering process.

### Custom Function Example: Filtering Users by Uppercase Names

Consider a scenario where you want to filter users based on the uppercase version of their first names. You can use a custom function to achieve this:

```java
package rs.qubit.fel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.qubit.fel.evaluator.value.NullValue;
import rs.qubit.fel.evaluator.value.StringValue;

import java.time.Instant;
import java.util.List;

public class Main {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    static class User {
        private String firstName;
        private String lastName;
        private Instant dateOfBirth;
    }

    public static void main(String[] args) {

        var users = List.of(
                new User("John", "Doe", Instant.parse("1990-01-01T00:00:00Z")),
                new User("Jane", "Doe", Instant.parse("1995-01-01T00:00:00Z"))
        );

        var predicate = Fel.filter("toUppercase(firstName) = 'JOHN'")
                .withFunction("toUppercase", values -> {
                    var parameter = values.get(0);
                    if (parameter instanceof NullValue) {
                        return new NullValue();
                    }

                    return new StringValue(parameter.asString().toUpperCase());
                });

        var filteredUsers = users.stream()
                .filter(predicate)
                .toList();

        System.out.println(filteredUsers);
    }
}
```

### Explanation

1. **Define Your Classes:** Create the `User` class with a `firstName`, `lastName`, and `dateOfBirth` fields.

2. **Initialize Your Data:** Create a list of users with different first names.

3. **Define a Custom Function:** Use the `withFunction` method to define a custom function called `toUppercase`. This function takes a string parameter and returns its uppercase version.

4. **Apply the Filter:** Use the `fel` method to define your filter expression, utilizing the custom function. In this example, we're filtering users whose uppercase `firstName` is `"JOHN"`.

5. **Filter and Collect:** Use Java streams to apply the filter and collect the results.

6. **Output the Results:** Print the filtered list of users.

### Advanced Usage Scenarios

Custom functions can be used for a variety of advanced filtering scenarios, such as:

- **String Manipulations:** Perform custom string transformations, such as trimming, concatenation, or pattern matching.
- **Mathematical Operations:** Implement custom mathematical operations or calculations.
- **Data Transformations:** Apply custom transformations to object fields before evaluating

the filter condition.

By leveraging custom functions, you can further extend the functionality of FEL to handle complex filtering logic tailored to your application's specific needs.

## Performance Considerations

Filter Expression Language (FEL) is designed to be lightweight and efficient for filtering collections of objects. However, when working with large datasets or complex filter expressions, consider the following performance considerations:

- **Filter Expression Complexity:** Complex filter expressions may impact performance, especially when they involve nested conditions or operations that require extensive computation. It's advisable to test and optimize filter expressions for performance-critical applications.

- **Data Set Size:** While FEL is efficient for typical use cases, performance can vary with the size of the dataset being filtered. For large datasets, consider implementing pagination or batch processing to manage memory usage and improve performance.

- **Testing and Benchmarking:** Before deploying FEL in production, conduct thorough testing and benchmarking to ensure that performance meets your application's requirements. Identify and optimize any bottlenecks that may arise from filter expression evaluation.

By understanding these considerations and optimizing where necessary, you can leverage FEL effectively for filtering operations while maintaining optimal performance in your applications.

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