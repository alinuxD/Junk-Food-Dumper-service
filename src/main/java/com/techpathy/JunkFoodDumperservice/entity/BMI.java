package com.techpathy.JunkFoodDumperservice.entity;

public class BMI {
    private final double height;
    private final double weight;
    private final double bmi;

    public BMI(double height, double weight, String hType, String wType){
//      Change from in to cm
        if (hType=="in"){
            height = height*2.54;
        }
//      Change from lb to kg
        if (wType=="lb"){
            weight = weight*0.45;
        }

        this.height = height;
        this.weight = weight;

        /* init BMI*/
        double bmi = weight / (height/100 * height/100);
        bmi = (double) Math.round(bmi * 10) / 10;
        this.bmi = bmi;
    }

    public double getBMI() {
        return bmi;
    }
}
