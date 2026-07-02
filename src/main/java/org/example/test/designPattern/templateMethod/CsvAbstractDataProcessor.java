package org.example.test.designPattern.templateMethod;

public class CsvAbstractDataProcessor extends AbstractDataProcessor {
    @Override
    public void readData() {
        System.out.println("csv 파일을 읽음");
    }

    @Override
    public void processData() {
        System.out.println("csv 데이터를 처리함");
    }
}
