package org.marcinski.todo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.marcinski.todo.model.Task;
import org.marcinski.todo.util.HibernateUtil;

import java.util.List;

public class TaskDao {

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void createTask(Task task){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.save(task);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Task> getAllTasks(){
        List<Task> tasks=null;
        try (Session session = sessionFactory.openSession()){
            String query = "SELECT s FROM Task s";
            tasks = session.createQuery(query).getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }

    public void deleteTask(Long id){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Task taskToRemove = session.find(Task.class, id);
            session.delete(taskToRemove);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
