package com.cy.jmm;

import lombok.Getter;

public enum CountryEnum {
    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"韩"),FIVE(5,"赵"),SIX(6,"魏");
    @Getter private Integer retCode;
     @Getter  private String retMessage;

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }
    public static  CountryEnum forE(int index){
        CountryEnum[] values = CountryEnum.values();
        for (CountryEnum element : values) {
            if (index==element.getRetCode()){
                return  element;
            }
        }
        return  null;
    }
}
