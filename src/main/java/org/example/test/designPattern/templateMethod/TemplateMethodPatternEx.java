package org.example.test.designPattern.templateMethod;

import java.util.List;

public class TemplateMethodPatternEx {
    public static void main(String[] args) {
        List<AbstractDataProcessor> abstractDataProcessors = List.of(
                new CsvAbstractDataProcessor(),
                new JsonAbstractDataProcessor()
        );

        abstractDataProcessors.forEach(AbstractDataProcessor::process);

        /*

        csv 파일을 읽음
        csv 데이터를 처리함
        데이터를 저장함
        json 파일 읽음
        json 파일을 처리함
        데이터를 저장함

         */
    }
}


