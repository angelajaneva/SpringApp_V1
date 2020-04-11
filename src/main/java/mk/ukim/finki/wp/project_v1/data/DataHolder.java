package mk.ukim.finki.wp.project_v1.data;

import mk.ukim.finki.wp.project_v1.model.*;
import mk.ukim.finki.wp.project_v1.model.Class;
import mk.ukim.finki.wp.project_v1.repository.jpa.*;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Student> students = new ArrayList<>();
    public static List<Class> classes = new ArrayList<>();
    public static List<Note> notes = new ArrayList<>();
    public static List<Question> questions = new ArrayList<>();
    public static List<ToDo> toDos = new ArrayList<>();
    public static List<Comment> comments = new ArrayList<>();

    private final JpaStudentRepository studentRepository;
    private final JpaClassRepository classRepository;
    private final JpaNotesRepository notesRepository;
    private final JpaQuestionRepository questionRepository;
    private final JpaTodoRepository todoRepository;
    private final JpaCommentRepository commentRepository;
    private final JpaReviewRepository reviewRepository;


    public DataHolder(JpaStudentRepository studentRepository, JpaClassRepository classRepository,
                      JpaNotesRepository notesRepository, JpaQuestionRepository questionRepository, JpaTodoRepository todoRepository, JpaCommentRepository commentRepository, JpaReviewRepository reviewRepository) {
        this.studentRepository = studentRepository;
        this.classRepository = classRepository;
        this.notesRepository = notesRepository;
        this.questionRepository = questionRepository;
        this.todoRepository = todoRepository;
        this.commentRepository = commentRepository;
        this.reviewRepository = reviewRepository;
    }


    @PostConstruct
    public void init() {
        students.add(new Student("S17001", "Angela", "Janeva", new ArrayList<>()));
        students.add(new Student("S17002", "Maria", "Evans", new ArrayList<>()));
        students.add(new Student("S17003", "David", "Brooks", new ArrayList<>()));
        students.add(new Student("S17004", "Mark", "Henderson", new ArrayList<>()));
        students.add(new Student("S17005", "Paul", "Gray", new ArrayList<>()));
        students.add(new Student("S17006", "Daniel", " Brooks", new ArrayList<>()));
        students.add(new Student("S17007", "Sarah", "Torres", new ArrayList<>()));
        students.add(new Student("S17008", "Jane", "Phillips", new ArrayList<>()));
        students.add(new Student("S17009", "Mona", "Smith", new ArrayList<>()));
        students.add(new Student("S17010", "Natalie", "Evans", new ArrayList<>()));
        students.add(new Student("S17011", "Mary", "Henderson", new ArrayList<>()));
        students.add(new Student("S17012", "Elizabeth", "Smith", new ArrayList<>()));

        Class VP = new Class("VP", "Веб програмирање", new ArrayList<>());
        Class BiM = new Class("BiM", "Бизнис и менаџмент", new ArrayList<>());
        Class BP = new Class("BP", "Бази на податоци", new ArrayList<>());
        Class EMT = new Class("EMT", "Електронска и мобилна трговија", new ArrayList<>());
        Class AngJ = new Class("AngJ", "Англиски јазик", new ArrayList<>());
        Class DM = new Class("DM", "Дискретна математика", new ArrayList<>());
        Class SP = new Class("SP", "Структурно програмирање", new ArrayList<>());
        Class KnIO = new Class("KnIO", "Концепти на информатичко општество", new ArrayList<>());
        Class BMS = new Class("BMS", "Безжични мултимедиски системи", new ArrayList<>());
        Class AOK = new Class("AOK", "Архитектура и организација на компјутери", new ArrayList<>());

        classes.add(VP);
        classes.add(BiM);
        classes.add(BP);
        classes.add(EMT);
        classes.add(AngJ);
        classes.add(DM);
        classes.add(SP);
        classes.add(KnIO);
        classes.add(BMS);
        classes.add(AOK);

        students.get(0).addClass(VP);
        students.get(0).addClass(BP);
        students.get(0).addClass(AngJ);

        students.get(1).addClass(DM);
        students.get(1).addClass(SP);
        students.get(1).addClass(BiM);
        students.get(1).addClass(VP);

        students.get(2).addClass(KnIO);
        students.get(2).addClass(AOK);
        students.get(2).addClass(EMT);

        students.get(3).addClass(BiM);
        students.get(3).addClass(VP);
        students.get(3).addClass(BP);

        students.get(4).addClass(DM);
        students.get(4).addClass(BMS);

        students.get(5).addClass(KnIO);
        students.get(5).addClass(BiM);
        students.get(5).addClass(BMS);
        students.get(5).addClass(DM);

        students.get(6).addClass(AOK);
        students.get(6).addClass(AngJ);
        students.get(6).addClass(SP);
        students.get(6).addClass(KnIO);

        students.get(7).addClass(VP);
        students.get(7).addClass(EMT);
        students.get(7).addClass(BP);

        students.get(8).addClass(AOK);

        students.get(9).addClass(DM);
        students.get(9).addClass(BiM);

        students.get(10).addClass(EMT);
        students.get(10).addClass(BiM);
        students.get(10).addClass(KnIO);

        students.get(11).addClass(VP);
        students.get(11).addClass(DM);


        questions.add(new Question("q001", "Како е добиено решението на слика5, предавање4?", students.get(0), VP));
        questions.add(new Question("q002", "Може ли некој да ја обајсни табелата на слајд 32 од предавање1?", students.get(3), VP));
        questions.add(new Question("q003", "Дали може објаснување на слајд5, предавање10?", students.get(7), VP));
        questions.add(new Question("q004", "Појаснување за второто барање од лабораториската?", students.get(10), EMT));
        questions.add(new Question("q005", "Ја знае ли некој задачата на слика8, предавање10?", students.get(7), EMT));
        questions.add(new Question("q006", "Дали може објаснување на слајд51, предавање2?", students.get(2), EMT));
        questions.add(new Question("q007", "Може ли некој да ја обајсни табелата на слајд 35 од предавање8?", students.get(7), EMT));
        questions.add(new Question("q008", "Може ли некој да ја обајсни табелата на слајд 33 од предавање5?", students.get(0), BP));
        questions.add(new Question("q009", "Ја знае ли некој задачата на слика16, предавање5?", students.get(3), BP));
        questions.add(new Question("q010", "Дали може објаснување на слајд61, предавање3?", students.get(0), AngJ));
        questions.add(new Question("q011", "Може ли некој да ја обајсни табелата на слајд53 од предавање9?", students.get(5), BiM));
        questions.add(new Question("q012", "Дали може објаснување на слајд17, предавање3?", students.get(1), BiM));
        questions.add(new Question("q013", "Може ли некој да ја обајсни табелата на слајд 10 од предавање6?", students.get(5), BMS));
        questions.add(new Question("q014", "Ја знае ли некој задачата на слика7, предавање10?", students.get(8), AOK));
        questions.add(new Question("q016", "Може ли некој да ја обајсни табелата на слајд 21 од предавање7?", students.get(2), AOK));
        questions.add(new Question("q017", "Дали некој знае да ја објасни следната задача? Од каде е добиено X?", students.get(11), DM));
        questions.add(new Question("q018", "Дали некој знае да ја објасни табела1?", students.get(9), DM));
        questions.add(new Question("q019", "Како е добиено решението на задача3, предавање4?", students.get(4), DM));
        questions.add(new Question("q020", "Дали може објаснување на слајд45, предавање4?", students.get(6), SP));
        questions.add(new Question("q021", "Ја знае ли некој задачата на слика1, предавање8?", students.get(1), SP));
        questions.add(new Question("q022", "Дали може објаснување на слајд12, предавање3?", students.get(2), KnIO));


        String d001 = "In this chapter, we first study the fundamentals of the relational model. A" +
                "substantial theory exists for relational databases.We study the part of this theory " +
                "dealing with queries in Chapter 6. In Chapters 7 through 8, we shall examine " +
                "aspects of database theory that help in the design of relational database schemas, " +
                "while in Chapters 12 and 13we discuss aspects of the theory dealingwith efficient " +
                "processing of queries.";
        String d002 = "A relational database consists of a collection of tables, each of which is assigned a " +
                "unique name. For example, consider the instructor table of Figure 2.1, which stores " +
                "information about instructors. The table has four column headers: ID, name, dept " +
                "name, and salary. Each row of this table records information about an instructor," +
                "consisting of the instructor’s ID, name, dept name, and salary. Similarly, the course " +
                "table of Figure 2.2 stores information about courses, consisting of a course id, title, " +
                "dept name, and credits, for each course. Note that each instructor is identified by " +
                "the value of the column ID, while each course is identified by the value of the " +
                "column course id.";
        String d003 = "Figure 2.3 shows a third table, prereq,which stores the prerequisite courses for " +
                "each course. The table has two columns, course id and prereq id. Each rowconsists " +
                "of a pair of course identifiers such that the second course is a prerequisite for the " +
                "first course.";
        String d004 = "In general, a row in a table represents a relationship among a set of values. " +
                "Since a table is a collection of such relationships, there is a close correspondence " +
                "between the concept of table and the mathematical concept of relation, fromwhich " +
                "the relational data model takes its name. In mathematical terminology, a tuple is " +
                "simply a sequence (or list) of values. A relationship between n values is represented " +
                "mathematically by an n-tuple of values, i.e., a tuple with n values, which " +
                "corresponds to a row in a table.";
        String d005 = "In this chapter,weshall be using a number ofdifferent relations to illustrate the " +
                "various concepts underlying the relational data model. These relations represent " +
                "part of a university. They do not include all the data an actual university database " +
                "would contain, in order to simplify our presentation.We shall discuss criteria for " +
                "the appropriateness of relational structures in great detail in Chapters 7 and 8.";
        String d006 = "We require that, for all relations r, the domains of all attributes of r be atomic. " +
                "A domain is atomic if elements of the domain are considered to be indivisible " +
                "units.";
        String d007 = "In general, a relation schema consists of a list of attributes and their corresponding " +
                "domains. We shall not be concerned about the precise definition of the " +
                "domain of each attribute until we discuss the SQL language in Chapter 3. " +
                "The concept of a relation instance corresponds to the programming-language " +
                "notion of a value of a variable.";
        String d008 = "All procedural relational query languages provide a set of operations that can be " +
                "applied to either a single relation or a pair of relations. These operations have " +
                "the nice and desired property that their result is always a single relation. This " +
                "property allows one to combine several of these operations in a modular way. " +
                "Specifically, since the result of a relational query is itself a relation, relational " +
                "operations can be applied to the results of queries as well as to the given set of " +
                "relations.";
        String d009 = "Another frequent operation is to select certain attributes (columns) from a " +
                "relation. The result is a new relation having only those selected attributes. For " +
                "example, suppose we want a list of instructor IDs and salaries without listing " +
                "the name and dept name values from the instructor relation of Figure 2.1, then the " +
                "result, shown in Figure 2.11, has the two attributes ID and salary.";
        String d010 = "The Cartesian product operation combines tuples fromtworelations, but unlike " +
                "the join operation, its result contains all pairs of tuples from the two relations, " +
                "regardless of whether their attribute values match.";
        String d011 = "As we noted earlier, we can perform operations on the results of queries. For " +
                "example, if we want to find the ID and salary for those instructors who have salary " +
                "greater than $85,000, we would perform the first two operations in our example " +
                "above. First we select those tuples from the instructor relation where the salary " +
                "value is greater than $85,000 and then, from that result, select the two attributes " +
                "ID and salary, resulting in the relation shown in Figure 2.13.";

        notes.add(new Note("n001", "", d001, VP, students.get(0)));
        notes.add(new Note("n002", "", d002, VP, students.get(3)));
        notes.add(new Note("n003", "", d003, VP, students.get(7)));
        notes.add(new Note("n004", "", d004, EMT, students.get(10)));
        notes.add(new Note("n005", "", d005, EMT, students.get(7)));
        notes.add(new Note("n006", "", d006, EMT, students.get(2)));
        notes.add(new Note("n007", "", d007, EMT, students.get(7)));
        notes.add(new Note("n008", "", d008, BP, students.get(0)));
        notes.add(new Note("n009", "", d009, BP, students.get(3)));
        notes.add(new Note("n010", "", d010, AngJ, students.get(0)));
        notes.add(new Note("n011", "", d011, BiM, students.get(5)));
        notes.add(new Note("n012", "", d001, BiM, students.get(1)));
        notes.add(new Note("n013", "", d002, BMS, students.get(5)));
        notes.add(new Note("n014", "", d003, AOK, students.get(8)));
        notes.add(new Note("n015", "", d004, AOK, students.get(2)));
        notes.add(new Note("n016", "", d005, DM, students.get(11)));
        notes.add(new Note("n017", "", d006, DM, students.get(9)));
        notes.add(new Note("n018", "", d007, DM, students.get(4)));
        notes.add(new Note("n019", "", d008, SP, students.get(6)));
        notes.add(new Note("n020", "", d009, SP, students.get(1)));
        notes.add(new Note("n021", "", d010, KnIO, students.get(2)));
        notes.add(new Note("n022", "", d011, KnIO, students.get(2)));

        toDos.add(new ToDo("t001", LocalDate.of(2020, 01, 21),
                "Read few pages from the book. Choose a theme or topic and stay on that.", true));
        toDos.add(new ToDo("t002", LocalDate.of(2020, 02, 04),
                "Do the homework and lab exams.", false));
        toDos.add(new ToDo("t003", LocalDate.of(2020, 02, 28),
                "Study for the final exam.", false));
        toDos.add(new ToDo("t004", LocalDate.of(2020, 03, 13),
                "Coffee with Emily at 14:00.", true));
        toDos.add(new ToDo("t005", LocalDate.of(2020, 03, 31),
                "Don't skip going on lessons. Monday 11:00 IT lesson and Tuesday 10:00 DM exercises.", true));


        if (studentRepository.count() == 0) {
            studentRepository.saveAll(students);
            classRepository.saveAll(classes);
            questionRepository.saveAll(questions);
            notesRepository.saveAll(notes);
            todoRepository.saveAll(toDos);
        }

        notesRepository.save(new Note("n004", "N004", d004, EMT, students.get(10)));
        notesRepository.save(new Note("n010", "", d010, AngJ, students.get(0)));

    }

}
