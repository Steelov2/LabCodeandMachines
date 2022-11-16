import java.util.*;
import static java.util.stream.Collectors.toMap;
public class OneMachine {
    public static int getByIndex(int i, HashMap<Integer, Double> sortedValue) {
        Object listKeys = sortedValue.keySet().toArray()[i];
        return (int) listKeys;
    }
    public static void main(String[] args) {
        HashMap<Integer, Double> dividedValue = new HashMap<>();
        HashMap<Integer, Double> sortedValue;
        int N;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of details:");
        N = input.nextInt();
        Integer[] T = new Integer[N];
        Integer[] A = new Integer[N];
        Integer[] sumT = new Integer[N];
        Integer[] sumA = new Integer[N];
        System.out.println("Enter the elements of T:");
        for (int i = 0; i < N; i++) {
            T[i] = input.nextInt();
        }
        System.out.println("Enter the elements of A:");
        for (int i = 0; i < N; i++) {
            A[i] = input.nextInt();
        }
        for (int i = 0; i < N; i++) {
            dividedValue.put(i, (double) A[i] / (double) T[i]);
        }
        System.out.println(dividedValue);
        sortedValue = dividedValue
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                        LinkedHashMap::new));
        System.out.println(sortedValue);
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sumT[i] = T[getByIndex(i, sortedValue)];
        }
        for (int i = 1; i < N; i++) {
            sumT[i] += sumT[i - 1];
        }
        for (int i = 0; i < N; i++) {
            sumA[i] = A[getByIndex(i, sortedValue)];
        }
//        System.out.println(Arrays.toString(sumT));
//        System.out.println(Arrays.toString(sumA));
        for (int i = 1; i < N; i++) {
            sum += sumT[i - 1] * sumA[i];
        }
        System.out.println(sum);
    }
}
