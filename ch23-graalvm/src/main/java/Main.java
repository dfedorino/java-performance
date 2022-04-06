import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;


public class Main {
	
public static boolean isPrime(long testNumber) {
		long maxToCheck =  (long) Math.sqrt(testNumber);
		for (long i = 2; i < maxToCheck; i++) {
			if (testNumber % i == 0) return false;
		}
		return true;
	}

public static void main(String[] args) throws InterruptedException {
		
		long start = System.currentTimeMillis(); 

		List<UUID> uuids = new ArrayList<UUID>();
		for (int i = 0; i < 500000; i++) {
			uuids.add(UUID.randomUUID());
		}
		
		System.out.println("UUIDs generated");
		
		//extract the integer parts - using a set to avoid duplicates
		Set<Long> numbersFromUUIDs = new HashSet<Long>();
		for (UUID uuid : uuids) {
			String numberFromUuid = uuid.toString().replaceAll("[^0-9]", "");
			if (numberFromUuid.length() > 9) {
				numberFromUuid = numberFromUuid.substring(0,9);
			}
			numbersFromUUIDs.add(Long.parseLong(numberFromUuid));
		}
		
		System.out.println("Integers generated");
		
		//find the primes
		List<Long> primes = new ArrayList<Long>();
		for (Long l : numbersFromUUIDs) {
			if (isPrime(l)) {
				primes.add(l);
			}
		}
		
		System.out.println(primes.size() + " primes found.");
		
		System.out.println("The largest prime was " + Collections.max(primes));
		
		long stop = System.currentTimeMillis();
		System.out.println("time taken : " + (stop - start) + " ms.");
	}

//	"C:\Program Files\Java\jdk1.8.0_231\bin\java.exe"
//	UUIDs generated
//	Integers generated
//	20277 primes found.
//	The largest prime was 999900647
//	time taken : 5848 ms.

//	"C:\Program Files\graalvm-ce-java11-22.0.0.2\bin\java.exe"
//	UUIDs generated
//	Integers generated
//	19992 primes found.
//	The largest prime was 999988547
//	time taken : 5487 ms.

}

