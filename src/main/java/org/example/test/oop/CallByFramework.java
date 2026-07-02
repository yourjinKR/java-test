package org.example.test.oop;

public class CallByFramework {
    public static void main(String[] args) {
        Version version = new Version2();
        version.setNickname("제한글자가 열글자 이상이면 부적절한 닉네임입니다");
        System.out.println(version.nickname);
    }
}


class Version {
    protected String nickname;

    public void setNickname(String nickname) {
        this.nickname = onSetNickName(nickname) ? nickname : "부적절한 닉네임";
    }

    protected boolean onSetNickName(String nickname) {
        return true;
    }
}

class Version2 extends Version {
    @Override
    protected boolean onSetNickName(String nickname) {
        return nickname.length() <= 10;
    }
}