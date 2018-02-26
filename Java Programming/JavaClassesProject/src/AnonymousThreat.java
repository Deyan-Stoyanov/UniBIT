import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String words = scanner.nextLine();
        String[] data = words.split("\\s+");
        ArrayList<String> input = new ArrayList<>();
        input.addAll(Arrays.asList(data));
        while (true){
            String command = scanner.nextLine();
            if(command.equals("3:1")){
                break;
            }
            String[] toDo = command.split("\\s+");
            switch (toDo[0]){
                case "merge":
                    int startIndex = Integer.parseInt(toDo[1]);
                    int endIndex = Integer.parseInt(toDo[2]);
                    StringBuilder concatenatedStr = new StringBuilder();
                    int count = 0;
                    if (startIndex > input.size()) {
                        continue;
                    }
                    for (int i = Math.max(0, startIndex); i <= Math.min(endIndex, input.size() - 1); i++) {
                        concatenatedStr.append(input.get(i));
                        count ++;
                    }
                    input.add(Math.max(0, startIndex), concatenatedStr.toString());
                    int k = Math.max(1, startIndex + 1);
                    int n = Math.min(k + count, input.size());
                    for (int i = k; i < n; i++) {
                        input.remove(input.get(k));
                    }

                    break;
                case "divide":
                    int index = Integer.parseInt(toDo[1]);
                    int partitions = Integer.parseInt(toDo[2]);
                    if (partitions > input.get(index).length()) {
                        partitions = input.get(index).length();
                    }
                    int length = input.get(index).length() / partitions;
                    ArrayList<String> splittedStr = new ArrayList<>();
                    if (input.get(index).length() % partitions == 0) {
                        for (int i = 0; i < partitions; i++) {
                            splittedStr.add(input.get(index).substring(0, length));
                            input.set(index, input.get(index).substring(length));
                        }
                    }else{
                        int remainder = input.get(index).length() % partitions;
                        for (int i = 0; i < partitions; i++) {
                            if (i == partitions - 1) {
                                splittedStr.add(input.get(index).substring(0, length + remainder));
                                input.set(index, input.get(index).substring(length + remainder));
                            }
                            else {
                                splittedStr.add(input.get(index).substring(0, length));
                                input.set(index, input.get(index).substring(0, length));
                            }
                        }
                    }
                    input.remove(index);
                    int j = index;
                    for (String substring : splittedStr) {
                    input.add(j, substring);
                    j++;
                }
                break;
            }
        }
        for (String anInput : input) {
            System.out.print(anInput + " ");
        }
    }
}
