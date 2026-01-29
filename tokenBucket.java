
import java.util.*;

public class tokenBucket {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter token bucket capacity: ");
        int tokenCapacity = sc.nextInt();

        System.out.print("Enter token generation rate(tokens per unit time): ");
        int tokenRate = sc.nextInt();

        System.out.print("Enter the output rate(max packets that can be sent per unit time): ");
        int outputRate = sc.nextInt();

        System.out.print("Enter the number of packets: ");
        int numPackets = sc.nextInt();
        int[] packetSizes = new int[numPackets];

        System.out.println("Enter the packet sizes: ");
        for (int i = 0; i < numPackets; i++) {
            packetSizes[i] = sc.nextInt();
        }

        int tokens = 0;

        System.out.println("\nTime\tPacket\tTokens Before\tStatus\tTokens After");

        for (int t = 0; t < numPackets; t++) {
            tokens += tokenRate;
            if (tokens > tokenCapacity) {
                tokens = tokenCapacity;
            }

            int pkt = packetSizes[t];
            int tokensBefore = tokens;

            if (pkt <= tokens && pkt <= outputRate) {
                tokens -= pkt;

                System.out.println(t + "\t" + pkt + "\t" + tokensBefore + "\t\t\tAccepted" + "\t" + tokens);
            } else {
                System.out.println(t + "\t" + pkt + "\t" + tokensBefore + "\t\t\tDropped" + "\t" + tokens);
            }
        }
        sc.close();
    }
}
