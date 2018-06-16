package domain;

import bl.HibernateUtil;
import entity.AddressEntity;
import entity.EmployeeEntity;
import entity.ProjectEntity;
import org.hibernate.Session;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;


public class Domain {

    public static void main( String[] args )
    {

        try {
            Session session = HibernateUtil.getSession();

            session.beginTransaction();

            AddressEntity address = new AddressEntity();
            address.setCountry("DC");
            address.setCity("Gotham City");
            address.setStreet("Arkham street 1");
            address.setPostCode("0987");


            EmployeeEntity employee = new EmployeeEntity();
            employee.setFirstName("James");
            employee.setLastName("Gordon");

            Calendar calendar = Calendar.getInstance();
            calendar.set(1939, Calendar.MAY, 1);

            employee.setBirthday(new Date(calendar.getTime().getTime()));
            employee.setAddressId(address.getId());

            ProjectEntity project = new ProjectEntity();
            project.setTitle("5678");

           /* Set<ProjectEntity> projects = new HashSet<ProjectEntity>();
            projects.add(project);
            employee.setProjects(projects);*/

            session.save(address);
            session.save(employee);
            session.save(project);

            session.getTransaction().commit();
        } finally {
            HibernateUtil.shutdown();
        }
    }

}
