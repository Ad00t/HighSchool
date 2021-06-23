/*
. . . I also tried writing this piece of code that takes attendance to make teachers'
jobs less tedious. I keep getting a null-pointer exception because of the last for-loop
where I detect null values in an array with the participants list spread out to a list
with as many spaces as kids in the class.

Saarah Nazar
Period 5
*/
import java.util.*;

public class SNAttendance {

	public static void main(String[] args) {

		String[] names = {"kid", "other kid", "other random kid", "some other kiddo", "that ONE KID"};

		Scanner console = new Scanner(System.in);
		System.out.print("Enter number of students currently in class: ");
		int numOfParticipants = console.nextInt();
		System.out.println();

		String[] participants = new String[numOfParticipants];

		for (int b = 0; b < numOfParticipants; b++) {
			System.out.print("participant " + b + ": ");
			participants[b] = console.next();
		}
		console.close();

		// System.out.println("participants: " + participants);

		String[] newParticipants = new String[names.length];
		int[] newParticipantsIndices = new int[numOfParticipants];
		for (int i = 0; i < participants.length; i++) {
			for (int j = 0; j < names.length; j++) {
				if (participants[i] == names[j]) {
					newParticipants[i] = names[j];
					newParticipantsIndices[i] = j;
				}
			}
		}

		System.out.println(Arrays.toString(newParticipants));
		System.out.println(Arrays.toString(newParticipantsIndices));

		String[] absentKiddos = new String[names.length];
		for (int a = 0; a < newParticipants.length; a++) {
			if (newParticipants[a] == null) {
				absentKiddos[a] = names[a];
			}
		}

		System.out.println(absentKiddos.toString());
	}
}

/*
Exception in thread "main" java.lang.NullPointerException
	at SNAttendance.main(SNAttendance.java:45)
*/