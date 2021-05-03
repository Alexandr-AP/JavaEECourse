package by.internetbanking.dao;

import by.internetbanking.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonJdbcDao implements PersonDao {



    public static void main(String[] args) {
        //Person person = new Person("Boba", 45);
        // new PersonJdbcDao().createPerson(person);
        //new PersonJdbcDao().deletePersonById(3);
        // new PersonJdbcDao().readPersonById(1);
       // new PersonJdbcDao().readAllPersons();
        //new PersonJdbcDao().createDefaultPerson();
    new PersonJdbcDao().createBase();

    }


    public void createDefaultPerson() {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Serh", 55));
        people.add(new Person("SUUUerh", 65));
        people.add(new Person("BaseUUUerh", 65));

        JdbcMysqlUtil jdbcMysqlUtil = new JdbcMysqlUtil();
        Connection connection = null;

        try {
            connection = jdbcMysqlUtil.getConnection();
            connection.setAutoCommit(false);
            String sql = "INSERT INTO `new_ferma`.`person` (`person_name`, `person_age`) VALUES (?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (Person person : people) {
                preparedStatement.setString(1, person.getName());
                preparedStatement.setInt(2, person.getAge());
                preparedStatement.execute();
            }
             connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            jdbcMysqlUtil.closeStatementAndConnection();
        }
    }

    @Override
    public void createPerson(Person person) {
        createPerson(person.getName(), person.getAge());
    }

    @Override
    public void createPerson(String name, int age) {

        JdbcMysqlUtil jdbcMysqlUtil = new JdbcMysqlUtil();
        Connection connection = null;

        try {
            connection = jdbcMysqlUtil.getConnection();
            connection.setAutoCommit(false);
            Statement statement = jdbcMysqlUtil.getStatement();

            String sql = "INSERT INTO `new_ferma`.`person` (`person_name`, `person_age`) VALUES ('" + name + "', '" + age + "');";
            statement.execute(sql);
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            jdbcMysqlUtil.closeStatementAndConnection();
        }
    }

    @Override
    public Person readPersonById(int id) {

        try (Connection connection = new JdbcMysqlUtil().getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM new_ferma.person where idperson=" + id;

            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {

                String personName = resultSet.getString("person_name");
                int personAge = resultSet.getInt(3);
                Person person = new Person(id, personName, personAge);
                return person;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Person> readAllPersons() {
        ArrayList<Person> people = new ArrayList<>();
        try (Connection connection = new JdbcMysqlUtil().getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM new_ferma.person";

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String personName = resultSet.getString("person_name");
                int personAge = resultSet.getInt(3);
                Person person = new Person(id, personName, personAge);
                people.add(person);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return people;
    }

    @Override
    public void updatePersonById(int id, String nameNew, int ageNew) {

        try (Connection connection = new JdbcMysqlUtil().getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "UPDATE `new_ferma`.`person` SET `person_name` = '" + nameNew + "', `person_age` = '" + ageNew + "' WHERE (`idperson` = '" + id + "');";
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public void updatePerson(Person personUpdated) {
        updatePersonById(personUpdated.getId(), personUpdated.getName(), personUpdated.getAge());
    }

    @Override
    public void deletePersonById(int id) {


        try (Connection connection = new JdbcMysqlUtil().getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "DELETE FROM `new_ferma`.`person` WHERE (`idperson` = '" + id + "')";
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void createBase () {

        JdbcMysqlUtil jdbcMysqlUtil = new JdbcMysqlUtil();
        Connection connection = null;

        try {
            connection= jdbcMysqlUtil.getConnection();
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            String sql= "CREATE TABLE developers " +
                    "(id INTEGER not NULL, " +
                    " name VARCHAR(50), " +
                    " specialty VARCHAR (50), " +
                    " salary INTEGER not NULL, " +
                    " PRIMARY KEY (id))";;
            statement.execute(sql);
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally { jdbcMysqlUtil.closeStatementAndConnection();
        }
    }
}

