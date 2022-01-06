public class TodolistApp {

    public static String[] model = new String[10]; // 10 data array

    public static void main(String[] args) {
        testAddTodoList();
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
    public static void removeTodoList() {

    }

    /**
     * View of Show all todo list
     */
    public static void viewShowTodoList() {

    }

    /**
     * View of Add/Save todo list
     */
    public static void viewAddTodoList() {

    }

    /**
     * View of Delete todo list
     */
    public static void viewRemoveTodoList() {

    }
}
