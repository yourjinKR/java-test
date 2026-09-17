package org.example.test.transientz;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

public class StudentSecret implements Serializable {
    private String name;
    private String email;
    private transient int age;

    public StudentSecret(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Student{name='%s', email='%s', age='%s'}", name, email, age);
    }

    public static void main(String[] args) {
        StudentSecret student = new StudentSecret("유어진", "example@naver.com", 27);
        byte[] serializedStudent;

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(student);
                // serializedMember -> 직렬화된 member 객체
                serializedStudent = baos.toByteArray();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String encodedStudent = Base64.getEncoder().encodeToString(serializedStudent);
        System.out.println(encodedStudent);

        byte[] serializedMember = Base64.getDecoder().decode(encodedStudent);
        try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedMember)) {
            try (ObjectInputStream ois = new ObjectInputStream(bais)) {
                Object objectMember = ois.readObject();
                StudentSecret member = (StudentSecret) objectMember;
                System.out.println(member);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
