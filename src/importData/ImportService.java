package importData;

import Dao.*;
import Model.*;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ImportService {

    public static void main(String[] args) throws Exception{
        importOrder();
    }
    public static void importService() throws Exception{
        FileReader reader = new FileReader("C:\\Users\\nick\\Desktop\\ws\\lab\\St2\\src\\importData\\services.txt");
        BufferedReader reader1 = new BufferedReader(reader);
        String str = " ";
        while ((str = reader1.readLine()) != null){
            String arr[] = str.split(",");
            int code = Integer.parseInt(arr[0]);
            String name = arr[1];
            Double cost = Double.parseDouble(arr[2]);
            System.out.println(code + "," + name + "," + cost + ", 1, 1");
            ServiceDao serviceDao = new ServiceDao();
            Service service = new Service(code, name, cost);
            serviceDao.create(service);
        }
    }
    public static void importEmployee() throws Exception{
        FileReader reader = new FileReader("C:\\Users\\nick\\Desktop\\ws\\lab\\St2\\src\\importData\\users.txt");
        BufferedReader reader1 = new BufferedReader(reader);
        String str = " ";
        while ((str = reader1.readLine()) != null){
            String arr[] = str.split(",");
            int id = Integer.parseInt(arr[0]);
            String fname = arr[1].split(" ")[0];
            String sname = arr[1].split(" ")[1];
            String login = arr[2];
            String passowrd = arr[3];
            String ip = arr[4];
            int year = Integer.parseInt(arr[5].split("/")[2]);
            int month = Integer.parseInt(arr[5].split("/")[1]);
            int day = Integer.parseInt(arr[5].split("/")[0]);
            Date lastenter = new Date(year, month, day);
            List<Service> services = new ArrayList<>();
            for(int i = 0; 6+ i < arr.length - 2; i++){
                int code = Integer.parseInt(arr[6 + i].split(":")[1].split("}")[0]);
                System.out.println(id + " " + code);
                ServiceDao serviceDao = new ServiceDao();
                services.add(serviceDao.getByCode(code));
            }
            User user = new User( id, login, passowrd, fname, sname, ip);
            Employee employee = new Employee(id, "Explorer", lastenter, user, services);
            EmployeeDao employeeDao = new EmployeeDao();
            employeeDao.create(employee);
        }
    }
    public static void importPatients() throws Exception {
        File file = new File("C:\\Users\\nick\\Desktop\\St2-master\\src\\importData\\patients.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        var nodes = document.getElementsByTagName("record");

        for (int i = 0; i < nodes.getLength(); i++) {
            String fname = nodes.item(i).getChildNodes().item(0).getTextContent().split(" ")[0];
            String lname = nodes.item(i).getChildNodes().item(0).getTextContent().split(" ", 2)[1];

            String login = nodes.item(i).getChildNodes().item(1).getTextContent();
            String password = nodes.item(i).getChildNodes().item(2).getTextContent();
            String ip = nodes.item(i).getChildNodes().item(17).getTextContent();
            System.out.println(login + password);

            UserDao userDao = new UserDao();
            User user = new User(101 + i, login, password, fname, lname, ip);
            try{
                userDao.createUser(user);
            } catch (Exception e ){}

            String inn = nodes.item(i).getChildNodes().item(16).getTextContent();
            System.out.println(inn);
            String country = nodes.item(i).getChildNodes().item(13).getTextContent();
            String address = nodes.item(i).getChildNodes().item(15).getTextContent();
            String name = nodes.item(i).getChildNodes().item(14).getTextContent();
            String rs = nodes.item(i).getChildNodes().item(18).getTextContent();
            String bik = nodes.item(i).getChildNodes().item(19).getTextContent();

            InsuranceDao insuranceDao = new InsuranceDao();

            Insurance insurance = new Insurance(inn, name, bik, rs, country, address);

            try {
                if(insuranceDao.getByInn(inn) == null){
                    insuranceDao.create(insurance);
                }
            } catch (Exception e) {}

            String number = nodes.item(i).getChildNodes().item(5).getTextContent();
            String type = nodes.item(i).getChildNodes().item(7).getTextContent();

            SocialDao socialDao = new SocialDao();
            Social social = new Social(number, type, insurance);
            try {
                socialDao.create(social);
            } catch (Exception e) {}

            String guid = nodes.item(i).getChildNodes().item(3).getTextContent();
            String email = nodes.item(i).getChildNodes().item(4).getTextContent();
            String ein = nodes.item(i).getChildNodes().item(6).getTextContent();
            String pass_series = nodes.item(i).getChildNodes().item(9).getTextContent();
            String pass_number = nodes.item(i).getChildNodes().item(10).getTextContent();
            String ua = nodes.item(i).getChildNodes().item(20).getTextContent();
            String phone = nodes.item(i).getChildNodes().item(8).getTextContent();

            PatientDao patientDao = new PatientDao();
            Patient patient = new Patient(guid, user, social, ein, pass_series, pass_number, email, phone, ua);
            try {
                patientDao.create(patient);
            } catch (Exception e) {}
            System.out.println(i + " "+ email);
        }
    }
    public static void importBlood() throws Exception{
        File file = new File("C:\\Users\\nick\\Desktop\\St2-master\\src\\importData\\blood.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        var nodes = document.getElementsByTagName("record");
        for (int i = 0; i < nodes.getLength(); i++){
            int id = Integer.parseInt(nodes.item(i).getChildNodes().item(0).getTextContent());

            int user_id = Integer.parseInt(nodes.item(i).getChildNodes().item(1).getTextContent());
            user_id = user_id + 100;
            String barcode = nodes.item(i).getChildNodes().item(2).getTextContent();
            Date date =  new Date(Long.parseLong(nodes.item(i).getChildNodes().item(3).getTextContent()));
            System.out.println(date + " " + barcode);
            PatientDao patientDao = new PatientDao();
            Patient patient = null;
            try {
                patient = patientDao.getByUserId(user_id);
            } catch (Exception e){}

            Blood blood = new Blood(id, patient , barcode, date);
            BloodDao bloodDao = new BloodDao();
            bloodDao.create(blood);
        }
    }
    public static void importOrder() throws Exception{
        File file = new File("C:\\Users\\nick\\Desktop\\St2-master\\src\\importData\\blood_services.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        var nodes = document.getElementsByTagName("record");
        for (int i = 0; i < nodes.getLength(); i++){
            Blood blood = null;
            BloodDao bloodDao = new BloodDao();
            blood = bloodDao.getOneById(Integer.parseInt(nodes.item(i).getChildNodes().item(0).getTextContent()));

            Service service = null;
            ServiceDao serviceDao = new ServiceDao();
            service = serviceDao.getByCode(Integer.parseInt(nodes.item(i).getChildNodes().item(1).getTextContent()));

            Double result = Double.parseDouble(nodes.item(i).getChildNodes().item(2).getTextContent());
            Date date =  new Date(Long.parseLong(nodes.item(i).getChildNodes().item(3).getTextContent()));
            Boolean status = Boolean.getBoolean( nodes.item(i).getChildNodes().item(4).getTextContent());
            String serviceStatus = nodes.item(i).getChildNodes().item(5).getTextContent();
            String analyzer = nodes.item(i).getChildNodes().item(6).getTextContent();
            EmployeeDao employeeDao = new EmployeeDao();
            Employee employee = null;
            employee = employeeDao.getOneById(Integer.parseInt(nodes.item(i).getChildNodes().item(7).getTextContent()));

            OrderDao orderDao = new OrderDao();
            Order order = new Order(i, blood, employee, service, serviceStatus, status, result, analyzer);
            orderDao.create(order);

        }
    }
}
