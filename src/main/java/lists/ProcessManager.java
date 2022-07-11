package lists;

import lists.services.IOService;
import lists.services.IOServiceImpl;

public class ProcessManager {

    private IOService ioService = new IOServiceImpl();
    private WorkWithList workWithList = new WorkWithList();

    public ProcessManager() {

    }

    public void run(){
        createList();
        chooseOperation();
    }

    private void createList(){
        ioService.write("Введите строку цифр в формате 1,2,3...");
        workWithList.createList(ioService.read());
    }

    private void mainMenu(){
        ioService.write("Выберите операцию");
        ioService.write("1 добавить элемент в список");
        ioService.write("2 удалить элемент из списка");
        ioService.write("3 распечатать список");
        ioService.write("4 проверить есть ли значение в списке");
        ioService.write("5 заменить элемент в списке");
        ioService.write("0 для выхода");
    }

    private void chooseOperation(){
        mainMenu();
        int operation = workWithList.readInt(ioService.read());
        switch (operation) {
            case 0:
                break;
            case 1:
                add();
                break;
            case 2:
                remove();
                break;
            case 3:
                print();
                break;
            case 4:
                contain();
                break;
            case 5:
                set();
                break;
            default:
                ioService.write("Неизвестная команда");
                chooseOperation();
        }
    }

    private void add(){
        ioService.write("Введите новый элемент");
        workWithList.addMethod(ioService.read());
        chooseOperation();
    }

    private void remove(){
        ioService.write("Введите элемент для удаления");
        try{
            workWithList.removeMethod(ioService.read());
        } catch (Exception e) {
            ioService.write(e.getMessage());
        }
        chooseOperation();
    }

    private void print(){
        ioService.write("Ваш список");
        workWithList.printMethod();
        chooseOperation();
    }

    private void contain(){
        ioService.write("Введите элемент, который хотите проверить");
        workWithList.containsMethod(ioService.read());
        chooseOperation();
    }

    private void set(){
        ioService.write("Введите индекс заменяемого элемента");
        String index = ioService.read();
        ioService.write("Введите новый элемент");
        String str = ioService.read();
        try{
            workWithList.setMethod(index, str);
        }
        catch (Exception e) {
            ioService.write(e.getMessage());
        }
        chooseOperation();
    }

}
