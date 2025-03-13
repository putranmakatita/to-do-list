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

    // Konstruktor untuk inisialisasi daftar to do
    public ToDoList() {
        tasks = new ArrayList<>();
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

    // Fungsi untuk mencari indeks to do dalam daftar
    public int findTaskIndex(String task) {
        return tasks.indexOf(task);
    }

    // Fungsi untuk menampilkan semua to do dalam daftar
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

    public static void main(String[] args) {
        ToDoList todoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // Menampilkan menu utama
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Find Task Index");
            System.out.println("4. Display Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = 0;
            try{
                choice = scanner.nextInt();
            }catch (Exception e){
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
                    // Menghapus to do
                    System.out.print("Enter task to delete: ");
                    String deleteTask = scanner.nextLine();
                    todoList.deleteTask(deleteTask);
                    break;
                case 3:
                    // Mencari indeks to do
                    System.out.print("Enter task to find: ");
                    String findTask = scanner.nextLine();
                    int index = todoList.findTaskIndex(findTask);
                    if (index != -1) {
                        System.out.println("Task found at index: " + index);
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 4:
                    // Menampilkan daftar to do
                    todoList.displayTasks();
                    break;
                case 5:
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
