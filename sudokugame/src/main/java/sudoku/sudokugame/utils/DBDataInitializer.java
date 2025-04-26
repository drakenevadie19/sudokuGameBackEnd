package sudoku.sudokugame.utils;//package edu.tcu.cs.motivateme.utils;
//
//import edu.tcu.cs.superfrogscheduler.reports.dto.Period;
//import edu.tcu.cs.superfrogscheduler.reports.entity.PaymentForm;
//import edu.tcu.cs.superfrogscheduler.reports.entity.PerformanceForm;
//import edu.tcu.cs.superfrogscheduler.reports.repository.PaymentFormRepository;
//import edu.tcu.cs.superfrogscheduler.reports.repository.PerformanceFormRepository;
//import edu.tcu.cs.superfrogscheduler.request.Request;
//import edu.tcu.cs.superfrogscheduler.request.RequestRepository;
//import edu.tcu.cs.superfrogscheduler.request.RequestStatus;
//import edu.tcu.cs.superfrogscheduler.user.UserRepository;
//import edu.tcu.cs.superfrogscheduler.user.entity.SuperFrogUser;
//import edu.tcu.cs.superfrogscheduler.user.entity.utils.PaymentPreference;
//import edu.tcu.cs.superfrogscheduler.user.security.UserSecurity;
//import edu.tcu.cs.superfrogscheduler.user.security.UserSecurityRepository;
//import edu.tcu.cs.superfrogscheduler.user.security.UserSecurityService;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//import java.util.Random;
//
//@Component
//public class DBDataInitializer implements CommandLineRunner {
//
//    private final UserSecurityRepository userSecurityRepository;
//
//    private final UserRepository userRepository;
//
//    private final UserSecurityService userSecurityService;
//
//    private final PerformanceFormRepository performanceFormRepository;
//
//    private final PaymentFormRepository paymentFormRepository;
//
//    private final RequestRepository requestRepository;
//
//    @Value("${server.environment}")
//    private String serverEnvironment;
//
//    public DBDataInitializer(UserSecurityRepository userSecurityRepository, UserRepository userRepository, UserSecurityService userSecurityService, RequestRepository requestRepository, PerformanceFormRepository performanceFormRepository, PaymentFormRepository paymentFormRepository) {
//        this.userSecurityRepository = userSecurityRepository;
//        this.userRepository = userRepository;
//        this.userSecurityService = userSecurityService;
//        this.performanceFormRepository = performanceFormRepository;
//        this.requestRepository = requestRepository;
//        this.paymentFormRepository = paymentFormRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println(serverEnvironment);
//        if(Objects.equals(serverEnvironment, "prod")) {
//            return;
//        }
//
//        SuperFrogUser admin = new SuperFrogUser();
//        admin.setAddress("adminAddress");
//        admin.setEmail("admin@tcu.edu");
//        admin.setFirstName("SuperFrog");
//        admin.setLastName("Admin");
//        admin.setPaymentPreference(PaymentPreference.MAIL_CHECK);
//        UserSecurity userSecurity = UserSecurity.createUserSecurity(admin);
//        userSecurity.setPassword("adminPassword");
//        this.userSecurityService.createBasicCredentials(userSecurity);
//        userSecurity.setRoles("user admin");
//        this.userRepository.save(admin);
//
//        // create 50 default users
//        List<SuperFrogUser> users = createUsers(50);
////        List<Request> requests = createRequests(50);
//        this.userRepository.saveAll(users);
////        this.requestRepository.saveAll(requests);
//
//        // For Reports
//
//        Period period3 = new Period(LocalDate.of(2023, 4, 1), LocalDate.of(2023, 4, 30));
//        PaymentForm paymentForm1 = new PaymentForm(
//                "John",
//                "Doe",
//                "123",
//                period3,
//                BigDecimal.valueOf(900.75)
//        );
//
//        Period period4 = new Period(LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 28));
//        PaymentForm paymentForm2 = new PaymentForm(
//                "Susan",
//                "Doe",
//                "124",
//                period4,
//                BigDecimal.valueOf(900.75)
//        );
//
//        this.paymentFormRepository.save(paymentForm1);
//        this.paymentFormRepository.save(paymentForm2);
//
//        Period period1 = new Period(LocalDate.of(2023, 4, 1), LocalDate.of(2023, 4, 30));
//        PerformanceForm performanceForm1 = new PerformanceForm(
//                period1,
//                "John",
//                "Doe",
//                "123",
//                7
//        );
//
//        Period period2 = new Period(LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 28));
//        PerformanceForm performanceForm2 = new PerformanceForm(
//                period2,
//                "Hanna",
//                "Sigman",
//                "124",
//                3
//        );
//        this.performanceFormRepository.save(performanceForm1);
//        this.performanceFormRepository.save(performanceForm2);
//
///*
//        SuperFrogUser student1 = new SuperFrogUser("Jane", "Smith", "1001");
//        SuperFrogUser student2 = new SuperFrogUser("John", "Doe", "1004");
//        SuperFrogUser student3 = new SuperFrogUser("Tim", "Johnson", "1012");
//        UserSecurity.createUserSecurity(student1);
//        UserSecurity.createUserSecurity(student2);
//        UserSecurity.createUserSecurity(student3);
//        this.userRepository.save(student1);
//        this.userRepository.save(student2);
//        this.userRepository.save(student3);
//        Request request1 = new Request(
//                "5",
//                EventType.TCU,
//                "Event address 1",
//                1.4,
//                LocalDate.of(2023, 4, 6),
//                LocalTime.of(13, 0),
//                LocalTime.of(15, 30),
//                RequestStatus.COMPLETED,
//                student1);
//        Request request2 = new Request(
//                "6",
//                EventType.NONPROFIT,
//                "Event address 2",
//                2.0,
//                LocalDate.of(2023, 4, 9),
//                LocalTime.of(9, 0),
//                LocalTime.of(12, 0),
//                RequestStatus.COMPLETED,
//                student1);
//        Request request3 = new Request(
//                "12",
//                EventType.PRIVATE,
//                "Event address 3",
//                99.0,
//                LocalDate.of(2023, 4, 16),
//                LocalTime.of(19, 30),
//                LocalTime.of(21, 30),
//                RequestStatus.COMPLETED,
//                student1);
//        Request request4 = new Request(
//                "16",
//                EventType.PRIVATE,
//                "Event address 4",
//                18.0,
//                LocalDate.of(2023, 4, 17),
//                LocalTime.of(11, 0),
//                LocalTime.of(12, 0),
//                RequestStatus.COMPLETED,
//                student2);
//        Request request5 = new Request(
//                "17",
//                EventType.NONPROFIT,
//                "Event address 5",
//                25.0,
//                LocalDate.of(2023, 4, 19),
//                LocalTime.of(14, 30),
//                LocalTime.of(15, 30),
//                RequestStatus.COMPLETED,
//                student2);
//        Request request6 = new Request(
//                "20",
//                EventType.PRIVATE,
//                "Event address 6",
//                50.0,
//                LocalDate.of(2023, 4, 22),
//                LocalTime.of(9, 30),
//                LocalTime.of(14, 30),
//                RequestStatus.COMPLETED,
//                student2);
//        Request request7 = new Request(
//                "22",
//                EventType.TCU,
//                "Event address 7",
//                0.6,
//                LocalDate.of(2023, 4, 26),
//                LocalTime.of(17, 0),
//                LocalTime.of(19, 0),
//                RequestStatus.COMPLETED,
//                student3);
//        this.requestRepository.save(request1);
//        this.requestRepository.save(request2);
//        this.requestRepository.save(request3);
//        this.requestRepository.save(request4);
//        this.requestRepository.save(request5);
//        this.requestRepository.save(request6);
//        this.requestRepository.save(request7);
// */
//
//    }
//
//
//    private List<SuperFrogUser> createUsers(int totalUser) {
//        List<SuperFrogUser> users = new ArrayList<>();
//        String[] firstNames = {"John", "Jane", "Michael", "Emily", "David", "Sarah", "William", "Elizabeth", "Christopher", "Olivia", "Drake", "Hiep", "Vinh"};
//        String[] lastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor", "Do", "Nguyen", "Ly"};
//        Random random = new Random();
//
//        for(int i = 1; i <= totalUser; i++) {
//            SuperFrogUser superFrogUser = new SuperFrogUser();
//            superFrogUser.setAddress(i+ " Main St, Suite " + i + ", Fort Worth, TX, 76109");
//
//            String randFirstName  = firstNames[random.nextInt(firstNames.length)];
//            String randLastName  = lastNames[random.nextInt(lastNames.length)];
//
//            superFrogUser.setEmail(randFirstName.toLowerCase() + randLastName.toLowerCase() + i + "@tcu.edu");
//            superFrogUser.setFirstName(randFirstName);
//            superFrogUser.setLastName(randLastName);
//            superFrogUser.setPhoneNumber("(817) 567-9999");
//
//            superFrogUser.setPaymentPreference(PaymentPreference.MAIL_CHECK);
//            superFrogUser.setRequests(createRequestsWithDifferentStatus());
//            superFrogUser.getRequests().forEach(request -> request.setSuperFrogUser(superFrogUser));
//
//            UserSecurity userSecurity = UserSecurity.createUserSecurity(superFrogUser);
//            userSecurity.setPassword("userPassword");
//            this.userSecurityService.createBasicCredentials(userSecurity);
//
//            users.add(superFrogUser);
//        }
//
////        Collections.reverse(users);
//
//        return users;
//    }
//
//    private List<Request> createRequestsWithDifferentStatus() {
//        List<Request> requests = new ArrayList<>();
//
//        Request request1 = new Request();
//        request1.setEventTitle("RequestPending");
//        request1.setRequestStatus(RequestStatus.PENDING);
//        request1.setStartTime(LocalTime.NOON);
//        request1.setEndTime(LocalTime.MIDNIGHT);
//        request1.setMileage(10.00);
//
//        Request request2 = new Request();
//        request2.setEventTitle("RequestApproved");
//        request2.setRequestStatus(RequestStatus.APPROVED);
//        request2.setStartTime(LocalTime.NOON);
//        request2.setEndTime(LocalTime.MIDNIGHT);
//        request2.setMileage(10.00);
//
//
//        Request request3 = new Request();
//        request3.setEventTitle("RequestRejected");
//        request3.setRequestStatus(RequestStatus.REJECTED);
//        request3.setStartTime(LocalTime.NOON);
//        request3.setEndTime(LocalTime.MIDNIGHT);
//        request3.setMileage(10.00);
//
//
//        Request request4 = new Request();
//        request4.setEventTitle("RequestCancelled");
//        request4.setRequestStatus(RequestStatus.CANCELLED);
//        request4.setStartTime(LocalTime.NOON);
//        request4.setEndTime(LocalTime.MIDNIGHT);
//        request4.setMileage(10.00);
//
//        Request request5 = new Request();
//        request5.setEventTitle("RequestCompleted");
//        request5.setRequestStatus(RequestStatus.COMPLETED);
//        request5.setStartTime(LocalTime.NOON);
//        request5.setEndTime(LocalTime.MIDNIGHT);
//        request5.setMileage(10.00);
//
//        Request request6 = new Request();
//        request6.setEventTitle("RequestIncomplete");
//        request6.setRequestStatus(RequestStatus.INCOMPLETE);
//        request6.setStartTime(LocalTime.NOON);
//        request6.setEndTime(LocalTime.MIDNIGHT);
//        request6.setMileage(10.00);
//
//        Request request7 = new Request();
//        request7.setEventTitle("RequestSubmitted");
//        request7.setRequestStatus(RequestStatus.SUBMITTED_TO_PAYROLL);
//        request7.setStartTime(LocalTime.NOON);
//        request7.setEndTime(LocalTime.MIDNIGHT);
//        request7.setMileage(10.00);
//
//        Request request8 = new Request();
//        request8.setEventTitle("RequestAssigned");
//        request8.setRequestStatus(RequestStatus.ASSIGNED);
//        request8.setStartTime(LocalTime.NOON);
//        request8.setEndTime(LocalTime.MIDNIGHT);
//        request8.setMileage(10.00);
//
//        requests.add(request1);
//        requests.add(request2);
//        requests.add(request3);
//        requests.add(request4);
//        requests.add(request5);
//        requests.add(request6);
//        requests.add(request7);
//        requests.add(request8);
//
//        for(int i = 0; i < requests.size(); i++) {
//            Request request = requests.get(i);
//            request.setEventTitle("Request "+i);
//            request.setEventDate(LocalDate.parse("2023-12-10"));
//            request.setStartTime(LocalTime.NOON);
//            request.setEndTime(LocalTime.MIDNIGHT);
//            request.setEventDescription("Request "+i+" description");
//            request.setCustomerFirstName("Customer "+i);
//            request.setCustomerLastName("Lastname "+i);
//            request.setCustomerPhoneNumber("1231221234");
//            request.setCustomerEmail("Customer"+i+"lastname"+i+"@gmail.com");
//            request.setMileage(i + .01);
//        }
//
//        return requests;
//    }
//
//    private List<Request> createRequests(int totalRequests) {
//        List<Request> requests = new ArrayList<>();
//
//        for(int i = 0; i < totalRequests; i++) {
//            Request request = new Request();
//            request.setEventTitle("Request "+i);
//            request.setRequestStatus(RequestStatus.APPROVED);
//            request.setEventDate(LocalDate.parse("2023-12-10"));
//            request.setEventDescription("Request "+i+" description");
//            request.setCustomerFirstName("Customer "+i);
//            request.setCustomerLastName("Lastname "+i);
//            request.setCustomerPhoneNumber("1231221234");
//            request.setCustomerEmail("Customer"+i+"lastname"+i+"@gmail.com");
//            request.setStartTime(LocalTime.NOON);
//            request.setEndTime(LocalTime.MIDNIGHT);
//            request.setMileage(i + .01);
//
//
//            requests.add(request);
//        }
//
////        Collections.reverse(users);
//
//        return requests;
//    }
//}