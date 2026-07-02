package org.example.test.designPattern.templateMethod;

public class JsonAbstractDataProcessor extends AbstractDataProcessor {
    @Override
    public void readData() {
        System.out.println("json 파일 읽음");
    }

    @Override
    public void processData() {
        System.out.println("json 파일을 처리함");
    }
}
