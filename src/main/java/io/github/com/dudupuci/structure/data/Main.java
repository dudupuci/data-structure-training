package io.github.com.dudupuci.structure.data;

import io.github.com.dudupuci.structure.data.entities.Person;
import io.github.com.dudupuci.structure.data.enums.Priority;
import io.github.com.dudupuci.structure.data.utils.NameGenerator;
import io.github.com.dudupuci.structure.data.utils.PasswordGenerator;
import io.github.com.dudupuci.structure.data.utils.PriorityGenerator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException {
        LinkedList<Person> persons = new LinkedList<>();
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        for (int i = 0; i < 6; i++) {
            persons.add(new Person(NameGenerator.generate(), PriorityGenerator.generate(), PasswordGenerator.generate()));
        }

        logger.info("Adicionando pessoas a fila");

        do {
            var priorityPersons = new ArrayList<>(persons.stream().filter(person -> person.getPriority() == Priority.RED).toList());

            if (!priorityPersons.isEmpty()) {
                for (Person priorityPerson : priorityPersons) {
                    logger.info("Atendendo pessoa prioritária: " + priorityPerson.getName());
                    persons.remove(priorityPerson);

                    executor.schedule(() -> {
                        persons.add(new Person(NameGenerator.generate(), PriorityGenerator.generate(), PasswordGenerator.generate()));
                        checkIfPersonNeedsPriority(persons.peekLast(), priorityPersons);
                        logger.info("Nova pessoa entrando no consultório..." + persons.peekLast());
                    }, 4, TimeUnit.SECONDS);

                    Thread.sleep(5000);
                    logger.info("Consulta com " + priorityPerson.getName() + " finalizada.");
                }
            }

            var nextPerson = persons.peekFirst();
            assert nextPerson != null;

            logger.info("Atendendo proximo paciente: " + nextPerson.getName());
            persons.remove(nextPerson);

            executor.schedule(() -> {
                persons.add(new Person(NameGenerator.generate(), PriorityGenerator.generate(), PasswordGenerator.generate()));
                checkIfPersonNeedsPriority(persons.peekLast(), priorityPersons);
                logger.info("Nova pessoa entrando no consultório..." + persons.peekLast());
            }, 4, TimeUnit.SECONDS);

            Thread.sleep(5000);
            logger.info("Consulta com " + nextPerson.getName() + " finalizada.");

        } while (true);
    }

    private static void checkIfPersonNeedsPriority(final Person person, ArrayList<Person> list) {
        if (person.getPriority() == Priority.RED) {
            list.add(person);
        }
    }
}
