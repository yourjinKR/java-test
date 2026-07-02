package org.example.test.designPattern.templateMethod;

public abstract class AbstractDataProcessor implements DataProcessor {

    public final void process() {
        readData();
        processData();
        saveData();
    }

    public abstract void readData();
    public abstract void processData();

    public void saveData() {
        System.out.println("데이터를 저장함");
    }
}
