import java.util.ArrayList;
import java.util.List;

public class AOC {

    public static void main(String[] args) {

        ex_3();

    }

    public static void ex_1() {

    }

    public static void ex_2() {


    }

    public static void ex_3() {

        //int input = 325489;
        int input = 23;
        List<Ring> rings = new ArrayList<>();
        int ring = findRing(input, rings);
        System.out.println(input + " is on the ring number " + ring);

        for(int i = 0; i < rings.size(); i++) {
            System.out.print(rings.get(i).getId() + ":");
            for(int j = 0; j < rings.get(i).getNumbers().size(); j++) {
                System.out.print(" " + rings.get(i).getNumbers().get(j) + ",");
            }
            System.out.println(" ");
        }

        Ring ringObject = rings.get(ring-1);

        //find place of input in list<int> of ring object
        //determine on which side the number is
        //from there, navigate to the sides middle number
        //finally, go as many steps as the number of the ring the number currently is on


    }

    public static int findRing(int input, List<Ring> rings) {

        if(input == 1) return 1;

        int ring = 1;
        int factor = 3;
        int total = 1;
        int oldTotal = 1;

        List<Integer> first = new ArrayList<>();
        first.add(1);
        rings.add(new Ring(1, first));

        while (true) {
            oldTotal = total;
            ring++;
            total += 2*factor + 2*(factor-2);
            factor += 2;

            List<Integer> nums = new ArrayList<>();
            for(int i = oldTotal+1; i < total+1; i++) {
                nums.add(i);
            }

            rings.add(new Ring(ring, nums));

            if(input <= total) return ring;
        }

    }

    public static class Ring {

        private int id;
        private List<Integer> numbers;

        public Ring(int anId, List<Integer> nums) {
            this.id = anId;
            this.numbers = nums;
        }
        public List<Integer> getNumbers() {
            return this.numbers;
        }
        public int getId() {
            return this.id;
        }
    }
}
