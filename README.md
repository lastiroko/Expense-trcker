Overview
This Expense Tracker application was built with JavaFX, using FXML for the layout and a dark, Web3-inspired CSS theme for a sleek and modern user interface. It supports core features like adding, editing, deleting, and categorizing expenses, as well as displaying real-time data in a PieChart.

Features
Dark Web3-Themed UI
Powered by a custom CSS file, offering a futuristic, sleek aesthetic.

Add, Edit, & Delete Expenses
Quickly manage your expenses through an intuitive table interface.

Categorization & Visualization
Classify expenses by category and view the breakdown via a dynamic PieChart.

Data Persistence
Save and load expense data from a CSV file so that information is retained between sessions.

Validation & Error Handling
Prompt messages guide users to correct input errors (e.g., invalid amounts).

Dynamic Summaries
Displays a running total of all expenses, updated in real-time with each transaction.



Main Window & Dark Theme

Installation & Setup
Clone the Repository

bash
Kopieren
Bearbeiten
git clone https://github.com/your-username/expense-tracker-javafx.git
cd expense-tracker-javafx
Open the Project

Open the project in your favorite IDE (e.g., IntelliJ, Eclipse, VS Code with Java extensions).
Ensure you have Java 8+ installed on your system.
Build & Run

If you’re using Maven or Gradle, run the appropriate command (e.g., mvn clean install or gradle build) to compile the project.
Then run the main application class, typically ExpenseTrackerApp.java, to launch the application.
Usage
Launch the Application

Upon startup, a window will appear with a form for entering expense details (description, amount, category).
Add a New Expense

Enter a description (e.g., “Groceries”), amount (e.g., 55.00), and select a category (e.g., “Food”) from the dropdown.
Click Add Expense to store this expense in the table.
Edit or Delete

Select an existing expense in the table, update the fields (description, amount, category), then click Edit Expense.
To remove an expense, select it and click Delete Expense.
Save & Load

Use Save Expenses to write your current list of expenses to a CSV file.
Load Expenses imports data from an existing CSV file, replacing the current list.
View Summary & Chart

A running total appears at the bottom of the window, updating dynamically.
The PieChart shows an expense breakdown by category.
Technologies Used
JavaFX for the user interface
FXML for UI structure and layout
CSS for the dark, Web3-style theme
CSV File I/O for data persistence (saving and loading)
Java 8+ (or higher) as the programming language
Future Improvements
Database Integration: Switch from CSV to a relational or NoSQL database for more robust data management.
User Authentication: Implement a login system to support multiple users and personalized tracking.
Budget Alerts: Notify users when they approach or exceed a budget limit.
Multi-Currency Support: Convert expenses into different currencies in real-time.
Mobile/Cloud Sync: Extend capabilities to mobile devices or store data in the cloud for cross-device synchronization.
Contributing
Contributions, issues, and feature requests are welcome. Feel free to check the Issues page if you’d like to submit a bug report or request a feature.

Fork this repository
Create a new branch for your changes (git checkout -b feature-newCoolFeature)
Commit your changes (git commit -m 'Add some cool feature')
Push to the branch (git push origin feature-newCoolFeature)
Open a Pull Request and describe the improvements or fixes you’ve made.
License
(Specify the license under which your project is distributed. For example, MIT.)

This project is licensed under the MIT License.

Thank you for checking out the Expense Tracker! If you have any questions or feedback, feel free to reach out or open an issue. Enjoy tracking your expenses in style!
