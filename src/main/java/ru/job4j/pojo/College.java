package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Gizzyatov Marsel");
        student.setGroup("RT-56");
        student.setCreated(new Date());

        System.out.println(student.getName() + " study in group " + student.getGroup() + ". Date of receipt: "
            + student.getCreated());
    }
}
