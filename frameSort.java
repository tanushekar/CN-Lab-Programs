
import java.util.*;

class frameSort {

    static class Frame {

        String content;
        int fnum;

        Frame(int n, String s) {
            this.fnum = n;
            this.content = s;
        }
    }

    public static void sorting(int n, Frame[] F) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (F[j].fnum > F[j + 1].fnum) {

                    String s1 = F[j].content;
                    String s2 = F[j + 1].content;
                    int a = F[j].fnum, b = F[j + 1].fnum;

                    F[j].fnum = b;
                    F[j + 1].fnum = a;

                    F[j].content = s2;
                    F[j + 1].content = s1;

                }

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of frames: ");

        int n = sc.nextInt();

        System.out.println("Enter the frame details: ");

        Frame[] F = new Frame[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the frame number: ");
            int a = sc.nextInt();
            System.out.print("Enter the frame content: ");
            String b = sc.next();

            F[i] = new Frame(a, b);
        }

        List<Frame> frameList = new ArrayList<>(Arrays.asList(F));

        Collections.shuffle(frameList);

        F = frameList.toArray(new Frame[0]);

        System.out.println("\nBefore Sorting(Shuffled frames): ");
        for (int i = 0; i < n; i++) {
            System.out.print(F[i].content + " ");
        }

        sorting(n, F);

        System.out.println("\nAfter sorting the frames: ");
        for (int i = 0; i < n; i++) {
            System.out.print(F[i].content + " ");
        }
        System.out.println();

        sc.close();
    }
}
