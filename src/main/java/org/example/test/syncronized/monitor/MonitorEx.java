package org.example.test.syncronized.monitor;

public class MonitorEx {
    public static void main(String[] args) throws InterruptedException {
        MessageBuffer messageBuffer = new MessageBuffer();

    }
}

class MessageBuffer {
    private String message;
    private boolean isEmpty = true;

    // synchronized: 모니터 영역 선언 (한 번에 한 스레드만 진입 가능)
    public synchronized void produce(String msg) throws InterruptedException {
        // 조건 확인 (while 루프 사용은 필수적인 안전 수칙입니다)
        while (!isEmpty) {
            wait(); // 버퍼가 차있으면 락을 반환하고 대기실로 이동
        }

        this.message = msg;
        this.isEmpty = false;
        System.out.println("생성 완료: " + msg);

        notifyAll(); // 대기실에서 기다리는 소비자 스레드들을 모두 깨움
    }

    // synchronized: 동일한 객체의 모니터 락을 공유함
    public synchronized String consume() throws InterruptedException {
        while (isEmpty) {
            wait(); // 버퍼가 비어있으면 락을 반환하고 대기실로 이동
        }

        String msg = this.message;
        this.isEmpty = true;
        System.out.println("소비 완료: " + msg);

        notifyAll(); // 버퍼가 비었으니 생성자 스레드들을 깨움
        return msg;
    }
}