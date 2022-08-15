import java.util.*;

public class PileComputer {

    private Pile<String> instructions;
    private Pile<Integer> values;

    public PileComputer(String instructions){
        String [] splitedInstructions = instructions.split("\n");
        LinkedList<String> instructionList = new LinkedList<>(Arrays.asList(splitedInstructions));
        Collections.reverse(instructionList);
        this.instructions = new Pile<>(instructionList);
        this.values = new Pile<>(new ArrayList<>());
    }


    public Integer execute(){
        String instruction = instructions.pop();
        Integer first_value;
        Integer second_value;
        Integer result;

        while (instruction != null){
            String [] splitedInstruction = instruction.split(" ");
            switch (splitedInstruction[0]){
                case "PUSH":
                    values.push(Integer.parseInt(splitedInstruction[1]));
                    break;
                case "MULT":
                    first_value = values.pop();
                    second_value = values.pop();
                    values.push(first_value*second_value);
                    break;
                case "SUM":
                    first_value = values.pop();
                    second_value = values.pop();
                    values.push(first_value+second_value);
                    break;
                case "SUB":
                    first_value = values.pop();
                    second_value = values.pop();
                    values.push(second_value/first_value);
                    break;
                case "DIV":
                    first_value = values.pop();
                    second_value = values.pop();
                    values.push(second_value/first_value);
                    break;
                case "PRINT":
                    return values.pop();
                default:
                    System.out.println("Instrucao nao reconhecida " + splitedInstruction[0]);
            }
            instruction = instructions.pop();
        }
    return null;
    }


}

class Pile<T> {

    private List<T> content;

    public Pile(List<T> content){
        this.content = content;
    }

    public T pop(){
        try {
            int size = content.size();
            if (size > 0) {
                T result = content.get(size-1);
                content.remove(size-1);
                return result;
            }
            return null;
        }catch (Exception e){
            System.out.println("Error poping caused by: "+e.getMessage());
            return null;
        }
    }

    public void push(T value){
        content.add(value);
    }
}
