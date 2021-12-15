package pddurfubot.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import pddurfubot.exam.ExamQuestion;

public class DataBase {
    private static Configuration configuration;
    private static StandardServiceRegistryBuilder builder;
    private static SessionFactory sessionFactory;
    private static Session session;

    public static void initialise(){
        configuration = new Configuration().configure();
        configuration.setProperty("hibernate.connection.password",System.getenv("JDBC_DATABASE_USERNAME"));
        configuration.setProperty("hibernate.connection.username",System.getenv("JDBC_DATABASE_PASSWORD"));
        configuration.setProperty("hibernate.connection.url",System.getenv("JDBC_DATABASE_URL"));
        configuration.addAnnotatedClass(ExamQuestion.class);
        builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory =configuration.buildSessionFactory(builder.build());

    }

    public static void openSession(){
        session = sessionFactory.openSession();
    }

    public static void closeSession(){
        session.close();
    }

    public static ExamQuestion getExamQuestion(int id){
        Transaction transaction1 = session.beginTransaction();
        ExamQuestion examQuestion = session.find(ExamQuestion.class,id);
        transaction1.commit();
        return examQuestion;
    }

    public static Integer getVariantsCount(){
        return 1;
    }

    public static ExamQuestion[] getVariant(Integer variant){
        ExamQuestion[] questions = new ExamQuestion[20];
        for (int i = 0; i < 20; i++){
            questions[i] = DataBase.getExamQuestion(i+1);
        }
        return questions;
    }
}
