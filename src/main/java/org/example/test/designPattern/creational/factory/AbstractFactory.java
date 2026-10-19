package org.example.test.designPattern.creational.factory;

public class AbstractFactory {
    public static void main(String[] args) {
        process(new WarriorFactory());

        CharacterFactory wizardFactory = new CharacterFactory() {

            @Override
            public Job createJob() {
                return new Job() {
                    @Override
                    public void getName() {
                        System.out.println("마법사");
                    }
                };
            }

            @Override
            public Weapon createWeapon() {
                return new Weapon() {
                    @Override
                    public void attack() {
                        System.out.println("주문을 발동함");
                    }
                };
            }

            @Override
            public Mount createMount() {
                return new Mount() {
                    @Override
                    public void ride() {
                        System.out.println("소환수를 탐");
                    }
                };
            }
        };

        process(wizardFactory);
    }

    static public void process(CharacterFactory factory) {
        Job job = factory.createJob();
        Weapon weapon = factory.createWeapon();
        Mount mount = factory.createMount();
        job.getName();
        weapon.attack();
        mount.ride();
    }
}

interface Job {
    public void getName();
}

interface Weapon {
    public void attack();
}

interface Mount {
    public void ride();
}

class Warrior implements Job {
    @Override
    public void getName() {
        System.out.println("전사");
    }
}

class Sword implements Weapon {
    @Override
    public void attack() {
        System.out.println("검을 휘두름");
    }
}

class Horse implements Mount {
    @Override
    public void ride() {
        System.out.println("말을 탐");
    }
}

interface CharacterFactory {
    public Job createJob();
    public Weapon createWeapon();
    public Mount createMount();
}

class WarriorFactory implements CharacterFactory {
    @Override
    public Job createJob() {
        return new Warrior();
    }

    @Override
    public Weapon createWeapon() {
        return new Sword();
    }

    @Override
    public Mount createMount() {
        return new Horse();
    }
}