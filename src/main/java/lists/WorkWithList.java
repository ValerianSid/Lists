package lists;

import lists.services.IOService;
import lists.services.IOServiceImpl;

import java.util.ArrayList;

public class WorkWithList {

        ArrayList<Integer> workList = new ArrayList<>();
        private IOService ioService = new IOServiceImpl();

    public WorkWithList() {
        this.workList = workList;
    }

    public void createList(String str){
        String[] array = str.split(",");
        for (int i = 0; i < array.length; i++){
            workList.add(readInt(array[i]));
        }
    }
    public int readInt(String str){
        return Integer.parseInt(str);
    }

    public void addMethod(String str){
        workList.add(readInt(str));
    }
     public void removeMethod(String str){
        workList.remove(readInt(str));
     }

     public void printMethod(){
         System.out.println(workList);
     }

     public void containsMethod(String str){
        if (workList.contains(readInt(str))){
            ioService.write("Такое значение есть в списке");
        }
        else {
            ioService.write("Такого значения в списке нет");
        }
     }

     public void setMethod(String index, String str){
        workList.set(readInt(index), readInt(str));
     }
}
