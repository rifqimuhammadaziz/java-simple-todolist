public class TodolistApp {

    public static String[] model = new String[10]; // 10 data array
    public static java.util.Scanner scanner = new java.util.Scanner(System.in); // input

    public static void main(String[] args) {
        testInput();
    }

    /**
     * Show all todo list
     */
    public static void showTodoList() {
        for (var i = 0; i <= model.length; i++) {
            var todo = model[i];
            var noTodo = i + 1;

            if (todo != null) {
                System.out.println(noTodo + ". " + todo);
            }
        }
    }

    public static void testShowTodoList() {
        model[0] = "Learning Java";
        model[1] = "Playing Dota2";
        showTodoList();
    }

    /**
     * Add/Save todo list
     */
    public static void addTodoList(String todo) {
        // RESIZE ARRAY LENGTH
        var isFull = true;
        for(int i = 0; i < model.length; i++) {
            // if found array[i] is empty
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        // if array isFull, rezise array 2x
        if (isFull) {
            var tempData = model; // var for old data
            model = new String[model.length * 2]; // create 2x size of old array

            // move old data to new array
            for (int i = 0; i < tempData.length; i++) {
                model[i] = tempData[i];
            }
        }

        // add data to null array
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        // will resize 2x (20, 40)
        for (int i = 0; i < 25; i++) {
            addTodoList("Test todo of - " + i);
        }

        showTodoList();
    }

    /**
     * Delete todo from list
     */
    public static boolean removeTodoList(Integer numberTodo) {
        // out of capacity of array
        if ((numberTodo - 1) >= model.length) {
            return false;
        } else if(model[numberTodo - 1] == null) {
            return false;
        } else {
            // remove data
            model[numberTodo - 1] = null;

            for (int i = (numberTodo - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(6);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine(); // read & save input
        return data;
    }

    public static void testInput() {
        var name = input("Nama");
        System.out.println("Hi " + name);

        var channel = input("Channel");
        System.out.println(channel);
    }

    /**
     * View of Show all todo list
     */
    public static void viewShowTodoList() {
        System.out.println("TodoList");
        showTodoList(); // show all todo list
        System.out.println("MENU");
        System.out.println("1. Add Todo");
        System.out.println("2. Remove");

        var input = input("Choose Menu");
        if (input.equals("1")) {
            viewAddTodoList();
        } else if (input.equals("2")) {
            viewRemoveTodoList();
        } else {
            System.out.println("Wrong input!");
        }
    }

    /**
     * View of Add/Save todo list
     */
    public static void viewAddTodoList() {
        while (true) {
            System.out.println("TodoList");
            showTodoList();
            System.out.println("MENU");
            System.out.println("1. Add Todo");
            System.out.println("2. Remove");
            System.out.println("3 . Exit");

            var input = input("Choose Menu");
            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("3")) {
                break;
            } else {
                System.out.println("Wrong input!");
            }
        }
    }

    /**
     * View of Delete todo list
     */
    public static void viewRemoveTodoList() {

    }
}
