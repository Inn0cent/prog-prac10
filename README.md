# Introduction to Programming

## Practical 10: Main methods 

## Instructions

This week the practical focuses on writing main methods. You will also get to use the university Linux system, showing how Java is cross-platform.

### Level 0:

1. Log in to the university Linux service mira, easiest to do by using putty (search for it from the start menu). Use the same username and password that you use to log in to CIS email etc. Use the command `cd` to change into a directory (folder) and `ls` to list the files that are there. If you want more instructions on basic Unix commands then look at the introduction and step one of this [Unix tutorial](http://www.open-of-course.org/courses/mod/page/view.php?id=453)
2. Get into a directory where one of your java projects is stored and compile a java files with the `javac` command e.g.

   ```javac Module.java```
   
   Try to execute your compiled code with (e.g.)
   
   ```java Module```
   
   This will give you an error message unless you have defined a main method for your class.
3. Define a main method i.e. one with the signature

   ```java
   public static void main(String[] args)
   ```
   
   This method should create an object in a local variable by using a constructor and then execute one of the methods on that object.

### Level 1: Palindromes

(This was an exam question back in the day when IP was assessed by a written exam)
Write a Java class called _Palindrome_ which identifies whether the text given
on the command line forms a palindrome (i.e. has the same letter ordering
forwards and backwards), so that executing

   ```java Palindrome Sex at noon taxes```
   
will display

   ```"Sex at noon taxes" is a palindrome```
   
whereas

   ```java Palindrome hello world```
   
will display

   ```"hello world" is not a palindrome```
   
Remember that when you execute a java class from the command line that the `main` method is executed and that the command line parameters (i.e. any text that is given after the name of the class) are passed to the main method as a `String[]` parameter.
 
### Level 2: The blues

1. Read this web page about singing the blues:
<http://www.analogman.com/singblues.htm>
For examples of blues songs, try searching for “crossroads lyrics” or “texas flood lyrics”.

2. Now, write a program to generate a random blues song using the structure
and examples from the web page. Invent three verses and generate an
appropriately named random author.

3. Next, adapt the program by allowing the user to provide key phrases/words on
the command line.

4. Finally, allow the user to start as much of a song as they like and then have
the computer finish it off in appropriate style. Inform the user if the input they
have provided does not, for whatever reason, constitute ‘the blues’.