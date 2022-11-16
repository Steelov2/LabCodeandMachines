import java.util.*;
public class TwoMachines {
        public static int getByIndex(int i, Map<Integer, Integer> sortedValue) {
        Object listKeys = sortedValue.keySet().toArray()[i];
        return (int) listKeys;
    }
    public static Map<Integer,Integer> sortAscending(Map<Integer, Integer> unSortedMap){
        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();

        unSortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        return sortedMap;
    }
    public static Map<Integer,Integer> sortDescending(Map<Integer, Integer> unSortedMap){
        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();

        unSortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        return sortedMap;
    }

    public static void main(String[] args) {
        int N;
        int QCounter=0;
        int JCounter=0;

        Map<Integer, Integer> JShtr = new LinkedHashMap<>();
        Map<Integer, Integer> QShtr=new LinkedHashMap<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of details:");
        N = input.nextInt();
        Integer[] AFinal = new Integer[N];
        Integer[] BFinal = new Integer[N];
        Integer[] B = new Integer[N];
        Integer[] A = new Integer[N];
        System.out.println("Enter the elements of A:");
        for (int i = 0; i < N; i++) {
            A[i] = input.nextInt();
        }
        System.out.println("Enter the elements of B:");
        for (int i = 0; i < N; i++) {
            B[i] = input.nextInt();
        }
        for (int i = 0; i < N; i++) {
            if(A[i]<=B[i])
                JCounter++;
            else QCounter++;
        }
        ArrayList<Integer> J = new ArrayList<>();
        ArrayList<Integer> Q = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if(A[i]<=B[i])
                J.add(i+1);
            else
                Q.add(i+1);
        }
        System.out.println("J:\n" + J);
        System.out.println("Q:\n" + Q);


        for (int i = 0; i < N; i++) {
            if(A[i]<=B[i])
                JShtr.put(i+1,A[i]);
            else
                QShtr.put(i+1,B[i]);
        }
        LinkedHashMap<Integer, Integer> J1 = (LinkedHashMap<Integer, Integer>) sortAscending(JShtr);
        LinkedHashMap<Integer, Integer> Q1 = (LinkedHashMap<Integer, Integer>) sortDescending(QShtr);
        System.out.println("J*:\n"+J1.keySet());
        System.out.println("Q*:\n"+Q1.keySet());
        J1.putAll(Q1);
        System.out.println(J1);
        for (int i = 0; i < N; i++) {
            AFinal[i]=A[getByIndex(i,J1)-1];
        }
        for (int i = 1; i < N; i++) {
            AFinal[i]+=AFinal[i-1];
        }
        BFinal[0]=AFinal[0]+B[getByIndex(0,J1)-1];
        for (int i = 1; i < N; i++) {
            BFinal[i]=B[getByIndex(i,J1)-1];
        }
        for (int i = 1; i < N; i++) {
            BFinal[i]+=BFinal[i-1];
        }
        System.out.println(Arrays.toString(AFinal));
        System.out.println(Arrays.toString(BFinal));
    }
}
