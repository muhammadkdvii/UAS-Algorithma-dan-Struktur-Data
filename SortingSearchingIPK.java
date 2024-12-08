import java.util.Scanner;

class Student {
    String name;
    double ipk;

    // Constructor
    Student(String name, double ipk) {
        this.name = name;
        this.ipk = ipk;
    }
}

public class SortingSearchingIPK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input jumlah mahasiswa
        System.out.print("Jumlah mahasiswa Vokasi UB: ");
        int jumlahMahasiswa = scanner.nextInt();
        scanner.nextLine();

        Student[] students = new Student[jumlahMahasiswa];

        // Input Nama dan IPK
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println((i + 1) + "). ");
            System.out.print("Nama Mahasiswa : ");
            String name = scanner.nextLine();

            System.out.print("Nilai IPK: ");
            double ipk = scanner.nextDouble();
            scanner.nextLine(); // Clear the buffer

            students[i] = new Student(name, ipk);
        }
        // Sorting Bubble Sort IPK
        for (int i = 0; i < jumlahMahasiswa - 1; i++) {
            for (int j = 0; j < jumlahMahasiswa - i - 1; j++) {
                if (students[j].ipk < students[j + 1].ipk) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        // Output Urutan IPK Mahasiswa
        System.out.println("\nUrutan IPK Mahasiswa :");
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("Nama: " + students[i].name + " dengan IPK: " + students[i].ipk);
        }

        // Searching IPK berdasarkan Nama
        System.out.print("\nMasukan Nama Mahasiswa : ");
        String searchName = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < jumlahMahasiswa; i++) {
            if (students[i].name.equalsIgnoreCase(searchName)) {
                System.out.println("IPK dari " + searchName + " adalah: " + students[i].ipk);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Nama mahasiswa " + searchName + " tidak ditemukan.");
        }

        scanner.close();
    }
}
