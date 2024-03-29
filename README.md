# CSX42: Assignment 2
## Name: Shivkumar Subhash Kothale

Using 1 Slack Day
4 remaining
-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in backupTrees/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile backupTrees/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile backupTrees/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command:  ant -buildfile backupTrees/src/build.xml run -Darg0=bstInput.txt -Darg1=bstOutput.txt -Darg2=errorLog.txt -Darg3=DEBUG -Darg4=1

## Replace <fileName.txt> with real file names. For example, if the files are available in the path,
## you can run it in the following manner:

Note: Arguments accept the absolute path of the files.

-----------------------------------------------------------------------
## Description:

#Work Flow for Driver code-
-Check if there are 5 command-line arguments and none of them match specific placeholder strings.
-If the conditions are not met, print an error message and exit the program.
-If the arguments are valid, continue with the following steps:
-Create a "Results" instance with the 2nd and 3rd command-line arguments.
-Create a "BstBuilder" instance.
-Read a file specified by the 1st command-line argument and use the "Results" instance for result storage.
-Print the inorder traversal of a binary search tree using the "printAll" method of "BstBuilder."
-Calculate and print the sum of B-Numbers in each tree using the "printSum" method of "BstBuilder."
-Declare an integer variable "update_value" and initialize it to 0.
-Attempt to parse the 5th command-line argument as an integer.
-If successful, assign the parsed integer to "update_value."
-If a number format error occurs, print the error stack trace, write an error message to the "Results" instance, and exit the program.
-If parsing is successful, update all trees using "update_value" in the "BstBuilder."
-Calculate and print the sum of B-Numbers in each tree after the increment using the "printSum" method of "BstBuilder."
-Close the file writer associated with the "Results" instance.
   -Justification of the Data Structures used 
        - Map used for storing observers 
            --key->Filter
            --Value->List of Observers

            If I use the map then->
                Retrival and insertion would be in O(1)
                So the operation of retrieving the observers would be O(C*N*M)-->O(1*N*P)-->O(N*M).





-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.""

Date: 20/10/2023


