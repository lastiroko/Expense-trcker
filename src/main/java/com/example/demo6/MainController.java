package com.example.demo6;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;

public class MainController {
    //Logic would be here Later
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField amountField;
    @FXML
    private Label messageLabel;

    @FXML
    private TableView<Expense> expenseTable;

    @FXML
    private TableColumn<Expense, String> descriptionColumn;

    @FXML
    private TableColumn<Expense, Double> amountColumn;
    @FXML
    private Label totalLabel;
//Observable List
    private ObservableList<Expense> expenseList = FXCollections.observableArrayList();

private static final String FILE_NAME = "expenses.csv";
    @FXML
    public void initialize() {
        //Bind table to property values(description and amount)
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
//set Items
        expenseTable.setItems(expenseList);
        System.out.println("MainController initialized! ");
        // Add a listener to update the input fields when a table row is selected
        expenseTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                descriptionField.setText(newSelection.getDescription());
                amountField.setText(String.valueOf(newSelection.getAmount()));
            }
        });
    }


    @FXML
    private void handleEditExpense() {
        // Get the selected expense from the table
        Expense selectedExpense = expenseTable.getSelectionModel().getSelectedItem();
        if (selectedExpense == null) {
            messageLabel.setText("Please select an expense to edit.");
            return;
        }

        // Get new values from the text fields
        String newDescription = descriptionField.getText();
        String newAmountText = amountField.getText();

        if (newDescription.isEmpty() || newAmountText.isEmpty()) {
            messageLabel.setText("Please fill in both fields to edit the expense.");
            return;
        }

        try {
            double newAmount = Double.parseDouble(newAmountText);

            // Update the selected expense
            selectedExpense.setDescription(newDescription);
            selectedExpense.setAmount(newAmount);

            // Refresh the table view to show the updated data
            expenseTable.refresh();

            messageLabel.setText("Expense updated.");
            // Optionally, clear the text fields after editing
            descriptionField.clear();
            amountField.clear();
        } catch (NumberFormatException e) {
            messageLabel.setText("Invalid input. Please enter a valid number for amount.");
        }
    }



    public void handleAddExpense() {
        String description = descriptionField.getText();
        String amountText = amountField.getText();

        if (description.isEmpty()  || amountText.isEmpty() ) {
            messageLabel.setText("Please Fill in Both Fields!");
            return;
        }


        try {
        double amount = Double.parseDouble(amountText);
        Expense expense = new Expense(description, amount);
        expenseList.add(expense);
        messageLabel.setText("Added expense: " + description + " - $" + amount);

        //Clear field for next entry
            descriptionField.clear();
            amountField.clear();
        } catch (NumberFormatException  e) {
            messageLabel.setText("Invalid input please enter a number!");
        }
    }
    @FXML
    private void handleDeleteExpense() {
        // Get the selected expense
        Expense selectedExpense = expenseTable.getSelectionModel().getSelectedItem();
        if (selectedExpense != null) {
            expenseList.remove(selectedExpense);
            messageLabel.setText("Expense deleted.");
        } else {
            messageLabel.setText("Please select an expense to delete.");
        }
    }
    @FXML
    private void handleSaveExpenses() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            // Write a header (optional)
            writer.write("description,amount");
            writer.newLine();
            // Write each expense to the file
            for (Expense expense : expenseList) {
                writer.write(expense.getDescription() + "," + expense.getAmount());
                writer.newLine();
            }
            messageLabel.setText("Expenses saved successfully.");
        } catch (IOException e) {
            messageLabel.setText("Error saving expenses: " + e.getMessage());
        }
    }


    @FXML
    private void handleLoadExpenses() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            // Clear the current list
            expenseList.clear();
            String line;
            // Skip header
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String description = parts[0];
                    double amount = Double.parseDouble(parts[1]);
                    Expense expense = new Expense(description, amount);
                    expenseList.add(expense);
                }
            }
            messageLabel.setText("Expenses loaded successfully.");
        } catch (IOException | NumberFormatException e) {
            messageLabel.setText("Error loading expenses: " + e.getMessage());
        }
    }
    private void updateTotal() {
        double total = expenseList.stream().mapToDouble(Expense::getAmount).sum();
        totalLabel.setText(String.format("Total Expense: $%.2f", total));
    }
}
