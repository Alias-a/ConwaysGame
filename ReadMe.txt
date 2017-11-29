--------------------------------------------------------------------------

How to compile and run

--------------------------------------------------------------------------

To run, use the command:

gradle run

from inside the unzipped ConwaysGame directory.

To run the unit tests, use the command:

gradle test

from inside the unzipped ConwaysGame directory.

Alternatively you can simply open the unzipped ConwaysGame directory with IntelliJ IDEA and run the Main.java or ConwaysGameTest.java through the IDE.

---------------------------------------------------------------------------

How to use

---------------------------------------------------------------------------

After running the program using the above instructions the program will ask you for input.
Most of this is pretty self-explanatory, but when inputting your initial city's state please note the following:

* If not specified, the default width and height of a city is 8 x 6
* + separated by whitespace characters indicates a living person/node
* any other character or string of characters separated by whitespace indicates a dead person/node. I recommend using - to keep things consistent though.
* I recommend that you input the information in rows, though you can do it any way you want.

ex)
"Please enter the initial state of your city:"
- - - - - - + -
+ + + - - - + -
- - - - - - + -
- - - - - - - -
- - - + + - - - 
- - - + + - - -


