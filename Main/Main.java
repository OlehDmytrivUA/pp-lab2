package Main;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Patient.Patient;

/**
 * Class Main with main method from which the execution of the program begins
 */
public class Main {
    /**
     * main method from which the execution of the program begins
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Patient> PatientsArray = new ArrayList<Patient>();
        Scanner scan = new Scanner(System.in);
        /*CreateArray(PatientsArray);
        PrintArray(PatientsArray);
        PrintPatientByDiagnosis(PatientsArray);
        PrintPatientByMedicalCard(PatientsArray);
        PrintPatientByPhoneNumber(PatientsArray);
        return;*/
        PatientsArray.add(new Patient(1234,"Stepanenko","Esfir","Hordyslavovych","Poltavsʹka oblastʹ, misto Poltava, prov. Volodymyrsʹka, 88","680982340",4692376,"alerhiya"));
        PatientsArray.add(new Patient(1431,"Bezotosnyy","Chernyn","Rostyslavovych","Dnipropetrovsʹka oblastʹ, misto Dnipro, vul. Prorizna, 02","971341434",3925023,"bronkhit"));
        PatientsArray.add(new Patient(4682,"Koshelʹ","Bratko","Bohuslavovych"," Ivano-Frankivsʹka oblastʹ, misto Ivano-Frankivsʹk, vul. Riznytsʹka, 13","982313232",2448332,"hryp"));
        PatientsArray.add(new Patient(1738,"Kryvonis","Yan","Kostyantynovych","Odesʹka oblastʹ, misto Odesa, vul. Lesi Ukrayinky, 47","679731322",1211290,"perelom kintsivky"));
        PatientsArray.add(new Patient(7093,"Vovk","Yaromyr","Antonovych","Poltavsʹka oblastʹ, misto Poltava, prov. Instytut·sʹka, 12","502240432",1092312,"hryp"));
        PatientsArray.add(new Patient(5993,"Zhytynsʹkyy","Odynetsʹ","Zhdanovych","Chernihivsʹka oblastʹ, misto Chernihiv, vul. I. Franka, 86","987248321",1342432,"alerhiya"));
        PatientsArray.add(new Patient(8473,"Kushchenko","Lyubovyr","Zoryanovych","Dnipropetrovsʹka oblastʹ, misto Dnipro, prov. Khreshchatyk, 20","504958234",6782423,"hryp"));
        PrintArray(PatientsArray);

        Task1(PatientsArray);
        Task2(PatientsArray);
        Task3(PatientsArray);
    }

    /**
     * Task1 method for the first laboratory task
     * @param array
     */
    private static void Task1(ArrayList<Patient> array){
        System.out.println("\n\nEnter Diagnosis you need: ");
        Scanner scan = new Scanner(System.in);
        String d = scan.nextLine();

        ArrayList<Patient> PatientsWithDiagnosis = PatientByDiagnosis(array, d);
        PrintArray(PatientsWithDiagnosis);
    }

    /**
     * Task2 method for the second laboratory task
     * @param array
     */
    private static void Task2(ArrayList<Patient> array){
        System.out.println("\n\nEnter Medical Card diapason:\n");
        Scanner scan = new Scanner(System.in);
        System.out.println("Min:");
        int min = scan.nextInt();
        System.out.println("Max:");
        int max = scan.nextInt();

        ArrayList<Patient> PatientsByMedCard = PatientByMedicalCard(array, min , max);
        PrintArray(PatientsByMedCard);
    }

    /**
     * Task3 method for the third laboratory task
     * @param array
     */
    private static void Task3(ArrayList<Patient> array){
        System.out.println("\n\nEnter first Phone number(0-9):\n");
        Scanner scan = new Scanner(System.in);
        String temp_first_phone_numb;
        String FirstNumb;
        Pattern pattern = Pattern.compile("\\d{1}");
        Matcher matcher;
        do{
            temp_first_phone_numb = scan.next();
            matcher = pattern.matcher(temp_first_phone_numb);
        }while(!matcher.matches());
        FirstNumb = temp_first_phone_numb;

        ArrayList<Patient> PatientsByFirstPhoneNumb = PatientByPhoneNumber(array, FirstNumb);
        PrintArray(PatientsByFirstPhoneNumb);
    }
    /**
     * CreateArray method that creates and fills with data from the keyboard an array of Patient objects
     * @param array list for Patient objects
     */
    private static void CreateArray(ArrayList<Patient> array) {
        System.out.println("\n\nEnter patient details, ending with any symbol in the Patient ID field:\n");
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^(\\d{3}[- .]?){2}\\d{4}$");
        Matcher matcher;

        int id;
        String last_name;
        String first_name;
        String middle_name;
        String address;
        String phone_number;
        String temp_phone;
        int med_card;
        String diagnosis;
        int x = 1;
        while (true)
        {
            System.out.println("Patient-" + x + " ID: ");
            if(!scan.hasNextInt()){
                scan.close();
                return;
            }
            id = scan.nextInt();
            System.out.println("Patient-" + x + " Last Name: ");
            last_name = scan.next();
            System.out.println("Patient-" + x + " First Name: ");
            first_name = scan.next();
            System.out.println("Patient-" + x + " Middle Name: ");
            middle_name = scan.next();
            System.out.println("Patient-" + x + " address: ");
            address = scan.nextLine();
            System.out.println("Patient-" + x + " phone number: ");
            do {
                temp_phone = scan.next();
                matcher = pattern.matcher(temp_phone);
            }while (!matcher.matches());
            phone_number = temp_phone;
            System.out.println("Patient-" + x + " med_card: ");
            med_card = scan.nextInt();
            System.out.println("Patient-" + x + " diagnosis: ");
            diagnosis = scan.nextLine();

            array.add(new Patient(id,last_name,first_name,middle_name,address,phone_number,med_card,diagnosis));
            x += 1;
        }
    }
    /**
     * PrintArray method that Print data of Patients Objects in array by toString method
     * @param array list of Patient objects
     */
    private static void PrintArray(ArrayList<Patient> array){
        for (Patient p : array) {
            System.out.println(array.indexOf(p)+". "+p);
        }
    }

    /**
     * PatientByDiagnosis method that create array and add Patient
     * if the diagnosis matches what you entered
     * @param array list of Patient objects
     * @return created array
     */
    private static ArrayList<Patient> PatientByDiagnosis(ArrayList<Patient> array, String diagnos){
        ArrayList<Patient> arrLocal= new ArrayList<Patient>();
        for (Patient p : array) {
            if(diagnos.equals(p.getDiagnosis())){
                arrLocal.add(p);
            }
        }
        return arrLocal;
    }

    /**
     * PatientByMedicalCard method that create array and add Patient
     * if the Medical card corresponds to the range you specified
     * @param array list of Patient objects
     * @return created array
     */
    private static ArrayList<Patient> PatientByMedicalCard(ArrayList<Patient> array, int min , int max){
        ArrayList<Patient> arrLocal= new ArrayList<Patient>();
        for (Patient p : array) {
            if(p.getMed_card()<max && p.getMed_card()>min){
                arrLocal.add(p);
            }
        }
        return arrLocal;
    }

    /**
     * PatientByPhoneNumber method that create array and add Patient
     * if the Phone Number field begin by number you entered
     * @param array list of Patient objects
     * @return created array
     */
    private static ArrayList<Patient> PatientByPhoneNumber(ArrayList<Patient> array, String FirstNumb) {
        ArrayList<Patient> arrLocal= new ArrayList<Patient>();
        for (Patient p : array) {
            if(FirstNumb.charAt(0) == p.getPhone_number().charAt(0)){
                arrLocal.add(p);
            }
        }
        return arrLocal;
    }

    }
































/*      arr[0]=new Patient(1234,"Степаненко","Есфір","Гордиславович","Полтавська область, місто Полтава, пров. Володимирська, 88","680982340",4692376,"алергія");
        arr[1]=new Patient(1431,"Безотосний","Чернин","Ростиславович","Дніпропетровська область, місто Дніпро, вул. Прорізна, 02","971341434",3925023,"бронхіт");
        arr[2]=new Patient(4682,"Кошель","Братко","Богуславович"," Івано-Франківська область, місто Івано-Франківськ, вул. Різницька, 13","982313232",2448332,"грип");
        arr[3]=new Patient(1738,"Кривоніс","Ян","Костянтинович","Одеська область, місто Одеса, вул. Лесі Українки, 47","679731322",1211290,"перелом кінцівки");
        arr[4]=new Patient(7093,"Вовк","Яромир","Антонович","Полтавська область, місто Полтава, пров. Інститутська, 12","502240432",1092312,"грип");
        arr[5]=new Patient(5993,"Житинський","Одинець","Жданович","Чернігівська область, місто Чернігів, вул. І. Франкa, 86","987248321",1342432,"алергія");
        arr[6]=new Patient(8473,"Кущенко","Любовир","Зорянович","Дніпропетровська область, місто Дніпро, пров. Хрещатик, 20","504958234",6782423,"грип");

        arr[0]=new Patient(1234,"Stepanenko","Esfir","Hordyslavovych","Poltavsʹka oblastʹ, misto Poltava, prov. Volodymyrsʹka, 88","680982340",4692376,"alerhiya");
        arr[1]=new Patient(1431,"Bezotosnyy","Chernyn","Rostyslavovych","Dnipropetrovsʹka oblastʹ, misto Dnipro, vul. Prorizna, 02","971341434",3925023,"bronkhit");
        arr[2]=new Patient(4682,"Koshelʹ","Bratko","Bohuslavovych"," Ivano-Frankivsʹka oblastʹ, misto Ivano-Frankivsʹk, vul. Riznytsʹka, 13","982313232",2448332,"hryp");
        arr[3]=new Patient(1738,"Kryvonis","Yan","Kostyantynovych","Odesʹka oblastʹ, misto Odesa, vul. Lesi Ukrayinky, 47","679731322",1211290,"perelom kintsivky");
        arr[4]=new Patient(7093,"Vovk","Yaromyr","Antonovych","Poltavsʹka oblastʹ, misto Poltava, prov. Instytut·sʹka, 12","502240432",1092312,"hryp");
        arr[5]=new Patient(5993,"Zhytynsʹkyy","Odynetsʹ","Zhdanovych","Chernihivsʹka oblastʹ, misto Chernihiv, vul. I. Franka, 86","987248321",1342432,"alerhiya");
        arr[6]=new Patient(8473,"Kushchenko","Lyubovyr","Zoryanovych","Dnipropetrovsʹka oblastʹ, misto Dnipro, prov. Khreshchatyk, 20","504958234",6782423,"hryp");



        */