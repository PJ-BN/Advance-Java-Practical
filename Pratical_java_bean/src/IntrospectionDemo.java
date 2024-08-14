import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class IntrospectionDemo {
    public static void main(String[] args) {
        try {
            
            PersonBean person = new PersonBean();
            person.setFirstName("John");
            person.setLastName("Doe");
            person.setAge(30);

            
            BeanInfo beanInfo = Introspector.getBeanInfo(PersonBean.class);

            
            System.out.println("Properties:");
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                System.out.println("Property Name: " + propertyDescriptor.getName());
                System.out.println("Property Type: " + propertyDescriptor.getPropertyType());
                System.out.println("Read Method: " + propertyDescriptor.getReadMethod());
                System.out.println("Write Method: " + propertyDescriptor.getWriteMethod());
                System.out.println();
            }

            
            System.out.println("Methods:");
            MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
            for (MethodDescriptor methodDescriptor : methodDescriptors) {
                System.out.println("Method Name: " + methodDescriptor.getMethod().getName());
                System.out.println("Method: " + methodDescriptor.getMethod());
                System.out.println();
            }

            
            System.out.println("Events:");
            
            
            System.out.println("Dynamically setting and getting property values:");
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String propertyName = propertyDescriptor.getName();
                Method setter = propertyDescriptor.getWriteMethod();
                Method getter = propertyDescriptor.getReadMethod();

                if (setter != null && getter != null) {
                    if (propertyName.equals("firstName")) {
                        setter.invoke(person, "Jane");
                    } else if (propertyName.equals("lastName")) {
                        setter.invoke(person, "Smith");
                    } else if (propertyName.equals("age")) {
                        setter.invoke(person, 25);
                    }

                    
                    Object value = getter.invoke(person);
                    System.out.println(propertyName + ": " + value);
                }
            }

        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
