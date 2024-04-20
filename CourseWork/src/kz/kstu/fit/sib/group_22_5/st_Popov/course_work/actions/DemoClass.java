package kz.kstu.fit.sib.group_22_5.st_Popov.course_work.actions;

import kz.kstu.fit.sib.group_22_5.st_Popov.course_work.help.Reporter;

import java.io.*;

public class DemoClass implements Serializable {
    private static final long serialVersionUID = 12345L; // UID поле
    private static int staticPrimitiveField; // поле примитивного типа static
    private transient String transientReferenceField; // ссылочное поле Transient
    private static final String staticStringField = "Статическая строка"; // статик строка

    public DemoClass(int staticPrimitiveField, String transientReferenceField) {
        DemoClass.staticPrimitiveField = staticPrimitiveField;
        this.transientReferenceField = transientReferenceField;
    }

    // метод для сериализации объекта
    public void serialize(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        }
    }

    // метод для десериализации объекта
    public static DemoClass deserialize(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (DemoClass) ois.readObject();
        }
    }

    public void report(Reporter reporter) {
        reporter.report("staticPrimitiveField: " + staticPrimitiveField);
        reporter.report("transientReferenceField: " + transientReferenceField); // null
        reporter.report("staticStringField: " + staticStringField);
        reporter.report("uid: " + serialVersionUID);
    }

    public static void demoSerialization(String filename, Reporter reporter) throws IOException, ClassNotFoundException {
        // Создание объекта
        DemoClass demoObject = new DemoClass(10, "Пример");

        // Сериализация объекта
        demoObject.serialize(filename);
        System.out.println(staticPrimitiveField);
        staticPrimitiveField = 9;
        // Десериализация объекта
        DemoClass deserializedObject = DemoClass.deserialize(filename);

        // Проверка значений с помощью Reporter
        deserializedObject.report(reporter);
    }
}
