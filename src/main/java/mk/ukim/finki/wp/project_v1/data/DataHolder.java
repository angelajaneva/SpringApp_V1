/*
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
    public static List<Review> reviews = new ArrayList<>();


    private final JpaStudentRepository studentRepository;
    private final JpaClassRepository classRepository;
    private final JpaNotesRepository notesRepository;
    private final JpaQuestionRepository questionRepository;
    private final JpaTodoRepository todoRepository;
    private final MongoCommentRepository commentRepository;
    private final JpaReviewRepository reviewRepository;


    public DataHolder(JpaStudentRepository studentRepository, JpaClassRepository classRepository,
                      JpaNotesRepository notesRepository, JpaQuestionRepository questionRepository, JpaTodoRepository todoRepository, MongoCommentRepository commentRepository, JpaReviewRepository reviewRepository) {
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

        Class VP = new Class("WP", "Web Programming", new ArrayList<>());
        Class BiM = new Class("BM", "Business and managment", new ArrayList<>());
        Class BP = new Class("DBMS", "Database Managment System", new ArrayList<>());
        Class EMT = new Class("EMC", "Electronic And Mobile Commerce", new ArrayList<>());
        Class AngJ = new Class("EngL", "English Language", new ArrayList<>());
        Class DM = new Class("DM", "Discrete Mathematics", new ArrayList<>());
        Class SP = new Class("SP", "Structured Programming", new ArrayList<>());
        Class KnIO = new Class("COIS", "Concepts Of Information Society", new ArrayList<>());
        Class BMS = new Class("WMS", "Wireless Multimedia Systems ", new ArrayList<>());
        Class AOK = new Class("CAO", "Computer Architecture And Organization", new ArrayList<>());

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


        questions.add(new Question("q001", "Suppose user A, who has all authorizations on a relation r , grants select on\n" +
                "relation r to public with grant option. Suppose user B then grants select on r to A. Does this cause a cycle in the authorization graph?", students.get(0), VP));
        questions.add(new Question("q002", "Difference between two-tier and three-tier architectures. Which" +
                "is better suited for Web applications? Why?", students.get(3), VP));
        questions.add(new Question("q003", "Consider the bank database of Figure 2.15.\n" +
                "What are the appropriate primary keys?", students.get(7), VP));
        questions.add(new Question("q004", "Why null values might be introduced into the database?",
                students.get(10), EMT));
        questions.add(new Question("q005", "Lossless-join decomposition into BCNF of schema R of Practice Exercise" +
                "8.1.?", students.get(7), EMT));
        questions.add(new Question("q006", "Describe the differences in meaning between the terms relation and relation" +
                "schema.", students.get(2), EMT));
        questions.add(new Question("q007", "what is meant by repetition of information and inability to represent" +
                "information?", students.get(7), EMT));
        questions.add(new Question("q008", "Under what circumstances would the query\n" +
                "select * from student natural full outer join takes natural full outer join course\n" +
                "include tuples with null values for the title attribute?", students.get(0), BP));
        questions.add(new Question("q009", "How to express the coalesce operation from Exercise 4.10 using the case operation?",
                students.get(3), BP));
        questions.add(new Question("q010", "What is meant by repetition of information and inability to represent" +
                "information?", students.get(0), AngJ));
        questions.add(new Question("q011", "Explain why each of these properties in Section1 may indicate a bad relational" +
                "database design?", students.get(5), BiM));
        questions.add(new Question("q012", "Why are certain functional dependencies called trivial functional dependencies?",
                students.get(1), BiM));
        questions.add(new Question("q013", "In designing a relational database, why might we choose a non-BCNF design?",
                students.get(5), BMS));
        questions.add(new Question("q014", "Why 4NF is a normal form more desirable than BCNF?",
                students.get(8), AOK));
        questions.add(new Question("q016", "How can the referer field be used to detect some XSS attacks?",
                students.get(2), AOK));
        questions.add(new Question("q017", "What is multi-factor authentication? How does it help safeguard against" +
                "stolen passwords??", students.get(11), DM));
        questions.add(new Question("q018", "What is a challenge–response system for authentication. Why is it" +
                "more secure than a traditional password-based system??", students.get(9), DM));
        questions.add(new Question("q019", "How to keep the bitmap up to date on record insertions and deletions?",
                students.get(4), DM));
        questions.add(new Question("q020", "How does the remapping of bad sectors by disk controllers affect dataretrieval rates?",
                students.get(6), SP));
        questions.add(new Question("q021", "What is scrubbing, in the context of RAID systems, and why is scrubbing important?",
                students.get(1), SP));
        questions.add(new Question("q022", "How to express the coalesce operation from Exercise 4.10 using the case operation?",
                students.get(2), KnIO));

        comments.add(new Comment(1L, "The schema of a relation refers to its logical design, while an instance of the " +
                "relation refers to its contents at a point in time. The schema of a database and " +
                "an instance of a database are similarly defined. The schema of a relation includes " +
                "its attributes, and optionally the types of the attributes and constraints " +
                "on the relation such as primary and foreign key constraints. ",
                LocalDate.of(2020, 1, 14), questions.get(0), students.get(1)));
        comments.add(new Comment(2L, "The relational data model is based on a collection of tables. The user of the " +
                "database system may query these tables, insert new tuples, delete tuples, " +
                "and update (modify) tuples. There are several languages for expressing these " +
                "operations.",
                LocalDate.of(2019, 4, 20), questions.get(1), students.get(0)));
        comments.add(new Comment(3L, "Many relational database products are now commercially available. These " +
                "include IBM’s DB2 and Informix, Oracle, Sybase, and Microsoft SQL Server. Open " +
                "source relational database systems include MySQL and PostgreSQL. Microsoft " +
                "Access is a single-user database product that is part of the Microsoft Office suite.",
                LocalDate.of(2018, 11, 4), questions.get(1), students.get(2)));
        comments.add(new Comment(4L, "The processing of SQL queries, including algorithms and performance issues, " +
                "is discussed in Chapters 12 and 13. Bibliographic references on these matters " +
                "appear in those chapters.",
                LocalDate.of(2019, 3, 5), questions.get(2), students.get(3)));
        comments.add(new Comment(5L, "Digital certificates are widely used to authenticate Web sites to users, to " +
                "prevent malicious sites from masquerading as other Web sites. In the HTTPS " +
                "protocol (the secure version of the HTTP protocol), the site provides its digital " +
                "certificate to the browser, which then displays it to the user.",
                LocalDate.of(2020, 4, 16), questions.get(7), students.get(4)));
        comments.add(new Comment(6L, "HTML provides the ability to define interfaces that combine hyperlinks with " +
                "forms facilities. Web browsers communicate with Web servers by the HTTP " +
                "protocol. Web servers can pass on requests to application programs, and " +
                "return the results to the browser.",
                LocalDate.of(2020, 2, 19), questions.get(6), students.get(5)));
        comments.add(new Comment(7L, "Techniques such as caching of various forms, including query result caching " +
                "and connection pooling, and parallel processing are used to improve application " +
                "performance.",
                LocalDate.of(2019, 6, 21), questions.get(6), students.get(6)));
        comments.add(new Comment(8L, "Encryption plays a key role in protecting information and in authentication " +
                "of users andWeb sites. Symmetric-key encryption and public-key encryption " +
                "are two contrasting but widely used approaches to encryption.",
                LocalDate.of(2019, 7, 29), questions.get(5), students.get(7)));
        comments.add(new Comment(9L, "When the domain relational calculus is restricted to safe expressions, it is equivalent " +
                "in expressive power to the tuple relational calculus restricted to safe expressions.",
                LocalDate.of(2020, 1, 25), questions.get(5), students.get(8)));
        comments.add(new Comment(10L, "The relational calculi are terse, formal languages that are inappropriate for " +
                "casual users of a database system. These two formal languages form the basis " +
                "for two more user-friendly languages, QBE and Datalog, that we cover in " +
                "Appendix B.",
                LocalDate.of(2020, 3, 30), questions.get(9), students.get(9)));
        comments.add(new Comment(11L, "Database systems are designed to store large bodies of information. The management " +
                "of data involves both the definition of structures for the storage of " +
                "information and the provision of mechanisms for the manipulation of information.",
                LocalDate.of(2020, 3, 15), questions.get(3), students.get(10)));
        comments.add(new Comment(12L, "In addition, the database system must provide for the safety of the " +
                "information stored, in the face of system crashes or attempts at unauthorized " +
                "access. If data are to be shared among several users, the system must avoid " +
                "possible anomalous results.",
                LocalDate.of(2019, 8, 24), questions.get(4), students.get(11)));
        comments.add(new Comment(13L, "The architecture of a database system is greatly influenced by the underlying " +
                "computer system on which the database system runs. Database systems can " +
                "be centralized, or client-server, where one server machine executes work on " +
                "behalf of multiple client",
                LocalDate.of(2019, 9, 4), questions.get(10), students.get(1)));
        comments.add(new Comment(14L, "Knowledge-discovery techniques attempt to discover automatically statistical " +
                "rules and patterns from data. The field of data mining combines knowledge discovery " +
                "techniques invented by artificial intelligence researchers and statistical " +
                "analysts.",
                LocalDate.of(2018, 12, 7), questions.get(11), students.get(0)));
        comments.add(new Comment(15L, "If the decomposition is dependency preserving, given a database update, all " +
                "functional dependencies can be verifiable from individual relations, without " +
                "computing a join of relations in the decomposition.",
                LocalDate.of(2019, 10, 5), questions.get(11), students.get(2)));
        comments.add(new Comment(16L, "We showed the development of a relational database design from an E-R " +
                "design, when schemas may be combined safely, and when a schema should " +
                "be decomposed. All valid decompositions must be lossless.",
                LocalDate.of(2019, 11, 3), questions.get(12), students.get(3)));
        comments.add(new Comment(17L, "We used the canonical covers to decompose a relation into 3NF, which is " +
                "a small relaxation of the BCNF condition. Relations in 3NF may have some " +
                "redundancy, but there is always a dependency-preserving decomposition " +
                "into 3NF.",
                LocalDate.of(2019, 12, 8), questions.get(14), students.get(4)));
        comments.add(new Comment(18L, "Other normal forms, such as PJNF and DKNF, eliminate more subtle forms " +
                "of redundancy. However, these are hard to work with and are rarely used." +
                "Appendix C gives details on these normal forms.",
                LocalDate.of(2020, 2, 18), questions.get(14), students.get(5)));
        comments.add(new Comment(19L, "Stable storage that must be accessible online is approximated with mirrored " +
                "disks, or other forms of RAID,which provide redundant data storage. Offline, " +
                "or archival, stable storage may consist of multiple tape copies of data stored " +
                "in a physically secure location.",
                LocalDate.of(2020, 1, 13), questions.get(15), students.get(6)));
        comments.add(new Comment(20L, "An integral part of a database system is a recovery scheme that is responsible " +
                "for the detection of failures and for the restoration of the database to a state " +
                "that existed before the occurrence of the failure.",
                LocalDate.of(2020, 3, 21), questions.get(16), students.get(7)));
        comments.add(new Comment(21L, "In case of failure, the state of the database system may no longer be consistent; " +
                "that is, it may not reflect a state of the world that the database is supposed to " +
                "capture.",
                LocalDate.of(2018, 10, 22), questions.get(16), students.get(8)));
        comments.add(new Comment(22L, "In log-based schemes, all updates are recorded on a log, which must be kept " +
                "in stable storage. A transaction is considered to have committed when its " +
                "last log record.",
                LocalDate.of(2020, 1, 31), questions.get(18), students.get(9)));
        comments.add(new Comment(23L, "Log records contain old values and new values for all updated data items. " +
                "The new values are used in case the updates need to be redone after a system " +
                "crash.",
                LocalDate.of(2020, 4, 11), questions.get(20), students.get(10)));
        comments.add(new Comment(24L, "Complex applications usually have a multilayer architecture, including a " +
                "model implementing business logic, a controller, and a view mechanism to " +
                "display results. They may also include a data access layer that implements " +
                "an object-relational mapping. Many applications implement and use Web " +
                "services, allowing functions to be invoked over HTTP.",
                LocalDate.of(2019, 9, 13), questions.get(0), students.get(11)));
        comments.add(new Comment(25L, "If the decomposition is dependency preserving, given a database update, all " +
                "functional dependencies can be verifiable from individual relations, without " +
                "computing a join of relations in the decomposition.",
                LocalDate.of(2019, 7, 7), questions.get(2), students.get(10)));
        comments.add(new Comment(26L, "Undo of an incomplete transaction writes out special redo-only log records, " +
                "and an abort log record. After that, the transaction can be considered to have " +
                "completed, and it will not be undone again.",
                LocalDate.of(2020, 4, 3), questions.get(7), students.get(9)));


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

        reviews.add(new Review("One of the great courses I have ever done. He tried to cover almost all the basic things you need to develop a website. " +
                " After complete this course, you just need to do lot of practice and get advance knowledge of web development.",
                4, students.get(1), VP, LocalDate.of(2019, 1, 30)));
        reviews.add(new Review("The course is great and creates a good foundation for the prospective web developer." +
                "The lessons are explained concisely and easy to follow. I have personally gained a lot from this course. Thank You!",
                5, students.get(2), VP, LocalDate.of(2020, 2, 7)));
        reviews.add(new Review("Excellent introduction to DB Management, I learned everything that I wanted to learn from it. I highly recommend" +
                " it and actually I am already enrolled to the next course of the specialization.",
                5, students.get(3), BP, LocalDate.of(2019, 2, 1)));
        reviews.add(new Review("Not enough implication from the instructors in the course. Students are left alone with the material," +
                " without any answers to there questions on the course.",
                2, students.get(4), DM, LocalDate.of(2019, 7, 3)));
        reviews.add(new Review("As a mid-career professional in finance and consulting, and interested in venture capital, I definitely needed a good introduction to this world so I can at least speak the language on a basic level," +
                " whether to startups, investors, etc. This course does exactly that and makes programming feel a lot less intimidating.",
                4, students.get(5), SP, LocalDate.of(2019, 3, 2)));
        reviews.add(new Review("I cannot describe how much I loved every bit of this course. All the contents in it has been organized in a way that anyone can comprehend those easily." +
                "All the quizzes and activities have made me to think like a real networking professional.",
                5, students.get(6), BMS, LocalDate.of(2019, 6, 16)));
        reviews.add(new Review("Excellent course! It was really nice to have a high-level course, and I feel like this course makes a great substitute" +
                " for the Computer Architecture course offered in my university.",
                5, students.get(7), AOK, LocalDate.of(2019, 6, 28)));
        reviews.add(new Review("This course is good to comprehend relation, function and combinations.",
                5, students.get(8), DM, LocalDate.of(2020, 2, 12)));
        reviews.add(new Review("Very useful and interesting course for beginners.",
                4, students.get(9), AngJ, LocalDate.of(2020, 3, 18)));
        reviews.add(new Review("It is a great course that simplifies how we should think about a business (the start and the long term visions) it also reorders" +
                "our way of thinking about how firms work and overcome their obstacles.\n",
                5, students.get(10), BiM, LocalDate.of(2019, 7, 1)));


        if (studentRepository.count() == 0) {
            studentRepository.saveAll(students);
            classRepository.saveAll(classes);
            questionRepository.saveAll(questions);
            notesRepository.saveAll(notes);
            todoRepository.saveAll(toDos);
            commentRepository.saveAll(comments);
            reviewRepository.saveAll(reviews);
        }
    }

}
*/


