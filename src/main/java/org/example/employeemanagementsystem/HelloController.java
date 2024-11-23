package org.example.employeemanagementsystem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class HelloController {

    @FXML
    private TextField inputField; // Поле для ввода (вместо нескольких отдельных полей)
    @FXML
    private Button addButton;
    @FXML
    private TableView<EmployeeData> tableView;
    @FXML
    private TableColumn<EmployeeData, String> nameColumn;
    @FXML
    private TableColumn<EmployeeData, String> typeColumn;
    @FXML
    private TableColumn<EmployeeData, Double> salaryColumn;

    private final ObservableList<EmployeeData> employees = FXCollections.observableArrayList();

    public void initialize() {
        // Настройка столбцов таблицы
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        typeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType()));
        salaryColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getSalary()).asObject());

        // Инициализация таблицы с пустыми данными
        tableView.setItems(employees);
    }

    @FXML
    private void handleAddEmployee() {
        try {
            // Получаем данные из текстового поля (разделенные запятой)
            String input = inputField.getText();
            String[] parts = input.split(",");

            if (parts.length != 3) {
                throw new IllegalArgumentException("Пожалуйста, введите имя, тип и зарплату, разделенные запятой.");
            }

            String name = parts[0].trim();
            String type = parts[1].trim();
            double salary = Double.parseDouble(parts[2].trim());

            // Создаем нового сотрудника
            EmployeeData employee = new EmployeeData(name, type, salary);

            // Добавляем сотрудника в таблицу
            employees.add(employee);

            // Очищаем поле ввода
            inputField.clear();
        } catch (Exception e) {
            showAlert("Ошибка", "Неверный ввод. Пожалуйста, введите данные в формате: имя, тип, зарплата.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
