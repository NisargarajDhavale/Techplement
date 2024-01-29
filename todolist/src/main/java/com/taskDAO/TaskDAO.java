package com.taskDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.todolist.Task;

import java.util.List;

public class TaskDAO {
 private final SessionFactory sessionFactory;

 public TaskDAO(SessionFactory sessionFactory) {
     this.sessionFactory = sessionFactory;
 }

 public void addTask(Task task) {
     try (Session session = sessionFactory.openSession()) {
         Transaction transaction = session.beginTransaction();
         session.save(task);
         transaction.commit();
     }
 }

 public Task getTaskById(Long taskId) {
     try (Session session = sessionFactory.openSession()) {
         return session.get(Task.class, taskId);
     }
 }

 public void updateTask(Task updatedTask) {
     try (Session session = sessionFactory.openSession()) {
         Transaction transaction = session.beginTransaction();
         session.update(updatedTask);
         transaction.commit();
     }
 }

 public void deleteTask(Long taskId) {
     try (Session session = sessionFactory.openSession()) {
         Transaction transaction = session.beginTransaction();
         Task taskToDelete = session.get(Task.class, taskId);
         if (taskToDelete != null) {
             session.delete(taskToDelete);
         }
         transaction.commit();
     }
 }

 public List<Task> getAllTasks() {
     try (Session session = sessionFactory.openSession()) {
         return session.createQuery("FROM Task", Task.class).list();
     }
 }
 
}
