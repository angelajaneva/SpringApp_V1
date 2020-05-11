//package mk.ukim.finki.wp.project_v1.db;
//
//import mk.ukim.finki.wp.project_v1.model.Student;
//import mk.ukim.finki.wp.project_v1.model.ToDo;
//import mk.ukim.finki.wp.project_v1.model.User;
//import mk.ukim.finki.wp.project_v1.repository.ToDoRepository;
//import mk.ukim.finki.wp.project_v1.repository.UserRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class DbInit implements CommandLineRunner {
//    private UserRepository userRepository;
//    private ToDoRepository toDoRepository;
//    private PasswordEncoder passwordEncoder;
//    private static List<Student> students = new ArrayList<>();
//
//    public DbInit(UserRepository userRepository, ToDoRepository toDoRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.toDoRepository = toDoRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public void run(String... args) {
//        students.add(new Student("S17001", "Angela", "Janeva", new ArrayList<>()));
//        students.add(new Student("S17002", "Maria", "Evans", new ArrayList<>()));
//        students.add(new Student("S17003", "David", "Brooks", new ArrayList<>()));
//        students.add(new Student("S17004", "Mark", "Henderson", new ArrayList<>()));
//        students.add(new Student("S17005", "Paul", "Gray", new ArrayList<>()));
//        students.add(new Student("S17006", "Daniel", " Brooks", new ArrayList<>()));
//        students.add(new Student("S17007", "Sarah", "Torres", new ArrayList<>()));
//        students.add(new Student("S17008", "Jane", "Phillips", new ArrayList<>()));
//        students.add(new Student("S17009", "Mona", "Smith", new ArrayList<>()));
//        students.add(new Student("S17010", "Natalie", "Evans", new ArrayList<>()));
//        students.add(new Student("S17011", "Mary", "Henderson", new ArrayList<>()));
//        students.add(new Student("S17012", "Elizabeth", "Smith", new ArrayList<>()));
//
//        User user1 = new User("student1", passwordEncoder.encode("123"), students.get(0), new ArrayList<>());
//        User user2 = new User("student2", passwordEncoder.encode("123"), students.get(1), new ArrayList<>());
//        User user3 = new User("student3", passwordEncoder.encode("123"), students.get(2), new ArrayList<>());
//        User user4 = new User("student4", passwordEncoder.encode("123"), students.get(3), new ArrayList<>());
//        User user5 = new User("student5", passwordEncoder.encode("123"), students.get(4), new ArrayList<>());
//        User user6 = new User("student6", passwordEncoder.encode("123"), students.get(5), new ArrayList<>());
//        User user7 = new User("student7", passwordEncoder.encode("123"), students.get(6), new ArrayList<>());
//        User user8 = new User("student8", passwordEncoder.encode("123"), students.get(7), new ArrayList<>());
//        User user9 = new User("student9", passwordEncoder.encode("123"), students.get(8), new ArrayList<>());
//        User user10 = new User("student10", passwordEncoder.encode("123"), students.get(9), new ArrayList<>());
//        User user11 = new User("student11", passwordEncoder.encode("123"), students.get(10), new ArrayList<>());
//        User user12 = new User("student12", passwordEncoder.encode("123"), students.get(11), new ArrayList<>());
//
////        userRepository.save(user1);
////        userRepository.save(user2);
////        userRepository.save(user3);
////        userRepository.save(user4);
////        userRepository.save(user5);
////        userRepository.save(user6);
////        userRepository.save(user7);
////        userRepository.save(user8);
////        userRepository.save(user9);
////        userRepository.save(user10);
////        userRepository.save(user11);
////        userRepository.save(user12);
//
//        ToDo toDo1 = new ToDo(LocalDate.of(2020, 01, 20), "Finish with DBMS, lecture 6", true, user1);
//        ToDo toDo2 = new ToDo(LocalDate.of(2020, 02, 11), "Watch the tutorial for react.js at freecodecamp", false, user1);
//        ToDo toDo3 = new ToDo(LocalDate.of(2020, 03, 18), "Write your third homework Digital Libraries", true, user1);
//        ToDo toDo4 = new ToDo(LocalDate.of(2020, 02, 04), "Complete the third point from the udemy react course", false, user1);
//        ToDo toDo5 = new ToDo(LocalDate.of(2019, 12, 22), "Write your notes for EMT lecture 7", true, user1);
//        ToDo toDo6 = new ToDo(LocalDate.of(2020, 01, 05), "Read about Spring Security with jwt", true, user2);
//        ToDo toDo7 = new ToDo(LocalDate.of(2020, 04, 05), "Finish the third lab for DBMS", false, user2);
//        ToDo toDo8 = new ToDo(LocalDate.of(2020, 04, 03), "Try to secure some web page", true, user2);
//        ToDo toDo9 = new ToDo(LocalDate.of(2019, 12,03), "Finish the third lab for DBMS", false, user2);
//        ToDo toDo10 = new ToDo(LocalDate.of(2020, 01, 9), "Repeat the exercises for EIMT", true, user3);
//        ToDo toDo11 = new ToDo(LocalDate.of(2020, 02, 12), "Read lecture 8 Digital Libraries", true, user3);
//        ToDo toDo12 = new ToDo(LocalDate.of(2019, 12, 03), "Write some notes for lecture 8", false, user3);
//        ToDo toDo13 = new ToDo(LocalDate.of(2020, 02, 10), "Customize HTML pages in Greenstone3 for Digital Library", true, user4);
//        ToDo toDo14 = new ToDo(LocalDate.of(2020, 01, 30), "Start the WP project: make model, repository service", false, user4);
//        ToDo toDo15 = new ToDo(LocalDate.of(2020, 03, 01), "Start the redux from udemy course", false, user4);
//        ToDo toDo16 = new ToDo(LocalDate.of(2020, 01, 18), "Translate chapter7 from EIMT book", true, user5);
//        ToDo toDo17 = new ToDo(LocalDate.of(2019, 11, 16), "Write notes from chapter7", false, user5);
//        ToDo toDo18 = new ToDo(LocalDate.of(2020, 01, 16), "Finish the fourth homework Digital Libraries", true, user6);
//        ToDo toDo19 = new ToDo(LocalDate.of(2020, 01, 12), "Do the forth laboratory work IT", true, user6);
//        ToDo toDo20 = new ToDo(LocalDate.of(2020, 05, 02), "Do the second laboratory work EIMT", false, user7);
//        ToDo toDo21 = new ToDo(LocalDate.of(2019, 10, 27), "Listen 3 lectures IT", false, user8);
//        ToDo toDo22 = new ToDo(LocalDate.of(2019, 12, 15), "Complete the second point from the udemy react course", true, user9);
//        ToDo toDo23 = new ToDo(LocalDate.of(2020, 05, 03), "Read few pages from the book. Choose a theme or topic and stay on that", false, user10);
//        ToDo toDo24 = new ToDo(LocalDate.of(2020, 04, 30), "Coffee with Emily at 10 o'clock.", true, user11);
//        ToDo toDo25 = new ToDo(LocalDate.of(2020, 04, 28), "Customize HTML pages in Greenstone3 for Digital Library.", true, user12);
//
//        toDoRepository.save(toDo1);
//        toDoRepository.save(toDo2);
//        toDoRepository.save(toDo3);
//        toDoRepository.save(toDo4);
//        toDoRepository.save(toDo5);
//        toDoRepository.save(toDo6);
//        toDoRepository.save(toDo7);
//        toDoRepository.save(toDo8);
//        toDoRepository.save(toDo9);
//        toDoRepository.save(toDo10);
//        toDoRepository.save(toDo11);
//        toDoRepository.save(toDo12);
//        toDoRepository.save(toDo13);
//        toDoRepository.save(toDo14);
//        toDoRepository.save(toDo15);
//        toDoRepository.save(toDo16);
//        toDoRepository.save(toDo17);
//        toDoRepository.save(toDo18);
//        toDoRepository.save(toDo19);
//        toDoRepository.save(toDo20);
//        toDoRepository.save(toDo21);
//        toDoRepository.save(toDo22);
//        toDoRepository.save(toDo23);
//        toDoRepository.save(toDo24);
//        toDoRepository.save(toDo25);
//
//    }
//}
