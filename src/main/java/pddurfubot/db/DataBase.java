package pddurfubot.db;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import pddurfubot.exam.ExamQuestion;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class DataBase {
    private static Configuration configuration;
    private static StandardServiceRegistryBuilder builder;
    private static SessionFactory sessionFactory;
    public static Session session;

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

    public static ExamQuestion getExamQuestion(Integer variant, Integer questionNumber){
        Transaction transaction1 = session.beginTransaction();
        Criteria criteria = session.createCriteria(ExamQuestion.class);
        criteria.add(Restrictions.eq("examVariant",variant));
        criteria.add(Restrictions.eq("questionNumber", questionNumber));
        transaction1.commit();
        return (ExamQuestion) criteria.uniqueResult();
    }

    public static Long getVariantsCount(){
        Transaction transaction1 = session.beginTransaction();
        Query query = session.createQuery("SELECT COUNT(DISTINCT examVariant) FROM ExamQuestion");

        transaction1.commit();
        return (Long) query.uniqueResult();
    }

    public static ArrayList<ExamQuestion> getVariant(Integer variant){
        ArrayList<ExamQuestion> questions = new ArrayList<ExamQuestion>() ;
        Transaction transaction1 = session.beginTransaction();
        Criteria criteria = session.createCriteria(ExamQuestion.class);
        criteria.add(Restrictions.eq("examVariant",variant));
        questions = (ArrayList<ExamQuestion>) criteria.list();
        transaction1.commit();
        return questions;
    }
}
