package org.example.test.exceptionTest;

/*
여러 예외를 하나로 묶어서 다루기 위해
 */
public class ChainedException1 {
    public static void main(String[] args) {
        try {
            study();
        } catch (StudyException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static void study() throws StudyException {
        try {
            System.out.println("공부 시작");
            throw new PlayGameException("게임 하고 싶어서 피시방 감");
        } catch (PlayGameException e) {
            StudyException se = new StudyException("공부 중 예외 발생");
            se.initCause(e);
            throw se;
        }
    }
}


class StudyException extends Exception {

    public StudyException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        return super.initCause(cause);
    }
}

class PlayGameException extends Exception {

    public PlayGameException(String message) {
        super(message);
    }
}

class SleepException extends Exception {

    public SleepException(String message) {
        super(message);
    }
}