package com.troot.dmstats;

import java.util.ArrayList;
import java.util.List;

public class Variables {

    private static List<String> monsterList = new ArrayList<>();
    private static List<Integer> healthList = new ArrayList<>();
    private static List<Integer> armourList = new ArrayList<>();

    public Variables(List<String> monsterList, List<Integer> healthList, List<Integer> armourList) {
        setMonsterList(monsterList);
        setHealthList(healthList);
        setArmourList(armourList);
    }


    public static List<String> getMonsterList() {
        return monsterList;
    }

    public static void setMonsterList(List<String> monsterListZero) {
        monsterList = monsterListZero;
    }

    public static List<Integer> getHealthList() {
        return healthList;
    }

    public static void setHealthList(List<Integer> healthListZero) {
        healthList = healthListZero;
    }

    public static List<Integer> getArmourList(){
        return armourList;
    }

    public static void setArmourList(List<Integer> armourListZero) {
        armourList = armourListZero;
    }
}
