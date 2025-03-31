/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.todolist;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Putra Nurhuda Makatita
 */
public class ToDoList {

    private ArrayList<String> tasks;
    private static Scanner scanner = new Scanner(System.in);

    // Konstruktor untuk inisialisasi daftar to do
    public ToDoList() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Fungsi untuk menambah to do ke daftar
    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    // Fungsi untuk menghapus to do dari daftar
    public void deleteTask(String task) {
        if (tasks.contains(task)) {
            tasks.remove(task);
            System.out.println("Task deleted: " + task);
        } else {
            System.out.println("Task not found.");
        }
    }

    // Fungsi untuk mencari indeks to do dalam daftar (Rekursif)
    public int findTaskIndex(String task, int idx) {
        if (idx >= tasks.size() || tasks.get(idx).equals(task)) {
            return idx >= tasks.size() ? -1 : idx + 1; // index yang ditemukan perlu ditambahkan 1 karena
                                                       // dimulai dari 0
        }

        return findTaskIndex(task, idx + 1);
    }

    // Fungsi untuk menampilkan semua to do dalam daftar (Read all)
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("To-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // Fungsi untuk menampilkan to do dalam daftar berdasarkan index (Read all)
    public String displayTaskByIdx(int idx) {
        idx = idx - 1; // harus dikurangi satu dulu karena index array dimulai dari 0 sedangkan user
                       // dimulai dari 1
        return idx >= tasks.size() || idx < 0 ? "Task is not found" : tasks.get(idx);
    }

    // Fungsi untuk menampilkan to do dalam daftar berdasarkan index (Read all)
    public String updateTask(int idx) {
        idx = idx - 1; // harus dikurangi satu dulu karena index array dimulai dari 0 sedangkan user
                       // dimulai dari 1
        // validasi jika index yang diinputkan user keluar dari index array
        if (idx >= tasks.size() || idx < 0) {
            return "Task is not found";
        }
        String oldTask = tasks.get(idx);

        System.out.print("Enter new task: ");
        String newTask = scanner.nextLine();

        tasks.set(idx, newTask);
        return "Task is updated: " + oldTask + " to " + newTask;
    }

    public static void main(String[] args) {
        ToDoList todoList = new ToDoList();

        while (true) {
            // Menampilkan menu utama
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Find Task Index");
            System.out.println("5. Display Task by Index");
            System.out.println("6. Display Tasks");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Please, only a number!");
            }

            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Menambahkan to do
                    System.out.print("Enter task: ");
                    String task = scanner.nextLine();
                    todoList.addTask(task);
                    break;
                case 2:
                    // Menyunting to do
                    try {
                        System.out.print("Enter task index: ");
                        int taskIdx = scanner.nextInt();
                        scanner.nextLine(); // untuk transisi dari nextInt() ke nextLine()
                        System.out.println(todoList.updateTask(taskIdx));
                    } catch (Exception e) {
                        System.out.println("Please, only a number!");
                    }
                    break;
                case 3:
                    // Menghapus to do
                    System.out.print("Enter task to delete: ");
                    String deleteTask = scanner.nextLine();
                    todoList.deleteTask(deleteTask);
                    break;
                case 4:
                    // Mencari indeks to do
                    System.out.print("Enter task to find: ");
                    String findTask = scanner.nextLine();
                    int index = todoList.findTaskIndex(findTask, 0);
                    if (index != -1) {
                        System.out.println("Task found at index: " + index);
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 5:
                    try {
                        System.out.print("Enter task index: ");
                        int taskIdx = scanner.nextInt();
                        System.out.println(todoList.displayTaskByIdx(taskIdx));
                    } catch (Exception e) {
                        System.out.println("Please, only a number!");
                    }
                    break;
                case 6:
                    // Menampilkan daftar to do
                    todoList.displayTasks();
                    break;
                case 7:
                    // Keluar dari program
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
