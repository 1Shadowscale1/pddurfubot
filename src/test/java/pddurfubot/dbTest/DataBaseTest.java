package pddurfubot.dbTest;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pddurfubot.db.DataBase;

import java.net.URISyntaxException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DataBaseTest {

    @BeforeAll
    public static void initDB() throws URISyntaxException {
        DataBase.initialise();
        DataBase.openSession();
    }

    @AfterAll
    public static void closeSession(){
        DataBase.closeSession();
    }

    @Test
    public void envTest(){
        assertNotEquals(null,System.getenv("DATABASE_URL"));
    }

    @Test
    public void notVoidQuestionTextCellsTest(){
        Transaction transaction = DataBase.session.beginTransaction();
        Query query = DataBase.session.createQuery("from ExamQuestion where questionText is null");
        transaction.commit();
        assertTrue(query.list().isEmpty());
    }

    @Test
    public void notVoidExamVariantCellsTest(){
        Transaction transaction = DataBase.session.beginTransaction();
        Query query = DataBase.session.createQuery("from ExamQuestion where examVariant is null");
        transaction.commit();
        assertTrue(query.list().isEmpty());
    }

    @Test
    public void notVoidQuestionNumberCellsTest(){
        Transaction transaction = DataBase.session.beginTransaction();
        Query query = DataBase.session.createQuery("from ExamQuestion where questionNumber is null");
        transaction.commit();
        assertTrue(query.list().isEmpty());
    }

}
