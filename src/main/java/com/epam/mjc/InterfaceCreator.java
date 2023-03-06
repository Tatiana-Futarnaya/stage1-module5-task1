package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        Predicate<List<String>> isValues=x->{
           boolean result=false;
            for (String item: x) {
                if(!isDigit(item)){
                    if(item.substring(0,1).equals(item.substring(0,1).toUpperCase()) ){
                        result=true;
                    }
                }
                break;
            }
           return result;
        };

        return isValues;
    }

    public boolean isDigit(String s){
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> list = new ArrayList<>();
            for (Integer item : x) {
                if (item % 2 == 0) {
                    list.add(item);
                }
            }
            x.addAll(list);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return ()->{
            List<String> list=new ArrayList<>();
            for (String item: values) {
                if(Character.isUpperCase(item.charAt(0))
                        && item.split(" ").length>3
                        && item.endsWith(".")){
                    list.add(item);
                }
            }
            return list;
        };

    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x->{
            Map<String, Integer> map=new HashMap<>();
            for (String item: x){
                map.put(item, item.length());
            }
            return map;
        };

    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1,list2)->{
            List<Integer> list=new ArrayList<>();
            list.addAll(list1);
            list.addAll(list2);
            return list;
        };
    }
}
