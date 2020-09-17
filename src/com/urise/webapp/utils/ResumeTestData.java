package com.urise.webapp.utils;

import com.urise.webapp.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.urise.webapp.model.ContactType.*;
import static com.urise.webapp.model.SectionType.*;

public class ResumeTestData {

    public static Resume getResume(String uuid, String fullname) {
        Resume resume = new Resume(uuid, "Nikolay");
        resume.addContact(TEL, "+7(921) 855-0482");
        resume.addContact(SKYPE, "grigory.kislin");
        resume.addContact(MAIL, "gkislin@yandex.ru");
        resume.addContact(LINKEDIN, "https://www.linkedin.com/in/gkislin");
        resume.addContact(GITHUB, "https://github.com/gkislin");
        resume.addContact(STACKOVERFLOW, "https://stackoverflow.com/users/548473");
        resume.addContact(WEBSITE, "http://gkislin.ru/");

        resume.addSection(OBJECTIVE, new ContentSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям\n"));
        resume.addSection(PERSONAL, new ContentSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.\n"));

        List<String> achievements = new ArrayList<>();

        achievements.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.\n");
        achievements.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.\n");
        achievements.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.\n");
        achievements.add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.\n");
        achievements.add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).\n");
        achievements.add("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.\n");

        resume.addSection(ACHIEVEMENT, new ListSection(achievements));

        List<String> qualifications = new ArrayList<>();

        qualifications.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2\n");
        qualifications.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce\n");
        qualifications.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,\n");
        qualifications.add("MySQL, SQLite, MS SQL, HSQLDB\n");
        qualifications.add("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,\n");
        qualifications.add("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,\n");
        qualifications.add("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).\n");
        qualifications.add("Python: Django.\n");
        qualifications.add("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js\n");
        qualifications.add("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka\n");
        qualifications.add("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.\n");
        qualifications.add("Инструменты: Maven + plugin development, Gradle, настройка Ngnix,\n");
        qualifications.add("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.\n");
        qualifications.add("Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования\n");
        qualifications.add("Родной русский, английский \"upper intermediate\"\n");

        resume.addSection(QUALIFICATION, new ListSection(qualifications));

        List<Organisation> companies = new ArrayList<>();
        //companies.add(new Organisation("Java Online Projects", "http://javaops.ru/", new Organisation.Position(LocalDate.of(2013, 10, 1), LocalDate.now(), "Автор проекта", null)));
        companies.add(new Organisation("Wrike", "https://www.wrike.com/", new Organisation.Position(LocalDate.of(2014, 10, 1), LocalDate.of(2016, 01, 1), "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.")));
        companies.add(new Organisation("RIT Center", "No website", new Organisation.Position(LocalDate.of(2012, 04, 1), LocalDate.of(2014, 10, 1), "Java архитектор", "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python")));
        companies.add(new Organisation("Luxoft (Deutsche Bank)", "http://www.luxoft.ru/", new Organisation.Position(LocalDate.of(2010, 12, 1), LocalDate.of(2012, 4, 1), "Ведущий программист", "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.")));
       // companies.add(new Organisation("Yota", "https://www.yota.ru/", new Organisation.Position(LocalDate.of(2008, 6, 11), LocalDate.of(2010, 12, 1), "Ведущий специалист", "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)")));
        companies.add(new Organisation("Enkata", "http://enkata.com/", new Organisation.Position(LocalDate.of(2007, 3, 1), LocalDate.of(2008, 6, 1), "Разработчик ПО", "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).\n")));
        resume.addSection(EXPERIENCE, new OrganisationSection(companies));

        List<Organisation> education = new ArrayList<>();
        education.add(new Organisation("Coursera", "https://www.coursera.org/course/progfun", new Organisation.Position(LocalDate.of(2013, 3, 1), LocalDate.of(2013, 5, 1), "Functional Programming Principles in Scala\" by Martin Odersky", null)));
        education.add(new Organisation("Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366", new Organisation.Position(LocalDate.of(2011, 3, 1), LocalDate.of(2011, 5, 1), "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.", null)));


        resume.addSection(EDUCATION, new OrganisationSection(education));

        return resume;
    }

    public static void main(String[] args) {
        Resume resume = getResume("uuid1", "Nikolay");
        System.out.println(resume);
    }
}
