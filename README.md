# CS151-SimpleBankingApp
Simple Banking App for CS 151 - Team #1

# Simple Banking Application

### Team #1: Alvin Lee, Khushi Chandra, Pio Romo, Ronald Celino

## Table of Contents
[Problem/Issue Statement](#Problem/Issue)\
[Functionality](#Functionality)\
[Previous Works](#Previous-Works)\
[More Information](#More-Information)\
[Plan and Approach](#Plan-and-Approach)
[Setting Up the Project](#Setting-Up-the-Project)\
[Examples](#Examples)\
[UML Diagram](#UML-Diagram)\
[Closing Thoughts](#Closing-Thoughts)\
[Individual Contributions](#Individual-Contributions)

### Problem/Issue:

Users are unable to view and modify bank accounts online. 

### Functionality:

Our simple banking application will allow users to view accounts through CLI. In addition, users can view and remove accounts, as well as deposit and withdraw. 

### Previous Works

We will be referencing a YT playlist by “Intro to Computer Science”, where he builds a simple banking application on NetBeans using Java Swing.

Playlist: https://www.youtube.com/watch?v=Qg_msJeezpA

### More Information

Project will be monitored through GitHub. IDE’s are up to personal preference, but may include VS Code and Eclipse. 


### Plan and Approach

Each team member, per project guidelines, is expected to contribute to the programming aspect of the project. 

Responsibilities will be specified after further discussion, and will be done a voluntary basis to ensure each member is assigned to a portion where they are most comfortable and best suited. 

The project will be split into 4 major portions: Add/create account, delete account, withdraw, deposit. 

1. Add/create account
    * Users will be able to create a an account, with the option to create others.
2. Delete account
    * Users will be able to remove any of their accounts.
3. Withdraw
    * Users will be able to withdraw from a selected account. Overdraft fees will be enforced if withdrawal amount is greater than current amount in bank account.
4. Deposit
    * Users will be able to deposit an amount into a selected bank account. Amount is limited to $5000 per each deposit.
5. UML diagram
    * Diagram showing representing the architecture of the project.
   
Each issue will be worked on from a separate branch, and then pulled into the main branch once review is complete. 

**By Oct 31 midpoint:** Application will allow users to create and delete accounts. 

**By project deadline:** Users should then be able to withdraw and deposit from a selected account. Entire app should be fully functional. UML should be complete. 

### Setting Up the Project

Setting up the project is a pretty easy process. All that's needed is to clone the git repository to your computer, then open it up in an IDE of your choosing. 
1. Open a terminal window on your machine, and navigate to where you want to store the repository.
2. Run this command: `git clone https://github.com/PioRomo/CS151-SimpleBankingApp`
3. The repo is now in your computer. You can now open the project in your IDE.
4. Once the project is open, you can go ahead and run it. A window will pop-up. Resize the window, and you will be able to use the app.
   
### Examples
### UML Diagram

Sequence Diagram:
![BankApplicationSequenceDiagramFinal drawio](https://github.com/PioRomo/CS151-SimpleBankingApp/assets/131488639/26e47bcc-a9b4-401d-a6fd-788d201f3050)

State Diagram:
![BankApplicationStateDiagramFinal drawio](https://github.com/PioRomo/CS151-SimpleBankingApp/assets/131488639/dce58515-2b3d-482f-b502-07b53b04fe16)


### Closing Thoughts

#### How did we solve our initial problem? 

The problem we set out to solve was that users were unable to view and modify their bank accounts online. 
With our application, users can do so much more. Users can create and delete accounts. Users can withdraw 
or deposit from their accounts. Additionally, users can also use our built-in CD calculator to view the
growth of a CD using custom inputs. 

#### Brief Description

The Simple Banking App allows users to create and delete banking accounts, both checking and savings. These accounts are stored on a table, and
users can also withdraw and deposit from select accounts. A CD calculator also allows users to calculate the growth of a CD with custom variables. 

### Individual Contributions

* Pio Romo:
   * Created the MainMenu page, which included the addition of buttons and the table.
   * Implemented the CD Calculator page.
   * Created the GitHub repo, including starting files and readme
   * Created report and presentation
* Alvin Lee:
   * Implemented Deposit functionality
   * Implemented Withdraw functionality
* Ronald Celino:
   * Implemented Create Account functionality
   * Worked on UML Diagram
* Khushi Chandra: 
   * Implemented Delete Account functionality
   * Worked on UML Diagram





