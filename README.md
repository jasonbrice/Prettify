
The code and unit test associated with this Eclipse project address the following development problem:

Write a number prettifier:
Write tested code (in any language) that accepts a numeric type and returns a truncated, 
"prettified" string version. The prettified version should include one number after the 
decimal when the truncated number is not an integer. It should prettify numbers greater 
than 6 digits and support millions, billions and trillions.
 
Assumptions:

 * Code does not (yet) need to be optimized for performance.
 * Code does not (yet) need to be thread-safe.

Design:
There are three classes provided:
 * The Prettify class, which includes a static main method as an entrypoint into the application
   (so that it could be run on a command line as well as from an IDE)
 * The PrettyFormatter class, which does the work of formatting the number. The PrettyFormatter
   class does not include a zero-argument constructor, because without a string to format,
   the PrettyFormatter is pretty useless.
 * The TestPrettyFormatter class, a JUnit test to validate the claims that the PrettyFormatter class
   makes. 
   
Other design notes: I've tried to keep each method short enough to fit on a single screen.
I've done a bit of basic refactoring (split the logic out from the Prettify class into the 
PrettyFormatter class), but the code could surely use some attention before it's ready for
production. Such as: 
  * Replace String concatenation using + with StringBuffer.
  * Replace hard-coded output strings to i18n localized ones.
  * Examine the input better and deal with edge cases rather than rely on exception handling. 
  * Accept other Locales rather than just treat the local environment as the only one.
  
General Notes:
The Java src and JUnit files contained herein were created with Eclipse. You ought to be able to 
import it as an existing project into Eclipse "as is". If you use something else, you'll need
to import the src, associate the project with JRE 1.6+, and point the classpath to JUnit4. 

