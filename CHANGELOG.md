![ONIX Labs](https://raw.githubusercontent.com/onix-labs/onix-labs.github.io/master/content/logo/master_full_md.png)

# Change Log

This document serves as the change log for the ONIXLabs Kotlin Core API.

## Version 2.0.0

#### TypeConverter (abstract class)

Represents the base class for implementing type converters. Type converters represent a mechanism to convert from one type to another, using type-safe convensions. 

The following type converters are implemented:

-   BigDecimalTypeConverter
-   BigIntegerTypeConverter
-   BooleanTypeConverter
-   ByteTypeConverter
-   CharTypeConverter
-   DoubleTypeConverter
-   FloatTypeConverter
-   IntTypeConverter
-   LongTypeConverter
-   ShortTypeConverter
-   StringTypeConverter
-   UUIDTypeConverter

### Extensions

#### KType Extensions

-   Renamed `name` to `formattedSimpleName`.
-   Renamed `fullName` to `formattedQualifiedName`.

## Version 1.0.0

#### ConsoleColor (enum)

Specifies constants that define background and foreground console colors.

#### DayOfMonth (class)

Represents an ordinal occurrence of a day in the month.

#### DayOfMonthOccurrence (enum)

Specifies the ordinal occurrence of a day in the month.

### Extensions

#### Iterable Extensions

-   Extension to determine whether the number of elements that satisfy the specified predicate match the expected count.
-   Extension to determine whether the iterable is empty or not empty.
-   Extensions to determine whether the content in two iterable collections is identical.

#### BigDecimal Extensions

-   Extension to determine whether the specified value represents an integer.

#### KClass Extensions

-   Extension to obtain the kotlin class of an object instance.
-   Extensions to create an instance of the specified kotlin class.
-   Extension to get the primary constructor for the specified kotlin class.
-   Extensions to get immutable and mutable properties from the specified kotlin class.

#### KType Extensions

-   Extension to get the simple name or fully qualified name, including type arguments for the specified kotlin type.

#### Duration Extensions

-   Extension to add days, hours, minutes, seconds, milliseconds and nanoseconds to the specified duration.
-   Extensions to convert the specified duration to seconds, or to microseconds.
-   Extension to convert the specified duration to the total length of the specified time unit.

#### Byte Extensions

-   Constant Byte representations of ZERO and ONE.
-   Extensions to convert Byte to BigInteger or BigDecimal.

#### Console Extensions

-   Print and print-line actions which output the result of an action block.
-   Print and print-line actions which output text in color using the ConsoleColor enum.

#### Double Extensions

-   Constant Double representations of ZERO and ONE.
-   Extension to determine whether the specified Double value represents an integer.
-   Extensions to convert Double to BigInteger or BigDecimal.

#### Float Extensions

-   Constant Float representations of ZERO and ONE.
-   Extension to determine whether the specified Float value represents an integer.
-   Extensions to convert Float to BigInteger or BigDecimal.

#### Int Extensions

-   Constant Int representations of ZERO and ONE.
-   Extensions to convert Int to BigInteger or BigDecimal.

#### Kotlin Extensions

-   Extension to for-each over a sequence of items.

#### Long Extensions

-   Constant Long representations of ZERO and ONE.
-   Extensions to convert Long to BigInteger or BigDecimal.

#### Short Extensions

-   Constant Short representations of ZERO and ONE.
-   Extensions to convert Short to BigInteger or BigDecimal.

#### String Extensions

-   Extension to wrap the current string inside the specified start and end strings.
-   Extensions to format strings as...
    -   UPPER_SNAKE_CASE
    -   lower_snake_case
    -   UPPER-KEBAB-CASE
    -   lower-kebab-case