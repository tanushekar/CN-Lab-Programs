
import java.util.*;

public class leakyBucket {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter bucket capacity: ");
        int bucketCapacity = sc.nextInt();

        System.out.print("Enter output rate (packets/sec): ");
        int outputRate = sc.nextInt();

        System.out.print("Enter the number of packets: ");
        int numPackets = sc.nextInt();

        int[] packetSizes = new int[numPackets];

        System.out.println("Enter the packet size: ");
        for (int i = 0; i < numPackets; i++) {
            packetSizes[i] = sc.nextInt();
        }

        int currentBucketSize = 0;

        System.out.println("\nPacket Size\tBucket Size\tSent\tRemaining\tStatus");

        for (int packetSize : packetSizes) {
            if (currentBucketSize + packetSize <= bucketCapacity) {
                currentBucketSize += packetSize;
                System.out.println(packetSize + "\t" + currentBucketSize + "\t" + Math.min(outputRate, currentBucketSize) + "\t" + Math.max(0, currentBucketSize - outputRate) + "\tAccepted");
            } else {
                System.out.println(packetSize + "\t" + currentBucketSize + "\t" + Math.min(outputRate, currentBucketSize) + "\t" + Math.max(0, currentBucketSize - outputRate) + "\tDropped");
            }

            currentBucketSize = Math.max(0, currentBucketSize - outputRate);
        }
        sc.close();
    }
}
