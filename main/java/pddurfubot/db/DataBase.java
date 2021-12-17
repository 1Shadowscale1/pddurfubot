package pddurfubot.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import pddurfubot.exam.ExamQuestion;

import java.net.URI;
import java.net.URISyntaxException;

public class DataBase {
    private static Configuration configuration;
    private static StandardServiceRegistryBuilder builder;
    private static SessionFactory sessionFactory;
    private static Session session;

    public static void initialise() throws URISyntaxException {
        configuration = new Configuration().configure();
        URI dbUri = new URI(System.getenv("DATABASE_URL"));
        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        configuration.setProperty("hibernate.connection.password",password);
        configuration.setProperty("hibernate.connection.username",username);
        configuration.setProperty("hibernate.connection.url",dbUrl);

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
        for (int i = 0; i < 3; i++){
            questions[i] = DataBase.getExamQuestion(i+1);
        }
        return questions;
    }
}
