# CS3330_Assignment5

Objective
The goal of this assignment is to develop a Java-based desktop application that applies
key Object-Oriented Programming (OOP) concepts in an engaging and practical project.
Students will build a Pet Adoption Center management system, leveraging Swing for the
GUI and Maven for project structure and dependency management.
Project Summary
Students will build a system to manage adoptable pets, including Dog, Cat, Rabbit, and
ExoticAnimal. The app will support adding, viewing, sorting, and adopting pets, while
maintaining clean software architecture and applying design principles.
Concepts Covered
• Java Generics
• Adapter Design Pattern
• SOLID Principles
• Comparator and Comparable interfaces
• Model-View-Controller (MVC) pattern
• Swing GUI development
• Maven project setup
Scenario
The Pet Adoption Center needs a desktop tool to manage its list of available pets. Occa-
sionally, exotic pets are provided through a third-party system that does not follow the
same structure. Your task is to create a unified application to manage all types of pets
using clean OOP principles.
1
Object-Oriented Programming Adopt Me!
Requirements
Functional Features
• Load the pets and the exotic pets from the given JSON files (pets.json and ex-
otic pets.json) when the program starts. These files must go to the “src/main/re-
sources” directory of your Maven project.
• Use the Gson library to work with JSON files. The library must be added as a
dependency to your Maven project. Adding it as a jar is invalid. Use the 2.13.1
version.
• Add, remove, and view adoptable pets.
• Sort pets by name, age, or species.
• Adopt a pet. Update the adopted pet’s status, and once it is adopted, it cannot be
adopted again (prompt message on multiple attempts).
• Import exotic pets via a third-party format using an Adapter.
• Save the pet list back to JSON file. For the saved file name, use the current date
and time when the save button is clicked. Ex: YYYYMMDD HHMMSS pets.json
Technical Implementation
• Generics: Create a generic Shelter<T extends Pet> class to store pets.
• Adapter Pattern: Wrap a third-party ExoticAnimal class to make it compatible
with the Pet abstract class.
• SOLID Principles: Follow Single Responsibility, Open/Closed, Liskov Substitu-
tion, Interface Segregation, and Dependency Inversion principles throughout the
codebase.
• Comparator & Comparable: Implement sorting logic using both Comparable
(default: by name) and multiple Comparator classes (e.g., by age or species).
• MVC: Structure the project using MVC:
– Model: Pet data classes and Shelter logic.
– View: Swing-based GUI.
– Controller: Connect GUI events to model updates.
• Swing GUI: Include:
– List or table of pets
– Buttons for actions (Add, Adopt, Remove, View Details, Save)
– Combobox for sort by category selection
– Dialogs for adding/viewing details
• Maven: Use Maven for dependency management and project structure.
2Object-Oriented Programming Adopt Me!
Requirements
Functional Features
• Load the pets and the exotic pets from the given JSON files (pets.json and ex-
otic pets.json) when the program starts. These files must go to the “src/main/re-
sources” directory of your Maven project.
• Use the Gson library to work with JSON files. The library must be added as a
dependency to your Maven project. Adding it as a jar is invalid. Use the 2.13.1
version.
• Add, remove, and view adoptable pets.
• Sort pets by name, age, or species.
• Adopt a pet. Update the adopted pet’s status, and once it is adopted, it cannot be
adopted again (prompt message on multiple attempts).
• Import exotic pets via a third-party format using an Adapter.
• Save the pet list back to JSON file. For the saved file name, use the current date
and time when the save button is clicked. Ex: YYYYMMDD HHMMSS pets.json
Technical Implementation
• Generics: Create a generic Shelter<T extends Pet> class to store pets.
• Adapter Pattern: Wrap a third-party ExoticAnimal class to make it compatible
with the Pet abstract class.
• SOLID Principles: Follow Single Responsibility, Open/Closed, Liskov Substitu-
tion, Interface Segregation, and Dependency Inversion principles throughout the
codebase.
• Comparator & Comparable: Implement sorting logic using both Comparable
(default: by name) and multiple Comparator classes (e.g., by age or species).
• MVC: Structure the project using MVC:
– Model: Pet data classes and Shelter logic.
– View: Swing-based GUI.
– Controller: Connect GUI events to model updates.
• Swing GUI: Include:
– List or table of pets
– Buttons for actions (Add, Adopt, Remove, View Details, Save)
– Combobox for sort by category selection
– Dialogs for adding/viewing details
• Maven: Use Maven for dependency management and project structure.
